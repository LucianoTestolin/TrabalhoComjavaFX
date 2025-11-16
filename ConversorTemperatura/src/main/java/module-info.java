module org.example.conversortemperatura {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.conversortemperatura to javafx.fxml;
    exports org.example.conversortemperatura;
}