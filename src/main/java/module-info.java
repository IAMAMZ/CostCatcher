module com.example.costcatcher {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.costcatcher to javafx.fxml;
    exports com.example.costcatcher;
}