module com.example.demo_pf {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.demo_pf to javafx.fxml;
    exports com.example.demo_pf;
}