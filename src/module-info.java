module calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;

    opens calculator.view to javafx.fxml;
    exports calculator.view;
    exports tests;
}
