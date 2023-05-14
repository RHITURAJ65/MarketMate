module com.example.mainshop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mainshop to javafx.fxml;
    exports com.example.mainshop;
}