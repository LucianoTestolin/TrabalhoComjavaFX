module org.example.simplescadastro {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.simplescadastro to javafx.fxml;
    exports org.example.simplescadastro;
}