package com.example.login_form;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class ModifiedApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        // Header banner with new color scheme
        Label bannerLabel = new Label("Data Entry Portal");
        bannerLabel.setStyle("-fx-font-size: 26px; -fx-text-fill: #FFFFFF; -fx-font-family: 'Segoe UI'; -fx-font-style: italic; -fx-font-weight: bold;");
        StackPane banner = new StackPane(bannerLabel);
        banner.setStyle("-fx-background-color: #3F51B5; -fx-padding: 20;");

        // Username field
        Label usernameLabel = new Label("Full Name: ");
        usernameLabel.setStyle("-fx-font-size: 14px; -fx-font-family: 'Segoe UI'; -fx-font-style: italic; -fx-font-weight: bold; -fx-text-fill: #37474F;");
        TextField usernameField = new TextField();
        usernameField.setStyle("-fx-font-size: 14px; -fx-font-family: 'Segoe UI'; -fx-background-color: #ECEFF1;");

        // Fathername field
        Label fathernameLabel = new Label("Father's Name: ");
        fathernameLabel.setStyle("-fx-font-size: 14px; -fx-font-family: 'Segoe UI'; -fx-font-style: italic; -fx-font-weight: bold; -fx-text-fill: #37474F;");
        TextField fathernameField = new TextField();
        fathernameField.setStyle("-fx-font-size: 14px; -fx-font-family: 'Segoe UI'; -fx-background-color: #ECEFF1;");

        // City ComboBox
        Label cityLabel = new Label("City: ");
        cityLabel.setStyle("-fx-font-size: 14px; -fx-font-family: 'Segoe UI'; -fx-font-style: italic; -fx-font-weight: bold; -fx-text-fill: #37474F;");
        ComboBox<String> cityComboBox = new ComboBox<>();
        cityComboBox.getItems().addAll("Karachi", "Lahore", "Islamabad", "Peshawar", "Quetta");
        cityComboBox.setStyle("-fx-font-size: 14px; -fx-font-family: 'Segoe UI'; -fx-background-color: #ECEFF1;");

        // Gender selection
        Label genderLabel = new Label("Gender: ");
        genderLabel.setStyle("-fx-font-size: 14px; -fx-font-family: 'Segoe UI'; -fx-font-style: italic; -fx-font-weight: bold; -fx-text-fill: #37474F;");
        RadioButton maleRadioButton = new RadioButton("Male");
        maleRadioButton.setStyle("-fx-font-size: 14px; -fx-font-family: 'Segoe UI'; -fx-font-style: italic; -fx-font-weight: bold; -fx-text-fill: #455A64;");
        RadioButton femaleRadioButton = new RadioButton("Female");
        femaleRadioButton.setStyle("-fx-font-size: 14px; -fx-font-family: 'Segoe UI'; -fx-font-style: italic; -fx-font-weight: bold; -fx-text-fill: #455A64;");
        ToggleGroup genderGroup = new ToggleGroup();
        maleRadioButton.setToggleGroup(genderGroup);
        femaleRadioButton.setToggleGroup(genderGroup);

        // Image upload section
        ImageView imageView = new ImageView();
        imageView.setFitWidth(120);
        imageView.setFitHeight(120);
        imageView.setPreserveRatio(true);
        Button chooseImageButton = new Button("Upload Image");
        chooseImageButton.setStyle("-fx-font-size: 14px; -fx-font-family: 'Segoe UI'; -fx-background-color: #7986CB; -fx-text-fill: #FFFFFF; -fx-font-style: italic; -fx-font-weight: bold;");
        chooseImageButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", ".png", ".jpg", ".jpeg", ".gif"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
                Image image = new Image(selectedFile.toURI().toString());
                imageView.setImage(image);
            }
        });

        // Submit button
        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-font-size: 14px; -fx-font-family: 'Segoe UI'; -fx-background-color: #3F51B5; -fx-text-fill: #FFFFFF; -fx-font-style: italic; -fx-font-weight: bold;");
        submitButton.setOnAction(e -> {
            String username = usernameField.getText();
            String fathername = fathernameField.getText();
            String city = cityComboBox.getValue();
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";

            VBox resultLayout = new VBox(15);
            resultLayout.setStyle("-fx-padding: 25; -fx-background-color: #ECEFF1; -fx-alignment: center;");
            resultLayout.setAlignment(Pos.CENTER);

            Label usernameResultLabel = new Label("Name: " + username);
            usernameResultLabel.setStyle("-fx-font-size: 16px; -fx-font-family: 'Segoe UI'; -fx-font-style: italic; -fx-font-weight: bold; -fx-text-fill: #5eb53f;");
            Label fathernameResultLabel = new Label("Father's Name: " + fathername);
            fathernameResultLabel.setStyle("-fx-font-size: 16px; -fx-font-family: 'Segoe UI'; -fx-font-style: italic; -fx-font-weight: bold; -fx-text-fill: #5eb53f;");
            Label genderResultLabel = new Label("Gender: " + gender);
            genderResultLabel.setStyle("-fx-font-size: 16px; -fx-font-family: 'Segoe UI'; -fx-font-style: italic; -fx-font-weight: bold; -fx-text-fill: #5eb53f;");
            Label cityResultLabel = new Label("City: " + city);
            cityResultLabel.setStyle("-fx-font-size: 16px; -fx-font-family: 'Segoe UI'; -fx-font-style: italic; -fx-font-weight: bold; -fx-text-fill: #5eb53f;");

            resultLayout.getChildren().addAll(usernameResultLabel, fathernameResultLabel, genderResultLabel, cityResultLabel);
            if (imageView.getImage() != null) {
                resultLayout.getChildren().add(new Label("Uploaded Image:"));
                resultLayout.getChildren().add(imageView);
            }

            Scene resultScene = new Scene(resultLayout, 400, 400);
            stage.setScene(resultScene);
        });

        // Form layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(15);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameField, 1, 0);
        gridPane.add(fathernameLabel, 0, 1);
        gridPane.add(fathernameField, 1, 1);
        gridPane.add(genderLabel, 0, 2);
        gridPane.add(maleRadioButton, 1, 2);
        gridPane.add(femaleRadioButton, 1, 3);
        gridPane.add(cityLabel, 0, 4);
        gridPane.add(cityComboBox, 1, 4);
        gridPane.add(chooseImageButton, 0, 5);
        gridPane.add(imageView, 1, 5);
        gridPane.add(submitButton, 1, 6);

        VBox root = new VBox(20, banner, gridPane);
        root.setStyle("-fx-background-color: #FAFAFA; -fx-padding: 20;");
        root.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(root, 650, 600);
        stage.setScene(scene);
        stage.setTitle("Data Entry Form");
        stage.show();
    }
}