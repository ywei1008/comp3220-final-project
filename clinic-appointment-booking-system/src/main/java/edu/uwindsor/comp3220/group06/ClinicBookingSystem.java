package edu.uwindsor.comp3220.group06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClinicBookingSystem extends Application {

    // Simple data structure to define what information is to be stored for each patient profile (CAN BE CHANGED)
    public record Patient(
        String fullName,
        String phoneNumber,
        String healthCard,
        String address,
        String dob,
        List<String> healthRecords
    ) {}

    // In-memory data store for submitted profiles
    private final List<Patient> patientDatabase = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.TOP_LEFT);

        // Form labels and text inputs
        Label nameLabel = new Label("Name (First and Last name):");
        TextField nameField = new TextField();

        Label phoneLabel = new Label("Phone Number:");
        TextField phoneField = new TextField();

        Label healthCardLabel = new Label("Health Card:");
        TextField healthCardField = new TextField();

        Label addressLabel = new Label("Address:");
        TextField addressField = new TextField();

        Label dobLabel = new Label("DOB (e.g., YYYY-MM-DD):");
        TextField dobField = new TextField();

        Label recordsLabel = new Label("Enter a list of health records, separated by commas:");
        TextField recordsField = new TextField();
        recordsField.setPromptText("diabetes, cholesterol, asthma");

        // Action button
        Button submitButton = new Button("Create Patient Profile");

        // Status label for quick user feedback, once they have created the new patient's profile
        Label statusLabel = new Label();

        // Handle button click
        submitButton.setOnAction(event -> {
            String rawRecords = recordsField.getText().trim();
            List<String> recordList = new ArrayList<>();

            //go through the list of health records to get each individual record and add it to the list 
            if (!rawRecords.isEmpty()) {
                String[] splitRecords = rawRecords.split(",");
                for (String record : splitRecords) {
                    String cleaned = record.trim();
                    if (!cleaned.isEmpty()) {
                        recordList.add(cleaned);
                    }
                }
            }

            // Create and store the patient profile from all the text boxes
            Patient newPatient = new Patient(
                nameField.getText().trim(),
                phoneField.getText().trim(),
                healthCardField.getText().trim(),
                addressField.getText().trim(),
                dobField.getText().trim(),
                recordList
            );

            //our patient database is a list of patient objects of type ArrayList
            patientDatabase.add(newPatient);

            // Print confirmation to the console
            System.out.println("Saved Patient Profile: " + newPatient);

            // Show confirmation popup
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Profile Created");
            alert.setContentText("Patient profile for " + newPatient.fullName() + " was saved successfully.");
            alert.showAndWait();

            // Clear the form fields
            nameField.clear();
            phoneField.clear();
            healthCardField.clear();
            addressField.clear();
            dobField.clear();
            recordsField.clear();
            statusLabel.setText("Last saved: " + newPatient.fullName() + " (" + patientDatabase.size() + " total patients)");
        });

        // Assemble the UI controls into the layout
        layout.getChildren().addAll(
            nameLabel, nameField,
            phoneLabel, phoneField,
            healthCardLabel, healthCardField,
            addressLabel, addressField,
            dobLabel, dobField,
            recordsLabel, recordsField,
            submitButton,
            statusLabel
        );

        // Wrap layout in a scroll pane to prevent clipping on smaller displays
        ScrollPane scrollPane = new ScrollPane(layout);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane, 480, 580);
        stage.setScene(scene);
        stage.setTitle("Clinic Booking System - Patient Registration");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}