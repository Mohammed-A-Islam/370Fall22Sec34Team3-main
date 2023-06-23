# Use Case Model

*This is the template for your use case model. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: Shane O'Neill

## 1 Use Case Diagram

![UserCase Diagram](https://user-images.githubusercontent.com/113305656/200200275-82a048d1-0041-4c06-94ce-7c379bbea9f8.png)


## 2 Use Case Descriptions

*For each use case in the use case diagram, this section should contain a description, with the following elements:*

- *Requirements: 
Login: has the customer put in a username and password to ligin

Login Error: if the user puts in a wrong password it will not let them into the app

Shopping List: A home Page of the Shopping lists made by the custoemr

Make New: Allows the User to make a new list


Delete list: allows the User to delete an already existing list
Get List: bring the user to a specified list of their chosing

Remove Item: Removes an item form the shopping list

Search Item: Lets the user search for an item

Add Item: allowsa the user to add the item they searched for onto the shoppinglist.

How Many?: how much of the ordered item is going to be on the shopping list?

- *Pre-conditions: Conditions that must be true before the use case is run.*
Login: the app is running

Login Error: a wrong password is entered

Shopping List: the user has successfully logged in

Make new: the user has loggeed in

Delete List: there is one or more existing shopping lists

Get List: there is one or more shopping lists

Remove Item a shopping list has one or more items in it

Search Item: the User has chosen a shopping list

Add Item: the user has searched for an item

how Many?: the User has selected an item to order

- *Post-conditions Conditions that must be true once the use case is run.*
- 
Login: the user logs in either successfully or unsuccessfully

Login Error: the customer can try logging in again

Shopping List: the customer chooses which List they want to look at, or if they ant to delete a list or make a new one

Make New: a new shopping list is added

Delete List: An existing Shopping list is deleted

Get List: THe customer is taken to the selected shopping list

Remove Item: the Item is removed from the shopping lsit

Search Item: the User types into the search bar the item that they want to d to their shopping list.

Add Item: The user adds the item to the shopping list.

How Many?: The item and how much of it the customer wants is added to the list.

- *Scenarios: Sequence of events that characterize the use case. This part may include multiple scenarios, for normal, alternate, and exceptional event sequences. These scenarios may be expressed as a list of steps in natural language or as sequence diagrams.*
- 
login: the user opens the app, and puts in the needed information

Login Eroor: the user entered a wrong password or username

Shopping List: The user is taken to a menu containing their shopping lists that they made

Make New: A customer ahs heard of a new store that newly opened and want to shop there

Delete List: A store went out of business, or the customer chose that they'd no longer shop there

Get List: the customer wants to get the list they made for the store they are going to for this specific shopping trip

Remove Item: A user may have clicked on the wrong item, or decided they do not want it after seeing the cost

Search Item: the user wants to add a new item to the list

Add Item: the user has found the item they are looking for

How Many?: the user wants more than one of that item
