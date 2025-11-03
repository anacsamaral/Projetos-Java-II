module org.example.manedelivery {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.manedelivery to javafx.fxml;
    exports org.example.manedelivery;
}