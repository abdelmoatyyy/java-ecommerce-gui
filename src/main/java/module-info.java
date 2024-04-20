module ecommerce {
    requires javafx.controls;
    requires javafx.fxml;

    opens ecommerce to javafx.fxml;
    exports ecommerce;
}
