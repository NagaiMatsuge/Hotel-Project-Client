module com.example.hotel {
    requires javafx.controls;
    requires javafx.fxml;
    requires  javafx.graphics;
    requires java.sql;
    requires gson;


    opens com.example.hotel to javafx.fxml;
    exports com.example.hotel;
}