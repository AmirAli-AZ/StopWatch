package com.amirali.stopwatch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        var fxmlLoader = new FXMLLoader(App.class.getResource("stopwatch-view.fxml"));
        var scene = new Scene(fxmlLoader.load(), 666, 440);
        stage.setTitle("StopWatch");
        stage.getIcons().addAll(
               new Image(Objects.requireNonNull(getClass().getResourceAsStream("icons/icon64.png"))),
               new Image(Objects.requireNonNull(getClass().getResourceAsStream("icons/icon32.png"))),
               new Image(Objects.requireNonNull(getClass().getResourceAsStream("icons/icon16.png")))
        );
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}