module com.example.userprofilefinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.userprofilefinal to javafx.fxml;
    exports com.example.userprofilefinal;
}