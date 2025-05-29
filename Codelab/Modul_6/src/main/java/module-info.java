module com.example.modul_6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.modul_6 to javafx.fxml;
    exports com.example.modul_6;
}