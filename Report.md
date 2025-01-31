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
