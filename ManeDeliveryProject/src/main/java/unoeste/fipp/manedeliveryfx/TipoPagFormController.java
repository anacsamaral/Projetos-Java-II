package unoeste.fipp.manedeliveryfx;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import unoeste.fipp.manedeliveryfx.db.dals.CategoriaDAL;
import unoeste.fipp.manedeliveryfx.db.dals.TipoPagamentoDAL;
import unoeste.fipp.manedeliveryfx.db.dals.TipoPagamentoDAL;
import unoeste.fipp.manedeliveryfx.db.dals.TipoPagamentoDAL;
import unoeste.fipp.manedeliveryfx.db.entidades.Categoria;
import unoeste.fipp.manedeliveryfx.db.entidades.TipoPagamento;
import unoeste.fipp.manedeliveryfx.db.entidades.TipoPagamento;
import unoeste.fipp.manedeliveryfx.db.entidades.TipoPagamento;
import unoeste.fipp.manedeliveryfx.db.util.SingletonDB;
import unoeste.fipp.manedeliveryfx.util.MaskFieldUtil;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TipoPagFormController implements Initializable {

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfNome;

    @FXML
    void onCancelar(ActionEvent event) {
        tfNome.getScene().getWindow().hide();
    }

    @FXML
    void onConfirmar(ActionEvent event) {
        TipoPagamentoDAL dal=new TipoPagamentoDAL();
        TipoPagamento TipoPagamento=new TipoPagamento();
        if (tfNome.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Campo obrigatório");
            alert.setContentText("O nome do tipo de pagamento não pode ficar vazio!");
            alert.showAndWait();
            tfNome.requestFocus();
            return;
        }
        TipoPagamento.setNome(tfNome.getText());
        if(tfId.getText().isEmpty()) {  //id vazio significa que é um novo TipoPagamento
            if (!dal.gravar(TipoPagamento)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Erro ao cadastrar\n" + SingletonDB.getConexao().getMensagemErro());
            }
        }
        else {
            TipoPagamento.setId(Integer.parseInt(tfId.getText()));
            if(!dal.alterar(TipoPagamento)) {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Erro ao alterar\n"+ SingletonDB.getConexao().getMensagemErro());
            }
        }
        tfNome.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(()->{tfNome.requestFocus();});
        //caso seja uma alteração, carregar o TipoPagamento que será alterado
        if(TipoPagTableController.TipoPagamentoSelecionado!=null){
            TipoPagamento aux=TipoPagTableController.TipoPagamentoSelecionado;
            tfId.setEditable(true);
            tfId.setText(""+aux.getId());
            tfId.setEditable(false);
            tfNome.setText(aux.getNome());
        }
    }

}
