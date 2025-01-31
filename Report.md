## Test `RecipeTest::testDefaultValues`
### Test ID: `1`
### Method
```java
@Test
void testDefaultValues() {
    assertEquals("", recipe.getName());
    assertEquals(0, recipe.getPrice());
    assertEquals(0, recipe.getAmtCoffee());
    assertEquals(0, recipe.getAmtMilk());
    assertEquals(0, recipe.getAmtSugar());
    assertEquals(0, recipe.getAmtChocolate());
}
```

### Purpose
This test verifies that a newly created `Recipe` object initializes its attributes with default values. Specifically, it checks that the name is an empty string, and the price, coffee amount, milk amount, sugar amount, and chocolate amount are all set to 0.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetNameValid`
### Test ID: `2`
### Method
```java
@Test
void testSetNameValid() {
    recipe.setName("Espresso");
    assertEquals("Espresso", recipe.getName(), "Name should be set to Espresso");
}
```

### Purpose
This test ensures that the `setName` method correctly updates the name of the recipe when a valid string is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetNameNull`
### Test ID: `3`
### Method
```java
@Test
void testSetNameNull() {
    recipe.setName(null);
    assertEquals("", recipe.getName(), "Name should remain unchanged");
}
```

### Purpose
This test checks that the `setName` method handles a `null` input gracefully by retaining the default empty string value for the name.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetPriceValid`
### Test ID: `4`
### Method
```java
@Test
void testSetPriceValid() throws RecipeException {
    recipe.setPrice("100");
    assertEquals(100, recipe.getPrice(), "Price should be set to 100");
}
```

### Purpose
This test verifies that the `setPrice` method correctly parses and sets the price when a valid integer string is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetPriceNegative`
### Test ID: `5`
### Method
```java
@Test
void testSetPriceNegative() {
    RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setPrice("-10"), "Negative Price Should Fail");
    assertEquals("Price must be a positive integer", exception.getMessage());
}
```

### Purpose
This test ensures that the `setPrice` method throws a `RecipeException` when a negative value is provided, as prices cannot be negative.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetPriceInvalidFormat`
### Test ID: `6`
### Method
```java
@Test
void testSetPriceInvalidFormat() {
    RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setPrice("abc"), "Invalid Format Price Should Fail");
    assertEquals("Price must be a positive integer", exception.getMessage());
}
```

### Purpose
This test checks that the `setPrice` method throws a `RecipeException` when an invalid format (non-integer string) is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetPriceZero`
### Test ID: `7`
### Method
```java
@Test
void testSetPriceZero() throws RecipeException {
    recipe.setPrice("0");
    assertEquals(0, recipe.getPrice(), "Price should be set to 0");
}
```

### Purpose
This test verifies that the `setPrice` method correctly handles a zero value, which is considered valid.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetPriceLargeValue`
### Test ID: `8`
### Method
```java
@Test
void testSetPriceLargeValue() throws RecipeException {
    recipe.setPrice("1000000");
    assertEquals(1000000, recipe.getPrice(), "Price should be set to 1,000,000");
}
```

### Purpose
This test ensures that the `setPrice` method can handle large integer values without issues.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetPriceWhitespace`
### Test ID: `9`
### Method
```java
@Test
void testSetPriceWhitespace() {
    RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setPrice("  "), "Whitespace Price Should Fail");
    assertEquals("Price must be a positive integer", exception.getMessage());
}
```

### Purpose
This test checks that the `setPrice` method throws a `RecipeException` when the input consists solely of whitespace.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetPriceFloatInput`
### Test ID: `10`
### Method
```java
@Test
void testSetPriceFloatInput() {
    RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setPrice("10.5"), "Float Input Price Should Fail");
}
```

### Purpose
This test ensures that the `setPrice` method throws a `RecipeException` when a floating-point number is provided, as only integers are allowed.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtCoffeeValid`
### Test ID: `11`
### Method
```java
@Test
void testSetAmtCoffeeValid() throws RecipeException {
    recipe.setAmtCoffee("5");
    assertEquals(5, recipe.getAmtCoffee(), "Coffee Amount should be set to 5");
}
```

