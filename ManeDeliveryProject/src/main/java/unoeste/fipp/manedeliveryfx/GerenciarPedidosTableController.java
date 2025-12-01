package unoeste.fipp.manedeliveryfx;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import unoeste.fipp.manedeliveryfx.db.dals.MarcaDAL;
import unoeste.fipp.manedeliveryfx.db.dals.PedidoDAL;
import unoeste.fipp.manedeliveryfx.db.dals.PedidoDAL;
import unoeste.fipp.manedeliveryfx.db.entidades.Categoria;
import unoeste.fipp.manedeliveryfx.db.entidades.Pedido;
import unoeste.fipp.manedeliveryfx.db.entidades.Pedido;
import unoeste.fipp.manedeliveryfx.db.entidades.Pedido;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GerenciarPedidosTableController implements Initializable {

    @FXML
    private TableColumn<Pedido, Integer> coId;

    @FXML
    private TableColumn<Pedido, String> coData;

    @FXML
    private TableColumn<Pedido, String> coPedido;

    @FXML
    private TableColumn<Pedido, Double> coTotal;

    @FXML
    private TableView<Pedido> tableView;

    @FXML
    private TextField tfPesquisar;
    static public Pedido PedidoSelecionado=null;

    @FXML
    void onFechar(ActionEvent event) {
        tfPesquisar.getScene().getWindow().hide();
    }

    @FXML
    void onPesquisar(KeyEvent event) {
        carregarTabela("upper(ped_clinome) LIKE '%"+tfPesquisar.getText().toUpperCase()+"%' AND ped_entregue = 'N'");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        coId.setCellValueFactory(new PropertyValueFactory<>("id"));
        coPedido.setCellValueFactory(new PropertyValueFactory<>("nomeCliente"));
        carregarTabela("ped_entregue = 'N'");
        coData.setCellValueFactory(new PropertyValueFactory<>("data"));
        coTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
    }

    private void carregarTabela(String filtro) {
        PedidoDAL dal =new PedidoDAL();
        List<Pedido> PedidoList=dal.get(filtro);
        tableView.setItems(FXCollections.observableArrayList(PedidoList));
    }

    public void onAlterar(ActionEvent actionEvent) {
        PedidoDAL dal=new PedidoDAL();
        if(tableView.getSelectionModel().getSelectedItem()!=null){
            PedidoSelecionado=tableView.getSelectionModel().getSelectedItem();
            try{
                Stage stage=new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(ManeDeliveryFX.class.getResource("novo-pedido-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setTitle("Alteração de Pedido");
                stage.setScene(scene);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.showAndWait();
                carregarTabela("ped_entregue = 'N'");
            }catch (Exception e){}
        }
    }

    @FXML
    void onMarcarEntregue(ActionEvent event) {
        Pedido pedido = tableView.getSelectionModel().getSelectedItem();
        if (pedido != null) {
            PedidoDAL dal = new PedidoDAL();
            pedido.setEntregue("S");  // marcar como entregue
            dal.alterar(pedido);
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Entrega alterada!\n");
            alert.setHeaderText("Mane DeliveryFX");
            alert.showAndWait();
            carregarTabela("ped_entregue = 'N'");
        }
    }

    public void onApagar(ActionEvent actionEvent) {
        PedidoDAL dal=new PedidoDAL();
        if(tableView.getSelectionModel().getSelectedItem()!=null){
            dal.apagar(tableView.getSelectionModel().getSelectedItem());
            carregarTabela("ped_entregue = 'N'");
        }
    }
}
