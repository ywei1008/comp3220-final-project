package edu.uwindsor.comp3220.group06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class ClinicBookingSystem extends Application {

    // In-memory data store for submitted profiles
    private final List<Patient> patientDatabase = new ArrayList<>();

    @Override
    public void start(Stage stage) {

        BorderPane bp = new BorderPane();   // creating first window
        Label title = new Label("Welcome to Your Clinic Booking Management System");
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
        bp.setTop(title);   // adding title to top of borderpane
        BorderPane.setAlignment(title, Pos.CENTER);
        BorderPane.setMargin(title, new Insets(20, 0, 0, 0));

        VBox btnBox = new VBox(10);
        Button newPatientBtn = new Button("Add new patient");   // our 2 button functions
        Button viewPatientBtn = new Button("View patient records");
        btnBox.getChildren().addAll(newPatientBtn, viewPatientBtn);
        btnBox.setAlignment(Pos.CENTER);
        bp.setCenter(btnBox);     // adding to center of screen

        //action listeners for both buttons
        newPatientBtn.setOnAction(e -> addPatientButtonClicked());
        viewPatientBtn.setOnAction(e -> viewPatientButtonClicked());

        Scene scene = new Scene(bp, 450, 200);
        stage.setScene(scene);
        stage.setTitle("Clinic Booking System - Patient Registration");
        stage.show();
    }

    // method invoked after clicking addPatientBtn
    public void addPatientButtonClicked() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.TOP_LEFT);

        // Form labels and text inputs
        Label nameLabel = new Label("Name (First and Last name):");
        TextField nameField = new TextField();

        Label phoneLabel = new Label("Phone Number:");
        TextField phoneField = new TextField();

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

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
                dobField.getText().trim(),
                healthCardField.getText().trim(),
                phoneField.getText().trim(),
                addressField.getText().trim(),
                emailField.getText().trim(),
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
            alert.setContentText("Patient profile for " + newPatient.getName() + " was saved successfully.");
            alert.showAndWait();

            // Clear the form fields
            nameField.clear();
            dobField.clear();
            healthCardField.clear();
            phoneField.clear();
            addressField.clear();
            emailField.clear();
            recordsField.clear();
            statusLabel.setText("Last saved: " + newPatient.getName() + " (" + patientDatabase.size() + " total patients)");
        });

        // Assemble the UI controls into the layout
        layout.getChildren().addAll(
            nameLabel, nameField,
            dobLabel, dobField,
            healthCardLabel, healthCardField,
            phoneLabel, phoneField,         
            addressLabel, addressField,
            emailLabel, emailField,
            recordsLabel, recordsField,
            submitButton,
            statusLabel
        );

        // Wrap layout in a scroll pane to prevent clipping on smaller displays
        ScrollPane scrollPane = new ScrollPane(layout);
        scrollPane.setFitToWidth(true);

        Stage addPatientWin = new Stage();
        addPatientWin.setScene(new Scene(scrollPane, 480, 580));
        addPatientWin.setTitle("New Patient");
        addPatientWin.show();
    }

    // method invoked after View patient records button is clicked
    public void viewPatientButtonClicked() {
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));

        Label prompt = new Label("Enter health card number: ");
        TextField healthcardTF = new TextField();
        Button searchBtn = new Button("Search records");

        layout.getChildren().addAll(prompt, healthcardTF, searchBtn); 

        Stage viewRecordWin = new Stage();
        viewRecordWin.setScene(new Scene(layout, 350, 200));
        viewRecordWin.setTitle("View Patient Records");
        viewRecordWin.show();

        searchBtn.setOnAction(e -> {
            Patient targetPatient = null;  // to store target patient after they're found in records
            String healthID = healthcardTF.getText().trim();

            for (Patient pat : patientDatabase) {
                if (healthID.equals(pat.getHealthCardID())) {
                    targetPatient = pat;
                    break;
                }
            }

            if (targetPatient == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("No patient found with this health card number");
                alert.showAndWait();
            } else {
                VBox profileLayout = new VBox();
                Label profileLbl = new Label(targetPatient.toString());

                profileLayout.getChildren().addAll(profileLbl);

                Stage foundRecordWin = new Stage();
                foundRecordWin.setScene(new Scene(profileLayout, 350, 400));
                foundRecordWin.setTitle("Found Patient Records");
                foundRecordWin.show();

            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}