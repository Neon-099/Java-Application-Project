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
import java.util.HashMap;
import java.util.Map;

public class RecipeManagerApp extends Application {

    private BorderPane root;
    private VBox recipeContainer;
    private String lastSelectedCategory = "Main Dishes"; // default category
    private Map<String, Recipe> recipeData = new HashMap<>();
    
    // Constants to avoid magic strings
    private static final String STYLE_WHITE_BG = "-fx-background-color: white;";
    private static final String STYLE_LIGHT_BG = "-fx-background-color: #f5f5f5;";
    private static final String STYLE_BORDER_BOTTOM = "-fx-border-color: #e0e0e0; -fx-border-width: 0 0 1 0;";
    private static final String STYLE_BORDER_RIGHT = "-fx-border-color: #e0e0e0; -fx-border-width: 0 1 0 0;";
    
    // Category constants
    private static final String CATEGORY_MAIN = "Main Dishes";
    private static final String CATEGORY_SOUPS = "Soups";
    private static final String CATEGORY_DESSERTS = "Desserts";
    private static final String CATEGORY_BEVERAGES = "Beverages";
    
    @Override
    public void start(Stage primaryStage) {
        // Initialize recipe data from RecipeData class
        recipeData = RecipeData.loadDefaultRecipes();
        
        // Setup main UI components
        setupMainUI(primaryStage);
    }
    
