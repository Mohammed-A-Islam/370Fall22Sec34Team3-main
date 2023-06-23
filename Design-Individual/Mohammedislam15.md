Design Information

1. A grocery list consists of items the users want to buy at a grocery store. The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list (e.g., change from one to two pounds of apples).
    
    User class basically consist of the user interface. A user will have to log on to access his or her shopping list.A User class can create GroceryList objects, and can access the GroceryList methods.
2. The application must contain a database (DB) of ​items​ and corresponding ​item types​.
    
    Item class and the ItemType class are created in the design.

3.Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item.
  
   Created two classes for this purpose with inheritance to represent the hierarchical requirements. The adding an item part is part of the list
    The ListItem class then calls its own setQuantity(quantity) to set the amount of an Item the User wishes to add.
    
4. Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type, in its DB.
    
    This is implemented with item and itemType classes. The additem function will request the users type thus doesn't need a parameter.
    
5. Lists must be saved automatically and immediately after they are modified.

    List taken care of by the program since if the variables are modified.

6. Users must be able to check off items in a list (without deleting them)

    Is handled by the "checked" attribute in the "Listitem" class along with the "checkItem"
    
7. Users must also be able to clear all the check-off marks in a list at once.

  Is handled by the "clearcheckItems()" method in the "GroceryList" class.

8. Check-off marks for a list are persistent and must also be saved immediately.

 Automatically taken care of by the program.
 
9. The application must present the items in a list grouped by type, so as to allow users to shop for a specific type of products at once (i.e., without having to go back and forth between aisles).

    The GroceryList class has a method "groupitemType()" which iterates through its own Items and groups them by ItemType.
    
10. The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly farmer’s market list”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete lists.

     User has the methods "createList()", "deleteList()", and "getList()". The last of these is used to get a specific GroceryList and invoke that GroceryLists's own "updateName()" method.
11. The User Interface (UI) must be intuitive and responsive

    This left up to app design so, it can't be represented in the uml diagram.
