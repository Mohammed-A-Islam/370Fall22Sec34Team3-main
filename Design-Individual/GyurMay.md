## 1. A grocery list consists of items the users want to buy at a grocery store. The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list (e.g., change from one to two pounds of apples).
### from GroceryList class, users can use addItems(), deleteItems() and from Item Class, users can change the current quantity of items selected

## 2. The application must contain a database (DB) of items and corresponding item types.
### a DB diagram black-boxed contains the user info and list of valid/pre-existing categories

## 3. Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item.
### the Item class contains category (juice) and itemName (apple juice) for this.

## 4. Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type, in its DB.
### User's can change name of Item from the item class since item name will be public. findCategory will be called for each keypresses to lookup and retrieve results and If a match cannot be found returns null

## 5. Lists must be saved automatically and immediately after they are modified.
### autoSave() feature in GroceryList.

## 6. Users must be able to check off items in a list (without deleting them).
### checked bool in Item

## 7. Users must also be able to clear all the check-off marks in a list at once.
### uncheckAll in GroceryList.

## 8. Check-off marks for a list are persistent and must also be saved immediately.
### autoSave() in GroceryList

## 9. The application must present the items in a list grouped by type, so as to allow users to shop for a specific type of product at once (i.e., without having to go back and forth between aisles).
### filterByCategory() in GroceryList

## 10. The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly farmer’s market list”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete lists.
### GroceryList itself as a class under user's DB/info.

## 11. The User Interface (UI) must be intuitive and responsive.
### I hope it's so.
