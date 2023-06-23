1.  A grocery list consists of items the users want to buy at a grocery
    store. The application must allow users to add items to a list,
    delete items from a list, and change the quantity of items in the
    list (e.g., change from one to two pounds of apples).

the Shopping List class allows the user to foredo an order from the
shopping list using the foredoOrder fcn, the setAmount fcn allows
someone to set how much they want

2.  The application must contain a database (DB) of items and
    corresponding item types.

the thing class has a Kind attribute, which is a instance of the Kind
class

3.  Users must be able to add items to a list by picking them from a
    hierarchical list, where the first level is the item type (e.g.,
    cereal), and the second level is the name of the actual item (e.g.,
    shredded wheat). After adding an item, users must be able to specify
    a quantity for that item.

an order has a setAmount fcn to let the app know how much of a thing the
customer wants

4.  Users must also be able to specify an item by typing its name. In
    this case, the application must look in its DB for items with
    similar names and ask the users, for each of them, whether that is
    the item they intended to add. If a match cannot be found, the
    application must ask the user to select a type for the item and then
    save the new item, together with its type, in its DB.

LookforThing fcn lets someone look for an item when adding an order

6.  Users must be able to check off items in a list (without deleting
    them).

boolean is used to see if an order is checked or not, and a fcn to check
and de-check them

7.  Users must also be able to clear all the check-off marks in a list
    at once.

clearChecks function in Shopping List removes all items which are
checked

8.  Check-off marks for a list are persistent and must also be saved
    immediately.

checked bool can be used in a connection to the ui, having it displaya
checkmark for orders that have the checked bool as true

9.  The application must present the items in a list grouped by type, so
    as to allow users to shop for a specific type of product at once
    (i.e., without having to go back and forth between aisles).

the groupbyKind fcn would iterate through the linkedlist so the orders
are grouped by their kind of the thing ordered

10. The application must support multiple lists at a time (e.g., "weekly
    grocery list", "monthly farmer's market list"). Therefore, the
    application must provide the users with the ability to create,
    (re)name, select, and delete lists

a shopping list can be created by the user and reopened
