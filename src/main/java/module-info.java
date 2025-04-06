     module cpsc.module4 {
    requires javafx.controls;
    requires javafx.fxml;

    exports cpsc.module4;
    exports cpsc.module4.data;
    exports cpsc.module4.model;

    // 👇 This is the critical part for FXML to work
    opens cpsc.module4.controller to javafx.fxml;
}
