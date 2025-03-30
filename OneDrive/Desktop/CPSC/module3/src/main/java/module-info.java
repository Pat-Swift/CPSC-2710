module module3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens cpsc.module3 to javafx.fxml;
    exports cpsc.module3;
}