### Purpose
This test verifies that the `setAmtCoffee` method correctly sets the coffee amount when a valid integer string is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtCoffeeZero`
### Test ID: `12`
### Method
```java
@Test
void testSetAmtCoffeeZero() throws RecipeException {
    recipe.setAmtCoffee("0");
    assertEquals(0, recipe.getAmtCoffee(), "Coffee Amount should be set to 0");
}
```

### Purpose
This test ensures that the `setAmtCoffee` method handles a zero value correctly, as zero is a valid input.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtCoffeeNonIntegerFormat`
### Test ID: `13`
### Method
```java
@Test
void testSetAmtCoffeeNonIntegerFormat() {
    RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtCoffee("abc"), "Non-Integer Format Coffee Amount Should Fail");
    assertEquals("Units of coffee must be a positive integer", exception.getMessage());
}
```

### Purpose
This test checks that the `setAmtCoffee` method throws a `RecipeException` when a non-integer string is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtCoffeeNull`
### Test ID: `14`
### Method
```java
@Test
void testSetAmtCoffeeNull() {
    RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtCoffee(null), "Null Coffee Amount Should Fail");
    assertEquals("Units of coffee must be a positive integer", exception.getMessage());
}
```

### Purpose
This test ensures that the `setAmtCoffee` method throws a `RecipeException` when a `null` value is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtCoffeeNegative`
### Test ID: `15`
### Method
```java
@Test
void testSetAmtCoffeeNegative() {
    RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtCoffee("-1"), "Negative Coffee Amount Should Fail");
    assertEquals("Units of coffee must be a positive integer", exception.getMessage());
}
```

### Purpose
This test verifies that the `setAmtCoffee` method throws a `RecipeException` when a negative value is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtCoffeeInvalidFormat`
### Test ID: `16`
### Method
```java
@Test
void testSetAmtCoffeeInvalidFormat() {
    RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtCoffee("xyz"), "Invalid Format Coffee Amount Should Fail");
    assertEquals("Units of coffee must be a positive integer", exception.getMessage());
}
```

### Purpose
This test checks that the `setAmtCoffee` method throws a `RecipeException` when an invalid format (non-integer string) is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtMilkValid`
### Test ID: `17`
### Method
```java
@Test
void testSetAmtMilkValid() throws RecipeException {
    recipe.setAmtMilk("3");
    assertEquals(3, recipe.getAmtMilk(), "Milk Amount should be set to 3");
}
```

### Purpose
This test verifies that the `setAmtMilk` method correctly sets the milk amount when a valid integer string is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtMilkZero`
### Test ID: `18`
### Method
```java
@Test
void testSetAmtMilkZero() throws RecipeException {
    recipe.setAmtMilk("0");
    assertEquals(0, recipe.getAmtMilk(), "Milk Amount should be set to 0");
}
```

### Purpose
This test ensures that the `setAmtMilk` method handles a zero value correctly, as zero is a valid input.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtMilkNegative`
### Test ID: `19`
### Method
```java
@Test
void testSetAmtMilkNegative() {
    RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtMilk("-2"), "Negative Milk Amount Should Fail");
    assertEquals("Units of milk must be a positive integer", exception.getMessage());
}
```

### Purpose
This test checks that the `setAmtMilk` method throws a `RecipeException` when a negative value is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtMilkNull`
### Test ID: `20`
### Method
```java
@Test
void testSetAmtMilkNull() {
    RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtMilk(null), "Null Milk Amount Should Fail");
    assertEquals("Units of milk must be a positive integer", exception.getMessage());
}
```

### Purpose
This test ensures that the `setAmtMilk` method throws a `RecipeException` when a `null` value is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtMilkInvalidFormat`
### Test ID: `21`
### Method
```java
@Test
void testSetAmtMilkInvalidFormat() {
    RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtMilk("milk"), "Invalid Format Milk Amount Should Fail");
    assertEquals("Units of milk must be a positive integer", exception.getMessage());
}
```

