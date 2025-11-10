module unoeste.fipp.manedeliveryfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens unoeste.fipp.manedeliveryfx to javafx.fxml;
    opens unoeste.fipp.manedeliveryfx.db.entidades to javafx.fxml;
    exports unoeste.fipp.manedeliveryfx;
    exports unoeste.fipp.manedeliveryfx.db.entidades;
}