package com.example;

public class Recipe {
    String name;
    String time;
    String category;
    String ingredients;
    String instructions;
    String imageUrl;

    public Recipe(String name, String time, String category, String ingredients, String instructions) {
        this(name, time, category, ingredients, instructions, null);
    }

    public Recipe(String name, String time, String category, String ingredients, String instructions, String imageUrl) {
        this.name = name;
        this.time = time;
        this.category = category;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.imageUrl = imageUrl;
    }
} 