### Purpose
This test verifies that the `setAmtMilk` method throws a `RecipeException` when an invalid format (non-integer string) is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtSugarValid`
### Test ID: `22`
### Method
```java
@Test
void testSetAmtSugarValid() throws RecipeException {
    recipe.setAmtSugar("4");
    assertEquals(4, recipe.getAmtSugar(), "Sugar Amount should be set to 4");
}
```

### Purpose
This test ensures that the `setAmtSugar` method correctly sets the sugar amount when a valid integer string is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtSugarZero`
### Test ID: `23`
### Method
```java
@Test
void testSetAmtSugarZero() throws RecipeException {
    recipe.setAmtSugar("0");
    assertEquals(0, recipe.getAmtSugar(), "Sugar Amount should be set to 0");
}
```

### Purpose
This test verifies that the `setAmtSugar` method handles a zero value correctly, as zero is a valid input.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtSugarNegative`
### Test ID: `24`
### Method
```java
@Test
void testSetAmtSugarNegative() {
    RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtSugar("-3"), "Negative Sugar Amount Should Fail");
    assertEquals("Units of sugar must be a positive integer", exception.getMessage());
}
```

### Purpose
This test checks that the `setAmtSugar` method throws a `RecipeException` when a negative value is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtSugarNull`
### Test ID: `25`
### Method
```java
@Test
void testSetAmtSugarNull() {
    RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtSugar(null), "Null Sugar Amount Should Fail");
    assertEquals("Units of sugar must be a positive integer", exception.getMessage());
}
```

### Purpose
This test ensures that the `setAmtSugar` method throws a `RecipeException` when a `null` value is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtSugarInvalidFormat`
### Test ID: `26`
### Method
```java
@Test
void testSetAmtSugarInvalidFormat() {
    RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtSugar("sweet"), "Invalid Format Sugar Amount Should Fail");
    assertEquals("Units of sugar must be a positive integer", exception.getMessage());
}
```

### Purpose
This test verifies that the `setAmtSugar` method throws a `RecipeException` when an invalid format (non-integer string) is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtChocolateValid`
### Test ID: `27`
### Method
```java
@Test
void testSetAmtChocolateValid() throws RecipeException {
    recipe.setAmtChocolate("6");
    assertEquals(6, recipe.getAmtChocolate(), "Chocolate Amount should be set to 6");
}
```

### Purpose
This test ensures that the `setAmtChocolate` method correctly sets the chocolate amount when a valid integer string is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtChocolateZero`
### Test ID: `28`
### Method
```java
@Test
void testSetAmtChocolateZero() throws RecipeException {
    recipe.setAmtChocolate("0");
    assertEquals(0, recipe.getAmtChocolate(), "Chocolate Amount should be set to 0");
}
```

### Purpose
This test verifies that the `setAmtChocolate` method handles a zero value correctly, as zero is a valid input.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtChocolateNull`
### Test ID: `29`
### Method
```java
@Test
void testSetAmtChocolateNull() {
    RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtChocolate(null), "Null Chocolate Amount Should Fail");
    assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
}
```

### Purpose
This test checks that the `setAmtChocolate` method throws a `RecipeException` when a `null` value is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtChocolateNegative`
### Test ID: `30`
### Method
```java
@Test
void testSetAmtChocolateNegative() {
    RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtChocolate("-5"), "Negative Chocolate Amount Should Fail");
    assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
}
```

### Purpose
This test ensures that the `setAmtChocolate` method throws a `RecipeException` when a negative value is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testSetAmtChocolateInvalidFormat`
### Test ID: `31`
### Method
```java
@Test
void testSetAmtChocolateInvalidFormat() {
    RecipeException exception = assertThrows(RecipeException.class, () -> recipe.setAmtChocolate("dark"), "Invalid Format Chocolate Amount Should Fail");
    assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
}
```

