package unoeste.fipp.manedeliveryfx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import unoeste.fipp.manedeliveryfx.db.dals.TipoPagamentoDAL;
import unoeste.fipp.manedeliveryfx.db.entidades.TipoPagamento;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MenuController {

    @FXML
    void onCadCategorias(ActionEvent event) {

    }

    @FXML
    void onCadMarcas(ActionEvent event) {

    }

    @FXML
    void onCadProdutos(ActionEvent event) {
       try{
           Stage stage=new Stage();
           FXMLLoader fxmlLoader = new FXMLLoader(ManeDeliveryFX.class.getResource("produtos-table-view.fxml"));
           Scene scene = new Scene(fxmlLoader.load());
           stage.setTitle("Cadastro de Produtos");
           stage.setScene(scene);
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.showAndWait();
       }catch (Exception e){}
    }

    @FXML
    void onCadTiposPagamento(ActionEvent event) {

    }

    @FXML
    void onFechar(ActionEvent event) {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Deseja finalizar a aplicação?");
        if(alert.showAndWait().get() == ButtonType.OK)
            Platform.exit();
    }

    @FXML
    void onGerenciarPedido(ActionEvent event) {

    }

    @FXML
    void onNovoPedido(ActionEvent event) {
        try{
            Stage stage=new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(ManeDeliveryFX.class.getResource("novo-pedido-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Novo Pedido");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }catch (Exception e){}

    }

    @FXML
    void onSobre(ActionEvent event) {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Desenvolvido por Silvio\nOutros");
        alert.setHeaderText("Mane DeliveryFX");
        alert.showAndWait();
    }


}
