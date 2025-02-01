## **Bug Report**

### **1. Sugar Can't Be Added with Positive Input**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 1          | 10              | `Inventory::addSugar` | 182      |

**Recommended Fix:**
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

### **2. Recipe Deletion Does Not Nullify Index Properly**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 2          | 99              | `CoffeeMaker::deleteRecipe` | 215      |

**Recommended Fix:**
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

### **3. Sugar Addition with Zero Units Fails**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 3          | 107             | `Inventory::addInventory` | 123      |

**Recommended Fix:**
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

### **4. Negative Index Should Not Be Allowed for Recipe Editing or Deletion**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 4          | 104             | `CoffeeMaker::editRecipe` | 210      |

**Recommended Fix:**
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

### **5. Duplicate Recipes Are Allowed**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 5          | 98              | `CoffeeMaker::addRecipe` | 138      |

**Recommended Fix:**
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

### **6. InventoryException Thrown for Positive Non-Numeric Inputs**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 6          | 108             | `Inventory::addInventory` | 120      |

**Recommended Fix:**
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

### **7. Insufficient Ingredients Not Properly Handled**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 7          | 114             | `CoffeeMaker::makeCoffee` | 180      |

**Recommended Fix:**
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

### **8. NullPointerException When Attempting to Add a Recipe with Null Ingredients**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 8          | N/A             | `CoffeeMaker::addRecipe` | 137      |

**Recommended Fix:**
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

### **9. InventoryException Thrown Without Specific Ingredient Errors**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 9          | N/A             | `Inventory::addInventory` | 118      |

**Recommended Fix:**
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

### **10. Multiple Simultaneous Additions of the Same Recipe**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 10         | N/A             | `CoffeeMaker::addRecipe` | 136      |

**Recommended Fix:**
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

### **11. Incorrect Handling of Recipe Addition when Inventory is Full**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 11         | N/A             | `CoffeeMaker::addRecipe` | 140      |

**Recommended Fix:**
```java
public boolean addRecipe(Recipe recipe) {
    for (int i = 0; i < recipes.length; i++) {
        if (recipes[i] == null) {
            recipes[i] = recipe;
            return true; // Add recipe to the first empty spot
        }
    }
    return false; // Inventory is full
}
```

---

### **12. Inventory Overflow with Negative Ingredients**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 12         | 120             | `Inventory::addInventory` | 121      |

**Recommended Fix:**
```java
public synchronized void addInventory(String coffee, String milk, String sugar, String chocolate) throws InventoryException {
    int amtCoffee = parsePositiveInt(coffee);
    int amtMilk = parsePositiveInt(milk);
    int amtSugar = parsePositiveInt(sugar);
    int amtChocolate = parsePositiveInt(chocolate);

    if (amtCoffee < 0 || amtMilk < 0 || amtSugar < 0 || amtChocolate < 0) {
        throw new InventoryException("Ingredient amounts must be positive");
    }
    
    Inventory.coffee += amtCoffee;
    Inventory.milk += amtMilk;
    Inventory.sugar += amtSugar;
    Inventory.chocolate += amtChocolate;
}
```

---

### **13. Recipe Editing Does Not Update Index Properly**
| **Bug ID** | **TestCase ID** | **Location**          | **Line** |
|------------|-----------------|-----------------------|----------|
| 13         | 105             | `CoffeeMaker::editRecipe` | 215      |

**Recommended Fix:**
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
