package com.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import com.example.RecipeManagerApp;

public class LoginSignupPage {
    private final Color ORANGE_BG = Color.rgb(255, 159, 67);
    private final Color LIGHT_ORANGE_BG = Color.rgb(255, 240, 230);
    private final Color DARK_GRAY = Color.rgb(51, 51, 51);
    private final Color WHITE = Color.rgb(255, 255, 255);

    public void showLoginPage(Stage stage) {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setBackground(new Background(new BackgroundFill(WHITE, null, null)));
        root.setPadding(new Insets(40));

        // Title
        Label titleLabel = new Label("Login");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(DARK_GRAY);

        // Login Form
        VBox form = new VBox(15);
        form.setAlignment(Pos.CENTER);
        form.setMaxWidth(300);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        styleTextField(usernameField);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        styleTextField(passwordField);

        Button loginButton = new Button("Login");
        styleButton(loginButton);
        loginButton.setOnAction(event -> {
            // Close the login window
            Stage currentStage = (Stage) loginButton.getScene().getWindow();
            currentStage.close();
            
            // Close the landing page (RecipeManager)
            Stage landingStage = (Stage) currentStage.getOwner();
            if (landingStage != null) {
                landingStage.close();
            }

            // Launch the Recipe Manager App
            RecipeManagerApp app = new RecipeManagerApp();
            Stage newStage = new Stage();
            app.start(newStage);
        });
        
        // Sign Up Link
        Hyperlink signupLink = new Hyperlink("Don't have an account? Sign Up");
        signupLink.setOnAction(e -> showSignupPage(stage));

        form.getChildren().addAll(usernameField, passwordField, loginButton, signupLink);
        root.getChildren().addAll(titleLabel, form);

        Scene scene = new Scene(root, 400, 500);
        stage.setScene(scene);
        stage.setTitle("Login - Recipe Manager");
        stage.show();
    }

    public void showSignupPage(Stage stage) {
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setBackground(new Background(new BackgroundFill(WHITE, null, null)));
        root.setPadding(new Insets(40));

        // Title
        Label titleLabel = new Label("Sign Up");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(DARK_GRAY);

        // Sign Up Form
        VBox form = new VBox(15);
        form.setAlignment(Pos.CENTER);
        form.setMaxWidth(300);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        styleTextField(usernameField);

        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        styleTextField(emailField);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        styleTextField(passwordField);

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm Password");
        styleTextField(confirmPasswordField);

        Button signupButton = new Button("Sign Up");
        styleButton(signupButton);
        signupButton.setOnAction(event -> {
            // Close the signup window
            Stage currentStage = (Stage) signupButton.getScene().getWindow();
            currentStage.close();
            
            // Close the landing page (RecipeManager)
            Stage landingStage = (Stage) currentStage.getOwner();
            if (landingStage != null) {
                landingStage.close();
            }

            // Launch the Recipe Manager App
            RecipeManagerApp app = new RecipeManagerApp();
            Stage newStage = new Stage();
            app.start(newStage);
        });

        // Login Link
        Hyperlink loginLink = new Hyperlink("Already have an account? Login");
        loginLink.setOnAction(e -> showLoginPage(stage));

        form.getChildren().addAll(usernameField, emailField, passwordField, confirmPasswordField, signupButton, loginLink);
        root.getChildren().addAll(titleLabel, form);

        Scene scene = new Scene(root, 400, 600);
        stage.setScene(scene);
        stage.setTitle("Sign Up - Recipe Manager");
        stage.show();
    }

    private void styleTextField(TextField textField) {
        textField.setStyle("-fx-background-color: #f5f5f5; -fx-background-radius: 5; -fx-padding: 10;");
        textField.setMaxWidth(300);
    }

    private void styleButton(Button button) {
        button.setStyle("-fx-background-color: #FF9F43; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10 20;");
        button.setMaxWidth(300);
    }
} 