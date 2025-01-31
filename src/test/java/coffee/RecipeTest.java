package coffee;

import coffee.exceptions.RecipeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {
    private Recipe recipe;

    @BeforeEach
    void setUp() {
        recipe = new Recipe();
    }

    // ========== Test Getters ========== //

    @Test
    void testDefaultValues() {
        assertEquals("", recipe.getName());
        assertEquals(0, recipe.getPrice());
        assertEquals(0, recipe.getAmtCoffee());
        assertEquals(0, recipe.getAmtMilk());
        assertEquals(0, recipe.getAmtSugar());
        assertEquals(0, recipe.getAmtChocolate());
    }

    // ========== Test Name ========== //

    @Test
    void testSetNameValid() {
        recipe.setName("Espresso");
        assertEquals("Espresso", recipe.getName(), "Name should be set to Espresso");
    }

    @Test
    void testSetNameNull() {
        recipe.setName(null);
        assertEquals("", recipe.getName(), "Name should remain unchanged");
    }

    // ========== Test Price ========== //

    @Test
    void testSetPriceValid() throws RecipeException {
        recipe.setPrice("100");
        assertEquals(100, recipe.getPrice(), "Price should be set to 100");
    }

    @Test
    void testSetPriceNegative() {
        RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setPrice("-10"), "Negative Price Should Fail");
        assertEquals("Price must be a positive integer", exception.getMessage());
    }

    @Test
    void testSetPriceInvalidFormat() {
        RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setPrice("abc"), "Invalid Format Price Should Fail");
        assertEquals("Price must be a positive integer", exception.getMessage());
    }

    @Test
    void testSetPriceZero() throws RecipeException {
        recipe.setPrice("0");
        assertEquals(0, recipe.getPrice(), "Price should be set to 0");
    }

    @Test
    void testSetPriceLargeValue() throws RecipeException {
        recipe.setPrice("1000000");
        assertEquals(1000000, recipe.getPrice(), "Price should be set to 1,000,000");
    }

    @Test
    void testSetPriceWhitespace() {
        RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setPrice("  "), "Whitespace Price Should Fail");
        assertEquals("Price must be a positive integer", exception.getMessage());
    }

    @Test
    void testSetPriceFloatInput() {
        RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setPrice("10.5"), "Float Input Price Should Fail");
    }

    // ========== Test Coffee Amount ========== //

    @Test
    void testSetAmtCoffeeValid() throws RecipeException {
        recipe.setAmtCoffee("5");
        assertEquals(5, recipe.getAmtCoffee(), "Coffee Amount should be set to 5");
    }

    @Test
    void testSetAmtCoffeeZero() throws RecipeException {
        recipe.setAmtCoffee("0");
        assertEquals(0, recipe.getAmtCoffee(), "Coffee Amount should be set to 0");
    }

    @Test
    void testSetAmtCoffeeNonIntegerFormat() {
        RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtCoffee("abc"), "Non-Integer Format Coffee Amount Should Fail");
        assertEquals("Units of coffee must be a positive integer", exception.getMessage());
    }

    @Test
    void testSetAmtCoffeeNull() {
        RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtCoffee(null), "Null Coffee Amount Should Fail");
        assertEquals("Units of coffee must be a positive integer", exception.getMessage());
    }

    @Test
    void testSetAmtCoffeeNegative() {
        RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtCoffee("-1"), "Negative Coffee Amount Should Fail");
        assertEquals("Units of coffee must be a positive integer", exception.getMessage());
    }

    @Test
    void testSetAmtCoffeeInvalidFormat() {
        RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtCoffee("xyz"), "Invalid Format Coffee Amount Should Fail");
        assertEquals("Units of coffee must be a positive integer", exception.getMessage());
    }

    // ========== Test Milk Amount ========== //

    @Test
    void testSetAmtMilkValid() throws RecipeException {
        recipe.setAmtMilk("3");
        assertEquals(3, recipe.getAmtMilk(), "Milk Amount should be set to 3");
    }

    @Test
    void testSetAmtMilkZero() throws RecipeException {
        recipe.setAmtMilk("0");
        assertEquals(0, recipe.getAmtMilk(), "Milk Amount should be set to 0");
    }

    @Test
    void testSetAmtMilkNegative() {
        RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtMilk("-2"), "Negative Milk Amount Should Fail");
        assertEquals("Units of milk must be a positive integer", exception.getMessage());
    }

    @Test
    void testSetAmtMilkNull() {
        RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtMilk(null), "Null Milk Amount Should Fail");
        assertEquals("Units of milk must be a positive integer", exception.getMessage());
    }

    @Test
    void testSetAmtMilkInvalidFormat() {
        RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtMilk("milk"), "Invalid Format Milk Amount Should Fail");
        assertEquals("Units of milk must be a positive integer", exception.getMessage());
    }

    // ========== Test Sugar Amount ========== //

    @Test
    void testSetAmtSugarValid() throws RecipeException {
        recipe.setAmtSugar("4");
        assertEquals(4, recipe.getAmtSugar(), "Sugar Amount should be set to 4");
    }

    @Test
    void testSetAmtSugarZero() throws RecipeException {
        recipe.setAmtSugar("0");
        assertEquals(0, recipe.getAmtSugar(), "Sugar Amount should be set to 0");
    }

    @Test
    void testSetAmtSugarNegative() {
        RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtSugar("-3"), "Negative Sugar Amount Should Fail");
        assertEquals("Units of sugar must be a positive integer", exception.getMessage());
    }

    @Test
    void testSetAmtSugarNull() {
        RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtSugar(null), "Null Sugar Amount Should Fail");
        assertEquals("Units of sugar must be a positive integer", exception.getMessage());
    }

    @Test
    void testSetAmtSugarInvalidFormat() {
        RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtSugar("sweet"), "Invalid Format Sugar Amount Should Fail");
        assertEquals("Units of sugar must be a positive integer", exception.getMessage());
    }

    // ========== Test Chocolate Amount ========== //

    @Test
    void testSetAmtChocolateValid() throws RecipeException {
        recipe.setAmtChocolate("6");
        assertEquals(6, recipe.getAmtChocolate(), "Chocolate Amount should be set to 6");
    }

    @Test
    void testSetAmtChocolateZero() throws RecipeException {
        recipe.setAmtChocolate("0");
        assertEquals(0, recipe.getAmtChocolate(), "Chocolate Amount should be set to 0");
    }

    @Test
    void testSetAmtChocolateNull() {
        RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtChocolate(null), "Null Chocolate Amount Should Fail");
        assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
    }

    @Test
    void testSetAmtChocolateNegative() {
        RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtChocolate("-5"), "Negative Chocolate Amount Should Fail");
        assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
    }

    @Test
    void testSetAmtChocolateInvalidFormat() {
        RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtChocolate("dark"), "Invalid Format Chocolate Amount Should Fail");
        assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
    }

    // ========== Test toString() ========== //

    @Test
    void testToString() {
        recipe.setName("Cappuccino");
        assertEquals("Cappuccino", recipe.toString());
    }

    // ========== Test Equals and HashCode ========== //

    @Test
    void testEqualsNullObject() {
        assertNotEquals(null, recipe);
    }

    @Test
    void testEqualsDifferentClass() {
        assertNotEquals(new Object(), recipe);
    }

    @Test
    void testEqualsDifferentName() {
        Recipe anotherRecipe = new Recipe();
        anotherRecipe.setName("Latte");
        recipe.setName("Mocha");
        assertNotEquals(recipe, anotherRecipe);
    }

    @Test
    void testEqualsSameName() {
        Recipe anotherRecipe = new Recipe();
        anotherRecipe.setName("Americano");
        recipe.setName("Americano");
        assertEquals(recipe, anotherRecipe);
    }

    @Test
    void testHashCodeSame() {
        Recipe anotherRecipe = new Recipe();
        anotherRecipe.setName("Espresso");
        recipe.setName("Espresso");
        assertEquals(recipe.hashCode(), anotherRecipe.hashCode());
    }

    @Test
    void testHashCodeDifferent() {
        Recipe anotherRecipe = new Recipe();
        anotherRecipe.setName("Mocha");
        recipe.setName("Latte");
        assertNotEquals(recipe.hashCode(), anotherRecipe.hashCode());
    }
}