### Purpose
This test verifies that the `setAmtChocolate` method throws a `RecipeException` when an invalid format (non-integer string) is provided.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testToString`
### Test ID: `32`
### Method
```java
@Test
void testToString() {
    recipe.setName("Cappuccino");
    assertEquals("Cappuccino", recipe.toString());
}
```

### Purpose
This test checks that the `toString` method returns the correct string representation of the recipe, which is the recipe's name.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testEqualsNullObject`
### Test ID: `33`
### Method
```java
@Test
void testEqualsNullObject() {
    assertNotEquals(null, recipe);
}
```

### Purpose
This test ensures that the `equals` method returns `false` when comparing a `Recipe` object to `null`.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testEqualsDifferentClass`
### Test ID: `34`
### Method
```java
@Test
void testEqualsDifferentClass() {
    assertNotEquals(new Object(), recipe);
}
```

### Purpose
This test verifies that the `equals` method returns `false` when comparing a `Recipe` object to an object of a different class.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testEqualsDifferentName`
### Test ID: `35`
### Method
```java
@Test
void testEqualsDifferentName() {
    Recipe anotherRecipe = new Recipe();
    anotherRecipe.setName("Latte");
    recipe.setName("Mocha");
    assertNotEquals(recipe, anotherRecipe);
}
```

### Purpose
This test checks that the `equals` method returns `false` when comparing two `Recipe` objects with different names.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testEqualsSameName`
### Test ID: `36`
### Method
```java
@Test
void testEqualsSameName() {
    Recipe anotherRecipe = new Recipe();
    anotherRecipe.setName("Americano");
    recipe.setName("Americano");
    assertEquals(recipe, anotherRecipe);
}
```

### Purpose
This test verifies that the `equals` method returns `true` when comparing two `Recipe` objects with the same name.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testHashCodeSame`
### Test ID: `37`
### Method
```java
@Test
void testHashCodeSame() {
    Recipe anotherRecipe = new Recipe();
    anotherRecipe.setName("Espresso");
    recipe.setName("Espresso");
    assertEquals(recipe.hashCode(), anotherRecipe.hashCode());
}
```

### Purpose
This test ensures that the `hashCode` method returns the same value for two `Recipe` objects with the same name.

### Execution Report: `PASSED`

---

## Test `RecipeTest::testHashCodeDifferent`
### Test ID: `38`
### Method
```java
@Test
void testHashCodeDifferent() {
    Recipe anotherRecipe = new Recipe();
    anotherRecipe.setName("Mocha");
    recipe.setName("Latte");
    assertNotEquals(recipe.hashCode(), anotherRecipe.hashCode());
}
```

### Purpose
This test checks that the `hashCode` method returns different values for two `Recipe` objects with different names.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testDefaultValues`
### Test ID: `39`
### Method
```java
@Test
public void testDefaultValues() {
    assertEquals(15, inventory.getCoffee());
    assertEquals(15, inventory.getMilk());
    assertEquals(15, inventory.getSugar());
    assertEquals(15, inventory.getChocolate());
}
```

### Purpose
This test verifies that a newly created `Inventory` object initializes its attributes with default values. Specifically, it checks that the coffee, milk, sugar, and chocolate amounts are all set to 15.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testSetCoffeeValid`
### Test ID: `40`
### Method
```java
@Test
public void testSetCoffeeValid() {
    inventory.setCoffee(10);
    assertEquals(10, inventory.getCoffee(), "Coffee should be set to 10");
}
```

### Purpose
This test ensures that the `setCoffee` method correctly updates the coffee amount when a valid positive integer is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testSetCoffeeNegative`
### Test ID: `41`
### Method
```java
@Test
public void testSetCoffeeNegative() {
    inventory.setCoffee(-5);
    assertEquals(15, inventory.getCoffee(), "Coffee should remain unchanged when set to a negative value");
}
```

### Purpose
This test checks that the `setCoffee` method ignores negative values and retains the default coffee amount.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testSetCoffeeZero`
### Test ID: `42`
### Method
```java
@Test
public void testSetCoffeeZero() {
    inventory.setCoffee(0);
    assertEquals(0, inventory.getCoffee(), "Coffee should be set to 0");
}
```

