package com.example;

import java.util.HashMap;
import java.util.Map;

public class RecipeData {
    public static Map<String, Recipe> loadDefaultRecipes() {
        Map<String, Recipe> recipes = new HashMap<>();
        
        // Main Dishes 
        recipes.put("Chicken Adobo", new Recipe(
            "Chicken Adobo",
            "30 mins",
            "🍽️ Main Dishes",
            "• 400g spaghetti\n• 4 eggs\n• 200g pancetta\n• 100g Pecorino Romano\n• 100g Parmigiano-Reggiano\n• Black pepper\n• Salt",
            "1. Cook pasta in salted water\n2. Fry pancetta until crispy\n3. Mix eggs, cheese, and pepper\n4. Combine hot pasta with egg mixture\n5. Add pancetta and serve immediately",
            "com/example/images/main/Chicken_adobo.jpg"
        ));
        
        recipes.put("Beef Caldereta", new Recipe(
            "Beef Caldereta",
            "25 mins",
            "🍽️ Main Dishes",
            "• 4 chicken breasts\n• 2 tbsp olive oil\n• 2 cloves garlic\n• 1 tsp oregano\n• Salt and pepper",
            "1. Marinate chicken with oil and herbs\n2. Preheat grill\n3. Grill 6-7 minutes per side\n4. Let rest before serving",
            "com/example/images/main/beef-caldereta.jpg"
        ));
        
        recipes.put("Bicol Express", new Recipe(
            "Bicol Express",
            "20 mins",
            "🍽️ Main Dishes",
            "• 500g beef strips\n• Mixed vegetables\n• Soy sauce\n• Ginger and garlic\n• Cooking oil",
            "1. Heat oil in wok\n2. Stir fry beef until browned\n3. Add vegetables\n4. Add sauce and seasonings\n5. Serve hot",
            "com/example/images/main/bicol-express.jpg"
        ));
        
        recipes.put("Laing", new Recipe(
            "Laing",
            "25 mins",
            "🍽️ Main Dishes",
            "• 4 salmon fillets\n• Lemon\n• Dill\n• Butter\n• Salt and pepper",
            "1. Preheat oven to 400°F\n2. Season salmon\n3. Add lemon and dill\n4. Bake for 12-15 minutes",
            "com/example/images/main/laing.jpg"
        ));
        
        recipes.put("Menudo", new Recipe(
            "Menudo",
            "60 mins",
            "🍽️ Main Dishes",
            "• Lasagna noodles\n• Ricotta cheese\n• Mixed vegetables\n• Tomato sauce\n• Mozzarella",
            "1. Layer noodles and filling\n2. Add sauce and cheese\n3. Repeat layers\n4. Bake until bubbly",
            "com/example/images/main/menudo.jpg"
        ));

        recipes.put("Chicken Curry", new Recipe(
            "Chicken Curry",
            "45 mins",
            "🍽️ Main Dishes",
            "• 500g chicken\n• Curry powder\n• Coconut milk\n• Onions\n• Garlic\n• Ginger",
            "1. Sauté onions, garlic, ginger\n2. Add chicken and curry powder\n3. Pour in coconut milk\n4. Simmer until cooked",
            "com/example/images/main/chicken-curry.jpg"
        ));

        recipes.put("Monggo pork", new Recipe(
            "Monggo pork",
            "30 mins",
            "🍽️ Main Dishes",
            "• Ground beef\n• Burger buns\n• Lettuce\n• Tomato\n• Cheese\n• Onion",
            "1. Form beef patties\n2. Grill until desired doneness\n3. Add cheese to melt\n4. Assemble with toppings",
            "com/example/images/main/monggo-pork.jpg"
        ));

        recipes.put("Sinigang pork", new Recipe(
            "Sinigang pork",
            "20 mins",
            "🍽️ Main Dishes",
            "• Shrimp\n• Garlic\n• White wine\n• Butter\n• Lemon\n• Parsley",
            "1. Sauté garlic in butter\n2. Add shrimp and cook\n3. Add wine and lemon\n4. Garnish with parsley",
            "com/example/images/main/sinigang-pork.jpg"
        ));

        recipes.put("Tinolang Chicken", new Recipe(
            "Tinolang Chicken",
            "35 mins",
            "🍽️ Main Dishes",
            "• Pork chops\n• Herbs\n• Garlic\n• Butter\n• Salt and pepper",
            "1. Season pork chops\n2. Heat pan with butter\n3. Cook 5-6 mins each side\n4. Rest before serving",
            "com/example/images/main/tinolang-chicken.jpg"
        ));

        recipes.put("Adobong pusit", new Recipe(
            "Adobong pusit",
            "50 mins",
            "🍽️ Main Dishes",
            "• Eggplant\n• Breadcrumbs\n• Marinara sauce\n• Mozzarella\n• Parmesan",
            "1. Bread eggplant slices\n2. Fry until golden\n3. Layer with sauce and cheese\n4. Bake until bubbly",
            "com/example/images/main/adobong-pusit.jpg"
        ));


        // SOUPS (10 recipes)
        recipes.put("Shrimp Sinigang", new Recipe(
            "Shrimp Sinigang",
            "45 mins",
            "🍲 Soups",
            "• Fresh tomatoes\n• Onion\n• Garlic\n• Vegetable stock\n• Cream",
            "1. Sauté onions and garlic\n2. Add tomatoes and stock\n3. Simmer and blend\n4. Add cream",
            ""
        ));
        
        recipes.put("Chicken Noodle Soup", new Recipe(
            "Chicken Noodle Soup",
            "50 mins",
            "🍲 Soups",
            "• Chicken\n• Egg noodles\n• Carrots\n• Celery\n• Onion",
            "1. Cook chicken in broth\n2. Add vegetables\n3. Cook noodles\n4. Season and serve",
            ""
        ));

        recipes.put("Mushroom Soup", new Recipe(
            "Mushroom Soup",
            "40 mins",
            "🍲 Soups",
            "• Mixed mushrooms\n• Onion\n• Garlic\n• Cream\n• Thyme",
            "1. Sauté mushrooms and onions\n2. Add garlic and thyme\n3. Add stock and simmer\n4. Blend and add cream",
            ""
        ));

        recipes.put("Butternut Squash Soup", new Recipe(
            "Butternut Squash Soup",
            "55 mins",
            "🍲 Soups",
            "• Butternut squash\n• Onion\n• Apple\n• Cream\n• Spices",
            "1. Roast squash\n2. Sauté onions and apple\n3. Blend with stock\n4. Add cream and spices",
            ""
        ));

        recipes.put("Lentil Soup", new Recipe(
            "Lentil Soup",
            "45 mins",
            "🍲 Soups",
            "• Red lentils\n• Carrots\n• Celery\n• Onion\n• Spices",
            "1. Sauté vegetables\n2. Add lentils and stock\n3. Simmer until tender\n4. Season to taste",
            ""
        ));

        recipes.put("French Onion Soup", new Recipe(
            "French Onion Soup",
            "70 mins",
            "🍲 Soups",
            "• Onions\n• Beef stock\n• Bread\n• Gruyere cheese\n• Butter",
            "1. Caramelize onions\n2. Add stock and simmer\n3. Top with bread\n4. Broil with cheese",
            ""

        ));

        recipes.put("Minestrone", new Recipe(
            "Minestrone",
            "50 mins",
            "🍲 Soups",
            "• Mixed vegetables\n• Pasta\n• Beans\n• Tomatoes\n• Herbs",
            "1. Cook vegetables\n2. Add beans and tomatoes\n3. Cook pasta\n4. Add herbs",
            ""
        ));

        recipes.put("Clam Chowder", new Recipe(
            "Clam Chowder",
            "45 mins",
            "🍲 Soups",
            "• Clams\n• Potatoes\n• Celery\n• Cream\n• Bacon",
            "1. Cook bacon\n2. Add vegetables\n3. Add clams and cream\n4. Simmer until thick",
            ""
        ));

        recipes.put("Gazpacho", new Recipe(
            "Gazpacho",
            "20 mins",
            "🍲 Soups",
            "• Tomatoes\n• Cucumber\n• Peppers\n• Garlic\n• Olive oil",
            "1. Blend vegetables\n2. Add olive oil\n3. Season well\n4. Chill before serving",
            ""
        ));

        recipes.put("Miso Soup", new Recipe(
            "Miso Soup",
            "15 mins",
            "🍲 Soups",
            "• Miso paste\n• Tofu\n• Seaweed\n• Green onions\n• Dashi stock",
            "1. Make dashi stock\n2. Add miso paste\n3. Add tofu and seaweed\n4. Garnish with green onions",
            ""
        ));


        // DESSERTS (10 recipes)
        recipes.put("Chocolate Cake", new Recipe(
            "Chocolate Cake",
            "60 mins",
            "🍰 Desserts",
            "• Flour\n• Cocoa powder\n• Sugar\n• Eggs\n• Butter",
            "1. Mix dry ingredients\n2. Add wet ingredients\n3. Bake at 350°F\n4. Frost when cool",
            ""
        ));
        
        recipes.put("Apple Pie", new Recipe(
            "Apple Pie",
            "75 mins",
            "🍰 Desserts",
            "• Pie crust\n• Apples\n• Sugar\n• Cinnamon\n• Butter",
            "1. Prepare pie crust\n2. Mix apple filling\n3. Assemble pie\n4. Bake until golden",
            ""
        ));

        recipes.put("Tiramisu", new Recipe(
            "Tiramisu",
            "40 mins",
            "🍰 Desserts",
            "• Ladyfingers\n• Mascarpone\n• Coffee\n• Cocoa powder\n• Eggs",
            "1. Dip ladyfingers in coffee\n2. Layer with cream\n3. Dust with cocoa\n4. Chill well",
            ""
        ));

        recipes.put("Cheesecake", new Recipe(
            "Cheesecake",
            "80 mins",
            "🍰 Desserts",
            "• Cream cheese\n• Graham crackers\n• Sugar\n• Eggs\n• Vanilla",
            "1. Make crust\n2. Mix filling\n3. Bake in water bath\n4. Cool completely"
        ));

        recipes.put("Brownies", new Recipe(
            "Brownies",
            "45 mins",
            "🍰 Desserts",
            "• Chocolate\n• Butter\n• Sugar\n• Eggs\n• Flour",
            "1. Melt chocolate and butter\n2. Mix ingredients\n3. Bake until set\n4. Cool before cutting"
        ));

        recipes.put("Crème Brûlée", new Recipe(
            "Crème Brûlée",
            "50 mins",
            "🍰 Desserts",
            "• Heavy cream\n• Vanilla bean\n• Egg yolks\n• Sugar",
            "1. Heat cream with vanilla\n2. Mix with yolks\n3. Bake in water bath\n4. Caramelize sugar top"
        ));

        recipes.put("Lemon Bars", new Recipe(
            "Lemon Bars",
            "55 mins",
            "🍰 Desserts",
            "• Shortbread crust\n• Lemons\n• Eggs\n• Sugar\n• Flour",
            "1. Bake crust\n2. Make lemon filling\n3. Bake until set\n4. Dust with sugar"
        ));

        recipes.put("Ice Cream", new Recipe(
            "Ice Cream",
            "40 mins",
            "🍰 Desserts",
            "• Heavy cream\n• Milk\n• Sugar\n• Vanilla\n• Egg yolks",
            "1. Make custard base\n2. Chill mixture\n3. Churn in machine\n4. Freeze until firm"
        ));

        recipes.put("Fruit Tart", new Recipe(
            "Fruit Tart",
            "65 mins",
            "🍰 Desserts",
            "• Pastry crust\n• Pastry cream\n• Fresh fruits\n• Glaze",
            "1. Bake tart shell\n2. Make pastry cream\n3. Arrange fruits\n4. Add glaze"
        ));

        recipes.put("Bread Pudding", new Recipe(
            "Bread Pudding",
            "55 mins",
            "🍰 Desserts",
            "• Bread\n• Milk\n• Eggs\n• Sugar\n• Vanilla",
            "1. Cut bread into cubes\n2. Mix custard\n3. Combine and soak\n4. Bake until golden"
        ));

        // Beverages (10 recipes)
        recipes.put("Fruit Smoothie", new Recipe(
            "Fruit Smoothie",
            "10 mins",
            "🥤 Beverages",
            "• Mixed berries\n• Banana\n• Yogurt\n• Honey\n• Ice",
            "1. Add all ingredients to blender\n2. Blend until smooth\n3. Adjust thickness\n4. Serve immediately",
            "/images/beverages/fruit-smoothie.jpg"
        ));
        
        recipes.put("Iced Coffee", new Recipe(
            "Iced Coffee",
            "15 mins",
            "🥤 Beverages",
            "• Strong coffee\n• Ice cubes\n• Milk\n• Sugar syrup",
            "1. Brew strong coffee\n2. Let cool\n3. Add ice and milk\n4. Sweeten to taste",
            ""
        ));

        recipes.put("Lemonade", new Recipe(
            "Lemonade",
            "20 mins",
            "🥤 Beverages",
            "• Lemons\n• Sugar\n• Water\n• Ice\n• Mint (optional)",
            "1. Make sugar syrup\n2. Juice lemons\n3. Combine and dilute\n4. Chill and serve",
            ""
        ));

        recipes.put("Hot Chocolate", new Recipe(
            "Hot Chocolate",
            "15 mins",
            "🥤 Beverages",
            "• Chocolate\n• Milk\n• Cream\n• Sugar\n• Vanilla",
            "1. Heat milk\n2. Add chocolate\n3. Whisk until smooth\n4. Top with cream"
        ));

        recipes.put("Green Tea Latte", new Recipe(
            "Green Tea Latte",
            "10 mins",
            "🥤 Beverages",
            "• Matcha powder\n• Hot water\n• Milk\n• Sugar",
            "1. Whisk matcha with water\n2. Heat and froth milk\n3. Combine\n4. Add sugar if desired"
        ));

        recipes.put("Mojito Mocktail", new Recipe(
            "Mojito Mocktail",
            "10 mins",
            "🥤 Beverages",
            "• Lime\n• Mint leaves\n• Sugar\n• Soda water\n• Ice",
            "1. Muddle mint and lime\n2. Add sugar and ice\n3. Top with soda\n4. Garnish and serve"
        ));

        recipes.put("Mango Lassi", new Recipe(
            "Mango Lassi",
            "10 mins",
            "🥤 Beverages",
            "• Mango pulp\n• Yogurt\n• Sugar\n• Cardamom\n• Ice",
            "1. Blend mango and yogurt\n2. Add sugar and cardamom\n3. Blend with ice\n4. Serve cold"
        ));

        recipes.put("Chai Tea", new Recipe(
            "Chai Tea",
            "20 mins",
            "🥤 Beverages",
            "• Black tea\n• Milk\n• Spices\n• Sugar\n• Water",
            "1. Boil water with spices\n2. Add tea and milk\n3. Simmer gently\n4. Strain and serve"
        ));

        recipes.put("Orange Julius", new Recipe(
            "Orange Julius",
            "10 mins",
            "🥤 Beverages",
            "• Orange juice\n• Milk\n• Vanilla\n• Sugar\n• Ice",
            "1. Blend juice and milk\n2. Add vanilla and sugar\n3. Blend with ice\n4. Serve frothy"
        ));

        recipes.put("Strawberry Milkshake", new Recipe(
            "Strawberry Milkshake",
            "10 mins",
            "🥤 Beverages",
            "• Strawberries\n• Vanilla ice cream\n• Milk\n• Whipped cream",
            "1. Blend strawberries\n2. Add ice cream and milk\n3. Blend until smooth\n4. Top with cream"
        ));

        return recipes;
    }
}