    // MAIN UI SETUP
    private void setupMainUI(Stage primaryStage) {
        // Main container
        root = new BorderPane();
        root.setStyle(STYLE_LIGHT_BG);
        
        // Setup UI components
        HBox header = createHeader();
        VBox sidebar = createSidebar();
        recipeContainer = createRecipeCardsContainer();
        ScrollPane scrollPane = new ScrollPane(recipeContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent;");
        HBox footer = createFooter();
        
        // Add components to root
        root.setTop(header);
        root.setLeft(sidebar);
        root.setCenter(scrollPane);
        root.setBottom(footer);
        
        // Create the scene
        Scene scene = new Scene(root, 1100, 700);
        primaryStage.setTitle("Recipe Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    //HEADER SECTION
    private HBox createHeader() {
        HBox header = new HBox();
        header.setPadding(new Insets(15, 25, 15, 25));
        header.setStyle(STYLE_WHITE_BG + STYLE_BORDER_BOTTOM);
        header.setAlignment(Pos.CENTER_LEFT);
        
        // Logo and app name
        Label iconLabel = new Label("🍴");
        iconLabel.setFont(Font.font("Arial", 20));
        
        Label appName = new Label("Recipe Manager");
        appName.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        appName.setPadding(new Insets(0, 0, 0, 5));
        
        // Search bar with functionality
        HBox searchContainer = createSearchBar();
        
        // Add Recipe button
        Button addRecipeButton = createStyledButton("+ Add Recipe", "-fx-background-color: #3a3f44; -fx-text-fill: white; -fx-font-weight: bold;", 
            event -> handleAddRecipe());
        addRecipeButton.setPadding(new Insets(8, 15, 8, 15));
        
        // Add all elements to header
        header.getChildren().addAll(iconLabel, appName, searchContainer, addRecipeButton);
        
        return header;
    }
    
    private HBox createSearchBar() {
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
        
        // Add real-time search functionality
        searchField.textProperty().addListener((observable, oldValue, newValue) -> handleSearch(newValue));
        
        searchContainer.getChildren().addAll(searchIcon, searchField);
        return searchContainer;
    }
    
    private VBox createSidebar() {
        VBox sidebar = new VBox(10);
        sidebar.setPadding(new Insets(20));
        sidebar.setStyle(STYLE_WHITE_BG + STYLE_BORDER_RIGHT);
        sidebar.setPrefWidth(220);
        
        // Categories title
        Label categoriesLabel = new Label("Categories");
        categoriesLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        categoriesLabel.setPadding(new Insets(0, 0, 10, 0));
        
        // Category buttons container
        VBox categoryButtons = new VBox(5);
        
        // Create category buttons with emojis
        Button mainDishesBtn = createCategoryButton("🍽️ " + CATEGORY_MAIN);
        Button soupsBtn = createCategoryButton("🍲 " + CATEGORY_SOUPS);
        Button dessertsBtn = createCategoryButton("🍰 " + CATEGORY_DESSERTS);
        Button beveragesBtn = createCategoryButton("🥤 " + CATEGORY_BEVERAGES);
        
        categoryButtons.getChildren().addAll(mainDishesBtn, soupsBtn, dessertsBtn, beveragesBtn);
        sidebar.getChildren().addAll(categoriesLabel, categoryButtons);
        
        return sidebar;
    }
    
    private Button createCategoryButton(String text) {
        Button button = createStyledButton(text, 
            "-fx-background-color: #f5f5f5; -fx-text-fill: black; -fx-alignment: CENTER_LEFT;", 
            event -> handleCategoryClick(text));
        button.setMaxWidth(Double.MAX_VALUE);
        button.setPadding(new Insets(10, 15, 10, 10));
        return button;
    }
    
    private Button createStyledButton(String text, String style, javafx.event.EventHandler<javafx.event.ActionEvent> handler) {
        Button button = new Button(text);
        button.setStyle(style);
        button.setOnAction(handler);
        return button;
    }
    
    private VBox createRecipeCardsContainer() {
        VBox container = new VBox(20);
        container.setPadding(new Insets(20));
        
        // Create sections and FlowPanes for each category
        Map<String, VBox> categorySections = new HashMap<>();
        Map<String, FlowPane> categoryFlows = new HashMap<>();
        
        // Initialize sections and flows for each category
        String[] categories = {CATEGORY_MAIN, CATEGORY_SOUPS, CATEGORY_DESSERTS, CATEGORY_BEVERAGES};
        for (String category : categories) {
            VBox section = createCategorySection(category);
            FlowPane flow = createFlowPane();
            categorySections.put(category, section);
            categoryFlows.put(category, flow);
        }
        
        // Add recipe cards from recipeData
        populateRecipeCards(categorySections, categoryFlows);
        
        // Add all sections to the container
        container.getChildren().addAll(
            categorySections.get(CATEGORY_MAIN),
            categorySections.get(CATEGORY_SOUPS),
            categorySections.get(CATEGORY_DESSERTS),
            categorySections.get(CATEGORY_BEVERAGES)
        );
        
        return container;
    }
    
    private FlowPane createFlowPane() {
        FlowPane flowPane = new FlowPane(20, 20);
        flowPane.setPrefWrapLength(1000);
        flowPane.setAlignment(Pos.TOP_LEFT);
        return flowPane;
    }
    
    private void populateRecipeCards(Map<String, VBox> sections, Map<String, FlowPane> flows) {
        for (Recipe recipe : recipeData.values()) {
            String categoryName = extractCategoryName(recipe.category);
            FlowPane targetFlow = flows.get(categoryName);
            VBox targetSection = sections.get(categoryName);
            
            if (targetFlow != null && targetSection != null) {
                VBox recipeCard = createRecipeCard(recipe.name, recipe.time, recipe.category);
                recipeCard.setPrefWidth(300);
                targetFlow.getChildren().add(recipeCard);
                
                // Add flow pane to section if not already added
                if (!targetSection.getChildren().contains(targetFlow)) {
                    targetSection.getChildren().add(targetFlow);
                }
            }
        }
    }
    
    private String extractCategoryName(String fullCategory) {
        // Extract category name from "Emoji Category" format
        int spaceIndex = fullCategory.indexOf(" ");
        return spaceIndex >= 0 ? fullCategory.substring(spaceIndex + 1) : fullCategory;
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
        card.setStyle("-fx-background-color: white; -fx-border-radius: 5; -fx-background-radius: 5; " + 
                      "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 4, 0, 0, 2);");
        card.setPrefWidth(300);
        
        // Image view
        ImageView imageView = createRecipeImageView(recipeName);
        
        // Recipe info section
        VBox recipeInfo = createRecipeInfoSection(recipeName, time, category);
        
        card.getChildren().addAll(imageView, recipeInfo);
        card.setUserData(recipeName);
        return card;
    }
    
    private ImageView createRecipeImageView(String recipeName) {
        ImageView imageView = new ImageView();
        imageView.setFitWidth(300);
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        
        // Try to load image from recipe data
        Recipe recipe = recipeData.get(recipeName);
        if (recipe != null && recipe.imageUrl != null) {
            try {
                Image image = new Image(recipe.imageUrl, true);
                imageView.setImage(image);
            } catch (Exception e) {
                setDefaultImage(imageView);
            }
        } else {
            setDefaultImage(imageView);
        }
        
        return imageView;
    }
    
    private VBox createRecipeInfoSection(String recipeName, String time, String category) {
        VBox recipeInfo = new VBox(3);
        recipeInfo.setPadding(new Insets(8, 12, 12, 12));
        
        // Recipe name
        Label nameLabel = new Label(recipeName);
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        nameLabel.setWrapText(true);
        
        // Time and category info
        HBox metaInfo = new HBox(10);
        metaInfo.setPadding(new Insets(3, 0, 5, 0));
        
        Label timeInfo = new Label("🕒 " + time);
        timeInfo.setFont(Font.font("Arial", 12));
        
        Label categoryInfo = new Label(category);
        categoryInfo.setFont(Font.font("Arial", 12));
        
        metaInfo.getChildren().addAll(timeInfo, categoryInfo);
        
        // Action buttons
        HBox actions = createRecipeCardActions(recipeName);
        
        recipeInfo.getChildren().addAll(nameLabel, metaInfo, actions);
        return recipeInfo;
    }
    
    private HBox createRecipeCardActions(String recipeName) {
        HBox actions = new HBox(5);
        actions.setPrefWidth(Double.MAX_VALUE);
        actions.setAlignment(Pos.CENTER_LEFT);
        
        String buttonStyle = "-fx-background-color: transparent; -fx-padding: 2 5;";
        Button viewButton = createStyledButton("👁️ View", buttonStyle, event -> handleViewRecipe(recipeName));
        viewButton.setFont(Font.font("Arial", 12));
        
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        Button editButton = createStyledButton("✏️ Edit", buttonStyle, event -> handleEditRecipe(recipeName));
        Button deleteButton = createStyledButton("🗑️ Delete", buttonStyle, event -> handleDeleteRecipe(recipeName));
        
        actions.getChildren().addAll(viewButton, spacer, editButton, deleteButton);
        return actions;
    }
    
    private void setDefaultImage(ImageView imageView) {
        String defaultImageUrl = "https://via.placeholder.com/300x150.png?text=No+Image";
        try {
            Image defaultImage = new Image(defaultImageUrl, true);
            imageView.setImage(defaultImage);
        } catch (Exception e) {
            // If even default image fails, use colored background
            imageView.setImage(null);
        }
    }
    
    private HBox createFooter() {
        HBox footer = new HBox();
        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(15));
        footer.setStyle(STYLE_WHITE_BG + " -fx-border-color: #e0e0e0; -fx-border-width: 1 0 0 0;");
        
        Label copyrightLabel = new Label("© 2025 Recipe Manager. All rights reserved.");
        footer.getChildren().add(copyrightLabel);
        
        return footer;
    }
    
    // Event handlers
    private void handleAddRecipe() {
        Dialog<Recipe> dialog = createRecipeDialog("Add New Recipe", null);
        
        dialog.showAndWait().ifPresent(recipe -> {
            // Add the recipe to the data map
            recipeData.put(recipe.name, recipe);
            
            // Find the appropriate category section and add the recipe
            addRecipeToUI(recipe);
        });
    }
    
    private Dialog<Recipe> createRecipeDialog(String title, Recipe existingRecipe) {
        Dialog<Recipe> dialog = new Dialog<>();
        dialog.setTitle(title);
        dialog.setHeaderText(null);

        ButtonType saveButtonType = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        // Create form fields
        TextField nameField = new TextField(existingRecipe != null ? existingRecipe.name : "");
        TextField timeField = new TextField(existingRecipe != null ? existingRecipe.time : "");
        TextField imageUrlField = new TextField(existingRecipe != null && existingRecipe.imageUrl != null ? existingRecipe.imageUrl : "");
        TextArea ingredientsArea = new TextArea(existingRecipe != null ? existingRecipe.ingredients : "");
        TextArea instructionsArea = new TextArea(existingRecipe != null ? existingRecipe.instructions : "");

        ingredientsArea.setPrefRowCount(4);
        instructionsArea.setPrefRowCount(4);

        // Style headers
        Label ingredientsHeader = new Label("Ingredients");
        ingredientsHeader.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        Label instructionsHeader = new Label("Instructions");
        instructionsHeader.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        // Add elements to grid
        grid.add(new Label("Recipe Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Cooking Time:"), 0, 1);
        grid.add(timeField, 1, 1);
        
        // Only show image URL field for new recipes
        if (existingRecipe == null) {
            grid.add(new Label("Image URL (optional):"), 0, 2);
            grid.add(imageUrlField, 1, 2);
            grid.add(ingredientsHeader, 0, 3, 2, 1);
            grid.add(ingredientsArea, 0, 4, 2, 1);
            grid.add(instructionsHeader, 0, 5, 2, 1);
            grid.add(instructionsArea, 0, 6, 2, 1);
        } else {
            grid.add(ingredientsHeader, 0, 2, 2, 1);
            grid.add(ingredientsArea, 0, 3, 2, 1);
            grid.add(instructionsHeader, 0, 4, 2, 1);
            grid.add(instructionsArea, 0, 5, 2, 1);
        }

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == saveButtonType) {
                // If editing, keep the existing category, otherwise use the last selected category
                String category = existingRecipe != null ? existingRecipe.category : 
                                  getCategoryEmoji(lastSelectedCategory) + " " + lastSelectedCategory;
                
                String imageUrl = existingRecipe != null ? existingRecipe.imageUrl : 
                                 (imageUrlField.getText().trim().isEmpty() ? null : imageUrlField.getText().trim());
                
                return new Recipe(
                    nameField.getText(),
                    timeField.getText(),
                    category,
                    ingredientsArea.getText(),
                    instructionsArea.getText(),
                    imageUrl
                );
            }
            return null;
        });

