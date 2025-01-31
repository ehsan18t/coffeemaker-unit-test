package coffee;
import static org.junit.jupiter.api.Assertions.*;

import coffee.exceptions.RecipeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import coffee.exceptions.InventoryException;

public class InventoryTest {

    private Inventory inventory;
    private Recipe recipe;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory();
        recipe = new Recipe();
    }

    // ========== Test Getters ========== //
    @Test
    public void testDefaultValues() {
        assertEquals(15, inventory.getCoffee());
        assertEquals(15, inventory.getMilk());
        assertEquals(15, inventory.getSugar());
        assertEquals(15, inventory.getChocolate());
    }


    // ========== Test Coffee ========== //
    @Test
    public void testSetCoffeeValid() {
        inventory.setCoffee(10);
        assertEquals(10, inventory.getCoffee(), "Coffee should be set to 10");
    }

    @Test
    public void testSetCoffeeNegative() {
        inventory.setCoffee(-5);
        assertEquals(15, inventory.getCoffee(), "Coffee should remain unchanged when set to a negative value");
    }

    @Test
    public void testSetCoffeeZero() {
        inventory.setCoffee(0);
        assertEquals(0, inventory.getCoffee(), "Coffee should be set to 0");
    }

    @Test
    public void testAddCoffeeValid() throws InventoryException {
        inventory.addCoffee("5");
        assertEquals(20, inventory.getCoffee(), "Coffee should increase by 5");
    }

    @Test
    public void testAddCoffeeZero() throws InventoryException {
        inventory.addCoffee("0");
        assertEquals(15, inventory.getCoffee(), "Coffee should remain unchanged when adding 0");
    }

    @Test
    public void testAddCoffeeNegativeValue() {
        Exception exception = assertThrows(InventoryException.class, () -> inventory.addCoffee("-10"), "Adding negative coffee should fail");
        assertEquals("Units of coffee must be a positive integer", exception.getMessage());
        assertEquals(15, inventory.getCoffee(), "Coffee should remain unchanged when adding a negative value");
    }

    @Test
    public void testAddCoffeeInvalidFormat() {
        Exception exception = assertThrows(InventoryException.class, () -> inventory.addCoffee("abc"), "Invalid Format Coffee Should Fail");
        assertEquals("Units of coffee must be a positive integer", exception.getMessage());
        assertEquals(15, inventory.getCoffee(), "Coffee should remain unchanged when adding an invalid string");
    }

    @Test
    public void testAddCoffeeDecimalValue() {
        Exception exception = assertThrows(InventoryException.class, () -> inventory.addCoffee("10.5"), "Adding decimal coffee should fail");
        assertEquals("Units of coffee must be a positive integer", exception.getMessage());
        assertEquals(15, inventory.getCoffee(), "Coffee should remain unchanged when adding a decimal value");
    }

    // ========== Test Milk ========== //
    @Test
    public void testSetMilkValid() {
        inventory.setMilk(10);
        assertEquals(10, inventory.getMilk(), "Milk should be set to 10");
    }

    @Test
    public void testSetMilkNegative() {
        inventory.setMilk(-5);
        assertEquals(15, inventory.getMilk(), "Milk should remain unchanged when set to a negative value");
    }

    @Test
    public void testSetMilkZero() {
        inventory.setMilk(0);
        assertEquals(0, inventory.getMilk(), "Milk should be set to 0");
    }

    @Test
    public void testAddMilkValid() throws InventoryException {
        inventory.addMilk("5");
        assertEquals(20, inventory.getMilk(), "Milk should increase by 5");
    }

    @Test
    public void testAddMilkZero() throws InventoryException {
        inventory.addMilk("0");
        assertEquals(15, inventory.getMilk(), "Milk should remain unchanged when adding 0");
    }

    @Test
    public void testAddMilkNegative() {
        Exception exception = assertThrows(InventoryException.class, () -> inventory.addMilk("-5"), "Negative Milk Should Fail");
        assertEquals("Units of milk must be a positive integer", exception.getMessage());
        assertEquals(15, inventory.getMilk(), "Milk should remain unchanged when adding a negative value");
    }

    @Test
    public void testAddMilkInvalidFormat() {
        Exception exception = assertThrows(InventoryException.class, () -> inventory.addMilk("abc"), "Invalid Format Milk Should Fail");
        assertEquals("Units of milk must be a positive integer", exception.getMessage());
        assertEquals(15, inventory.getMilk(), "Milk should remain unchanged when adding an invalid string");
    }

    @Test
    public void testAddMilkDecimalValue() {
        Exception exception = assertThrows(InventoryException.class, () -> inventory.addMilk("5.5"), "Decimal Milk Should Fail");
        assertEquals("Units of milk must be a positive integer", exception.getMessage());
        assertEquals(15, inventory.getMilk(), "Milk should remain unchanged when adding a decimal value");
    }

    // ========== Test Sugar ========== //
    @Test
    public void testSetSugarValid() {
        inventory.setSugar(10);
        assertEquals(10, inventory.getSugar(), "Sugar should be set to 10");
    }

    @Test
    public void testSetSugarNegative() {
        inventory.setSugar(-5);
        assertEquals(15, inventory.getSugar(), "Sugar should remain unchanged when set to a negative value");
    }

    @Test
    public void testSetSugarZero() {
        inventory.setSugar(0);
        assertEquals(0, inventory.getSugar(), "Sugar should be set to 0");
    }

    @Test
    public void testAddSugarValid() {
        try {
            inventory.addSugar("5");
        } catch (InventoryException e) {
            fail("Adding sugar should not throw an exception");
        }
        assertEquals(20, inventory.getSugar(), "Sugar should increase by 5");
    }

    @Test
    public void testAddSugarZero() {
        try {
            inventory.addSugar("0");
        } catch (InventoryException e) {
            fail("Adding sugar should not throw an exception");
        }
        assertEquals(15, inventory.getSugar(), "Sugar should remain unchanged when adding 0");
    }

    @Test
    public void testAddSugarNegativeValue() {
        Exception exception = assertThrows(InventoryException.class, () -> inventory.addSugar("-10"), "Adding negative sugar should fail");
        assertEquals("Units of sugar must be a positive integer", exception.getMessage());
        assertEquals(15, inventory.getSugar(), "Sugar should remain unchanged when adding a negative value");
    }

    @Test
    public void testAddSugarInvalidFormat() {
        Exception exception = assertThrows(InventoryException.class, () -> inventory.addSugar("abc"), "Invalid Format Sugar Should Fail");
        assertEquals("Units of sugar must be a positive integer", exception.getMessage());
        assertEquals(15, inventory.getSugar(), "Sugar should remain unchanged when adding an invalid string");
    }

    @Test
    public void testAddSugarDecimalValue() {
        Exception exception = assertThrows(InventoryException.class, () -> inventory.addSugar("10.5"), "Adding decimal sugar should fail");
        assertEquals("Units of sugar must be a positive integer", exception.getMessage());
        assertEquals(15, inventory.getSugar(), "Sugar should remain unchanged when adding a decimal value");
    }

    // ========== Test Chocolate ========== //
    @Test
    public void testSetChocolateValid() {
        inventory.setChocolate(10);
        assertEquals(10, inventory.getChocolate(), "Chocolate should be set to 10");
    }

    @Test
    public void testSetChocolateNegative() {
        inventory.setChocolate(-5);
        assertEquals(15, inventory.getChocolate(), "Chocolate should remain unchanged when set to a negative value");
    }

    @Test
    public void testSetChocolateZero() {
        inventory.setChocolate(0);
        assertEquals(0, inventory.getChocolate(), "Chocolate should be set to 0");
    }

    @Test
    public void testAddChocolateValid() throws InventoryException {
        inventory.addChocolate("5");
        assertEquals(20, inventory.getChocolate(), "Chocolate should increase by 5");
    }

    @Test
    public void testAddChocolateZero() throws InventoryException {
        inventory.addChocolate("0");
        assertEquals(15, inventory.getChocolate(), "Chocolate should remain unchanged when adding 0");
    }

    @Test
    public void testAddChocolateNegativeValue() {
        Exception exception = assertThrows(InventoryException.class,
            () -> inventory.addChocolate("-5"),
            "Adding negative chocolate should fail");
        assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
        assertEquals(15, inventory.getChocolate(), "Chocolate should remain unchanged when adding a negative value");
    }

    @Test
    public void testAddChocolateInvalidFormat() {
        Exception exception = assertThrows(InventoryException.class,
            () -> inventory.addChocolate("abc"),
            "Adding invalid format for chocolate should fail");
        assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
        assertEquals(15, inventory.getChocolate(), "Chocolate should remain unchanged when adding an invalid string");
    }

    @Test
    public void testAddChocolateDecimalValue() {
        Exception exception = assertThrows(InventoryException.class,
            () -> inventory.addChocolate("10.5"),
            "Adding decimal chocolate should fail");
        assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
        assertEquals(15, inventory.getChocolate(), "Chocolate should remain unchanged when adding a decimal value");
    }

    // ========== Test enoughIngredients ========== //
    @Test
    public void testEnoughIngredientsSufficient() {
        try {
            recipe.setAmtCoffee("5");
            recipe.setAmtMilk("5");
            recipe.setAmtSugar("5");
            recipe.setAmtChocolate("5");
        } catch (RecipeException e) {
            fail("Adding ingredients should not throw an exception");
        }
        assertTrue(inventory.enoughIngredients(recipe), "Should return true when there are sufficient ingredients");
    }

    @Test
    public void testEnoughIngredientsInsufficientCoffee() {
        try {
            inventory.setCoffee(0);
            recipe.setAmtCoffee("5");
        } catch (RecipeException e) {
            fail("Adding ingredients should not throw an exception");
        }
        assertFalse(inventory.enoughIngredients(recipe), "Should return false when coffee is insufficient");
    }

    @Test
    public void testEnoughIngredientsInsufficientMilk() {
        try {
            inventory.setMilk(0);
            recipe.setAmtMilk("5");
        } catch (RecipeException e) {
            fail("Adding ingredients should not throw an exception");
        }
        assertFalse(inventory.enoughIngredients(recipe), "Should return false when milk is insufficient");
    }

    @Test
    public void testEnoughIngredientsInsufficientSugar() {
        try {
            inventory.setSugar(0);
            recipe.setAmtSugar("5");
        } catch (RecipeException e) {
            fail("Adding ingredients should not throw an exception");
        }
        assertFalse(inventory.enoughIngredients(recipe), "Should return false when sugar is insufficient");
    }

    @Test
    public void testEnoughIngredientsInsufficientChocolate() {
        try {
            inventory.setChocolate(0);
            recipe.setAmtChocolate("5");
        } catch (RecipeException e) {
            fail("Adding ingredients should not throw an exception");
        }
        assertFalse(inventory.enoughIngredients(recipe), "Should return false when chocolate is insufficient");
    }

    // ========== Test UseIngredients ========== //
    @Test
    public void testUseIngredientsSufficient() {
        try {
            recipe.setAmtCoffee("5");
            recipe.setAmtMilk("5");
            recipe.setAmtSugar("5");
            recipe.setAmtChocolate("5");
        } catch (RecipeException e) {
            fail("Setting recipe amounts should not throw an exception");
        }

        assertAll("Inventory should have enough ingredients to make the recipe",
            () -> assertTrue(inventory.useIngredients(recipe), "useIngredients should return true when ingredients are sufficient"),
            () -> assertEquals(10, inventory.getCoffee(), "Coffee should decrease by 5"),
            () -> assertEquals(10, inventory.getMilk(), "Milk should decrease by 5"),
            () -> assertEquals(10, inventory.getSugar(), "Sugar should decrease by 5"),
            () -> assertEquals(10, inventory.getChocolate(), "Chocolate should decrease by 5")
        );
    }

    @Test
    public void testUseIngredientsInsufficient() {
        try {
            inventory.setMilk(2);
            recipe.setAmtCoffee("5");
            recipe.setAmtMilk("5");
        } catch (RecipeException e) {
            fail("Setting recipe amounts should not throw an exception");
        }
        assertFalse(inventory.useIngredients(recipe), "useIngredients should return false when ingredients are insufficient");
        assertEquals(15, inventory.getCoffee(), "Coffee should remain unchanged when ingredients are insufficient");
        assertEquals(2, inventory.getMilk(), "Milk should remain unchanged when ingredients are insufficient");
    }

    @Test
    public void testUseIngredientsZeroAmounts() {
        try {
            recipe.setAmtCoffee("0");
            recipe.setAmtMilk("0");
            recipe.setAmtSugar("0");
            recipe.setAmtChocolate("0");
        } catch (RecipeException e) {
            fail("Setting recipe amounts should not throw an exception");
        }
        assertTrue(inventory.useIngredients(recipe), "useIngredients should return true when the recipe requires zero amounts");
        assertEquals(15, inventory.getCoffee(), "Coffee should remain unchanged when the recipe requires zero amounts");
        assertEquals(15, inventory.getMilk(), "Milk should remain unchanged when the recipe requires zero amounts");
        assertEquals(15, inventory.getSugar(), "Sugar should remain unchanged when the recipe requires zero amounts");
        assertEquals(15, inventory.getChocolate(), "Chocolate should remain unchanged when the recipe requires zero amounts");
    }


    // ========== Test Equals and HashCode ========== //
    @Test
    public void testToString() {
        String expected = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";
        assertEquals(expected, inventory.toString());
    }
}