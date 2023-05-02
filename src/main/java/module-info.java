module com.example.sdata {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sdata to javafx.fxml;
    exports com.example.sdata;
}