module com.example.videorentalsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.example.videorentalsystem to javafx.fxml;
    exports com.example.videorentalsystem;
}