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
import unoeste.fipp.manedeliveryfx.db.dals.MarcaDAL;
import unoeste.fipp.manedeliveryfx.db.dals.MarcaDAL;
import unoeste.fipp.manedeliveryfx.db.dals.MarcaDAL;
import unoeste.fipp.manedeliveryfx.db.entidades.Categoria;
import unoeste.fipp.manedeliveryfx.db.entidades.Marca;
import unoeste.fipp.manedeliveryfx.db.entidades.Marca;
import unoeste.fipp.manedeliveryfx.db.entidades.Marca;
import unoeste.fipp.manedeliveryfx.db.util.SingletonDB;
import unoeste.fipp.manedeliveryfx.util.MaskFieldUtil;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MarcasFormController implements Initializable {

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
        MarcaDAL dal=new MarcaDAL();
        Marca Marca=new Marca();
        if (tfNome.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Campo obrigatório");
            alert.setContentText("O nome da marca não pode ficar vazio!");
            alert.showAndWait();
            tfNome.requestFocus();
            return;
        }
        Marca.setNome(tfNome.getText());
        if(tfId.getText().isEmpty()) {  //id vazio significa que é um novo Marca
            if (!dal.gravar(Marca)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Erro ao cadastrar\n" + SingletonDB.getConexao().getMensagemErro());
            }
        }
        else {
            Marca.setId(Integer.parseInt(tfId.getText()));
            if(!dal.alterar(Marca)) {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Erro ao alterar\n"+ SingletonDB.getConexao().getMensagemErro());
            }
        }
        tfNome.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(()->{tfNome.requestFocus();});
        //caso seja uma alteração, carregar o Marca que será alterado
        if(MarcasTableController.MarcaSelecionado!=null){
            Marca aux=MarcasTableController.MarcaSelecionado;
            tfId.setEditable(true);
            tfId.setText(""+aux.getId());
            tfId.setEditable(false);
            tfNome.setText(aux.getNome());
        }
    }

}