        return dialog;
    }
    
    private void addRecipeToUI(Recipe recipe) {
        // Find the section for the category
        String categoryName = extractCategoryName(recipe.category);
        String sectionId = categoryName.toLowerCase().replace(" ", "-");
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
                flowPane = createFlowPane();
                categorySection.getChildren().add(flowPane);
            }
            
            // Create and add the new recipe card
            VBox recipeCard = createRecipeCard(recipe.name, recipe.time, recipe.category);
            recipeCard.setPrefWidth(300);
            flowPane.getChildren().add(recipeCard);
            
            // Scroll to the category section
            scrollToSection(categorySection);
            
            // Focus on the new recipe card
            recipeCard.requestFocus();
        }
    }
    
    private void scrollToSection(Node section) {
        ScrollPane scrollPane = (ScrollPane) root.getCenter();
        double height = scrollPane.getContent().getBoundsInLocal().getHeight();
        double y = section.getBoundsInParent().getMinY();
        scrollPane.setVvalue(y / height);
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
        
        // Create sections and flows for each category
        Map<String, VBox> categorySections = new HashMap<>();
        Map<String, FlowPane> categoryFlows = new HashMap<>();
        
        String[] categories = {CATEGORY_MAIN, CATEGORY_SOUPS, CATEGORY_DESSERTS, CATEGORY_BEVERAGES};
        for (String category : categories) {
            categorySections.put(category, createCategorySection(category));
            categoryFlows.put(category, createFlowPane());
        }
        
        // Sort recipes into categories
        for (Recipe recipe : recipesToShow.values()) {
            String categoryName = extractCategoryName(recipe.category);
            FlowPane targetFlow = categoryFlows.get(categoryName);
            VBox targetSection = categorySections.get(categoryName);
            
            if (targetFlow != null && targetSection != null) {
                VBox recipeCard = createRecipeCard(recipe.name, recipe.time, recipe.category);
                recipeCard.setPrefWidth(300);
                targetFlow.getChildren().add(recipeCard);
                
                // Add flow pane to section if not empty
                if (!targetFlow.getChildren().isEmpty() && !targetSection.getChildren().contains(targetFlow)) {
                    targetSection.getChildren().add(targetFlow);
                }
            }
        }
        
        // Only add sections that have recipes
        for (String category : categories) {
            VBox section = categorySections.get(category);
            if (section.getChildren().size() > 1) { // More than just the title
                recipeContainer.getChildren().add(section);
            }
        }
        
        // If no results found, show a message
        if (recipeContainer.getChildren().isEmpty()) {
            showNoResultsMessage();
        }
    }
    
    private void showNoResultsMessage() {
        VBox noResultsBox = new VBox();
        noResultsBox.setAlignment(Pos.CENTER);
        noResultsBox.setPadding(new Insets(50));
        
        Label noResultsLabel = new Label("No recipes found");
        noResultsLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        noResultsLabel.setStyle("-fx-text-fill: #666666;");
        
        noResultsBox.getChildren().add(noResultsLabel);
        recipeContainer.getChildren().add(noResultsBox);
    }
    
    private void handleCategoryClick(String category) {
        // Extract category name from button text (remove emoji)
        String categoryName = extractCategoryName(category);
        lastSelectedCategory = categoryName; // Update last selected category
        
        // Find the section by ID and scroll to it
        String sectionId = categoryName.toLowerCase().replace(" ", "-");
        Node section = recipeContainer.lookup("#" + sectionId);
        
        if (section != null) {
            section.requestFocus();
            scrollToSection(section);
        }
    }
    
    private void handleViewRecipe(String recipeName) {
        Recipe recipe = recipeData.get(recipeName);
        if (recipe == null) return;

        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("View Recipe");
        dialog.setHeaderText(null);

        ButtonType closeButtonType = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().add(closeButtonType);

        VBox content = createRecipeViewContent(recipe);
        
        ScrollPane scrollPane = new ScrollPane(content);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle(STYLE_WHITE_BG);

        dialog.getDialogPane().setContent(scrollPane);
        dialog.getDialogPane().setPrefWidth(550);
        dialog.getDialogPane().setPrefHeight(600);
        dialog.getDialogPane().setStyle(STYLE_WHITE_BG);
        
        dialog.showAndWait();
    }
    
    private VBox createRecipeViewContent(Recipe recipe) {
        VBox content = new VBox(15);
        content.setPadding(new Insets(20));
        content.setPrefWidth(500);
        content.setStyle(STYLE_WHITE_BG);

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

        TextArea ingredientsArea = createStyledTextArea(recipe.ingredients);

        // Instructions Section
        Label instructionsTitle = new Label("Instructions");
        instructionsTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        instructionsTitle.setPadding(new Insets(10, 0, 5, 0));

        TextArea instructionsArea = createStyledTextArea(recipe.instructions);
        instructionsArea.setPrefRowCount(8);

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
        
        return content;
    }
    
    private TextArea createStyledTextArea(String content) {
        TextArea textArea = new TextArea(content);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setPrefRowCount(6);
        textArea.setStyle("-fx-control-inner-background: #f8f8f8; -fx-background-color: #f8f8f8; -fx-border-color: #e0e0e0;");
        return textArea;
    }
    
    private void handleEditRecipe(String recipeName) {
        Recipe currentRecipe = recipeData.get(recipeName);
        if (currentRecipe == null) return;

        Dialog<Recipe> dialog = createRecipeDialog("Edit Recipe", currentRecipe);
        dialog.getDialogPane().setPrefWidth(400);

        dialog.showAndWait().ifPresent(updatedRecipe -> {
            // Update the recipe data
            recipeData.put(updatedRecipe.name, updatedRecipe);
            
            // Find and update the recipe card
            VBox recipeCard = findRecipeCard(recipeName);
            if (recipeCard != null) {
                updateRecipeCard(recipeCard, updatedRecipe);
            }
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
                    
                    // If flowPane is empty, remove it from the category section
                    if (flowPane.getChildren().isEmpty()) {
                        VBox categorySection = (VBox) flowPane.getParent();
                        categorySection.getChildren().remove(flowPane);
                    }
                }
            }
        });
    }
    
    private String getCategoryEmoji(String category) {
        switch (category) {
            case CATEGORY_MAIN: return "🍽️";
            case CATEGORY_SOUPS: return "🍲";
            case CATEGORY_DESSERTS: return "🍰";
            case CATEGORY_BEVERAGES: return "🥤";
            default: return "📝";
        }
    }

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