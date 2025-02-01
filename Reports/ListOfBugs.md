# **Bug Report**

---

### **1. Incorrect Inventory Initialization**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 1          | N/A             | `Inventory::Inventory` | 18       |

**Description:**
The `Inventory` constructor initializes the inventory with 15 units of each ingredient, but the fields are declared as `static`. This means that the inventory is shared across all instances of the `Inventory` class, which is not the intended behavior.

**Impact:**
If multiple instances of the `Inventory` class are created, they will all share the same inventory, leading to incorrect inventory management.

**Recommended Fix:**
Remove the `static` modifier from the inventory fields to ensure that each instance of the `Inventory` class has its own inventory.

```java
private int coffee;
private int milk;
private int sugar;
private int chocolate;
```

---

### **2. Incorrect Inventory Update in `useIngredients` Method**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 2         | 77              | `Inventory::useIngredients` | 220      |

**Description:**
The `useIngredients` method in the `Inventory` class incorrectly updates the inventory when ingredients are used. Specifically, the method adds the amount of `coffee` instead of subtracting it, which leads to an incorrect inventory count.

**Impact:**
This bug will cause the inventory to increase when a recipe is made, which is incorrect. This will lead to inaccurate inventory tracking and potential issues when trying to make subsequent recipes.

**Recommended Fix:**
Modify the `useIngredients` method to correctly subtract the ingredients used from the inventory.

```java
public synchronized boolean useIngredients(Recipe r) {
    if (enoughIngredients(r)) {
        Inventory.coffee -= r.getAmtCoffee();  // Subtract coffee
        Inventory.milk -= r.getAmtMilk();
        Inventory.sugar -= r.getAmtSugar();
        Inventory.chocolate -= r.getAmtChocolate();
        return true;
    } else {
        return false;
    }
}
```

---

### **3. Incorrect Handling of Negative Values in `addSugar` Method**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 3         | 59, 61          | `Inventory::addSugar` | 182      |

**Description:**
The `addSugar` method in the `Inventory` class incorrectly checks for negative values. The condition `if (amtSugar <= 0)` is used, which allows negative values to be added to the inventory and reject valid positive values. This can lead to incorrect inventory counts.

**Impact:**
Negative values can be added to the sugar inventory, which can cause the inventory to become incorrect and potentially lead to issues when making recipes.

**Recommended Fix:**
Modify the `addSugar` method to correctly check for positive values before adding them to the inventory.

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

---

### **4. Incorrect Recipe Deletion Logic**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 4         | 88              | `RecipeBook::deleteRecipe` | 60       |

**Description:**
The `deleteRecipe` method in the `RecipeBook` class incorrectly sets the recipe to a new empty `Recipe` object instead of setting it to `null`. This can lead to confusion and potential issues when checking for empty slots in the recipe array.

**Impact:**
The recipe array will not be properly cleared, and the slot will still contain an empty `Recipe` object instead of being set to `null`. This can cause issues when adding new recipes or checking for available slots.

**Recommended Fix:**
Modify the `deleteRecipe` method to set the recipe to `null` instead of creating a new `Recipe` object.

```java
public synchronized String deleteRecipe(int recipeToDelete) {
    if (recipeArray[recipeToDelete] != null) {
        String recipeName = recipeArray[recipeToDelete].getName();
        recipeArray[recipeToDelete] = null; // Set to null instead of new Recipe()
        return recipeName;
    } else {
        return null;
    }
}
```

---

### **5. Incorrect Recipe Editing Logic**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 5         | 92, 103         | `RecipeBook::editRecipe` | 77       |

**Description:**
The `editRecipe` method in the `RecipeBook` class incorrectly sets the name of the new recipe to an empty string before replacing the existing recipe. This can lead to the loss of the recipe name and potential issues when displaying or referencing the recipe.

**Impact:**
The recipe name will be lost when editing a recipe, which can cause confusion and issues when trying to reference or display the recipe.

**Recommended Fix:**
Modify the `editRecipe` method to preserve the name of the new recipe when replacing the existing recipe.

```java
public synchronized String editRecipe(int recipeToEdit, Recipe newRecipe) {
    if (recipeArray[recipeToEdit] != null) {
        String recipeName = recipeArray[recipeToEdit].getName();
        recipeArray[recipeToEdit] = newRecipe; // Preserve the name of the new recipe
        return recipeName;
    } else {
        return null;
    }
}
```

---

### **6. Inflexible Recipe Array Size**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 6          | N/A             | `RecipeBook::RecipeBook` | 13       |

**Description:**
The `RecipeBook` constructor initializes the recipe array with a size of 4, but the `NUM_RECIPES` constant is set to 4. This means that the array size is hardcoded and not flexible.

**Impact:**
If the number of recipes needs to be changed, the code must be modified, which is not ideal for maintainability.

**Recommended Fix:**
Create an overloaded constructor that takes the number of recipes as a parameter to allow for a flexible array size.

```java
public RecipeBook() {
    recipeArray = new Recipe[NUM_RECIPES];
}

public RecipeBook(int numRecipes) {
    recipeArray = new Recipe[numRecipes];
}
```

---

#### **7. Inconsistent Synchronization in `CoffeeMaker` Class**
| **Bug ID** | **TestCase ID** | **Location**          | **Line**   |
|------------|-----------------|-----------------------|------------|
| 7          | N/A             | `CoffeeMaker::makeCoffee` | 30, 41, 52 |

**Description:**
The `makeCoffee` method in the `CoffeeMaker` class is synchronized, but other methods that modify shared resources (e.g., `addRecipe`, `deleteRecipe`) are not. This can lead to race conditions in a multi-threaded environment.

**Impact:**
Inconsistent synchronization can cause race conditions, leading to incorrect behavior when multiple threads access shared resources simultaneously.

**Recommended Fix:**
Ensure that all methods that modify shared resources are properly synchronized.

```java
public synchronized boolean addRecipe(Recipe r) {
    // Existing logic
}

public synchronized String deleteRecipe(int recipeToDelete) {
    // Existing logic
}

public synchronized String editRecipe(int recipeToEdit, Recipe r) {
    // Existing logic
}
```

---

#### **8. Missing empty string Checks in `Recipe` Class**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 8          | N/A             | `Recipe::setName`     | 127      |

**Description:**
The `setName` method in the `Recipe` class does checks if it's null but does not check if the input `name` is empty string. This can lead to recipes with empty names, which may cause issues when displaying or referencing recipes.

**Impact:**
Recipes with empty names can cause confusion and issues when trying to reference or display them.

**Recommended Fix:**
Add empty checks in the `setName` method.

```java
public void setName(String name) {
    if (name != null && !name.trim().isEmpty()) {
        this.name = name;
    } else {
        throw new IllegalArgumentException("Recipe name cannot be null or empty");
    }
}
```

---
