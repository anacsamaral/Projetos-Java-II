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
import unoeste.fipp.manedeliveryfx.db.dals.ProdutoDAL;
import unoeste.fipp.manedeliveryfx.db.entidades.Categoria;
import unoeste.fipp.manedeliveryfx.db.entidades.Marca;
import unoeste.fipp.manedeliveryfx.db.entidades.Produto;
import unoeste.fipp.manedeliveryfx.db.util.SingletonDB;
import unoeste.fipp.manedeliveryfx.util.MaskFieldUtil;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CategoriasFormController implements Initializable {

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
        CategoriaDAL dal=new CategoriaDAL();
        Categoria categoria = new Categoria();
        if (tfNome.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Campo obrigatório");
            alert.setContentText("O nome da categoria não pode ficar vazio!");
            alert.showAndWait();
            tfNome.requestFocus();
            return;
        }
        categoria.setNome(tfNome.getText());
        if(tfId.getText().isEmpty()) {  //id vazio significa que é um novo produto
            if (!dal.gravar(categoria)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Erro ao cadastrar\n" + SingletonDB.getConexao().getMensagemErro());
            }
            else
                tfNome.getScene().getWindow().hide();
        }
        else {
            categoria.setId(Integer.parseInt(tfId.getText()));
            if(!dal.alterar(categoria)) {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Erro ao alterar\n"+ SingletonDB.getConexao().getMensagemErro());
            }
            else
                tfNome.getScene().getWindow().hide();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(()->{tfNome.requestFocus();});
        //caso seja uma alteração, carregar o produto que será alterado
        if(ProdutosTableController.produtoSelecionado!=null){
            Produto aux=ProdutosTableController.produtoSelecionado;
            tfId.setEditable(true);
            tfId.setText(""+aux.getId());
            tfId.setEditable(false);
            tfNome.setText(aux.getNome());
        }
    }
}
