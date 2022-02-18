package com.amirali.stopwatch;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    @FXML
    private BorderPane root;

    @FXML
    private Label timeView;

    @FXML
    private Button startAndStop;

    private final StopWatch stopWatch = new StopWatch();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeView.textProperty().bind(stopWatch.getFormattedTimeProperty());
    }

    @FXML
    public void startAndStopAction(ActionEvent event) {
        if (!stopWatch.isActive()) {
            stopWatch.start();
            startAndStop.setText("Stop");
        }else {
            stopWatch.stop();
            startAndStop.setText("Start");
        }
    }

    @FXML
    public void reset(ActionEvent event) {
        stopWatch.reset();
        startAndStop.setText("Start");
        root.requestFocus();
    }

    @FXML
    public void keyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER)
            startAndStop.fire();
    }
}