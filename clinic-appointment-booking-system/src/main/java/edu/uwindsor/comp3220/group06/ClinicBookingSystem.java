package edu.uwindsor.comp3220.group06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ClinicBookingSystem extends Application {

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane(new Label("It works!"));
        stage.setScene(new Scene(root, 400, 300));
        stage.setTitle("Clinic");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}