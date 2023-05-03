module com.example.sdata {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.sdata to javafx.fxml;
    exports com.example.sdata;
}