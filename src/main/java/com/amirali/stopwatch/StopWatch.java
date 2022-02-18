package com.amirali.stopwatch;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Duration;

public class StopWatch {

    private long elapsedTime , startTime;
    private final StringProperty formattedTimeProperty = new SimpleStringProperty("00:00:000");
    private final BooleanProperty activeProperty = new SimpleBooleanProperty(false);
    private Timeline timeline;

    public StopWatch() {
    }

    public StopWatch(Duration startTime) {
        this.elapsedTime = (long) startTime.toMillis();
        this.startTime = (long) startTime.toMillis();
    }

    public void start() {
        var kf = new KeyFrame(Duration.millis(1), event -> {
            elapsedTime++;
            formattedTimeProperty.set(format(elapsedTime));
        });
        timeline = new Timeline(kf);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        activeProperty.set(true);
    }

    public void stop() {
        if (isActive()) {
            timeline.stop();
            activeProperty.set(false);
        }
    }

    public void reset() {
        if (timeline != null) {
            stop();
            elapsedTime = startTime;
            formattedTimeProperty.set("00:00:000");
        }
    }

    private String format(long milliseconds) {
        var minutes = milliseconds / 60000;
        var seconds = (milliseconds / 1000) % 60;
        return String.format("%02d:%02d:%03d" , minutes , seconds , milliseconds % 1000);
    }

    public StringProperty getFormattedTimeProperty() {
        return formattedTimeProperty;
    }

    public String getCurrentFormattedTime() {
        return formattedTimeProperty.get();
    }

    public BooleanProperty activeProperty() {
        return activeProperty;
    }

    public boolean isActive() {
        return activeProperty.get();
    }
}
