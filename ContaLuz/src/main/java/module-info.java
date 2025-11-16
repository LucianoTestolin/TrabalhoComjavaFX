module org.example.contaluz {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.contaluz to javafx.fxml;
    exports org.example.contaluz;
}