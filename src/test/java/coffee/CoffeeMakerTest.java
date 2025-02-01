package coffee;

import static org.junit.jupiter.api.Assertions.*;

import coffee.exceptions.RecipeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import coffee.exceptions.InventoryException;

public class CoffeeMakerTest {

    private CoffeeMaker coffeeMaker;
    private Recipe recipe1;
    private Recipe recipe2;

    @BeforeEach
    public void setUp() {
        coffeeMaker = new CoffeeMaker();
        recipe1 = new Recipe();
        recipe1.setName("Recipe1");
        recipe2 = new Recipe();
        recipe2.setName("Recipe2");
        try {
            recipe1.setPrice("50");
            recipe1.setAmtCoffee("5");
            recipe1.setAmtMilk("5");
            recipe1.setAmtSugar("5");
            recipe1.setAmtChocolate("5");

            recipe2.setPrice("100");
            recipe2.setAmtCoffee("10");
            recipe2.setAmtMilk("10");
            recipe2.setAmtSugar("10");
            recipe2.setAmtChocolate("10");
        } catch (RecipeException e) {
            fail("RecipeException should not be thrown");
        }
    }

    // ========== Test Getters ========== //
    @Test
    public void testDefaultValues() {
        // RecipeBook
        assertNotNull(coffeeMaker.getRecipes());
        assertEquals(4, coffeeMaker.getRecipes().length);

        // Inventory
        String inventory = coffeeMaker.checkInventory();
        assertTrue(inventory.contains("Coffee: 15"));
        assertTrue(inventory.contains("Milk: 15"));
        assertTrue(inventory.contains("Sugar: 15"));
        assertTrue(inventory.contains("Chocolate: 15"));
    }

    // ========== Test Add Recipe ========== //
    @Test
    public void testAddRecipeSuccess() {
        assertTrue(coffeeMaker.addRecipe(recipe1), "Recipe1 should be added");
    }

    @Test
    public void testAddRecipeDuplicate() {
        coffeeMaker.addRecipe(recipe1);
        assertFalse(coffeeMaker.addRecipe(recipe1), "Recipe1 should not be added again");
    }

    // ========== Test Delete Recipe ========== //
    @Test
    public void testDeleteRecipeSuccess() {
        coffeeMaker.addRecipe(recipe1);
        assertEquals("Recipe1", coffeeMaker.deleteRecipe(0), "Recipe1 should be deleted");

        Recipe[] recipes = coffeeMaker.getRecipes();
        assertNull(recipes[0], "Recipe1 deleted, so index 0 should be null");
    }

    @Test
    public void testDeleteRecipeInvalidIndexNegative() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            coffeeMaker.deleteRecipe(-1);
        }, "Negative index should throw ArrayIndexOutOfBoundsException");
    }

    @Test
    public void testDeleteRecipeInvalidIndexOutOfBounds() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            coffeeMaker.deleteRecipe(4);
        }, "Out of bounds index should throw ArrayIndexOutOfBoundsException");
    }

    @Test
    public void testDeleteRecipeDoesNotExist() {
        assertNull(coffeeMaker.deleteRecipe(0), "No recipe at index 0, so should return null");
    }

    // ========== Test Edit Recipe ========== //
    @Test
    public void testEditRecipeSuccess() {
        coffeeMaker.addRecipe(recipe1);
        Recipe newRecipe = new Recipe();
        newRecipe.setName("NewRecipe");
        assertEquals("Recipe1", coffeeMaker.editRecipe(0, newRecipe));
    }

    @Test
    public void testEditRecipeInvalidIndexNegative() {
        Recipe newRecipe = new Recipe();
        newRecipe.setName("NewRecipe");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            coffeeMaker.editRecipe(-1, newRecipe);
        }, "Negative index should throw ArrayIndexOutOfBoundsException");
    }

    @Test
    public void testEditRecipeInvalidIndexOutOfBounds() {
        Recipe newRecipe = new Recipe();
        newRecipe.setName("NewRecipe");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            coffeeMaker.editRecipe(4, newRecipe);
        }, "Out of bounds index should throw ArrayIndexOutOfBoundsException");
    }

    @Test
    public void testEditRecipeDoesNotExist() {
        Recipe newRecipe = new Recipe();
        newRecipe.setName("NewRecipe");
        assertNull(coffeeMaker.editRecipe(0, newRecipe), "No recipe at index 0, so should return null");
    }

    // ========== Test Add Inventory ========== //
    @Test
    public void testAddInventorySuccess() {
        try {
            coffeeMaker.addInventory("10", "10", "10", "10");
            String inventory = coffeeMaker.checkInventory();
            assertTrue(inventory.contains("Coffee: 25"));
            assertTrue(inventory.contains("Milk: 25"));
            assertTrue(inventory.contains("Sugar: 25"));
            assertTrue(inventory.contains("Chocolate: 25"));
        } catch (InventoryException e) {
            fail("Adding ingredient should not throw an exception");
        }
    }

    @Test
    public void testAddInventoryInvalidNonNumeric() {
        assertThrows(InventoryException.class, () -> {
            coffeeMaker.addInventory("abc", "10", "10", "10");
        }, "Non-numeric input should throw InventoryException");
    }

    @Test
    public void testAddInventoryInvalidNegative() {
        assertThrows(InventoryException.class, () -> {
            coffeeMaker.addInventory("-5", "10", "10", "10");
        }, "Negative input should throw InventoryException");
    }

    @Test
    public void testAddInventoryInvalidNull() {
        assertThrows(InventoryException.class, () -> {
            coffeeMaker.addInventory(null, "10", "10", "10");
        }, "NULL input should throw InventoryException");
    }

    // ========== Test Make Coffee ========== //
    @Test
    public void testMakeCoffeeSuccess() {
        coffeeMaker.addRecipe(recipe1);
        int change = coffeeMaker.makeCoffee(0, 100);
        assertEquals(50, change, "Price is 50, paid 100. Change should be 50");
    }

    @Test
    public void testMakeCoffeeRecipeDoesNotExist() {
        int change = coffeeMaker.makeCoffee(0, 100);
        assertEquals(100, change, "Recipe does not exist, return full payment");
    }

    @Test
    public void testMakeCoffeeInsufficientPayment() {
        coffeeMaker.addRecipe(recipe1);
        int change = coffeeMaker.makeCoffee(0, 40);
        assertEquals(40, change, "Price is 50, paid 40 (insufficient), return 40");
    }

    @Test
    public void testMakeCoffeeInsufficientIngredients() {
        coffeeMaker.addRecipe(recipe2); // Requires 10 units of each ingredient
        int change = coffeeMaker.makeCoffee(0, 100);
        assertEquals(100, change, "Insufficient ingredients, return full payment");
    }
}