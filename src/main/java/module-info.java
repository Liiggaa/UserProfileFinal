module com.example.userprofilefinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.userprofilefinal to javafx.fxml;
    exports com.example.userprofilefinal;
}