### Purpose
This test verifies that the `setCoffee` method correctly handles a zero value.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testAddCoffeeValid`
### Test ID: `43`
### Method
```java
@Test
public void testAddCoffeeValid() throws InventoryException {
    inventory.addCoffee("5");
    assertEquals(20, inventory.getCoffee(), "Coffee should increase by 5");
}
```

### Purpose
This test ensures that the `addCoffee` method correctly increases the coffee amount when a valid integer string is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testAddCoffeeZero`
### Test ID: `44`
### Method
```java
@Test
public void testAddCoffeeZero() throws InventoryException {
    inventory.addCoffee("0");
    assertEquals(15, inventory.getCoffee(), "Coffee should remain unchanged when adding 0");
}
```

### Purpose
This test checks that the `addCoffee` method does not change the coffee amount when a zero value is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testAddCoffeeNegativeValue`
### Test ID: `45`
### Method
```java
@Test
public void testAddCoffeeNegativeValue() {
    Exception exception = assertThrows(InventoryException.class, () -> inventory.addCoffee("-10"), "Adding negative coffee should fail");
    assertEquals("Units of coffee must be a positive integer", exception.getMessage());
    assertEquals(15, inventory.getCoffee(), "Coffee should remain unchanged when adding a negative value");
}
```

### Purpose
This test verifies that the `addCoffee` method throws an `InventoryException` when a negative value is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testAddCoffeeInvalidFormat`
### Test ID: `46`
### Method
```java
@Test
public void testAddCoffeeInvalidFormat() {
    Exception exception = assertThrows(InventoryException.class, () -> inventory.addCoffee("abc"), "Invalid Format Coffee Should Fail");
    assertEquals("Units of coffee must be a positive integer", exception.getMessage());
    assertEquals(15, inventory.getCoffee(), "Coffee should remain unchanged when adding an invalid string");
}
```

### Purpose
This test ensures that the `addCoffee` method throws an `InventoryException` when an invalid format (non-integer string) is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testAddCoffeeDecimalValue`
### Test ID: `47`
### Method
```java
@Test
public void testAddCoffeeDecimalValue() {
    Exception exception = assertThrows(InventoryException.class, () -> inventory.addCoffee("10.5"), "Adding decimal coffee should fail");
    assertEquals("Units of coffee must be a positive integer", exception.getMessage());
    assertEquals(15, inventory.getCoffee(), "Coffee should remain unchanged when adding a decimal value");
}
```

### Purpose
This test checks that the `addCoffee` method throws an `InventoryException` when a decimal value is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testSetMilkValid`
### Test ID: `48`
### Method
```java
@Test
public void testSetMilkValid() {
    inventory.setMilk(10);
    assertEquals(10, inventory.getMilk(), "Milk should be set to 10");
}
```

### Purpose
This test ensures that the `setMilk` method correctly updates the milk amount when a valid positive integer is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testSetMilkNegative`
### Test ID: `49`
### Method
```java
@Test
public void testSetMilkNegative() {
    inventory.setMilk(-5);
    assertEquals(15, inventory.getMilk(), "Milk should remain unchanged when set to a negative value");
}
```

### Purpose
This test verifies that the `setMilk` method ignores negative values and retains the default milk amount.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testSetMilkZero`
### Test ID: `50`
### Method
```java
@Test
public void testSetMilkZero() {
    inventory.setMilk(0);
    assertEquals(0, inventory.getMilk(), "Milk should be set to 0");
}
```

