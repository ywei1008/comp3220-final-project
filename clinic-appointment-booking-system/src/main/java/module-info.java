module edu.uwindsor.comp3220.group06 {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.uwindsor.comp3220.group06 to javafx.fxml;
    exports edu.uwindsor.comp3220.group06;
}
