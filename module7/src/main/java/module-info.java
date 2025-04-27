module cpsc.module7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens cpsc.module7 to javafx.fxml;
    exports cpsc.module7;
}