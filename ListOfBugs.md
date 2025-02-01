## Bug: `Sugar can't be added with positive input`
### Bug ID: `1`
### TestCase ID: `10`
### Location: `Inventory::addSugar`
**Class:** `Inventory`
**Method:** `addSugar`
**Line:** `182`
### Recommended Fix
```java
public synchronized void addSugar(String sugar) throws InventoryException {
	int amtSugar = 0;
	try {
		amtSugar = Integer.parseInt(sugar);
	} catch (NumberFormatException e) {
		throw new InventoryException("Units of sugar must be a positive integer");
	}
	if (amtSugar >= 0) {
		Inventory.sugar += amtSugar;
	} else {
		throw new InventoryException("Units of sugar must be a positive integer");
	}
}
```

## Bug: `Recipe deletion does not nullify index properly`
### Bug ID: `2`
### TestCase ID: `99`
### Location: `CoffeeMaker::deleteRecipe`
**Class:** `CoffeeMaker`
**Method:** `deleteRecipe`
**Line:** `215`
### Recommended Fix
```java
public String deleteRecipe(int index) {
    if (index < 0 || index >= recipes.length) {
        throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
    }
    String recipeName = null;
    if (recipes[index] != null) {
        recipeName = recipes[index].getName();
        recipes[index] = null; // Ensure recipe at index is set to null
    }
    return recipeName;
}
```

---

## Bug: `Sugar addition with zero units fails`
### Bug ID: `3`
### TestCase ID: `107`
### Location: `Inventory::addInventory`
**Class:** `Inventory`
**Method:** `addInventory`
**Line:** `123`
### Recommended Fix
```java
public synchronized void addInventory(String coffee, String milk, String sugar, String chocolate) throws InventoryException {
    int amtCoffee = parsePositiveInt(coffee);
    int amtMilk = parsePositiveInt(milk);
    int amtSugar = parsePositiveInt(sugar); // Ensure zero is a valid input
    int amtChocolate = parsePositiveInt(chocolate);
    
    Inventory.coffee += amtCoffee;
    Inventory.milk += amtMilk;
    Inventory.sugar += amtSugar;
    Inventory.chocolate += amtChocolate;
}

private int parsePositiveInt(String value) throws InventoryException {
    try {
        int amount = Integer.parseInt(value);
        if (amount < 0) {
            throw new InventoryException("Units must be a positive integer");
        }
        return amount;
    } catch (NumberFormatException e) {
        throw new InventoryException("Units must be a positive integer");
    }
}
```

---

## Bug: `Negative index should not be allowed for recipe editing or deletion`
### Bug ID: `4`
### TestCase ID: `104`
### Location: `CoffeeMaker::editRecipe`
**Class:** `CoffeeMaker`
**Method:** `editRecipe`
**Line:** `210`
### Recommended Fix
```java
public String editRecipe(int index, Recipe newRecipe) {
    if (index < 0 || index >= recipes.length) {
        throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
    }
    String oldRecipeName = recipes[index].getName();
    recipes[index] = newRecipe;
    return oldRecipeName;
}
```

---

## Bug: `Duplicate recipes are allowed`
### Bug ID: `5`
### TestCase ID: `98`
### Location: `CoffeeMaker::addRecipe`
**Class:** `CoffeeMaker`
**Method:** `addRecipe`
**Line:** `138`
### Recommended Fix
```java
public boolean addRecipe(Recipe recipe) {
    for (int i = 0; i < recipes.length; i++) {
        if (recipes[i] != null && recipes[i].getName().equals(recipe.getName())) {
            return false; // Prevent duplicates
        }
    }
    for (int i = 0; i < recipes.length; i++) {
        if (recipes[i] == null) {
            recipes[i] = recipe;
            return true;
        }
    }
    return false; // If no space is available
}
```

---

