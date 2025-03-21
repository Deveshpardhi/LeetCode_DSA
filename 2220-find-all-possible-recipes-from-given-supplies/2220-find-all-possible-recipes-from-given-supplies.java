import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // Set of ingredients we initially have
        Set<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));
        Set<String> madeRecipes = new HashSet<>();
        List<String> result = new ArrayList<>();
        
        // Keep track of recipes that are ready to be made
        boolean madeSomething = true;
        
        // Continue checking until no new recipes are made
        while (madeSomething) {
            madeSomething = false;
            // Iterate over all recipes
            for (int i = 0; i < recipes.length; i++) {
                // If the recipe is already made, skip it
                if (madeRecipes.contains(recipes[i])) {
                    continue;
                }
                
                // Check if all ingredients for this recipe are available
                List<String> recipeIngredients = ingredients.get(i);
                boolean canMakeRecipe = true;
                for (String ingredient : recipeIngredients) {
                    if (!suppliesSet.contains(ingredient)) {
                        canMakeRecipe = false;
                        break;
                    }
                }
                
                // If all ingredients are available, mark the recipe as made
                if (canMakeRecipe) {
                    suppliesSet.add(recipes[i]);
                    madeRecipes.add(recipes[i]);
                    result.add(recipes[i]);
                    madeSomething = true; // We made a new recipe, so continue the loop
                }
            }
        }
        
        return result;
    }
}
