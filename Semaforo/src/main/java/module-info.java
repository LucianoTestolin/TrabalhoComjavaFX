module org.example.semaforo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.semaforo to javafx.fxml;
    exports org.example.semaforo;
}