module com.example.mines {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.mines to javafx.fxml;
    exports com.example.mines;
}