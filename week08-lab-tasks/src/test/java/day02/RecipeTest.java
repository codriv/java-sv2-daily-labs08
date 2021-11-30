package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    @Test
    void testRecipeWithName() {
        Recipe recipe = new Recipe("name");
        assertEquals("name", recipe.getName());
        assertEquals(null, recipe.getDescription());
        assertEquals(0, recipe.getIngredients().size());
    }

    @Test
    void testRecipeWithNameAndDescription() {
        Recipe recipe = new Recipe("name", "description");
        assertEquals("description", recipe.getDescription());
        assertEquals(0, recipe.getIngredients().size());
    }

    @Test
    void testRecipeAddIngredients() {
        Recipe recipe = new Recipe("Almás pite");
        recipe.addIngredient("alma");
        recipe.addIngredient("fahéj", "liszt", "tojás", "cukor", "só");
        assertEquals(6, recipe.getIngredients().size());
        assertEquals("cukor", recipe.getIngredients().get(4));
    }
}