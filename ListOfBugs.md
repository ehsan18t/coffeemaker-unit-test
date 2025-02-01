### **Bug Report**

---

### **1. Incorrect Handling of Recipe Addition when Inventory is Full**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 1         | N/A             | `RecipeBook::addRecipe` | 29       |

**Description:**
The `addRecipe` method in the `RecipeBook` class does not correctly handle the case when the recipe array is full. The current implementation checks if the recipe already exists and then attempts to add it to the first available spot. However, if the array is full, the method will return `false` without providing any feedback to the user about why the recipe could not be added.

**Impact:**
If the recipe array is full, users will not be able to add new recipes, and the system will silently fail without notifying the user. This can lead to confusion and a poor user experience.

**Recommended Fix:**
Modify the `addRecipe` method to check if the recipe array is full before attempting to add a new recipe. If the array is full, return `false` and provide appropriate feedback to the user.

```java
public synchronized boolean addRecipe(Recipe r) {
    // Check if the recipe already exists in the array
    for (int i = 0; i < recipeArray.length; i++) {
        if (r.equals(recipeArray[i])) {
            return false; // Recipe already exists
        }
    }
    
    // Check for the first empty spot in the array
    for (int i = 0; i < recipeArray.length; i++) {
        if (recipeArray[i] == null) {
            recipeArray[i] = r;
            return true; // Recipe added successfully
        }
    }
    
    return false; // Recipe array is full
}
```

---

### **2. Incorrect Inventory Update in `useIngredients` Method**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 2         | N/A             | `Inventory::useIngredients` | 140      |

**Description:**
The `useIngredients` method in the `Inventory` class incorrectly updates the inventory when ingredients are used. Specifically, the method adds the amount of coffee instead of subtracting it, which leads to an incorrect inventory count.

**Impact:**
This bug will cause the inventory to increase when a recipe is made, which is incorrect. This will lead to inaccurate inventory tracking and potential issues when trying to make subsequent recipes.

**Recommended Fix:**
Modify the `useIngredients` method to correctly subtract the ingredients used from the inventory.

```java
public synchronized boolean useIngredients(Recipe r) {
    if (enoughIngredients(r)) {
        Inventory.coffee -= r.getAmtCoffee();  // Subtract coffee
        Inventory.milk -= r.getAmtMilk();      // Subtract milk
        Inventory.sugar -= r.getAmtSugar();    // Subtract sugar
        Inventory.chocolate -= r.getAmtChocolate(); // Subtract chocolate
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
| 3         | N/A             | `Inventory::addSugar` | 140      |

**Description:**
The `addSugar` method in the `Inventory` class incorrectly checks for negative values. The condition `if (amtSugar <= 0)` is used, which allows negative values to be added to the inventory. This can lead to incorrect inventory counts.

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
| 4         | N/A             | `RecipeBook::deleteRecipe` | 140      |

**Description:**
The `deleteRecipe` method in the `RecipeBook` class incorrectly sets the recipe to a new `Recipe` object instead of setting it to `null`. This can lead to confusion and potential issues when checking for empty slots in the recipe array.

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
| 5         | N/A             | `RecipeBook::editRecipe` | 140      |

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

### **6. Incorrect Inventory Initialization**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 6         | N/A             | `Inventory::Inventory` | 18       |

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

### **7. Incorrect Inventory Check in `enoughIngredients` Method**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 7         | N/A             | `Inventory::enoughIngredients` | 140      |

**Description:**
The `enoughIngredients` method in the `Inventory` class does not correctly check if there are enough ingredients to make a recipe. The method should return `false` if any ingredient is insufficient, but the current implementation may not handle all cases correctly.

**Impact:**
The method may incorrectly return `true` even if there are not enough ingredients, leading to issues when making recipes.

**Recommended Fix:**
Modify the `enoughIngredients` method to correctly check if there are enough ingredients for the recipe.

```java
protected synchronized boolean enoughIngredients(Recipe r) {
    return Inventory.coffee >= r.getAmtCoffee() &&
           Inventory.milk >= r.getAmtMilk() &&
           Inventory.sugar >= r.getAmtSugar() &&
           Inventory.chocolate >= r.getAmtChocolate();
}
```

---

### **8. Incorrect Recipe Array Size**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 8         | N/A             | `RecipeBook::RecipeBook` | 18       |

**Description:**
The `RecipeBook` constructor initializes the recipe array with a size of 4, but the `NUM_RECIPES` constant is set to 4. This means that the array size is hardcoded and not flexible.

**Impact:**
If the number of recipes needs to be changed, the code must be modified, which is not ideal for maintainability.

**Recommended Fix:**
Use the `NUM_RECIPES` constant to initialize the recipe array size.

```java
public RecipeBook() {
    recipeArray = new Recipe[NUM_RECIPES];
}
```

---