### Purpose
This test checks that the `setMilk` method correctly handles a zero value.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testAddMilkValid`
### Test ID: `51`
### Method
```java
@Test
public void testAddMilkValid() throws InventoryException {
    inventory.addMilk("5");
    assertEquals(20, inventory.getMilk(), "Milk should increase by 5");
}
```

### Purpose
This test ensures that the `addMilk` method correctly increases the milk amount when a valid integer string is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testAddMilkZero`
### Test ID: `52`
### Method
```java
@Test
public void testAddMilkZero() throws InventoryException {
    inventory.addMilk("0");
    assertEquals(15, inventory.getMilk(), "Milk should remain unchanged when adding 0");
}
```

### Purpose
This test verifies that the `addMilk` method does not change the milk amount when a zero value is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testAddMilkNegative`
### Test ID: `53`
### Method
```java
@Test
public void testAddMilkNegative() {
    Exception exception = assertThrows(InventoryException.class, () -> inventory.addMilk("-5"), "Negative Milk Should Fail");
    assertEquals("Units of milk must be a positive integer", exception.getMessage());
    assertEquals(15, inventory.getMilk(), "Milk should remain unchanged when adding a negative value");
}
```

### Purpose
This test checks that the `addMilk` method throws an `InventoryException` when a negative value is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testAddMilkInvalidFormat`
### Test ID: `54`
### Method
```java
@Test
public void testAddMilkInvalidFormat() {
    Exception exception = assertThrows(InventoryException.class, () -> inventory.addMilk("abc"), "Invalid Format Milk Should Fail");
    assertEquals("Units of milk must be a positive integer", exception.getMessage());
    assertEquals(15, inventory.getMilk(), "Milk should remain unchanged when adding an invalid string");
}
```

### Purpose
This test ensures that the `addMilk` method throws an `InventoryException` when an invalid format (non-integer string) is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testAddMilkDecimalValue`
### Test ID: `55`
### Method
```java
@Test
public void testAddMilkDecimalValue() {
    Exception exception = assertThrows(InventoryException.class, () -> inventory.addMilk("5.5"), "Decimal Milk Should Fail");
    assertEquals("Units of milk must be a positive integer", exception.getMessage());
    assertEquals(15, inventory.getMilk(), "Milk should remain unchanged when adding a decimal value");
}
```

### Purpose
This test verifies that the `addMilk` method throws an `InventoryException` when a decimal value is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testSetSugarValid`
### Test ID: `56`
### Method
```java
@Test
public void testSetSugarValid() {
    inventory.setSugar(10);
    assertEquals(10, inventory.getSugar(), "Sugar should be set to 10");
}
```

### Purpose
This test ensures that the `setSugar` method correctly updates the sugar amount when a valid positive integer is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testSetSugarNegative`
### Test ID: `57`
### Method
```java
@Test
public void testSetSugarNegative() {
    inventory.setSugar(-5);
    assertEquals(15, inventory.getSugar(), "Sugar should remain unchanged when set to a negative value");
}
```

### Purpose
This test checks that the `setSugar` method ignores negative values and retains the default sugar amount.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testSetSugarZero`
### Test ID: `58`
### Method
```java
@Test
public void testSetSugarZero() {
    inventory.setSugar(0);
    assertEquals(0, inventory.getSugar(), "Sugar should be set to 0");
}
```

### Purpose
This test verifies that the `setSugar` method correctly handles a zero value.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testAddSugarValid`
### Test ID: `59`
### Method
```java
@Test
public void testAddSugarValid() {
    try {
        inventory.addSugar("5");
    } catch (InventoryException e) {
        fail("Adding sugar should not throw an exception");
    }
    assertEquals(20, inventory.getSugar(), "Sugar should increase by 5");
}
```

### Purpose
This test ensures that the `addSugar` method correctly increases the sugar amount when a valid integer string is provided.

### Execution Report: `FAILED`
```
org.opentest4j.AssertionFailedError: Adding sugar should not throw an exception
```

---

## Test `InventoryTest::testAddSugarZero`
### Test ID: `60`
### Method
```java
@Test
public void testAddSugarZero() {
    try {
        inventory.addSugar("0");
    } catch (InventoryException e) {
        fail("Adding sugar should not throw an exception");
    }
    assertEquals(15, inventory.getSugar(), "Sugar should remain unchanged when adding 0");
}
```

### Purpose
This test checks that the `addSugar` method does not change the sugar amount when a zero value is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testAddSugarNegativeValue`
### Test ID: `61`
### Method
```java
@Test
public void testAddSugarNegativeValue() {
    Exception exception = assertThrows(InventoryException.class, () -> inventory.addSugar("-10"), "Adding negative sugar should fail");
    assertEquals("Units of sugar must be a positive integer", exception.getMessage());
    assertEquals(15, inventory.getSugar(), "Sugar should remain unchanged when adding a negative value");
}
```

