module org.example.cadastropessoa {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.cadastropessoa to javafx.fxml;
    exports org.example.cadastropessoa;
}