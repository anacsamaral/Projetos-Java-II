package unoeste.fipp.manedeliveryfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import unoeste.fipp.manedeliveryfx.db.dals.PedidoDAL;
import unoeste.fipp.manedeliveryfx.db.entidades.Pedido;
import unoeste.fipp.manedeliveryfx.reports.PedidoReports;

import java.time.LocalDate;
import java.util.List;

public class RelatorioFormController {

    @FXML
    private DatePicker dtFinal;

    @FXML
    private DatePicker dtInicio;

    @FXML
    void onCancelar(ActionEvent event) {
        // Apenas fecha a janela se quiser depois
    }

    @FXML
    void onConfirmar(ActionEvent event) {

        LocalDate inicio = dtInicio.getValue();
        LocalDate fim = dtFinal.getValue();

        if (inicio == null || fim == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Selecione a data inicial e final!");
            alert.showAndWait();
            return;
        }

        String filtro = "ped_data BETWEEN '" + inicio + "' AND '" + fim + "' ORDER BY ped_data";
        PedidoDAL dal = new PedidoDAL();
        List<Pedido> pedidos = dal.get(filtro);
        // Gera o PDF
        PedidoReports.relPedidos(pedidos);
        dtInicio.getScene().getWindow().hide();
    }

}