### Purpose
This test verifies that the `addSugar` method throws an `InventoryException` when a negative value is provided.

### Execution Report: `FAILED`
```
org.opentest4j.AssertionFailedError: Adding negative sugar should fail ==> 
Expected coffee.exceptions.InventoryException to be thrown, but nothing was thrown.
```

---

## Test `InventoryTest::testAddSugarInvalidFormat`
### Test ID: `62`
### Method
```java
@Test
public void testAddSugarInvalidFormat() {
    Exception exception = assertThrows(InventoryException.class, () -> inventory.addSugar("abc"), "Invalid Format Sugar Should Fail");
    assertEquals("Units of sugar must be a positive integer", exception.getMessage());
    assertEquals(15, inventory.getSugar(), "Sugar should remain unchanged when adding an invalid string");
}
```

### Purpose
This test ensures that the `addSugar` method throws an `InventoryException` when an invalid format (non-integer string) is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testAddSugarDecimalValue`
### Test ID: `63`
### Method
```java
@Test
public void testAddSugarDecimalValue() {
    Exception exception = assertThrows(InventoryException.class, () -> inventory.addSugar("10.5"), "Adding decimal sugar should fail");
    assertEquals("Units of sugar must be a positive integer", exception.getMessage());
    assertEquals(15, inventory.getSugar(), "Sugar should remain unchanged when adding a decimal value");
}
```

### Purpose
This test checks that the `addSugar` method throws an `InventoryException` when a decimal value is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testSetChocolateValid`
### Test ID: `64`
### Method
```java
@Test
public void testSetChocolateValid() {
    inventory.setChocolate(10);
    assertEquals(10, inventory.getChocolate(), "Chocolate should be set to 10");
}
```

### Purpose
This test ensures that the `setChocolate` method correctly updates the chocolate amount when a valid positive integer is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testSetChocolateNegative`
### Test ID: `65`
### Method
```java
@Test
public void testSetChocolateNegative() {
    inventory.setChocolate(-5);
    assertEquals(15, inventory.getChocolate(), "Chocolate should remain unchanged when set to a negative value");
}
```

### Purpose
This test verifies that the `setChocolate` method ignores negative values and retains the default chocolate amount.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testSetChocolateZero`
### Test ID: `66`
### Method
```java
@Test
public void testSetChocolateZero() {
    inventory.setChocolate(0);
    assertEquals(0, inventory.getChocolate(), "Chocolate should be set to 0");
}
```

### Purpose
This test checks that the `setChocolate` method correctly handles a zero value.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testAddChocolateValid`
### Test ID: `67`
### Method
```java
@Test
public void testAddChocolateValid() throws InventoryException {
    inventory.addChocolate("5");
    assertEquals(20, inventory.getChocolate(), "Chocolate should increase by 5");
}
```

### Purpose
This test ensures that the `addChocolate` method correctly increases the chocolate amount when a valid integer string is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testAddChocolateZero`
### Test ID: `68`
### Method
```java
@Test
public void testAddChocolateZero() throws InventoryException {
    inventory.addChocolate("0");
    assertEquals(15, inventory.getChocolate(), "Chocolate should remain unchanged when adding 0");
}
```

