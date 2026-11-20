module org.example.javafxtableviewframework {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javafxtableviewframework to javafx.fxml;
    exports org.example.javafxtableviewframework;
}