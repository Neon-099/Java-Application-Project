package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.Region;
import com.example.RecipeManagerApp;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class RecipeManager extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Main container
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: white;");
        
        // Header
        HBox header = createHeader();
        root.setTop(header);
        
        // Content
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: white;");
        
        VBox content = createContent();
        scrollPane.setContent(content);
        root.setCenter(scrollPane);
        
        // Create the scene
        Scene scene = new Scene(root, 1220, 700);
        primaryStage.setTitle("Recipe Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private HBox createHeader() {
        HBox header = new HBox();
        header.setPadding(new Insets(10));
        header.setStyle("-fx-background-color: beige brown;");
        header.setAlignment(Pos.CENTER_LEFT);
        
        // App icon and name
        HBox logoBox = new HBox(5);
        
        // Using text instead of image for simplicity
        Label iconLabel = new Label("🍴");
        iconLabel.setFont(Font.font("Arial", 18));
        
        Label appName = new Label("Recipe Manager");
        appName.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        
        logoBox.getChildren().addAll(iconLabel, appName);
        logoBox.setAlignment(Pos.CENTER_LEFT);
        
        
        // Add logo and menu to header
        header.getChildren().addAll(logoBox);
        header.setSpacing(100);
        
        return header;
    }
    
    private VBox createContent() {
        VBox content = new VBox(20);
        content.setPadding(new Insets(20));
        content.setStyle("-fx-background-color: white;");
        content.setAlignment(Pos.TOP_CENTER);
        
        // Title section
        Label titleLabel = new Label("Your Personal Recipe Assistant");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        titleLabel.setWrapText(true);
        titleLabel.setTextAlignment(TextAlignment.CENTER);
        titleLabel.setMaxWidth(260);
        
        Label subtitleLabel = new Label("Organize, create, and discover amazing recipes all in one place");
        subtitleLabel.setFont(Font.font("Arial", 14));
        subtitleLabel.setWrapText(true);
        subtitleLabel.setTextAlignment(TextAlignment.CENTER);
        subtitleLabel.setMaxWidth(260);
        
        // Start Button
        Button startButton = new Button("Start here");
        startButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        startButton.setStyle("-fx-background-color: #1a2639; -fx-text-fill: white;");
        startButton.setPrefWidth(240);
        startButton.setPrefHeight(40);
        
        // Simplified button click handler
        startButton.setOnAction(event -> {
            // Close current window
            Stage currentStage = (Stage) startButton.getScene().getWindow();
            currentStage.close();
            
            // Launch RecipeManagerApp
            RecipeManagerApp app = new RecipeManagerApp();
            Stage newStage = new Stage();
            app.start(newStage);
        });
        
        // Features section with image background
        VBox featuresSection = new VBox(20);
        
        try {
            // Load the background image
            Image backgroundImage = new Image("https://www.seriouseats.com/thmb/BBksd7FXnrkxFa8Dipf_LmgP9HA=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/Filipino-Features-Hero-Final-2-b785e627967843b0aa631c6a977adabe.jpg");
            
            // Create BackgroundImage
            BackgroundImage bImg = new BackgroundImage(
                backgroundImage, 
                BackgroundRepeat.NO_REPEAT, 
                BackgroundRepeat.NO_REPEAT, 
                BackgroundPosition.CENTER, 
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
            );
            
            // Set the background
            featuresSection.setBackground(new Background(bImg));
        } catch (Exception e) {
            // Fallback to a solid color if image fails to load
            featuresSection.setStyle("-fx-background-color: beige brown;");
            System.out.println("Failed to load background image: " + e.getMessage());
        }
        
        // Add a lighter overlay to see more of the image
        VBox overlay = new VBox(20);
        // Reduce opacity from 0.5 to 0.3 for more background visibility
        overlay.setStyle("-fx-background-color: rgba(0, 0, 0, 0.3);");
        overlay.setPadding(new Insets(40, 20, 40, 20));
        overlay.setAlignment(Pos.TOP_CENTER);
        
        // Feature section title with light color for better visibility on dark background
        Label featuresTitle = new Label("Key Features");
        featuresTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        featuresTitle.setPadding(new Insets(0, 0, 10, 0));
        featuresTitle.setStyle("-fx-text-fill: white;");
        
        // Add features to overlay
        overlay.getChildren().addAll(
            featuresTitle,
            createFeatureItem("📚", "Recipe Collection", "Save and organize your favorite recipes in one place"),
            createFeatureItem("🕒", "Meal Planning", "Plan your weekly meals with ease")
        );
        
        // Add overlay to features section
        featuresSection.getChildren().add(overlay);
        
        // Footer section with background
        VBox footer = new VBox(10);
        footer.setStyle("-fx-background-color: #1a2639;"); // Dark background
        footer.setPadding(new Insets(20));
        footer.setAlignment(Pos.CENTER);
        footer.setMinWidth(Region.USE_PREF_SIZE); // Make footer stretch full width
        
        Label footerText = new Label("© 2025 RecipeKeeper. All rights reserved.");
        footerText.setFont(Font.font("Arial", 12));
        footerText.setStyle("-fx-text-fill: white;"); // White text
        
        footer.getChildren().add(footerText);
        
        // Add all sections to main content
        content.getChildren().addAll(
            titleLabel, 
            subtitleLabel,
            startButton,
            featuresSection,
            footer
        );
        
        return content;
    }
    
    private VBox createFeatureItem(String icon, String title, String description) {
        VBox featureBox = new VBox(5);
        // Remove the white background, make it transparent with just a subtle border
        featureBox.setStyle("-fx-background-color: transparent; -fx-border-color: rgba(255,255,255,0.3); -fx-border-radius: 5;");
        featureBox.setPadding(new Insets(15));
        featureBox.setPrefWidth(240);
        
        // Feature icon - make it white for visibility on the background image
        Label iconLabel = new Label(icon);
        iconLabel.setFont(Font.font("Arial", 24));
        iconLabel.setStyle("-fx-text-fill: white;");
        
        // Feature title and description - make text white for visibility
        Label featureTitle = new Label(title);
        featureTitle.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        featureTitle.setStyle("-fx-text-fill: white;");
        
        Label featureDescription = new Label(description);
        featureDescription.setFont(Font.font("Arial", 14));
        featureDescription.setStyle("-fx-text-fill: white;");
        featureDescription.setWrapText(true);
        
        featureBox.getChildren().addAll(iconLabel, featureTitle, featureDescription);
        
        return featureBox;
    }

    
    public static void main(String[] args) {
        launch(args);
    }
}
