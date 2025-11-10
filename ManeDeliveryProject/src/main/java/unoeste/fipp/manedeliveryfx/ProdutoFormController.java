package unoeste.fipp.manedeliveryfx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import unoeste.fipp.manedeliveryfx.db.entidades.Categoria;
import unoeste.fipp.manedeliveryfx.db.entidades.Marca;

import java.net.URL;
import java.util.ResourceBundle;

public class ProdutoFormController implements Initializable {

    @FXML
    private ComboBox<Categoria> cbCategoria;

    @FXML
    private ComboBox<Marca> cbMarca;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfPreco;

    @FXML
    private TextField tfVolume;

    @FXML
    void onCancelar(ActionEvent event) {

    }

    @FXML
    void onConfirmar(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(()->{tfNome.requestFocus();});

    }
}
