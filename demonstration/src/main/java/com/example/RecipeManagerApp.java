package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class RecipeManagerApp extends Application {

    private BorderPane root;
    private VBox recipeContainer;
    
    // TRACK LAST SELECTED CATEGORY
    private String lastSelectedCategory = "Main Dishes"; // default category
    
    // HASHMAP TO STORE RECIPE DATA (WHEN ADDING NEW RECIPE)
    private Map<String, Recipe> recipeData = new HashMap<>();
    
    // HASHMAP TO STORE MEAL PLANS
    private Map<String, List<Recipe>> mealPlans = new HashMap<>();
    
    @Override
    public void start(Stage primaryStage) {
        // Initialize recipe data from RecipeData class
        recipeData = RecipeData.loadDefaultRecipes();
        
        // Main container
        root = new BorderPane();
        root.setStyle("-fx-background-color: #f5f5f5;");
        
        // Top header
        HBox header = createHeader();
        
        root.setTop(header);
        
        // Left sidebar
        VBox sidebar = createSidebar();
        sidebar.setStyle("-fx-background-color: #FFA53F");
        root.setLeft(sidebar);
        
        // Center content - Recipe cards
        recipeContainer = createRecipeCardsContainer();
        ScrollPane scrollPane = new ScrollPane(recipeContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent;");
        root.setCenter(scrollPane);
        
        // Footer
        HBox footer = createFooter();
        root.setBottom(footer);
        
        // Create the scene
        Scene scene = new Scene(root, 1400, 700);
        primaryStage.setTitle("Recipe Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private HBox createHeader() {
        HBox header = new HBox();
        header.setPadding(new Insets(15, 25, 15, 25));
        header.setStyle("-fx-background-color: #FFA53F; -fx-border-width: 0 0 1 0;");
        header.setAlignment(Pos.CENTER_LEFT);
        
        // Logo
        Label iconLabel = new Label("🍴");
        iconLabel.setFont(Font.font("Arial", 20));
        
        // App name
        Label appName = new Label("Recipe Manager");
        appName.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        appName.setPadding(new Insets(0, 0, 0, 5));
        
        // Search bar
        HBox searchContainer = new HBox();
        searchContainer.setAlignment(Pos.CENTER);
        searchContainer.setPadding(new Insets(0, 0, 0, 50));
        HBox.setHgrow(searchContainer, Priority.ALWAYS);
        
        TextField searchField = new TextField();
        searchField.setPromptText("Search recipes...");
        searchField.setPrefWidth(400);
        searchField.setPadding(new Insets(8));
        
        // Search icon
        Label searchIcon = new Label("🔍");
        searchIcon.setPadding(new Insets(0, 10, 0, 0));
        
        searchContainer.getChildren().addAll(searchIcon, searchField);
        
        // Real-time search functionality
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            handleSearch(newValue);
        });
        
        // Add Recipe button
        Button addRecipeButton = new Button("+ Add Recipe");
        addRecipeButton.setStyle("-fx-background-color: #3a3f44; -fx-text-fill: white; -fx-font-weight: bold;");
        addRecipeButton.setPadding(new Insets(8, 15, 8, 15));
        
        // Add event handler
        addRecipeButton.setOnAction(event -> handleAddRecipe());
        
        // Add children to header
        header.getChildren().addAll(iconLabel, appName, searchContainer, addRecipeButton);
        
        return header;
    }
    
    private VBox createSidebar() {
        VBox sidebar = new VBox(10);
        sidebar.setPadding(new Insets(20));
        sidebar.setStyle("-fx-background-color: white; -fx-border-color: #e0e0e0; -fx-border-width: 0 1 0 0;");
        sidebar.setPrefWidth(220);
        
        // Categories title
        Label categoriesLabel = new Label("Categories");
        categoriesLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        categoriesLabel.setPadding(new Insets(0, 0, 10, 0));
        
        // Category buttons
        VBox categoryButtons = new VBox(5);
        
        Button mainDishesBtn = createCategoryButton("🍽️ Main Dishes");
        Button soupsBtn = createCategoryButton("🍲 Soups");
        Button dessertsBtn = createCategoryButton("🍰 Desserts");
        Button beveragesBtn = createCategoryButton("🥤 Beverages");
        
        categoryButtons.getChildren().addAll(mainDishesBtn, soupsBtn, dessertsBtn, beveragesBtn);
        
        // Add Meal Planning section
        Label mealPlanLabel = new Label("Meal Planning");
        mealPlanLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        mealPlanLabel.setPadding(new Insets(20, 0, 10, 0));
        
        VBox mealPlanButtons = new VBox(5);
        
        Button mondayBtn = createMealPlanButton("Monday");
        Button tuesdayBtn = createMealPlanButton("Tuesday");
        Button wednesdayBtn = createMealPlanButton("Wednesday");
        Button thursdayBtn = createMealPlanButton("Thursday");
        Button fridayBtn = createMealPlanButton("Friday");
        Button saturdayBtn = createMealPlanButton("Saturday");
        Button sundayBtn = createMealPlanButton("Sunday");
        
        mealPlanButtons.getChildren().addAll(
            mondayBtn, tuesdayBtn, wednesdayBtn, thursdayBtn,
            fridayBtn, saturdayBtn, sundayBtn
        );
        
        sidebar.getChildren().addAll(categoriesLabel, categoryButtons, mealPlanLabel, mealPlanButtons);
        
        return sidebar;
    }
    
    private Button createCategoryButton(String text) {
        Button button = new Button(text);
        button.setStyle("-fx-background-color: #f5f5f5; -fx-text-fill: black; -fx-alignment: CENTER_LEFT;");
        button.setMaxWidth(Double.MAX_VALUE);
        button.setPadding(new Insets(10, 15, 10, 10));
        
        // Add event handler
        button.setOnAction(event -> handleCategoryClick(text));
        
        return button;
    }
    
    private Button createMealPlanButton(String day) {
        Button button = new Button("📅 " + day);
        button.setStyle("-fx-background-color: #f5f5f5; -fx-text-fill: black; -fx-alignment: CENTER_LEFT;");
        button.setMaxWidth(Double.MAX_VALUE);
        button.setPadding(new Insets(10, 15, 10, 10));
        
        // Add event handler
        button.setOnAction(event -> handleMealPlanClick(day));
        
        return button;
    }
    
    private VBox createRecipeCardsContainer() {
        VBox container = new VBox(20);
        container.setPadding(new Insets(20));
        
        // Create sections for each category
        VBox mainDishesSection = createCategorySection("Main Dishes");
        VBox soupsSection = createCategorySection("Soups");
        VBox dessertsSection = createCategorySection("Desserts");
        VBox beveragesSection = createCategorySection("Beverages");
        
        // Create FlowPane for each category to allow wrapping of cards
        // Adjust the spacing between cards (both horizontal and vertical)
        double spacing = 15;
        FlowPane mainDishesFlow = createFlowPane(spacing);
        FlowPane soupsFlow = createFlowPane(spacing);
        FlowPane dessertsFlow = createFlowPane(spacing);
        FlowPane beveragesFlow = createFlowPane(spacing);
        
        // Add recipe cards from recipeData
        for (Recipe recipe : recipeData.values()) {
            FlowPane targetFlow;
            VBox targetSection;
            
            switch (recipe.category.substring(recipe.category.indexOf(" ") + 1)) {
                case "Main Dishes":
                    targetFlow = mainDishesFlow;
                    targetSection = mainDishesSection;
                    break;
                case "Soups":
                    targetFlow = soupsFlow;
                    targetSection = soupsSection;
                    break;
                case "Desserts":
                    targetFlow = dessertsFlow;
                    targetSection = dessertsSection;
                    break;
                case "Beverages":
                    targetFlow = beveragesFlow;
                    targetSection = beveragesSection;
                    break;
                default:
                    continue;
            }
            
            VBox recipeCard = createRecipeCard(recipe.name, recipe.time, recipe.category);
            recipeCard.setPrefWidth(300); // Make cards slightly smaller
            targetFlow.getChildren().add(recipeCard);
            
            // Add flow pane to section if not already added
            if (!targetSection.getChildren().contains(targetFlow)) {
                targetSection.getChildren().add(targetFlow);
            }
        }
        
        container.getChildren().addAll(mainDishesSection, soupsSection, dessertsSection, beveragesSection);
        return container;
    }
    
    private VBox createCategorySection(String categoryName) {
        VBox section = new VBox(10);
        section.setId(categoryName.toLowerCase().replace(" ", "-")); // for scrolling
        
        Label categoryTitle = new Label(categoryName);
        categoryTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        categoryTitle.setPadding(new Insets(20, 0, 10, 0));
        
        section.getChildren().add(categoryTitle);
        return section;
    }
    
    private VBox createRecipeCard(String recipeName, String time, String category) {
        VBox card = new VBox(0); // Reduce spacing between image and content
        card.setStyle("-fx-background-color: white; -fx-border-radius: 5; -fx-background-radius: 5; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 4, 0, 0, 2);");
        
        // Adjust the card width to better fit the layout
        card.setPrefWidth(400);
        card.setMinWidth(320);
        card.setMaxWidth(320);
        
        // Image container - make it fill the card width completely
        ImageView imageView = createRecipeImageView(recipeName);
        
        // Set the image to fill the entire width of the card
        imageView.setFitWidth(320);
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(false); // Allow image to stretch to fill space
        
        // Recipe info - reduce padding to minimize white space
        VBox recipeInfo = new VBox(2); // Reduce spacing between elements
        recipeInfo.setPadding(new Insets(8, 10, 8, 10)); // Reduce padding
        
        Label nameLabel = new Label(recipeName);
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        nameLabel.setWrapText(true);
        nameLabel.setPrefHeight(40); // Fixed height for title to ensure consistent card height
        
        // Meta info with more compact layout
        HBox metaInfo = new HBox(8); // Reduce spacing
        metaInfo.setPadding(new Insets(0, 0, 2, 0)); // Minimal padding
        
        Label timeInfo = new Label("🕒 " + time);
        timeInfo.setFont(Font.font("Arial", 11));
        
        // Make the category text smaller
        Label categoryInfo = new Label(category);
        categoryInfo.setFont(Font.font("Arial", 11));
        
        metaInfo.getChildren().addAll(timeInfo, categoryInfo);
        
        // Action buttons in a more compact layout
        HBox actions = new HBox(5);
        actions.setPrefWidth(Double.MAX_VALUE);
        actions.setAlignment(Pos.CENTER_LEFT);
        
        Button viewButton = new Button("👁️ View");
        viewButton.setStyle("-fx-background-color: transparent; -fx-padding: 2 5;");
        viewButton.setFont(Font.font("Arial", 11));
        
        Button editButton = new Button("✏️ Edit");
        editButton.setStyle("-fx-background-color: transparent; -fx-padding: 2 5;");
        editButton.setFont(Font.font("Arial", 11));
        
        Button deleteButton = new Button("🗑️ Delete");
        deleteButton.setStyle("-fx-background-color: transparent; -fx-padding: 2 5;");
        deleteButton.setFont(Font.font("Arial", 11));
        
        Button planMealButton = new Button("📅 Plan");
        planMealButton.setStyle("-fx-background-color: transparent; -fx-padding: 2 5;");
        planMealButton.setFont(Font.font("Arial", 11));
        
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        actions.getChildren().addAll(viewButton, editButton, deleteButton, planMealButton, spacer);

        // Add event handlers
        viewButton.setOnAction(event -> handleViewRecipe(recipeName));
        editButton.setOnAction(event -> handleEditRecipe(recipeName));
        deleteButton.setOnAction(event -> handleDeleteRecipe(recipeName));
        planMealButton.setOnAction(event -> showMealPlanDialog(recipeName));
        
        recipeInfo.getChildren().addAll(nameLabel, metaInfo, actions);
        card.getChildren().addAll(imageView, recipeInfo);
        
        card.setUserData(recipeName);
        return card;
    }
    
    private FlowPane createFlowPane(double spacing) {
        // Reduce spacing between cards to allow more cards to fit
        FlowPane flowPane = new FlowPane(spacing, spacing);
        // Set a hgap and vgap directly
        flowPane.setHgap(18);
        flowPane.setVgap(18);
        // Make the cards flow better by adjusting wrap length
        flowPane.setPrefWrapLength(1200); // Match the scene width
        flowPane.setAlignment(Pos.TOP_LEFT);
        return flowPane;
    }
    
    //IMAGES HANDLING
    private ImageView createRecipeImageView(String recipeName) {
        ImageView imageView = new ImageView();
        imageView.setFitWidth(450);  // Match the card width
        imageView.setFitHeight(250); // Fixed height for consistency
        imageView.setPreserveRatio(false); // Allow image to stretch to fill space
        imageView.setSmooth(true);

        Recipe recipe = recipeData.get(recipeName);
        if (recipe != null && recipe.imageUrl != null && !recipe.imageUrl.isEmpty()) {
            try {
                // Log the image URL
                System.out.println("Loading image from URL: " + recipe.imageUrl);

                String imageUrl = recipe.imageUrl;
                
                // Handle different types of paths
                if (imageUrl.startsWith("http") || imageUrl.startsWith("https")) {
                    // Direct URL - use as is
                } else if (imageUrl.startsWith("/")) {
                    // Absolute path from resources root
                    imageUrl = getClass().getResource(imageUrl).toExternalForm();
                } else {
                    // Relative path - try to resolve from classpath
                    imageUrl = getClass().getResource("/" + imageUrl).toExternalForm();
                }
                
                System.out.println("Resolved image URL: " + imageUrl);
                Image image = new Image(imageUrl, true);
                imageView.setImage(image);
            } catch (Exception e) {
                System.out.println("Failed to load image for " + recipeName + ": " + e.getMessage());
                setDefaultImage(imageView);
            }
        } else {
            setDefaultImage(imageView);
        }

        return imageView;
    }
    
    // Helper method to set default image
    private void setDefaultImage(ImageView imageView) {
        // You can replace this URL with any default food image URL
        String defaultImageUrl = "https://via.placeholder.com/300x150.png?text=No+Image";
        try {
            Image defaultImage = new Image(defaultImageUrl, true);
            imageView.setImage(defaultImage);
        } catch (Exception e) {
            // If even default image fails, use colored background
            StackPane placeholder = new StackPane();
            placeholder.setPrefHeight(150);
            placeholder.setStyle("-fx-background-color: #f0f0f0;");
            Label imageIcon = new Label("🖼️");
            imageIcon.setFont(Font.font("Arial", 24));
            placeholder.getChildren().add(imageIcon);
            imageView.setImage(null);
        }
    }
    
    private HBox createFooter() {
        HBox footer = new HBox();
        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(15));
        footer.setStyle("-fx-background-color: #3a3f44; -fx-border-width: 1 0 0 0;");
        
        Label copyrightLabel = new Label("© 2025 Recipe Manager.");
        copyrightLabel.setStyle("-fx-text-fill: white;");
        footer.getChildren().add(copyrightLabel);
        
        return footer;
    }
    
    // Event handlers  (ADD NEW RECIPE BAR)
    private void handleAddRecipe() {
        //ADD NEW RECIPE DIALOG
        Dialog<Recipe> dialog = new Dialog<>();
        dialog.setTitle("Add New Recipe");
        dialog.setHeaderText(null);

        ButtonType saveButtonType = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        TextField nameField = new TextField();
        TextField timeField = new TextField();
        TextField imageUrlField = new TextField();
        TextArea ingredientsArea = new TextArea();
        TextArea instructionsArea = new TextArea();

        ingredientsArea.setPrefRowCount(4);
        instructionsArea.setPrefRowCount(4);

        // Style headers
        Label ingredientsHeader = new Label("Ingredients");
        ingredientsHeader.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        Label instructionsHeader = new Label("Instructions");
        instructionsHeader.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        grid.add(new Label("Recipe Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Cooking Time:"), 0, 1);
        grid.add(timeField, 1, 1);
        grid.add(new Label("Image URL (optional):"), 0, 2);
        grid.add(imageUrlField, 1, 2);
        grid.add(ingredientsHeader, 0, 3, 2, 1);
        grid.add(ingredientsArea, 0, 4, 2, 1);
        grid.add(instructionsHeader, 0, 5, 2, 1);
        grid.add(instructionsArea, 0, 6, 2, 1);

        dialog.getDialogPane().setContent(grid);

        // SET THE RESULT CONVERTER (RECIPE OBJECT)
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == saveButtonType) {
                String categoryWithEmoji = getCategoryEmoji(lastSelectedCategory) + " " + lastSelectedCategory;
                return new Recipe(
                    nameField.getText(),
                    timeField.getText(),
                    categoryWithEmoji,
                    ingredientsArea.getText(),
                    instructionsArea.getText(),
                    imageUrlField.getText().trim().isEmpty() ? null : imageUrlField.getText().trim()
                );
            }
            return null;
        });

        // Show the dialog and handle the result
        dialog.showAndWait().ifPresent(recipe -> {
            // ADD THE RECIPE TO THE DATA HASHMAP
            recipeData.put(recipe.name, recipe);
            
            // FIND THE SECTION FOR THE LAST SELECTED CATEGORY
            String sectionId = lastSelectedCategory.toLowerCase().replace(" ", "-");
            VBox categorySection = (VBox) recipeContainer.lookup("#" + sectionId);
            
            if (categorySection != null) {
                // FIND OR CREATE FLOW PANE FOR THE CATEGORY
                FlowPane flowPane = null;
                for (Node node : categorySection.getChildren()) {
                    if (node instanceof FlowPane) {
                        flowPane = (FlowPane) node;
                        break;
                    }
                }
                
                if (flowPane == null) {
                    flowPane = new FlowPane(20, 20);
                    flowPane.setPrefWrapLength(1000);
                    flowPane.setAlignment(Pos.TOP_LEFT);
                    categorySection.getChildren().add(flowPane);
                }
                
                // CREATE AND ADD THE NEW RECIPE CARD
                VBox recipeCard = createRecipeCard(recipe.name, recipe.time, recipe.category);
                recipeCard.setPrefWidth(300);
                flowPane.getChildren().add(recipeCard);
                
                // Scroll to the category section
                ScrollPane scrollPane = (ScrollPane) root.getCenter();
                double height = scrollPane.getContent().getBoundsInLocal().getHeight();
                double y = categorySection.getBoundsInParent().getMinY();
                scrollPane.setVvalue(y / height);
                
                // Focus on the new recipe card
                recipeCard.requestFocus();
            }
        });
    }
    

        //EDIT RECIPE HANDLING
    private void handleEditRecipe(String recipeName) {
        Recipe recipe = recipeData.get(recipeName);
        if (recipe == null) return;

        Dialog<Recipe> dialog = new Dialog<>();
        dialog.setTitle("Edit Recipe");
        dialog.setHeaderText(null);

        ButtonType saveButtonType = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        TextField nameField = new TextField(recipe.name);
        TextField timeField = new TextField(recipe.time);
        TextField imageUrlField = new TextField(recipe.imageUrl != null ? recipe.imageUrl : "");
        TextArea ingredientsArea = new TextArea(recipe.ingredients);
        TextArea instructionsArea = new TextArea(recipe.instructions);

        ingredientsArea.setPrefRowCount(4);
        instructionsArea.setPrefRowCount(4);

        // Style headers
        Label ingredientsHeader = new Label("Ingredients");
        ingredientsHeader.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        Label instructionsHeader = new Label("Instructions");
        instructionsHeader.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        grid.add(new Label("Recipe Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Cooking Time:"), 0, 1);
        grid.add(timeField, 1, 1);
        grid.add(new Label("Image URL (optional):"), 0, 2);
        grid.add(imageUrlField, 1, 2);
        grid.add(ingredientsHeader, 0, 3, 2, 1);
        grid.add(ingredientsArea, 0, 4, 2, 1);
        grid.add(instructionsHeader, 0, 5, 2, 1);
        grid.add(instructionsArea, 0, 6, 2, 1);

        dialog.getDialogPane().setContent(grid);

        // Set the result converter
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == saveButtonType) {
                return new Recipe(
                    nameField.getText(),
                    timeField.getText(),
                    recipe.category, // Keep the same category
                    ingredientsArea.getText(),
                    instructionsArea.getText(),
                    imageUrlField.getText().trim().isEmpty() ? null : imageUrlField.getText().trim()
                );
            }
            return null;
        });

        // Show the dialog and handle the result
        dialog.showAndWait().ifPresent(updatedRecipe -> {
            // Remove the old recipe
            recipeData.remove(recipeName);
            // Add the updated recipe
            recipeData.put(updatedRecipe.name, updatedRecipe);
            
            // Refresh the recipe display
            refreshRecipeDisplay(recipeData);
        });
    }

    //DELETE RECIPE HANDLING
    private void handleDeleteRecipe(String recipeName) {
        // Create confirmation dialog
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Recipe");
        alert.setHeaderText("Are you sure you want to delete this recipe?");
        alert.setContentText("This action cannot be undone.");
        
        // Customize the buttons
        ButtonType deleteButton = new ButtonType("Delete", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(deleteButton, cancelButton);
        
        // Show the dialog and handle the result
        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == deleteButton) {
                // Remove the recipe from the data map
                recipeData.remove(recipeName);
                
                // Remove the recipe from any meal plans
                for (List<Recipe> dayMeals : mealPlans.values()) {
                    dayMeals.removeIf(r -> r.name.equals(recipeName));
                }
                
                // Refresh the display
                refreshRecipeDisplay(recipeData);
                
                // Show success message
                showAlert("Recipe Deleted", "The recipe has been successfully deleted.");
            }
        });
    }

    //SEARCH HANDLING
    private void handleSearch(String query) {
        if (query == null || query.trim().isEmpty()) {
            // If search is empty, show all recipes
            refreshRecipeDisplay(recipeData);
            return;
        }
        
        // Convert query to lowercase and split into words
        String[] searchWords = query.toLowerCase().trim().split("\\s+");
        
        // Create a map for filtered recipes
        Map<String, Recipe> filteredRecipes = new HashMap<>();
        
        // Search through all recipes using exact word matching
        for (Recipe recipe : recipeData.values()) {
            // Combine all recipe fields into one text
            String recipeText = (recipe.name + " " + recipe.ingredients + " " + 
                               recipe.instructions + " " + recipe.category + " " + 
                               recipe.time).toLowerCase();
            
            // Split recipe text into words
            String[] recipeWords = recipeText.split("\\s+");
            
            // Check if any of the search words match any recipe word
            for (String searchWord : searchWords) {
                boolean wordFound = false;
                for (String recipeWord : recipeWords) {
                    if (recipeWord.equals(searchWord)) {
                        wordFound = true;
                        break;
                    }
                }
                if (wordFound) {
                    filteredRecipes.put(recipe.name, recipe);
                    break; // Found a match, no need to check other search words
                }
            }
        }
        
        // Update the display with filtered recipes
        refreshRecipeDisplay(filteredRecipes);
    }
    
    private void refreshRecipeDisplay(Map<String, Recipe> recipesToShow) {
        // Clear existing recipe container
        recipeContainer.getChildren().clear();
        
        // Create new sections for each category
        VBox mainDishesSection = createCategorySection("Main Dishes");
        VBox soupsSection = createCategorySection("Soups");
        VBox dessertsSection = createCategorySection("Desserts");
        VBox beveragesSection = createCategorySection("Beverages");
        
        // Create FlowPane for each category with adjusted spacing
        double spacing = 15;
        FlowPane mainDishesFlow = createFlowPane(spacing);
        FlowPane soupsFlow = createFlowPane(spacing);
        FlowPane dessertsFlow = createFlowPane(spacing);
        FlowPane beveragesFlow = createFlowPane(spacing);
        
        // Sort recipes into categories
        for (Recipe recipe : recipesToShow.values()) {
            FlowPane targetFlow;
            VBox targetSection;
            
            switch (recipe.category.substring(recipe.category.indexOf(" ") + 1)) {
                case "Main Dishes":
                    targetFlow = mainDishesFlow;
                    targetSection = mainDishesSection;
                    break;
                case "Soups":
                    targetFlow = soupsFlow;
                    targetSection = soupsSection;
                    break;
                case "Desserts":
                    targetFlow = dessertsFlow;
                    targetSection = dessertsSection;
                    break;
                case "Beverages":
                    targetFlow = beveragesFlow;
                    targetSection = beveragesSection;
                    break;
                default:
                    continue;
            }
            
            VBox recipeCard = createRecipeCard(recipe.name, recipe.time, recipe.category);
            recipeCard.setPrefWidth(500); // Use consistent width (changing this will change the width of the cards)
            targetFlow.getChildren().add(recipeCard);
            
            // Add flow pane to section if not empty
            if (!targetFlow.getChildren().isEmpty() && !targetSection.getChildren().contains(targetFlow)) {
                targetSection.getChildren().add(targetFlow);
            }
        }
        
        // Only add sections that have recipes
        if (!mainDishesSection.getChildren().isEmpty()) recipeContainer.getChildren().add(mainDishesSection);
        if (!soupsSection.getChildren().isEmpty()) recipeContainer.getChildren().add(soupsSection);
        if (!dessertsSection.getChildren().isEmpty()) recipeContainer.getChildren().add(dessertsSection);
        if (!beveragesSection.getChildren().isEmpty()) recipeContainer.getChildren().add(beveragesSection);
        
        // If no results found, show a message
        if (recipeContainer.getChildren().isEmpty()) {
            VBox noResultsBox = new VBox();
            noResultsBox.setAlignment(Pos.CENTER);
            noResultsBox.setPadding(new Insets(50));
            
            Label noResultsLabel = new Label("No recipes found");
            noResultsLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
            noResultsLabel.setStyle("-fx-text-fill: #666666;");
            
            noResultsBox.getChildren().add(noResultsLabel);
            recipeContainer.getChildren().add(noResultsBox);
        }
    }
    
    private void handleCategoryClick(String category) {
        // Extract category name from button text (remove emoji)
        String categoryName = category.substring(category.indexOf(" ") + 1);
        lastSelectedCategory = categoryName; // Update last selected category
        
        // Find the section by ID and scroll to it
        String sectionId = categoryName.toLowerCase().replace(" ", "-");
        Node section = recipeContainer.lookup("#" + sectionId);
        
        if (section != null) {
            section.requestFocus();
            ScrollPane scrollPane = (ScrollPane) root.getCenter();
            double height = scrollPane.getContent().getBoundsInLocal().getHeight();
            double y = section.getBoundsInParent().getMinY();
            scrollPane.setVvalue(y / height);
        }
    }
    
    private void handleViewRecipe(String recipeName) {
        VBox recipeCard = findRecipeCard(recipeName);
        if (recipeCard == null) return;

        Recipe recipe = recipeData.get(recipeName);
        if (recipe == null) return;

        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("View Recipe");
        dialog.setHeaderText(null);

        ButtonType closeButtonType = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().add(closeButtonType);

        VBox content = new VBox(15);
        content.setPadding(new Insets(20));
        content.setPrefWidth(500);
        content.setStyle("-fx-background-color: white;");

        // Recipe Title
        Label titleLabel = new Label(recipe.name);
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setWrapText(true);

        // Meta information (time and category)
        HBox metaInfo = new HBox(15);
        metaInfo.setAlignment(Pos.CENTER_LEFT);
        Label timeLabel = new Label("🕒 " + recipe.time);
        timeLabel.setFont(Font.font("Arial", 14));
        Label categoryLabel = new Label(recipe.category);
        categoryLabel.setFont(Font.font("Arial", 14));
        metaInfo.getChildren().addAll(timeLabel, categoryLabel);

        // Separator
        Separator separator = new Separator();
        separator.setStyle("-fx-background-color: #e0e0e0;");

        // Ingredients Section
        Label ingredientsTitle = new Label("Ingredients");
        ingredientsTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        ingredientsTitle.setPadding(new Insets(10, 0, 5, 0));

        TextArea ingredientsArea = new TextArea(recipe.ingredients);
        ingredientsArea.setEditable(false);
        ingredientsArea.setWrapText(true);
        ingredientsArea.setPrefRowCount(6);
        ingredientsArea.setStyle("-fx-control-inner-background: #f8f8f8; -fx-background-color: #f8f8f8; -fx-border-color: #e0e0e0;");

        // Instructions Section
        Label instructionsTitle = new Label("Instructions");
        instructionsTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        instructionsTitle.setPadding(new Insets(10, 0, 5, 0));

        TextArea instructionsArea = new TextArea(recipe.instructions);
        instructionsArea.setEditable(false);
        instructionsArea.setWrapText(true);
        instructionsArea.setPrefRowCount(8);
        instructionsArea.setStyle("-fx-control-inner-background: #f8f8f8; -fx-background-color: #f8f8f8; -fx-border-color: #e0e0e0;");

        // Add all components to the content
        content.getChildren().addAll(
            titleLabel,
            metaInfo,
            separator,
            ingredientsTitle,
            ingredientsArea,
            instructionsTitle,
            instructionsArea
        );

        ScrollPane scrollPane = new ScrollPane(content);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: white;");

        dialog.getDialogPane().setContent(scrollPane);
        dialog.getDialogPane().setPrefWidth(550);
        dialog.getDialogPane().setPrefHeight(600);
        
        // Set dialog style
        dialog.getDialogPane().setStyle("-fx-background-color: white;");
        
        dialog.showAndWait();
    }
    
    private void handleMealPlanClick(String day) {
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Meal Plan for " + day);
        dialog.setHeaderText(null);
        
        ButtonType closeButton = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().add(closeButton);
        
        VBox content = new VBox(15);
        content.setPadding(new Insets(20));
        content.setStyle("-fx-background-color: white;");
        
        Label headerLabel = new Label("Planned Meals for " + day);
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        
        List<Recipe> plannedMeals = mealPlans.getOrDefault(day, new ArrayList<>());
        
        if (plannedMeals.isEmpty()) {
            Label placeholder = new Label("No meals planned yet");
            placeholder.setStyle("-fx-text-fill: #666666;");
            content.getChildren().addAll(headerLabel, placeholder);
        } else {
            VBox mealsContainer = new VBox(10);
            
            for (Recipe recipe : plannedMeals) {
                // Enhanced meal card with more details
                VBox mealCard = new VBox(10);
                mealCard.setStyle("-fx-background-color: #f8f8f8; -fx-padding: 15; -fx-background-radius: 5;");
                
                // Header with name and remove button
                HBox header = new HBox(10);
                header.setAlignment(Pos.CENTER_LEFT);
                
                Label nameLabel = new Label(recipe.name);
                nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                
                Region spacer = new Region();
                HBox.setHgrow(spacer, Priority.ALWAYS);
                
                Button removeButton = new Button("❌");
                removeButton.setStyle("-fx-background-color: transparent;");
                
                header.getChildren().addAll(nameLabel, spacer, removeButton);
                
                // Recipe details
                HBox details = new HBox(15);
                details.setAlignment(Pos.CENTER_LEFT);
                
                Label timeLabel = new Label("🕒 " + recipe.time);
                Label categoryLabel = new Label(recipe.category);
                
                details.getChildren().addAll(timeLabel, categoryLabel);
                
                // Preview of ingredients
                Label ingredientsLabel = new Label("Ingredients:");
                ingredientsLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                
                TextArea ingredientsPreview = new TextArea(recipe.ingredients);
                ingredientsPreview.setEditable(false);
                ingredientsPreview.setWrapText(true);
                ingredientsPreview.setPrefRowCount(2);
                ingredientsPreview.setStyle("-fx-control-inner-background: #ffffff;");
                
                // View full recipe button
                Button viewButton = new Button("👁️ View Full Recipe");
                viewButton.setStyle("-fx-background-color: #3a3f44; -fx-text-fill: white;");
                
                mealCard.getChildren().addAll(
                    header,
                    details,
                    ingredientsLabel,
                    ingredientsPreview,
                    viewButton
                );
                
                // Add event handlers
                removeButton.setOnAction(e -> {
                    plannedMeals.remove(recipe);
                    if (plannedMeals.isEmpty()) {
                        mealPlans.remove(day);
                        content.getChildren().clear();
                        Label noMealsLabel = new Label("No meals planned yet");
                        noMealsLabel.setStyle("-fx-text-fill: #666666;");
                        content.getChildren().addAll(headerLabel, noMealsLabel);
                    } else {
                        mealsContainer.getChildren().remove(mealCard);
                    }
                });
                
                viewButton.setOnAction(e -> handleViewRecipe(recipe.name));
                
                mealsContainer.getChildren().add(mealCard);
            }
            
            content.getChildren().addAll(headerLabel, mealsContainer);
        }
        
        ScrollPane scrollPane = new ScrollPane(content);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: white;");
        
        dialog.getDialogPane().setContent(scrollPane);
        dialog.getDialogPane().setPrefWidth(450);
        dialog.getDialogPane().setPrefHeight(600);
        
        dialog.showAndWait();
    }
    
    private void showMealPlanDialog(String recipeName) {
        Recipe recipe = recipeData.get(recipeName);
        if (recipe == null) return;
        
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Add to Meal Plan");
        dialog.setHeaderText("Choose a day to add " + recipeName);
        
        ButtonType addButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);
        
        VBox content = new VBox(15);
        content.setPadding(new Insets(20));
        
        // Add recipe preview
        VBox recipePreview = new VBox(10);
        recipePreview.setStyle("-fx-background-color: #f8f8f8; -fx-padding: 15; -fx-background-radius: 5;");
        
        // Recipe image
        ImageView imageView = createRecipeImageView(recipeName);
        imageView.setFitWidth(200);
        imageView.setFitHeight(120);
        
        // Recipe details
        Label nameLabel = new Label(recipe.name);
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        
        Label timeLabel = new Label("🕒 " + recipe.time);
        Label categoryLabel = new Label(recipe.category);
        
        // Preview of ingredients
        Label ingredientsTitle = new Label("Ingredients:");
        ingredientsTitle.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        TextArea ingredientsPreview = new TextArea(recipe.ingredients);
        ingredientsPreview.setEditable(false);
        ingredientsPreview.setWrapText(true);
        ingredientsPreview.setPrefRowCount(3);
        ingredientsPreview.setStyle("-fx-control-inner-background: #ffffff;");
        
        recipePreview.getChildren().addAll(
            imageView, 
            nameLabel, 
            timeLabel, 
            categoryLabel,
            ingredientsTitle,
            ingredientsPreview
        );
        
        // Day selection
        Label selectDayLabel = new Label("Select day to add this meal:");
        selectDayLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        selectDayLabel.setPadding(new Insets(10, 0, 5, 0));
        
        ComboBox<String> dayPicker = new ComboBox<>();
        dayPicker.getItems().addAll(
            "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday"
        );
        dayPicker.setValue("Monday");
        dayPicker.setMaxWidth(Double.MAX_VALUE);
        
        content.getChildren().addAll(recipePreview, selectDayLabel, dayPicker);
        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().setPrefWidth(300);
        
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButton) {
                return dayPicker.getValue();
            }
            return null;
        });
        
        dialog.showAndWait().ifPresent(day -> {
            mealPlans.computeIfAbsent(day, k -> new ArrayList<>()).add(recipe);
            showAlert(
                "Meal Planned",
                recipeName + " has been added to your meal plan for " + day
            );
        });
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Add this helper method to get category emoji
    private String getCategoryEmoji(String category) {
        switch (category) {
            case "Main Dishes": return "🍽️";
            case "Soups": return "🍲";
            case "Desserts": return "🍰";
            case "Beverages": return "🥤";
            default: return "📝";
        }
    }

    // Helper methods
    private VBox findRecipeCard(String recipeName) {
        for (Node categorySection : recipeContainer.getChildren()) {
            if (categorySection instanceof VBox) {
                for (Node node : ((VBox) categorySection).getChildren()) {
                    if (node instanceof FlowPane) {
                        FlowPane flowPane = (FlowPane) node;
                        for (Node card : flowPane.getChildren()) {
                            if (card instanceof VBox) {
                                VBox recipeCard = (VBox) card;
                                String cardRecipeName = (String) recipeCard.getUserData();
                                if (recipeName.equals(cardRecipeName)) {
                                    return recipeCard;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        launch(args);
    }
}