module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.demo1.controllers to javafx.fxml; // Corregido: Abre el paquete controllers
    exports com.example.demo1;
}
