module org.example.mediaescolar {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.mediaescolar to javafx.fxml;
    exports org.example.mediaescolar;
}