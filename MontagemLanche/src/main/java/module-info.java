module org.example.montagemlanche {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.montagemlanche to javafx.fxml;
    exports org.example.montagemlanche;
}