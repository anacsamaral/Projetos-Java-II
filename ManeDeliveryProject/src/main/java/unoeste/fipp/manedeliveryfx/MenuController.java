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
import unoeste.fipp.manedeliveryfx.db.dals.PedidoDAL;
import unoeste.fipp.manedeliveryfx.db.dals.TipoPagamentoDAL;
import unoeste.fipp.manedeliveryfx.db.entidades.Pedido;
import unoeste.fipp.manedeliveryfx.db.entidades.TipoPagamento;
import unoeste.fipp.manedeliveryfx.reports.PedidoReports;

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

    // perguntar a data inicial e a data dos pedidos

    public void onRelatórioPedido(ActionEvent actionEvent){
        String filtro = "ped_data BETWEEN '2025-11-01 AND '2025-11-17' ORDER BY ped_data";
        PedidoDAL dal = new PedidoDAL();
        List<Pedido> pedidoList = dal.get(filtro);
        PedidoReports.relPedidos(null);
    }
}
