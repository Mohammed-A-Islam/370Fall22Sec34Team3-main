1. A grocery list consists of items the users want to buy at a grocery store.
 The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list 
(e.g., change from one to two pounds of apples).

> To fulfil this requirement, I added to desisn a class grocery list with methods to add delete and edit quanitities of the items in the list.



2. The application must contain a database (DB) of items and corresponding item types.
 
> all classes obtain their items and itemtypes from a database. 

 

3. Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item.

>To fulfil this requirement, I have made two separate classes, one for the item type and the other for the item itself. This would allow for showing the display accordingly.



4. Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type, in its DB.

> To fulfill this requirement, I have added a class, app display that, among other things, also has method to display items similar to the typed text.



5. Lists must be saved automatically and immediately after they are modified. 

 > This has little to do with the design bit. In other words it can be done without a class.


6. Users must be able to check off items in a list (without deleting them). -

> to fulfill this requirement, I have added array attribute CheckedOffitems[] to store the checked off items and a method to check off an item, in the Grocerylist class.


7. Users must also be able to clear all the check-off marks in a list at once. 
>  to fulfill this requirement,uncheck all items in the list,  in the class GroceryList.

8. Check-off marks for a list are persistent and must also be saved immediately. 
> The array CheckOffitems in class GroceryList, keeps the all the items that were marked saved.

9. The application must present the items in a list grouped by type, so as to allow users to shop for a specific type of product at once (i.e., without having to go back and forth between aisles). 

>To make the list present itself in that way I ahve added class AppDisplay that has methods getAllItemTypes(), ifItemTypeClicked(), displayAllItems() to display it in that hierarchy

 10. The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly farmer’s market list”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete lists. 

> To accomodate this requirement, I added attibutes in GroceryList class, groceryListID and groceryListName to label different GroceryLists, and methodscreateList(), nameList() and delete list. these methods fulfill the requirements.


11. The User Interface (UI) must be intuitive and responsive
> this is not the part of the design. It does not affect the design directly.

>
