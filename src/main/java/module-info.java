module com.example.sdp_project2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.sdp_project2 to javafx.fxml;
    exports com.example.sdp_project2;
}