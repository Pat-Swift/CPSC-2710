module cpsc.module_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens cpsc.module_2 to javafx.fxml;
    exports cpsc.module_2;
}