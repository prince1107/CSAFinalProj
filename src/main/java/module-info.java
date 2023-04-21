module com.csafinal.basedefense {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.csafinal.basedefense to javafx.fxml;
    exports com.csafinal.basedefense;
}
