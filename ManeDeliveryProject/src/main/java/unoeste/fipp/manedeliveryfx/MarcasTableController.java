package unoeste.fipp.manedeliveryfx;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import unoeste.fipp.manedeliveryfx.db.dals.MarcaDAL;
import unoeste.fipp.manedeliveryfx.db.dals.MarcaDAL;
import unoeste.fipp.manedeliveryfx.db.entidades.Categoria;
import unoeste.fipp.manedeliveryfx.db.entidades.Marca;
import unoeste.fipp.manedeliveryfx.db.entidades.Marca;
import unoeste.fipp.manedeliveryfx.db.entidades.Marca;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MarcasTableController implements Initializable {

    @FXML
    private TableColumn<Marca, Integer> coId;

    @FXML
    private TableColumn<Marca, String> coMarca;

    @FXML
    private TableView<Marca> tableView;

    @FXML
    private TextField tfPesquisar;
    static public Marca MarcaSelecionado=null;

    @FXML
    void onFechar(ActionEvent event) {
        tfPesquisar.getScene().getWindow().hide();
    }
    
    @FXML
    void onNovaMarca(ActionEvent event) {
        try{
            Stage stage=new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(ManeDeliveryFX.class.getResource("marcas-form-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Cadastro de Marcas");
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();
            carregarTabela("");
        }catch (Exception e){}
    }

    @FXML
    void onPesquisar(KeyEvent event) {
        carregarTabela("upper(mar_nome) LIKE '%"+tfPesquisar.getText().toUpperCase()+"%'");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        coId.setCellValueFactory(new PropertyValueFactory<>("id"));
        coMarca.setCellValueFactory(new PropertyValueFactory<>("nome"));
        carregarTabela("");
    }

    private void carregarTabela(String filtro) {
        MarcaDAL dal =new MarcaDAL();
        List<Marca> marcaList=dal.get(filtro);
        tableView.setItems(FXCollections.observableArrayList(marcaList));
    }

    public void onAlterar(ActionEvent actionEvent) {
        MarcaDAL dal=new MarcaDAL();
        if(tableView.getSelectionModel().getSelectedItem()!=null){
            MarcaSelecionado=tableView.getSelectionModel().getSelectedItem();
            try{
                Stage stage=new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(ManeDeliveryFX.class.getResource("marcas-form-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setTitle("Alteração de Marcas");
                stage.setScene(scene);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.showAndWait();
                carregarTabela("");
            }catch (Exception e){}
        }
    }

    public void onApagar(ActionEvent actionEvent) {
        MarcaDAL dal=new MarcaDAL();
        if(tableView.getSelectionModel().getSelectedItem()!=null){
            dal.apagar(tableView.getSelectionModel().getSelectedItem());
            carregarTabela("");
        }
    }
}
