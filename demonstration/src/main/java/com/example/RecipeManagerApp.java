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
import java.util.Map;

public class RecipeManagerApp extends Application {

    private BorderPane root;
    private VBox recipeContainer;
    
    // Add this field to track last selected category
    private String lastSelectedCategory = "Main Dishes"; // default category
    
    // Add a Hashmap to store recipe data
    private Map<String, Recipe> recipeData = new HashMap<>();
    
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
        Scene scene = new Scene(root, 1100, 700);
        primaryStage.setTitle("Recipe Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private HBox createHeader() {
        HBox header = new HBox();
        header.setPadding(new Insets(15, 25, 15, 25));
        header.setStyle("-fx-background-color: white; -fx-border-color: #e0e0e0; -fx-border-width: 0 0 1 0;");
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
        
        sidebar.getChildren().addAll(categoriesLabel, categoryButtons);
        
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
    
    private VBox createRecipeCardsContainer() {
        VBox container = new VBox(20);
        container.setPadding(new Insets(20));
        
        // Create sections for each category
        VBox mainDishesSection = createCategorySection("Main Dishes");
        VBox soupsSection = createCategorySection("Soups");
        VBox dessertsSection = createCategorySection("Desserts");
        VBox beveragesSection = createCategorySection("Beverages");
        
        // Create FlowPane for each category to allow wrapping of cards
        FlowPane mainDishesFlow = new FlowPane(20, 20);
        FlowPane soupsFlow = new FlowPane(20, 20);
        FlowPane dessertsFlow = new FlowPane(20, 20);
        FlowPane beveragesFlow = new FlowPane(20, 20);
        
        // Set common properties for all FlowPanes
        FlowPane[] flowPanes = {mainDishesFlow, soupsFlow, dessertsFlow, beveragesFlow};
        for (FlowPane flowPane : flowPanes) {
            flowPane.setPrefWrapLength(1000); // Adjust this value based on your window width
            flowPane.setAlignment(Pos.TOP_LEFT);
        }
        
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
        VBox card = new VBox(5);
        card.setStyle("-fx-background-color: white; -fx-border-radius: 5; -fx-background-radius: 5; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 4, 0, 0, 2);");
        card.setPrefWidth(300);
        
        // Image container
        ImageView imageView = new ImageView();
        imageView.setFitWidth(300);
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        
        // Try to load image from recipe data
        Recipe recipe = recipeData.get(recipeName);
        if (recipe != null && recipe.imageUrl != null) {
            try {
                Image image = new Image(recipe.imageUrl, true); // true enables background loading
                imageView.setImage(image);
            } catch (Exception e) {
                // If image loading fails, use default placeholder
                setDefaultImage(imageView);
            }
        } else {
            setDefaultImage(imageView);
        }
        
        // Recipe info
        VBox recipeInfo = new VBox(3);
        recipeInfo.setPadding(new Insets(8, 12, 12, 12));
        
        Label nameLabel = new Label(recipeName);
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14)); // Slightly smaller font
        nameLabel.setWrapText(true);
        
        HBox metaInfo = new HBox(10);
        metaInfo.setPadding(new Insets(3, 0, 5, 0));
        
        Label timeInfo = new Label("🕒 " + time);
        timeInfo.setFont(Font.font("Arial", 12)); // Smaller font
        Label categoryInfo = new Label(category);
        categoryInfo.setFont(Font.font("Arial", 12)); // Smaller font
        
        metaInfo.getChildren().addAll(timeInfo, categoryInfo);
        
        // Action buttons
        HBox actions = new HBox(5); // Reduce spacing
        actions.setPrefWidth(Double.MAX_VALUE);
        actions.setAlignment(Pos.CENTER_LEFT);
        
        Button viewButton = new Button("👁️ View");
        viewButton.setStyle("-fx-background-color: transparent; -fx-padding: 2 5;"); // Smaller padding
        viewButton.setFont(Font.font("Arial", 12)); // Smaller font
        
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        Button editButton = new Button("✏️ Edit");
        editButton.setStyle("-fx-background-color: transparent; -fx-padding: 2 5;");
        
        Button deleteButton = new Button("🗑️ Delete");  
        deleteButton.setStyle("-fx-background-color: transparent; -fx-padding: 2 5;");
        
        actions.getChildren().addAll(viewButton, spacer, editButton, deleteButton);
        
        // Add event handlers
        viewButton.setOnAction(event -> handleViewRecipe(recipeName));
        editButton.setOnAction(event -> handleEditRecipe(recipeName));
        deleteButton.setOnAction(event -> handleDeleteRecipe(recipeName));
        
        recipeInfo.getChildren().addAll(nameLabel, metaInfo, actions);
        card.getChildren().addAll(imageView, recipeInfo);
        
        card.setUserData(recipeName);
        return card;
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
        footer.setStyle("-fx-background-color: white; -fx-border-color: #e0e0e0; -fx-border-width: 1 0 0 0;");
        
        Label copyrightLabel = new Label("© 2025 Recipe Manager. All rights reserved.");
        footer.getChildren().add(copyrightLabel);
        
