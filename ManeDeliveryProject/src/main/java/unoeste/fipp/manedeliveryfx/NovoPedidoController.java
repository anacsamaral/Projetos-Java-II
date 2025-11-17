package unoeste.fipp.manedeliveryfx;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.json.JSONObject;
import unoeste.fipp.manedeliveryfx.db.dals.PedidoDAL;
import unoeste.fipp.manedeliveryfx.db.dals.ProdutoDAL;
import unoeste.fipp.manedeliveryfx.db.dals.TipoPagamentoDAL;
import unoeste.fipp.manedeliveryfx.db.entidades.Pedido;
import unoeste.fipp.manedeliveryfx.db.entidades.Produto;
import unoeste.fipp.manedeliveryfx.db.entidades.TipoPagamento;
import unoeste.fipp.manedeliveryfx.util.MaskFieldUtil;
import unoeste.fipp.manedeliveryfx.util.ModalTable;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class NovoPedidoController implements Initializable {

    private Produto produto=null;
    private double totalPedido=0;

    @FXML
    private Button btProduto;

    @FXML
    private ComboBox<TipoPagamento> cbTipoPagamento;

    @FXML
    private TableColumn<Pedido.Item, String> coProduto;

    @FXML
    private TableColumn<Pedido.Item, String> coQuant;

    @FXML
    private TableColumn<Pedido.Item, String> coValor;

    @FXML
    private Label lbTotal;

    @FXML
    private Spinner<Integer> spQuant;

    @FXML
    private TableView<Pedido.Item> tableView;

    @FXML
    private TextField tfCep;

    @FXML
    private TextField tfCliente;

    @FXML
    private TextField tfEndereco;

    @FXML
    private TextField tfNumero;

    @FXML
    private TextField tfTelefone;

    @FXML
    void onAdicItem(ActionEvent event) {
        double precoItem=produto.getPreco()*spQuant.getValue();
        Pedido.Item item=new Pedido.Item(produto,spQuant.getValue(),precoItem);
        tableView.getItems().add(item);
        totalPedido+=precoItem;
        lbTotal.setText(String.format("%.2f",totalPedido));
    }

    @FXML
    void onBuscarCep(KeyEvent event) {
        if(tfCep.getText().length()==9) {
            String sjson=consultaCep(tfCep.getText(), "json");
            JSONObject json=new JSONObject(sjson);
            tfEndereco.setText(json.getString("logradouro")+", "+
                               json.getString("bairro")+", "+
                               json.getString("localidade")+"/"+
                               json.getString("uf"));
            Platform.runLater(()->tfNumero.requestFocus());
        }
    }

    @FXML
    void onCancelar(ActionEvent event) {
        btProduto.getScene().getWindow().hide();
    }

    @FXML
    void onConfirmar(ActionEvent event) {
        PedidoDAL dal=new PedidoDAL();
        Pedido pedido=new Pedido();
        pedido.setData(LocalDate.now());
        pedido.setLocal(tfEndereco.getText());
        pedido.setNumero(tfNumero.getText());
        pedido.setFoneCliente(tfTelefone.getText());
        pedido.setTipoPagamento(cbTipoPagamento.getValue());
        for(Pedido.Item item : tableView.getItems()) {
            pedido.addItem(item.produto(), item.quantidade());
        }
        dal.gravar(pedido);
        btProduto.getScene().getWindow().hide();
    }

    @FXML
    void onDelItem(ActionEvent event) {
        Pedido.Item item=tableView.getSelectionModel().getSelectedItem();
        if(item!=null){
            tableView.getItems().remove(item);
        }
    }

    @FXML
    void onSelProduto(ActionEvent event) {
        ModalTable mt=new ModalTable(new ProdutoDAL().get(""),new String[]{"id","nome","preco","marca"},"nome");
        Stage stage=new Stage();
        stage.setScene(new Scene(mt));
        stage.setWidth(1024); stage.setHeight(600); stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        produto = (Produto)mt.getSelecionado();
        if (produto!=null)
            btProduto.setText(produto.getNome());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //configurando as colunas do tablevies
        coProduto.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().produto().getNome()));
        coQuant.setCellValueFactory(cellData->new SimpleStringProperty(""+cellData.getValue().quantidade()));
        coValor.setCellValueFactory(cellData->new SimpleStringProperty(""+cellData.getValue().valor()));
        CarregarCBTipoPagamento();
        spQuant.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,1));
        MaskFieldUtil.foneField(tfTelefone);
        MaskFieldUtil.cepField(tfCep);
        Platform.runLater(()->tfCliente.requestFocus());
    }

    private void CarregarCBTipoPagamento() {
        TipoPagamentoDAL dal=new TipoPagamentoDAL();
        List<TipoPagamento> tipoPagamentoList = dal.get("");
        cbTipoPagamento.setItems(FXCollections.observableArrayList(tipoPagamentoList));
    }
    public String consultaCep(String cep, String formato)
    {
        StringBuffer dados = new StringBuffer();
        try {
            URL url = new URL("https://viacep.com.br/ws/"+ cep + "/"+formato+"/");
            URLConnection con = url.openConnection();
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setAllowUserInteraction(false);
            InputStream in = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String s = "";
            while (null != (s = br.readLine()))
                dados.append(s);
            br.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return dados.toString();
    }
}