## Bug: `InventoryException thrown for positive non-numeric inputs`
### Bug ID: `6`
### TestCase ID: `108`
### Location: `Inventory::addInventory`
**Class:** `Inventory`
**Method:** `addInventory`
**Line:** `120`
### Recommended Fix
```java
public synchronized void addInventory(String coffee, String milk, String sugar, String chocolate) throws InventoryException {
    int amtCoffee = parsePositiveInt(coffee);
    int amtMilk = parsePositiveInt(milk);
    int amtSugar = parsePositiveInt(sugar);
    int amtChocolate = parsePositiveInt(chocolate);
    
    Inventory.coffee += amtCoffee;
    Inventory.milk += amtMilk;
    Inventory.sugar += amtSugar;
    Inventory.chocolate += amtChocolate;
}

private int parsePositiveInt(String value) throws InventoryException {
    try {
        int amount = Integer.parseInt(value);
        if (amount < 0) {
            throw new InventoryException("Units must be a positive integer");
        }
        return amount;
    } catch (NumberFormatException e) {
        throw new InventoryException("Units must be a positive integer");
    }
}
```

---

## Bug: `Insufficient ingredients not properly handled`
### Bug ID: `7`
### TestCase ID: `114`
### Location: `CoffeeMaker::makeCoffee`
**Class:** `CoffeeMaker`
**Method:** `makeCoffee`
**Line:** `180`
### Recommended Fix
```java
public int makeCoffee(int recipeIndex, int payment) {
    Recipe selectedRecipe = recipes[recipeIndex];
    if (selectedRecipe == null) {
        return payment; // Return full payment if recipe does not exist
    }
    
    if (!hasSufficientIngredients(selectedRecipe)) {
        return payment; // Return full payment if insufficient ingredients
    }
    
    // Calculate the change
    int price = selectedRecipe.getPrice();
    int change = payment - price;
    
    if (change < 0) {
        return payment; // Return full payment if insufficient funds
    }
    
    // Deduct ingredients and proceed with making coffee
    deductIngredients(selectedRecipe);
    
    return change;
}

private boolean hasSufficientIngredients(Recipe recipe) {
    return Inventory.coffee >= recipe.getCoffeeAmount() &&
           Inventory.milk >= recipe.getMilkAmount() &&
           Inventory.sugar >= recipe.getSugarAmount() &&
           Inventory.chocolate >= recipe.getChocolateAmount();
}

private void deductIngredients(Recipe recipe) {
    Inventory.coffee -= recipe.getCoffeeAmount();
    Inventory.milk -= recipe.getMilkAmount();
    Inventory.sugar -= recipe.getSugarAmount();
    Inventory.chocolate -= recipe.getChocolateAmount();
}
```

---

## Bug: `NullPointerException when attempting to add a recipe with null ingredients`
### Bug ID: `8`
### Location: `CoffeeMaker::addRecipe`
**Class:** `CoffeeMaker`
**Method:** `addRecipe`
**Line:** `137`
### Recommended Fix
```java
public boolean addRecipe(Recipe recipe) {
    if (recipe == null || recipe.getIngredients() == null || recipe.getIngredients().isEmpty()) {
        throw new IllegalArgumentException("Recipe or its ingredients cannot be null or empty");
    }
    
    for (int i = 0; i < recipes.length; i++) {
        if (recipes[i] == null) {
            recipes[i] = recipe;
            return true;
        }
    }
    return false; // No space left
}
```

---

