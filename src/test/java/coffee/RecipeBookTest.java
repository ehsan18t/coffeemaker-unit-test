package coffee;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecipeBookTest {
    private RecipeBook recipeBook;
    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;
    private Recipe recipe4;
    private Recipe recipe5;

    @BeforeEach
    public void setUp() {
        recipeBook = new RecipeBook();
        recipe1 = new Recipe();
        recipe1.setName("Recipe1");
        recipe2 = new Recipe();
        recipe2.setName("Recipe2");
        recipe3 = new Recipe();
        recipe3.setName("Recipe3");
        recipe4 = new Recipe();
        recipe4.setName("Recipe4");
        recipe5 = new Recipe();
        recipe5.setName("Recipe5");
    }

    // ========== Test Getters ========== //
    @Test
    public void testDefaultValues() {
        Recipe[] recipes = recipeBook.getRecipes();
        assertNotNull(recipes, "Recipe array should not be null");
        assertEquals(4, recipes.length, "Initial Recipe array should have length 4");
        for (Recipe recipe : recipes) {
            assertNull(recipe, "Initial Recipe array should be empty");
        }
    }

    // ========== Test Add Recipe ========== //
    @Test
    public void testAddRecipeSuccess() {
        assertTrue(recipeBook.addRecipe(recipe1));
        assertTrue(recipeBook.addRecipe(recipe2));
        assertTrue(recipeBook.addRecipe(recipe3));
        assertTrue(recipeBook.addRecipe(recipe4));
    }

    @Test
    public void testAddRecipeDuplicate() {
        recipeBook.addRecipe(recipe1);
        assertFalse(recipeBook.addRecipe(recipe1), "Duplicate recipe should not be added");
    }

    @Test
    public void testAddRecipeDuplicateWithDifferentObject() {
        Recipe duplicateRecipe = new Recipe();
        duplicateRecipe.setName("Recipe1");
        recipeBook.addRecipe(recipe1);
        assertFalse(recipeBook.addRecipe(duplicateRecipe), "Recipes with identical contents should be treated as duplicates");
    }

    @Test
    public void testAddRecipeFull() {
        recipeBook.addRecipe(recipe1);
        recipeBook.addRecipe(recipe2);
        recipeBook.addRecipe(recipe3);
        recipeBook.addRecipe(recipe4);
        assertFalse(recipeBook.addRecipe(recipe5), "Recipe book is full, so recipe5 should not be added");
    }

    @Test
    public void testAddRecipeNull() {
        try {
            assertFalse(recipeBook.addRecipe(null), "Adding a null recipe should return false");
        } catch (NullPointerException e) {
            fail("throwing NullPointerException instead of returning false");
        }
    }

    @Test
    public void testAddRecipeDoesNotOverwrite() {
        recipeBook.addRecipe(recipe1);
        recipeBook.addRecipe(recipe2);
        Recipe[] recipes = recipeBook.getRecipes();
        assertEquals(recipe1, recipes[0], "Recipe1 should remain at index 0");
        assertEquals(recipe2, recipes[1], "Recipe2 should remain at index 1");
        assertNull(recipes[2], "Index 2 should be null");
    }

    // ========== Test Delete Recipe ========== //
    @Test
    public void testDeleteRecipeSuccess() {
        recipeBook.addRecipe(recipe1);
        assertEquals(recipe1.getName(), recipeBook.deleteRecipe(0));
        assertNull(recipeBook.getRecipes()[0], "Recipe1 should be deleted");
    }

    @Test
    public void testDeleteRecipeInvalidIndexNegative() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            recipeBook.deleteRecipe(-1);
        }, "Negative index should throw ArrayIndexOutOfBoundsException");
    }

    @Test
    public void testDeleteRecipeInvalidIndexOutOfBounds() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            recipeBook.deleteRecipe(4);
        }, "Out of bounds index should throw ArrayIndexOutOfBoundsException");
    }

    @Test
    public void testDeleteRecipeDoesNotExist() {
        assertNull(recipeBook.deleteRecipe(0), "No recipe at index 0, so should return null");
    }

    // ========== Test Edit Recipe ========== //
    @Test
    public void testEditRecipeSuccess() {
        recipeBook.addRecipe(recipe1);
        Recipe newRecipe = new Recipe();
        newRecipe.setName("NewRecipe");
        assertEquals("Recipe1", recipeBook.editRecipe(0, newRecipe), "Recipe1 should be edited");
        assertEquals(newRecipe, recipeBook.getRecipes()[0], "Recipe1 should be replaced by newRecipe");
    }

    @Test
    public void testEditRecipeInvalidIndexNegative() {
        Recipe newRecipe = new Recipe();
        newRecipe.setName("NewRecipe");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            recipeBook.editRecipe(-1, newRecipe);
        }, "Negative index should throw ArrayIndexOutOfBoundsException");
    }

    @Test
    public void testEditRecipeInvalidIndexOutOfBounds() {
        Recipe newRecipe = new Recipe();
        newRecipe.setName("NewRecipe");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            recipeBook.editRecipe(4, newRecipe);
        }, "Out of bounds index should throw ArrayIndexOutOfBoundsException");
    }

    @Test
    public void testEditRecipeDoesNotExist() {
        Recipe newRecipe = new Recipe();
        newRecipe.setName("NewRecipe");
        assertNull(recipeBook.editRecipe(0, newRecipe), "No recipe at index 0, should return null");
    }
}
