module com.example.game_1a2b {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.game_1a2b to javafx.fxml;
    exports com.example.game_1a2b;
}