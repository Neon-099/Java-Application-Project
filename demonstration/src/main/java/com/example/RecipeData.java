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

        recipes.put("Beef Asado", new Recipe(
            "Beef Asado",
            "30 mins",
            "🍽️ Main Dishes",
            "• 2 lbs beef chuck (cut into cubes).\n• 1/4 cup soy sauce.\n• 1/4 cup vinegar.\n• 1 onion (sliced).\n• 3 cloves garlic (minced).\n• 2-3 tomatoes (chopped).\n• 1/2 cup water.\n• 2 tbsp cooking oil.\n• 1-2 bay leaves.\n• 1 tsp sugar.\n• Salt and pepper to taste.\n• Bell peppers (for garnish, optional)",
            "1. In a bowl, marinate the beef cubes in soy sauce, vinegar, minced garlic, and black .\n• pepper for at least 30 minutes.\n2. Heat oil in a pot over medium heat. Remove the beef from the marinade (reserve the marinade) and brown the beef cubes.\n3. Add the sliced onion and chopped tomatoes, and sauté until the onion is soft.\n4. Pour in the reserved marinade and add water, bay leaves, and sugar. Bring to a boil.\n5. Lower the heat and simmer for about 1 hour, or until the beef is tender. Stir occasionally and add more water if needed.\n6. Season with salt and pepper to taste. Serve hot, with steamed rice and garnished with bell peppers if desired.",
            "com/example/images/main/beef-asado.jpg"
        ));

        recipes.put("Bistek (Beef Steak)", new Recipe(
            "Bistek (Beef Steak)",
            "30 mins",
            "🍽️ Main Dishes",
            "• 1 lb beef sirloin (sliced into thin pieces).\n• 1/3 cup soy sauce.\n• 1/4 cup calamansi juice (or lemon juice).\n• 1/2 tsp black pepper.\n• 3 cloves garlic (minced).\n• 1 onion (sliced into rings).\n• 2-3 tbsp cooking oil.\n• Salt to taste.\n• Green onions (for garnish, optional)",
            "1. In a bowl, marinate the beef slices in soy sauce, calamansi juice, black pepper, and minced garlic for at least 30 minutes.\n2. Heat oil in a pan over medium heat. Remove the beef from the marinade (reserve the marinade) and fry the beef slices until browned. Remove and set aside.\n3. In the same pan, sauté the onion rings until they are soft and translucent.\n4. Return the beef to the pan. Pour in the reserved marinade and simmer for about 10-15 minutes until the beef is cooked through and the sauce thickens slightly.\n5. Adjust seasoning with salt if needed. Serve hot, garnished with green onions, and enjoy with steamed rice.",
            "com/example/images/main/bistek.jpg"
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
        recipes.put("Mango Float", new Recipe(
            "Mango Float",
            "30 mins (plus chilling time)",
            "🍰 Desserts",
            "• 2 ripe mangoes (sliced).\n• 1 pack (200g) graham crackers.\n• 1 can (14 oz) sweetened condensed milk.\n• 1 cup all-purpose cream.",
            "1. In a bowl, mix condensed milk and all-purpose cream until smooth.\n2. In a dish, layer graham crackers, cream mixture, and mango slices.\n3. Repeat layers, finishing with the cream mixture on top.\n4. Chill for at least 4 hours or overnight before serving.",
            "com/example/images/desserts/mango-float.jpg"
        ));
        
        recipes.put("Biko (Sticky Rice Cake)", new Recipe(
            "Biko (Sticky Rice Cake)",
            "1 hour",
            "🍰 Desserts",
            "• 2 cups glutinous rice.\n• 1 can (14 oz) coconut milk.\n• 1 cup brown sugar.\n• 1/2 tsp salt.\n• Grated coconut (for topping)",
            "1. Cook glutinous rice according to package instructions.\n2. In a pot, mix coconut milk, brown sugar, and salt. Heat until sugar dissolves.\n3. Combine the cooked rice with the coconut mixture. Cook until thick.\n4. Pour into a greased dish, top with grated coconut, and let cool before serving.",
            "com/example/images/desserts/biko.jpg"
        ));

        recipes.put("Tapioca Pudding (Sago)", new Recipe(
            "Tapioca Pudding (Sago)",
            "40 mins",
            "🍰 Desserts",
            "• 1 cup tapioca pearls.\n• 1 can (14 oz) coconut milk.\n• 1 cup sugar.\n• 1/2 cup water.\n• 1/2 cup sweetened fruits (like mango or jackfruit)",
            "1. Boil tapioca pearls in water until translucent (about 15 minutes). Drain and rinse.\n2. In a pot, combine coconut milk and sugar. Heat until sugar dissolves.\n3. Add cooked tapioca and sweetened fruits. Simmer for a few minutes.\n4. Chill before serving.",
            "com/example/images/desserts/tapioca-pudding.jpg"
        ));

        recipes.put("Puto Bumbong", new Recipe(
            "Puto Bumbong",
            "1 hour",
            "🍰 Desserts",
            "• 2 cups glutinous rice flour.\n• 1 cup water.\n• 1/2 cup purple rice (soaked overnight).\n• Grated coconut (for topping).\n• Brown sugar (for serving)",
            "1. Drain purple rice and blend with water until smooth.\n2. In a bowl, mix glutinous rice flour with the purple rice mixture.\n3. Pour batter into puto bumbong molds and steam for 20-30 minutes.\n4. Serve topped with grated coconut and brown sugar.",
            "com/example/images/desserts/puto-bumbong.jpg"
        ));

        recipes.put("Cassava Cake", new Recipe(
            "Cassava Cake",
            "1.5 hours",
            "🍰 Desserts",
            "• 2 cups grated cassava (fresh or frozen).\n• 1 can (14 oz) coconut milk.\n• 1 can (14 oz) sweetened condensed milk.\n• 1 cup sugar.\n• 2 eggs.\n• 1 tsp vanilla extract.\n• 1/2 cup grated cheese (optional for topping)",
            "1. Preheat oven to 350°F (175°C).\n2. In a bowl, mix cassava, coconut milk, condensed milk, sugar, eggs, and vanilla until well combined.\n3. Pour mixture into a greased baking dish.\n4. Bake for 45-50 minutes. If using cheese, sprinkle it on top and bake for an additional 10 minutes until melted.",
            "com/example/images/desserts/cassava-cake.jpg"
        ));

        recipes.put("Pineapple Upside-Down Cake", new Recipe(
            "Pineapple Upside-Down Cake",
            "1 hour",
            "🍰 Desserts",
            "• 1 can (20 oz) pineapple slices.\n• 1/2 cup butter.\n• 1 cup brown sugar.\n• 1 cup all-purpose flour.\n• 1 cup sugar.\n• 2 tsp baking powder.\n• 1/2 cup milk.\n• 2 eggs.\n• Maraschino cherries (for garnish)",
            "1. Preheat oven to 350°F (175°C).\n2. Melt butter in a pan and add brown sugar. Arrange pineapple slices on top.\n3. In a bowl, mix flour, sugar, baking powder, milk, and eggs until smooth.\n4. Pour batter over pineapple and bake for 30-35 minutes. Let cool before flipping.",
            "com/example/images/desserts/pineapple-cake.jpg"
        ));

        recipes.put("Kutsinta", new Recipe(
            "Kutsinta",
            "1 hour",
            "🍰 Desserts",
            "• 2 cups rice flour.\n• 1 cup brown sugar.\n• 2 cups water.\n• 1 tsp lye water.\n• Grated coconut (for topping)",
            "1. Mix all ingredients until smooth..\n2. Pour into molds and steam for 30 minutes..\n3. Serve topped with grated coconut.",
            "com/example/images/desserts/kutsinta.jpg"
        ));

        recipes.put("Buko Pandan Salad", new Recipe(
            "Buko Pandan Salad",
            "30 mins",
            "🍰 Desserts",
            "• 1 cup young coconut (buko), shredded.\n• 1 pack (8 oz) pandan-flavored gelatin.\n• 1 cup condensed milk.\n• 1 cup all-purpose cream.\n• 1 cup water.\n• 1/2 cup sugar",
            "1. Prepare gelatin according to package instructions and let cool, then cut into cubes.\n2. In a bowl, mix coconut, gelatin, condensed milk, and cream.\n3. Chill before serving.",
            "com/example/images/desserts/buko-pandan-salad.jpg"
        ));

        recipes.put("Maja Blanca", new Recipe(
            "Maja Blanca",
            "1 hour",
            "🍰 Desserts",
            "• 1 can (14 oz) coconut milk.\n• 1 can (12 oz) evaporated milk.\n• 1 cup corn kernels.\n• 1 cup cornstarch.\n• 1 cup sugar.\n• Grated coconut (for topping)",
            "1. In a pot, mix coconut milk, evaporated milk, sugar, and corn.\n2. Dissolve cornstarch in a small amount of water and add to the mixture.\n3. Stir over low heat until thick. Pour into a mold and let cool. Top with grated coconut.",
            "com/example/images/desserts/maja-blanca.jpg"
        ));

        recipes.put("Turon", new Recipe(
            "Turon",
            "30 mins",
            "🍰 Desserts",
            "• 4 ripe bananas (saba).\n• 1 cup brown sugar.\n• Lumpia wrappers.\n• Oil (for frying)",
            "1. Roll each banana in brown sugar and wrap in lumpia wrappers.\n2. Heat oil in a pan and fry until golden brown and crispy.\n3. Drain excess oil and serve.",
            "com/example/images/desserts/turon.jpg"
        ));

        recipes.put("Halo-Halo", new Recipe(
            "Halo-Halo",
            "30 mins",
            "🍰 Desserts",
            "• 1 cup crushed ice.\n• 1/2 cup sweetened jackfruit.\n• 1/2 cup sweetened banana.\n• 1/2 cup sweetened beans.\n• 1/2 cup leche flan (cubed).\n• 1/2 cup purple yam (u-be) puree.\n• 1 cup evaporated milk.\n• 1 scoop ice cream (optional)",
            "1. In a tall glass, layer sweetened fruits and beans.\n2. Add crushed ice on top.\n3. Pour evaporated milk over the ice and top with ice cream if desired.",
            "com/example/images/desserts/halo-halo.jpg"
        ));

        recipes.put("Sapin-Sapin", new Recipe(
            "Sapin-Sapin",
            "1.5 hours",
            "🍰 Desserts",
            "• 2 cups glutinous rice flour.\n• 1 can (14 oz) coconut milk.\n• 1 cup sugar.\n• 1 cup water.\n• 1/2 cup purple yam (u-be) puree.\n• 1/2 cup mung bean (cooked).\n• 1/2 cup grated coconut (for topping)",
            "1. In a bowl, mix glutinous rice flour, sugar, coconut milk, and water.\n2. Divide batter into three parts. Add purple yam to one, mung bean to another, and leave the third as is.\n3. Layer in a mold and steam for 30-40 minutes. Top with grated coconut and serve.",
            "com/example/images/desserts/sapin-sapin.jpg"
        ));

        recipes.put("Puto", new Recipe(
            "Puto",
            "1 hour",
            "🍰 Desserts",
            "• 2 cups rice flour.\n• 1 cup milk.\n• 1 cup sugar.\n•2 tsp baking powder.\n• 1/2 cup butter (melted).\n• 2 eggs.\n• Cheese slices (for topping)",
            "1. In a bowl, mix rice flour, sugar, and baking powder.\n2. Add milk, melted butter, and eggs; mix until smooth.\n3. Pour into molds and place a slice of cheese on top.\n4. Steam for 30 minutes until cooked.",
            "com/example/images/desserts/puto.jpg"
        )); 

        recipes.put("Bibingka", new Recipe(
            "Bibingka",
            "1 hour",
            "🍰 Desserts",
            "• 2 cups rice flour.\n• 1 cup coconut milk.\n• 1 cup water.\n• 1 cup sugar.\n• 2 tsp baking powder.\n• 2 eggs.\n• Banana leaves (for lining).\n• Grated coconut (for topping)",
            "1. Preheat oven to 375°F (190°C).\n2. Mix rice flour, sugar, baking powder, coconut milk, water, and eggs until smooth.\n3. Line baking pans with banana leaves. Pour batter into pans.\n4. Bake for 30-35 minutes. Top with grated coconut before serving.",
            "com/example/images/desserts/bibingka.jpg"
        )); 

        recipes.put("Leche Flan", new Recipe(
            "Leche Flan",
            "10 mins",
            "🍰 Desserts",
            "• 1 cup sugar (for caramel).\n• 1 can (14 oz) sweetened condensed milk.\n• 1 can (12 oz) evaporated milk.\n• 5 egg yolks.\n• 1 tsp vanilla extract",
            "1. In a saucepan, melt sugar over medium heat until golden brown. Pour into a flan mold.\n2. In a bowl, whisk together condensed milk, evaporated milk, egg yolks, and vanilla.\n3. Pour mixture over caramel in the mold.\n4. Cover with foil and steam for 30-40 minutes. Chill before serving.",
            "com/example/images/desserts/leche-flan.jpg"
        ));
        
        // Beverages (10 recipes)
        recipes.put("Sago’t Gulaman", new Recipe(
            "Sago’t Gulaman",
            "10 mins",
            "🥤 Beverages",
            "• 1 cup sago (tapioca pearls).\n• 1 cup gulaman (agar jelly), cut into cubes.\n• 1 cup brown sugar.\n• 4 cups water.\n• 2-3 pandan leaves",
            "1. Boil 4 cups of water with pandan leaves. Remove leaves once water is fragrant.\n2. Add sago and cook until translucent (about 15 minutes). Drain and rinse.\n3. In a separate pot, dissolve brown sugar in 1 cup of water to make syrup.\n4. In a glass, layer sago, gulaman, and pour syrup over it. Serve chilled.",
            "com/example/images/beverages/sago-gulaman.jpg"
        ));
        
        recipes.put("Buko Juice", new Recipe(
            "Buko Juice",
            "15 mins",
            "🥤 Beverages",
            "• 1 cup young coconut (buko), shredded.\n• 1 cup sugar.\n• 1 cup water.\n• 1/2 cup condensed milk.\n• 1 cup all-purpose cream",
            "1. In a bowl, mix coconut, sugar, and water until sugar dissolves.\n2. Add condensed milk and cream. Chill before serving.",
            "com/example/images/beverages/buko-juice.jpg"
        ));

        recipes.put("Lemonade", new Recipe(
            "Lemonade",
            "20 mins",
            "🥤 Beverages",
            "• Lemons\n• Sugar\n• Water\n• Ice\n• Mint (optional)",
            "1. Make sugar syrup\n2. Juice lemons\n3. Combine and dilute\n4. Chill and serve",
            "com/example/images/beverages/lemonade.jpg"
        ));

        recipes.put("Hot Chocolate", new Recipe(
            "Hot Chocolate",
            "15 mins",
            "🥤 Beverages",
            "• 1 cup cocoa powder.\n• 1 cup sugar.\n• 1 cup water.\n• 1/2 cup condensed milk.\n• 1 cup all-purpose cream",
            "1. In a pot, mix cocoa powder, sugar, and water until sugar dissolves.\n2. Add condensed milk and cream. Simmer until thick. Chill before serving.",
            "com/example/images/beverages/hot-chocolate.jpg"
        ));

        recipes.put("Pineapple Juice", new Recipe(
            "Pineapple Juice",
            "10 mins",
            "🥤 Beverages",
            "• 1 ripe pineapple.\n• Water (as needed)",
            "1. Peel and chop the pineapple.\n2. Blend with water until smooth. Strain if desired. Serve chilled.",
            "com/example/images/beverages/pineapple-juice.jpg"
        ));

        recipes.put("Milk Tea", new Recipe(
            "Milk Tea",
            "10 mins",
            "🥤 Beverages",
            "• 2 cups water.\n• 2 black tea bags.\n• 1 cup milk.\n• Sugar (to taste).\n• Tapioca pearls (optional)",
            "1. Boil water and steep tea bags for 5 minutes.\n2. Remove tea bags and add milk and sugar. Stir well.\n3. Serve hot or cold, adding tapioca pearls if desired.",
            "com/example/images/beverages/milk-tea.jpg"
        ));

        recipes.put("Mango Lassi", new Recipe(
            "Mango Lassi",
            "10 mins",
            "🥤 Beverages",
            "• 1 cup mango pulp.\n• 1 cup plain yogurt.\n• 1/2 cup sugar.\n• 1/2 tsp cardamom powder.\n• Ice cubes",
            "1. Blend mango pulp and yogurt.\n2. Add sugar and cardamom powder.\n3. Blend with ice cubes.\n4. Serve chilled.",
            "com/example/images/beverages/mango-lasi.jpg"
        ));

        recipes.put("Mango Shake", new Recipe(
            "Mango Shake",
            "20 mins",
            "🥤 Beverages",
            "• 1 ripe mango.\n• 1 cup milk.\n• 1/2 cup sugar.\n• 1/2 tsp cardamom powder.\n• Ice cubes",
            "1. Blend mango pulp and milk.\n2. Add sugar and cardamom powder.\n3. Blend with ice cubes.\n4. Serve chilled.",
            "com/example/images/beverages/mango-shake.jpg"
        ));

        recipes.put("Buko Pandan Shake", new Recipe(
            "Buko Pandan Shake",
            "10 mins",
            "🥤 Beverages",
            "• 1 cup young coconut (buko), shredded.\n• 1 cup milk.\n• 1/2 cup sugar.\n• 1/2 tsp cardamom powder.\n• Ice cubes",
            "1. Blend buko and milk.\n2. Add sugar and cardamom powder.\n3. Blend with ice cubes.\n4. Serve chilled.",
            "com/example/images/beverages/buko-pandan-shake.jpg"
        ));

        recipes.put("Lemon Basil Drink (Basil Lemonade)", new Recipe(
            "Lemon Basil Drink (Basil Lemonade)",
            "10 mins",
            "🥤 Beverages",
            "• 1 cup lemon juice (freshly squeezed).\n• 1 cup basil leaves.\n• 1 cup sugar (adjust to taste).\n• 4 cup water.\n• 1/2 cup condensed milk.\n• Ice cubes",
            "1. In a pot, bring 1 cup of water to a boil and add the basil leaves. Steep for 5 minutes, then strain to remove the leaves.\n2.In a pitcher, combine the basil-infused water, lemon juice, remaining water, and sugar. Stir until the sugar is dissolved.\n3. Serve over ice and garnish with additional basil leaves or lemon slices if desired.",
            "com/example/images/beverages/lemon-basil-drink.jpg"
        ));

        recipes.put("Strawberry Milkshake", new Recipe(
            "Strawberry Milkshake",
            "10 mins",
            "🥤 Beverages",
            "• 1 cup strawberries.\n• 1 cup milk.\n• 1/2 cup sugar.\n• 1/2 tsp cardamom powder.\n• Ice cubes",
            "1. Blend strawberries and milk.\n2. Add sugar and cardamom powder.\n3. Blend with ice cubes.\n4. Serve chilled.",  
            "com/example/images/beverages/strawberry-milkshake.jpg"
        ));

        recipes.put("Fruit Shake", new Recipe(
            "Fruit Shake",
            "10 mins",
            "🥤 Beverages",
            "• 1 banana.\n• 1 cup mixed fruits (mango, pineapple, etc.).\n• 1 cup yogurt or milk.\n• Ice",
            "1. Blend all ingredients until smooth.\n2. Serve chilled.",
            "com/example/images/beverages/mango-smoothie.jpg"
        ));

        recipes.put("Strawberry Smoothie", new Recipe(
            "Strawberry Smoothie",
            "10 mins",
            "🥤 Beverages",
            "• 1 cup strawberries.\n• 1 cup milk.\n• 1/2 cup sugar.\n• 1/2 tsp cardamom powder.\n• Ice cubes",
            "1. Blend strawberries and milk.\n2. Add sugar and cardamom powder.\n3. Blend with ice cubes.\n4. Serve chilled.",
            "com/example/images/beverages/strawberry-smoothie.jpg"
        ));

        recipes.put("Choco Banana Smoothie", new Recipe(
            "Choco Banana Smoothie",
            "10 mins",
            "🥤 Beverages",
            "• 1 ripe banana.\n• 1 cup milk.\n• 1/2 cup sugar.\n• 1/2 tsp cardamom powder.\n• Ice cubes",
            "1. Blend banana and milk.\n2. Add sugar and cardamom powder.\n3. Blend with ice cubes.\n4. Serve chilled.",    
            "com/example/images/beverages/choco-banana-smoothie.jpg"
        ));

        recipes.put("Soursop Juice (Guyabano Juice)", new Recipe(
            "Soursop Juice (Guyabano Juice)",
            "10 mins",
            "🥤 Beverages",
            "• 1 ripe soursop.\n• 1 cup milk.\n• 1/2 cup sugar.\n• 1/2 tsp cardamom powder.\n• Ice cubes",
            "1. Blend soursop and milk.\n2. Add sugar and cardamom powder.\n3. Blend with ice cubes.\n4. Serve chilled.",
            "com/example/images/beverages/soursop-juice.jpg"
        ));
        return recipes;
    }
}