### Purpose
This test verifies that the `addChocolate` method does not change the chocolate amount when a zero value is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testAddChocolateNegativeValue`
### Test ID: `69`
### Method
```java
@Test
public void testAddChocolateNegativeValue() {
    Exception exception = assertThrows(InventoryException.class,
        () -> inventory.addChocolate("-5"),
        "Adding negative chocolate should fail");
    assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
    assertEquals(15, inventory.getChocolate(), "Chocolate should remain unchanged when adding a negative value");
}
```

### Purpose
This test checks that the `addChocolate` method throws an `InventoryException` when a negative value is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testAddChocolateInvalidFormat`
### Test ID: `70`
### Method
```java
@Test
public void testAddChocolateInvalidFormat() {
    Exception exception = assertThrows(InventoryException.class,
        () -> inventory.addChocolate("abc"),
        "Adding invalid format for chocolate should fail");
    assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
    assertEquals(15, inventory.getChocolate(), "Chocolate should remain unchanged when adding an invalid string");
}
```

### Purpose
This test ensures that the `addChocolate` method throws an `InventoryException` when an invalid format (non-integer string) is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testAddChocolateDecimalValue`
### Test ID: `71`
### Method
```java
@Test
public void testAddChocolateDecimalValue() {
    Exception exception = assertThrows(InventoryException.class,
        () -> inventory.addChocolate("10.5"),
        "Adding decimal chocolate should fail");
    assertEquals("Units of chocolate must be a positive integer", exception.getMessage());
    assertEquals(15, inventory.getChocolate(), "Chocolate should remain unchanged when adding a decimal value");
}
```

### Purpose
This test verifies that the `addChocolate` method throws an `InventoryException` when a decimal value is provided.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testEnoughIngredientsSufficient`
### Test ID: `72`
### Method
```java
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
```

### Purpose
This test checks that the `enoughIngredients` method returns `true` when the inventory has sufficient ingredients for the recipe.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testEnoughIngredientsInsufficientCoffee`
### Test ID: `73`
### Method
```java
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
```

### Purpose
This test verifies that the `enoughIngredients` method returns `false` when the coffee amount is insufficient for the recipe.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testEnoughIngredientsInsufficientMilk`
### Test ID: `74`
### Method
```java
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
```

### Purpose
This test ensures that the `enoughIngredients` method returns `false` when the milk amount is insufficient for the recipe.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testEnoughIngredientsInsufficientSugar`
### Test ID: `75`
### Method
```java
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
```

### Purpose
This test checks that the `enoughIngredients` method returns `false` when the sugar amount is insufficient for the recipe.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testEnoughIngredientsInsufficientChocolate`
### Test ID: `76`
### Method
```java
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
```

### Purpose
This test verifies that the `enoughIngredients` method returns `false` when the chocolate amount is insufficient for the recipe.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testUseIngredientsSufficient`
### Test ID: `77`
### Method
```java
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
```

### Purpose
This test ensures that the `useIngredients` method correctly reduces the inventory amounts when there are sufficient ingredients for the recipe.

### Execution Report: `FAILED`
```
org.opentest4j.AssertionFailedError: Coffee should decrease by 5 ==> 
Expected :10
Actual   :20
```

---

## Test `InventoryTest::testUseIngredientsInsufficient`
### Test ID: `78`
### Method
```java
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
```

### Purpose
This test checks that the `useIngredients` method returns `false` and does not modify the inventory when there are insufficient ingredients for the recipe.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testUseIngredientsZeroAmounts`
### Test ID: `79`
### Method
```java
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
```

### Purpose
This test verifies that the `useIngredients` method returns `true` and does not modify the inventory when the recipe requires zero amounts of all ingredients.

### Execution Report: `PASSED`

---

## Test `InventoryTest::testToString`
### Test ID: `80`
### Method
```java
@Test
public void testToString() {
    String expected = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";
    assertEquals(expected, inventory.toString());
}
```

### Purpose
This test ensures that the `toString` method returns the correct string representation of the inventory.

### Execution Report: `PASSED`

---