        return footer;
    }
    
    // Event handlers  (ADD NEW RECIPE BAR)
    private void handleAddRecipe() {
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
            // Add the recipe to the data map
            recipeData.put(recipe.name, recipe);
            
            // Find the section for the last selected category
            String sectionId = lastSelectedCategory.toLowerCase().replace(" ", "-");
            VBox categorySection = (VBox) recipeContainer.lookup("#" + sectionId);
            
            if (categorySection != null) {
                // Find or create FlowPane for the category
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
                
                // Create and add the new recipe card
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
    
    private void handleSearch(String query) {
        if (query == null || query.trim().isEmpty()) {
            // If search is empty, show all recipes
            refreshRecipeDisplay(recipeData);
            return;
        }
        
        // Convert query to lowercase for case-insensitive search
        query = query.toLowerCase().trim();
        
        // Create a map for filtered recipes
        Map<String, Recipe> filteredRecipes = new HashMap<>();
        
        // Search through all recipes
        for (Recipe recipe : recipeData.values()) {
            if (recipe.name.toLowerCase().contains(query) ||
                recipe.ingredients.toLowerCase().contains(query) ||
                recipe.instructions.toLowerCase().contains(query) ||
                recipe.category.toLowerCase().contains(query) ||
                recipe.time.toLowerCase().contains(query)) {
                
                filteredRecipes.put(recipe.name, recipe);
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
        
        // Create FlowPane for each category
        FlowPane mainDishesFlow = new FlowPane(20, 20);
        FlowPane soupsFlow = new FlowPane(20, 20);
        FlowPane dessertsFlow = new FlowPane(20, 20);
        FlowPane beveragesFlow = new FlowPane(20, 20);
        
        // Set common properties for all FlowPanes
        FlowPane[] flowPanes = {mainDishesFlow, soupsFlow, dessertsFlow, beveragesFlow};
        for (FlowPane flowPane : flowPanes) {
            flowPane.setPrefWrapLength(1000);
            flowPane.setAlignment(Pos.TOP_LEFT);
        }
        
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
            recipeCard.setPrefWidth(300);
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
    
    private void handleEditRecipe(String recipeName) {
        VBox recipeCard = findRecipeCard(recipeName);
        if (recipeCard == null) return;

        Recipe currentRecipe = recipeData.get(recipeName);
        if (currentRecipe == null) return;

        Dialog<Recipe> dialog = new Dialog<>();
        dialog.setTitle("Edit Recipe");
        dialog.setHeaderText(null);

        ButtonType saveButtonType = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        // Create and populate fields with current values
        TextField nameField = new TextField(currentRecipe.name);
        TextField timeField = new TextField(currentRecipe.time);
        TextArea ingredientsArea = new TextArea(currentRecipe.ingredients);
        TextArea instructionsArea = new TextArea(currentRecipe.instructions);

        ingredientsArea.setPrefRowCount(4);
        ingredientsArea.setWrapText(true);
        instructionsArea.setPrefRowCount(4);
        instructionsArea.setWrapText(true);

        // Style headers
        Label ingredientsHeader = new Label("Ingredients");
        ingredientsHeader.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        Label instructionsHeader = new Label("Instructions");
        instructionsHeader.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        // Add all elements to grid
        grid.add(new Label("Recipe Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Cooking Time:"), 0, 1);
        grid.add(timeField, 1, 1);
        grid.add(ingredientsHeader, 0, 2, 2, 1);
        grid.add(ingredientsArea, 0, 3, 2, 1);
        grid.add(instructionsHeader, 0, 4, 2, 1);
        grid.add(instructionsArea, 0, 5, 2, 1);

        dialog.getDialogPane().setContent(grid);
        dialog.getDialogPane().setPrefWidth(400);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == saveButtonType) {
                return new Recipe(
                    nameField.getText(),
                    timeField.getText(),
                    currentRecipe.category,
                    ingredientsArea.getText(),
                    instructionsArea.getText()
                );
            }
            return null;
        });

        dialog.showAndWait().ifPresent(recipe -> {
            // Update the recipe data
            recipeData.put(recipe.name, recipe);
            // Update the recipe card
            updateRecipeCard(recipeCard, recipe);
        });
    }
    
    private void handleDeleteRecipe(String recipeName) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Recipe");
        alert.setHeaderText("Delete " + recipeName);
        alert.setContentText("Are you sure you want to delete this recipe?");

        alert.showAndWait().ifPresent(result -> {
            if (result == ButtonType.OK) {
                // Remove the recipe from the data map
                recipeData.remove(recipeName);
                
                // Find and remove the recipe card from UI
                VBox recipeCard = findRecipeCard(recipeName);
                if (recipeCard != null) {
                    FlowPane flowPane = (FlowPane) recipeCard.getParent();
                    flowPane.getChildren().remove(recipeCard);
                    
                    // If flowPane is empty, remove the category section
                    if (flowPane.getChildren().isEmpty()) {
                        VBox categorySection = (VBox) flowPane.getParent();
                        categorySection.getChildren().remove(flowPane);
                    }
                }
            }
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


    private void updateRecipeCard(VBox recipeCard, Recipe recipe) {
        VBox recipeInfo = (VBox) recipeCard.getChildren().get(1);
        
        // Update name
        Label nameLabel = (Label) recipeInfo.getChildren().get(0);
        nameLabel.setText(recipe.name);
        
        // Update time and category
        HBox metaInfo = (HBox) recipeInfo.getChildren().get(1);
        Label timeInfo = (Label) metaInfo.getChildren().get(0);
        timeInfo.setText("🕒 " + recipe.time);
        
        Label categoryInfo = (Label) metaInfo.getChildren().get(1);
        categoryInfo.setText(getCategoryEmoji(recipe.category) + " " + recipe.category);
    }

    public static void main(String[] args) {
        launch(args);
    }
}