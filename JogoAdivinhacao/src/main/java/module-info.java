module org.example.jogoadivinhacao {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.jogoadivinhacao to javafx.fxml;
    exports org.example.jogoadivinhacao;
}