## Bug: `InventoryException thrown without specific ingredient errors`
### Bug ID: `9`
### Location: `Inventory::addInventory`
**Class:** `Inventory`
**Method:** `addInventory`
**Line:** `118`
### Recommended Fix
```java
public synchronized void addInventory(String coffee, String milk, String sugar, String chocolate) throws InventoryException {
    try {
        int amtCoffee = Integer.parseInt(coffee);
        if (amtCoffee < 0) throw new InventoryException("Coffee units cannot be negative");
        Inventory.coffee += amtCoffee;
    } catch (NumberFormatException e) {
        throw new InventoryException("Coffee must be a positive integer");
    }
    
    try {
        int amtMilk = Integer.parseInt(milk);
        if (amtMilk < 0) throw new InventoryException("Milk units cannot be negative");
        Inventory.milk += amtMilk;
    } catch (NumberFormatException e) {
        throw new InventoryException("Milk must be a positive integer");
    }
    
    try {
        int amtSugar = Integer.parseInt(sugar);
        if (amtSugar < 0) throw new InventoryException("Sugar units cannot be negative");
        Inventory.sugar += amtSugar;
    } catch (NumberFormatException e) {
        throw new InventoryException("Sugar must be a positive integer");
    }
    
    try {
        int amtChocolate = Integer.parseInt(chocolate);
        if (amtChocolate < 0) throw new InventoryException("Chocolate units cannot be negative");
        Inventory.chocolate += amtChocolate;
    } catch (NumberFormatException e) {
        throw new InventoryException("Chocolate must be a positive integer");
    }
}
```

---

## Bug: `Multiple simultaneous additions of the same recipe`
### Bug ID: `10`
### Location: `CoffeeMaker::addRecipe`
**Class:** `CoffeeMaker`
**Method:** `addRecipe`
**Line:** `136`
### Recommended Fix
```java
public boolean addRecipe(Recipe recipe) {
    if (recipe == null || recipe.getName() == null || recipe.getName().trim().isEmpty()) {
        throw new IllegalArgumentException("Recipe name cannot be null or empty");
    }
    
    for (int i = 0; i < recipes.length; i++) {
        if (recipes[i] != null && recipes[i].getName().equals(recipe.getName())) {
            throw new IllegalArgumentException("Recipe with this name already exists");
        }
    }
    
    for (int i = 0; i < recipes.length; i++) {
        if (recipes[i] == null) {
            recipes[i] = recipe;
            return true;
        }
    }
    return false; // No space left
}
```

---

## Bug: `Index out of bounds during recipe selection`
### Bug ID: `11`
### Location: `CoffeeMaker::selectRecipe`
**Class:** `CoffeeMaker`
**Method:** `selectRecipe`
**Line:** `155`
### Recommended Fix
```java
public Recipe selectRecipe(int index) {
    if (index < 0 || index >= recipes.length || recipes[index] == null) {
        throw new ArrayIndexOutOfBoundsException("Invalid recipe index or recipe does not exist");
    }
    return recipes[index];
}
```

---

## Bug: `Price mismatch or insufficient funds handling missing in CoffeeMaker`
### Bug ID: `12`
### Location: `CoffeeMaker::makeCoffee`
**Class:** `CoffeeMaker`
**Method:** `makeCoffee`
**Line:** `179`
### Recommended Fix
```java
public int makeCoffee(int recipeIndex, int payment) {
    Recipe selectedRecipe = recipes[recipeIndex];
    if (selectedRecipe == null) {
        return payment; // Return full payment if recipe does not exist
    }
    
    int price = selectedRecipe.getPrice();
    if (payment < price) {
        return payment; // Return full payment if insufficient funds
    }
    
    if (!hasSufficientIngredients(selectedRecipe)) {
        return payment; // Return payment if insufficient ingredients
    }
    
    // Proceed to make coffee if everything is valid
    deductIngredients(selectedRecipe);
    return payment - price; // Return the change
}
```

---

## Bug: `Negative recipe quantities causing invalid results`
### Bug ID: `13`
### Location: `Recipe::getPrice`
**Class:** `Recipe`
**Method:** `getPrice`
**Line:** `102`
### Recommended Fix
```java
public int getPrice() {
    if (coffeeAmount < 0 || milkAmount < 0 || sugarAmount < 0 || chocolateAmount < 0) {
        throw new IllegalArgumentException("Ingredient quantities cannot be negative");
    }
    return coffeeAmount + milkAmount + sugarAmount + chocolateAmount;
}
```

---
