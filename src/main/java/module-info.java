module com.amirali.stopwatch {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.amirali.stopwatch to javafx.fxml;
    exports com.amirali.stopwatch;
}