package com.example;

import java.util.HashMap;
import java.util.Map;

public class RecipeData {
    public static Map<String, Recipe> loadDefaultRecipes() {
        Map<String, Recipe> recipes = new HashMap<>();
        
        // Main Dishes 
        recipes.put("Chicken Adobo", new Recipe(
            "Chicken Adobo",
            "1 hour (including marination)",
            "🍽️ Main Dishes",
            "• 1 kg chicken or pork\n• 1 cup soy sauce\n• 1 cup vinegar\n• 1 head garlic, crushed\n• 2 bay leaves\n• 1 tsp black peppercorns\n• 2 tbsp oil\n• Salt to taste",
            "1. Marinate the meat in soy sauce, garlic, bay leaves, and peppercorns for at least 30 minutes.\n2. Heat oil in a pot and sauté the marinated meat until browned.\n3. Add vinegar and bring to a boil without stirring. Simmer for 30 minutes.\n4. Adjust seasoning and serve with rice.",
            "com/example/images/main/adobo.jpg"
        ));
        
        recipes.put("Pinakbet", new Recipe(
            "Pinakbet",
            "1 hour",
            "🍽️ Main Dishes",
            "• 1/2 kg pork belly, cubed \n• 1 cup water\n• 1 onion, chopped\n• 2-3 cloves garlic, minced\n• 1 cup tomatoes, chopped\n• 1 cup eggplant, sliced\n• 1 cup bitter melon (ampalaya), sliced\n• 1 cup squash, cubed\n• 1 cup string beans \n• 2-3 tbsp shrimp paste (bagoong)\n• Salt and pepper to taste",
            "1. Sauté onion and garlic until fragrant. Add pork and cook until browned.\n2. Add tomatoes and water; simmer until pork is tender.\n3. Add vegetables and shrimp paste; cook until vegetables are tender. Season to taste.",
            "com/example/images/main/pinakbet.jpg"
        ));
        
        recipes.put("Bicol Express", new Recipe(
            "Bicol Express",
            "1 hour",
            "🍽️ Main Dishes",
            "• 1 kg pork belly, cubed.\n• 1 can coconut milk.\n• 1 onion, chopped.\n• 2-3 green chilies.\n• 1 tbsp shrimp paste.\n• Salt to taste",
            "1. Sauté onion in a pot until translucent. Add pork and cook until browned.\n2. Stir in shrimp paste and green chilies; sauté for a few minutes.\n3. Pour in coconut milk and simmer until thick and pork is tender. Season to taste.",
            "com/example/images/main/bico-express.jpg"
        ));
        
        recipes.put("Laing", new Recipe(
            "Laing",
            "30-40 mins",
            "🍽️ Main Dishes",
            "• 2 cups dried taro leaves.\n• 1 can coconut milk.\n• 1 onion, chopped.\n• 2-3 cloves garlic, minced.\n• 2-3 red chilies.\n• 1/2 cup shrimp or pork (optional).\n• Salt to taste",
            "1. Sauté onion and garlic until fragrant. Add shrimp or pork (if using) and cook until done.\n2. Add taro leaves and stir for a few minutes.\n3. Pour in coconut milk and simmer until leaves are tender. Season with salt.",
            "com/example/images/main/laing.jpg"
        ));
        
        recipes.put("Pork Menudo", new Recipe(
            "Pork Menudo",
            "60 mins",
            "🍽️ Main Dishes",
            "• 1 kg pork, cubed.\n• 1 cup tomato sauce.\n• 1 onion, chopped.\n• 2-3 cloves garlic, minced.\n• 1 cup carrots, diced.\n• 1 cup potatoes, diced.\n• 1/2 cup green peas.\n• 2 tbsp cooking oil.\n• Salt and pepper to taste",
            "1. Heat oil in a pan and sauté onion and garlic until fragrant.\n2. Add pork and cook until browned. Stir in tomato sauce and simmer.\n3. Add carrots, potatoes, and peas; cook until vegetables are tender. Season to taste. ",
            "com/example/images/main/menudo.jpg"
        ));

        recipes.put("Chicken Curry", new Recipe(
            "Chicken Curry",
            "60 mins",
            "🍽️ Main Dishes",
            "• 1 kg chicken, cut into pieces.\n• 2-3 cups coconut milk.\n• 1 onion, chopped.\n• 2-3 cloves garlic, minced.\n• 1-2 tbsp curry powder.\n• 1 cup potatoes, diced.\n• 1 cup carrots, diced.\n• Salt and pepper to taste",
            "1 Sauté onion and garlic until fragrant. Add chicken and cook until browned.\n2. Stir in curry powder, then add coconut milk. Simmer until chicken is cooked through.\n3. Add potatoes and carrots; cook until tender. Season to taste.",
            "com/example/images/main/curry.jpg"
        ));

        recipes.put("Monggo pork", new Recipe(
            "Monggo pork",
            "60 mins",
            "🍽️ Main Dishes",
            "• 1 cup mung beans (monggo).\n• 1/2 kg pork belly, cubed.\n• 1 onion, chopped.\n• 2-3 cloves garlic, minced.\n• 2-3 cups water.\n• 1 cup spinach or water spinach (kangkong).\n• 1-2 tomatoes, chopped.\n• 1-2 tablespoons fish sauce (patis).\n• Salt and pepper to taste.\n• 2 tablespoons cooking oil",
            "1. Rinse mung beans under cold water.\n2In a pot, boil them in 3 cups of water until tender. This usually takes about 30-40 minutes. (You can add more water if needed).\n3. In another pot, heat oil over medium heat. Sauté onion and garlic until fragrant.\n4. Add chopped tomatoes to the pork and cook until softened.\n5. Pour in the cooked mung beans along with the water they were boiled in. Stir to combine.\n6. Add fish sauce, salt, and pepper to taste. Let it simmer for about 15-20 minutes to allow the flavors to meld.\n7. Stir in the spinach or water spinach and cook for an additional 5 minutes until the greens are wilted.\n8. Adjust seasoning if necessary and serve hot with rice.",
            "com/example/images/main/monggo-pork.jpg"
        ));

        recipes.put("Sinigang Pork", new Recipe(
            "Sinigang Pork",
            "60 mins",
            "🍽️ Main Dishes",
            "• 1 kg pork (belly or ribs).\n• 1 onion, quartered.\n• 2-3 tomatoes, quartered.\n• 1 radish, sliced.\n• 1 cup eggplant, sliced.\n• 1 cup water spinach (kangkong).\n• 1 packet tamarind mix.\n• Salt and pepper to taste",
            "1. Boil pork and onion in water until tender.\n2. Add tomatoes and radish; cook for 10 minutes.\n3. Stir in tamarind mix, eggplant, and kangkong. Season to taste.",
            "com/example/images/main/sinigang-na-baboy.jpg"
        ));

        recipes.put("Beef Caldereta", new Recipe(
            "Beef Caldereta",
            "2 hours",
            "🍽️ Main Dishes",
            "• 1 kg beef, cubed.\n• 2 cups beef broth.\n• 1 onion, chopped.\n• 2-3 cloves garlic, minced.\n• 2 carrots, sliced.\n• 1 cup potatoes, cubed.\n• 1 cup bell peppers, slice.\n• 1/2 cup tomato sauce.\n• 1/2 cup liver spread.\n• 2 tbsp cooking oil.\n• Salt and pepper to taste",
            "1. Heat oil in a pot and sauté onion and garlic until fragrant.\n2 Add beef and cook until browned.\n3. Pour in beef broth and tomato sauce. Simmer until beef is tender.\n4. Add carrots, potatoes, and bell peppers; cook until vegetables are tender.\n5. Stir in liver spread and season to taste.",
            "com/example/images/main/beef-caldereta.jpg"
        ));

        recipes.put("Adobong pusit", new Recipe(
            "Adobong pusit",
            "30-40 mins",
            "🍽️ Main Dishes",
            "• 1 kg squid, cleaned and sliced.\n• 1 cup soy sauce.\n• 1/2 cup vinegar.\n• 1 head garlic, crushed.\n• 1 onion, chopped.\n• 2-3 bay leaves.\n• 2 tbsp oil.\n• Salt and pepper to taste",
            "1. Marinate squid in soy sauce, vinegar, garlic, and bay leaves for 30 minutes..\n2 Heat oil in a pan and sauté onion until fragrant. Add squid and cook for a few minutes..\n3 Pour in the marinade and simmer until sauce thickens. Season to taste.",
            "com/example/images/main/AdobongPusit.jpg"
        ));

        recipes.put("Spaghetti", new Recipe(
            "Spaghetti",
            "30-40 mins",
            "🍽️ Main Dishes",
            "• 500 g spaghetti noodles.\n• 1 lb ground beef.\n• 1 onion, chopped.\n• 2-3 cloves garlic, minced.\n•1 can tomato sauce.\n• 1/2 cup grated cheese.\n• Salt and pepper to taste",
            "1. Cook spaghetti noodles according to package instructions. Drain and set aside.\n2. Sauté onion and garlic in a pan, then add ground beef and cook until browned.\n3. Stir in tomato sauce and season. Simmer for 10-15 minutes.\n4. Mix with cooked spaghetti and top with cheese.",
            "com/example/images/main/spaghetti.jpg"
        ));

        recipes.put("Pancit Bihon", new Recipe(
            "Pancit Bihon",
            "30-40 mins",
            "🍽️ Main Dishes",
            "•400 g spaghetti.\n• 200 g bacon or pancetta, chopped.\n• 2-3 eggs.\n• 1/2 cup grated cheese (Parmesan or Pecorino).\n• 1/2 cup heavy cream (optional).\n• Salt and pepper to taste",
            "1. Soak bihon noodles in warm water until softened, then drain.\n2. Sauté garlic, add chicken, and cook until browned.\n3. Add vegetables, noodles, and chicken broth; cook until noodles are tender. Season with \n4. soy sauce.",
            "com/example/images/main/pancit-bihon.jpg"
        ));

        recipes.put("Carbonara", new Recipe(
            "Carbonara",
            "20-30 mins",
            "🍽️ Main Dishes",
            "• 250 g rice noodles.\n• 1 cup chicken, shredded.\n• 1 cup vegetables (carrots, bell peppers, cabbage).\n• 2-3 cloves garlic, minced.\n• 2 cups chicken broth.\n• Soy sauce to taste.\n• 2 tbsp oil",
            "1. Cook spaghetti according to package instructions. Reserve some pasta water.\n2. Sauté bacon until crispy. In a bowl, whisk eggs and cheese.\n3. Combine hot spaghetti with bacon and the egg mixture. Add pasta water as needed for.\n4. creaminess. Season to taste.",
            "com/example/images/main/carbonara.jpeg"
        ));


        // SOUPS
        recipes.put("Chicken Ginger Soup (Tinola)", new Recipe(
            "Chicken Ginger Soup (Tinola)",
            "45 mins",
            "🍲 Soups",
            "• 1 kg chicken, cut into pieces.\n• 1 onion, chopped.\n• 1 ginger, sliced.\n• 2-3 cups water.\n• 1 cup green papaya, sliced.\n• Fish sauce to taste",
            "1. Sauté onion and ginger in a pot until fragrant.\n2. Add chicken and cook until browned.\n3. Pour in water and let it boil. Simmer until chicken is cooked through.\n4. Add papaya and cook until tender. Finally, stir in spinach and season with fish sauce.\n5. Serve hot.",
            "com/example/images/soups/tinolang-manok.jpg"
        ));
        
        recipes.put("Miso Soup with Fish", new Recipe(
            "Miso Soup with Fish",
            "30 mins",
            "🍲 Soups",
            "• 1/2 kg fish (such as bangus or tilapia).\n• 1/4 cup miso paste.\n• 1 onion, sliced.\n• 2-3 cups water.\n• 1 cup tofu, cubed.\n• 1 cup spinach or green onions, chopped",
            "1. In a pot, bring water to a boil and add onions.\n2. Once boiling, add the fish and cook until it flakes easily.\n3. In a small bowl, dissolve miso paste in a bit of hot broth, then stir it into the pot.\n4. Add tofu and cook for a few minutes. Finish with spinach or green onions\n5. Serve hot.",
            "com/example/images/soups/miso-fish.JPG"
        ));

        recipes.put("Labanos Soup (Radish Soup)", new Recipe(
            "Labanos Soup (Radish Soup)",
            "60 mins",
            "🍲 Soups",
            "• 1 radish (labanos), sliced.\n• 1/2 kg pork belly, cubed.\n• 1 onion, chopped.\n• 2-3 cups water.\n• Fish sauce to taste.\n• Green onions for garnish",
            "1. Sauté onion and pork in a pot until pork is browned.\n2. Add water and bring to a boil. Simmer until the pork is tender.\n3. Add sliced radish and cook until tender. Season with fish sauce.\n4. Garnish with green onions and serve hot.",
            "com/example/images/soups/labanos.jpg"
        ));

        recipes.put("Bulalo (Beef Bone Soup)", new Recipe(
            "Bulalo (Beef Bone Soup)",
            "2 hours",
            "🍲 Soups",
            "• 1 kg beef shank with bone.\n• 1 onion, quartered.\n• 2-3 cups water.\n• 1 cup corn, cut in half.\n• 1 cup potatoes, cubed.\n• 1 cup cabbage, chopped.\n• Salt and pepper to taste",
            "1. Boil beef shank and onion in water until tender (about 2 hours).\n2. Add corn and potatoes; cook until soft.\n3. Add cabbage and season with salt and pepper.\n4. Serve hot with rice.",
            "com/example/images/soups/bulalo.jpg"
        ));

        recipes.put("Sopas (Filipino Macaroni Soup)", new Recipe(
            "Sopas (Filipino Macaroni Soup)",
            "30-40 mins",
            "🍲 Soups",
            "• 1 cup macaroni.\n• 1/2 kg chicken, shredded.\n• 1 onion, chopped.\n• 2-3 cups water.\n• 1 cup milk.\n• 1/2 cup carrots, diced.\n• Salt and pepper to taste",
            "1. In a pot, boil water and cook macaroni until al dente. Drain and set aside.\n2. Sauté onion and add shredded chicken, cooking until heated through.\n3. Add water, carrots, and cooked macaroni; simmer for 10 minutes.\n4. Stir in milk and season with salt and pepper. Serve hot.",
            "com/example/images/soups/sopas.jpg"
        ));

        recipes.put("Sinigang na Isda (Fish Sinigang)", new Recipe(
            "Sinigang na Isda (Fish Sinigang)",
            "45 mins",
            "🍲 Soups",
            "• 1 kg fish (e.g., tilapia or bangus).\n• 1 onion, quartered.\n• 2-3 tomatoes, quartered.\n• 1 radish, sliced.\n• 1 cup long green beans.\n• 1 packet tamarind mix or fresh tamarind.\n• Salt and pepper to taste.\n• 6 cups water",
            "1. Boil water with onion and tomatoes for 10 minutes.\n2. Add fish and cook until it flakes easily.\n3. Stir in tamarind mix and radish; simmer for 5 minutes.\n4. Add green beans and season with salt and pepper. Serve hot.",
            "com/example/images/soups/sinigang.jpg"

        ));

        recipes.put("Arroz Caldo (Chicken Rice Porridge)", new Recipe(
            "Arroz Caldo (Chicken Rice Porridge)",
            "60 mins",
            "🍲 Soups",
            "• 1 cup rice.\n• 1/2 kg chicken, cut into pieces.\n• 1 onion, chopped.\n• 1 ginger, sliced.\n• 6 cups water or chicken broth.\n• Salt and pepper to taste.\n• Green onions and hard-boiled eggs for garnish",
            "1. Sauté onion and ginger in a pot until fragrant.\n2. Add chicken and cook until browned.\n3. Stir in rice and add water or broth. Bring to a boil and simmer until rice is cooked and porridge is thickened.\n4. Season with salt and pepper. Garnish with green onions and hard-boiled eggs. Serve hot.",
            "com/example/images/soups/arroz-caldo.jpg"
        ));

        recipes.put("Batchoy (Ilocos Noodle Soup)", new Recipe(
            "Batchoy (Ilocos Noodle Soup)",
            "30-40 mins",
            "🍲 Soups",
            "• 1/2 kg pork, sliced.\n• 1/4 kg liver, sliced.\n• 4 cups beef broth.\n• 1 onion, chopped.\n• 2-3 cloves garlic, minced.\n• Egg noodles.\n• Green onions for garnish",
            "1. Sauté onion and garlic; add pork and liver until cooked.\n2. Pour in beef broth and simmer for 10 minutes.\n3. Cook egg noodles separately and add to the soup.\n4. Garnish with green onions and serve hot.",
            "com/example/images/soups/batchoy.jpg"
        ));

        recipes.put("Sopa de Pichon (Pigeon Soup)", new Recipe(
            "Sopa de Pichon (Pigeon Soup)",
            "60 mins",
            "🍲 Soups",
            "• 1 kg pigeon or quail.\n• 1 onion, chopped.\n• 2-3 cups water.\n• 1 cup potatoes, cubed.\n• Salt and pepper to taste",
            "1. Boil pigeon or quail with onion in water until tender.\n2. Add potatoes and cook until soft. Season with salt and pepper.\n3. Serve hot.",
            "com/example/images/soups/pichon.jpg"
        ));

        recipes.put("Labanos at Baboy (Radish and Pork Soup)", new Recipe(
            "Labanos at Baboy (Radish and Pork Soup)",
            "60 mins",
            "🍲 Soups",
            "• 1/2 kg pork belly, cubed.\n• 1 radish (labanos), sliced.\n• 1 onion, chopped.\n• 2-3 cups water.\n• 2-3 tablespoons fish sauce (patis).\n• Salt and pepper to taste.\n• Green onions for garnish",
            "1. In a pot, sauté onion until translucent. Add pork and cook until browned.\n2. Pour in water and bring to a boil. Simmer until pork is tender (about 30-40 minutes).\n3. Add sliced radish and cook until tender (about 10 minutes).\n4. Season with fish sauce, salt, and pepper. Garnish with green onions before serving.",
            "com/example/images/soups/labanos.jpg"
        ));

        recipes.put("Pochero (Spanish-Style Stew)", new Recipe(
            "Pochero (Spanish-Style Stew)",
            "2 hours",
            "🍲 Soups",
            "• 1 kg beef shank, cut into pieces.\n• 1 onion, chopped.\n• 2-3 cups water.\n• 1 cup potatoes, cubed.\n• 1 cup carrots, sliced.\n• 1 cup cabbage, chopped.\n• 1 banana heart, sliced (optional).\n• 1/2 cup tomato sauce.\n• Salt and pepper to taste",
            "1. In a pot, sauté onion until fragrant. Add beef and cook until browned.\n2. Pour in water and bring to a boil. Simmer until beef is tender (about 1-2 hours).\n3. Add potatoes, carrots, and banana heart; cook until tender.\n4. Stir in tomato sauce, cabbage, and season with salt and pepper. Serve hot.",
            "com/example/images/soups/pochero.jpg"
        ));

        recipes.put("Sinigang na Baboy sa Bayabas (Pork Sinigang with Guava)", new Recipe(
            "Sinigang na Baboy sa Bayabas (Pork Sinigang with Guava)",
            "60 mins",
            "🍲 Soups",
            "• 1 kg pork (belly or ribs).\n• 1 onion, quartered.\n• 2-3 tomatoes, quartered.\n• 2-3 ripe guavas, quartered.\n• 1 radish, sliced.\n• 1 cup long green beans.\n• 1 cup water spinach (kangkong).\n• 6 cups water.\n• Salt and pepper to taste",
            "1.In a pot, boil the pork and onion in water until the pork is tender (about 45 minutes).\n2. Add tomatoes and guavas; cook for 10 minutes until guavas soften.\n3. Press the guavas against the side of the pot to release their flavor.\n4. Add radish and cook for about 5 minutes.\n5. Stir in the long green beans and cook until tender. Finally, add the kangkong and season with salt and pepper.\n6. Serve hot with rice.",
            "com/example/images/soups/baboy-bayabas.jpg"
        ));

        recipes.put("Chicken and Corn Soup", new Recipe(
            "Chicken and Corn Soup",
            "30-40 mins",
            "🍲 Soups",
            "• 1/2 kg chicken, shredded.\n• 2 cups corn kernels (fresh or canned).\n• 1 onion, chopped.\n• 2-3 cups chicken broth or water.\n• 1/2 cup carrots, diced.\n• Salt and pepper to taste.\n• Green onions for garnish",
            "1. In a pot, sauté onion until translucent. Add shredded chicken and cook until heated through.\n2. Pour in chicken broth or water, and add corn and carrots. Simmer until carrots are .\n• tender (about 15-20 minutes).\n3. Season with salt and pepper. Garnish with green onions before serving.",
            "com/example/images/soups/corn-chicken.jpg"
        ));

        recipes.put("Sopas na Baka (Beef Macaroni Soup)", new Recipe(
            "Sopas na Baka (Beef Macaroni Soup)",
            "1 hour & 30 mins",
            "🍲 Soups",
            "• 1 cup macaroni.\n• 1/2 kg beef, cubed.\n• 1 onion, chopped.\n• 2-3 cups beef broth.\n• 1 cup carrots, diced.\n• 1 cup celery, chopped.\n• 1 cup milk.\n• Salt and pepper to taste",
            "1. In a pot, boil macaroni in salted water until al dente. Drain and set aside.\2.• Sauté onion in a pot until fragrant. Add beef and cook until browned.\n3. Pour in beef broth and simmer until beef is tender (about 1 hour).\n4. Add carrots, celery, and cooked macaroni. Stir in milk and season with salt and pepper. Serve hot.",
            "com/example/images/soups/sopas-baka.jpg"
        ));

        recipes.put("Caldo Verde (Green Soup)", new Recipe(
            "Caldo Verde (Green Soup)",
            "30 mins",
            "🍲 Soups",
            "• 1 kg potatoes, peeled and diced.\n• 1 onion, chopped.\n• 4 cups water or chicken broth.\n• 1 cup kale or spinach, chopped.\n• 2-3 cloves garlic, minced.\n• Olive oil.\n• Salt and pepper to taste",
            "1. In a pot, sauté onion and garlic in olive oil until fragrant.\n2. Add potatoes and water or chicken broth; bring to a boil. Simmer until potatoes are tender (about 20 minutes).\n3. Mash the potatoes slightly in the pot to thicken the soup.\n4. Stir in kale or spinach and cook until wilted. Season with salt and pepper before serving.",
            "com/example/images/soups/caldo-verde.jpg"
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
