# Project Plan

**Author**: Team 3

## 1 Introduction

This android application is used to manage grocery lists. A user can add lists to the first page, and add items to the second page. A search function will allow the user to search the database, and add items to their list, or add custom items to the list.


## 2 Process Description

GroceryLists

This activity is used to add and remove grocery lists. This activity will have a button to add a list. After clicking this button, they can input a name an confirm the creation of the new list. Upon holding down the tile of an existing list, they can choose to edit the name of, or delete a list. Clicking briefly on a list's tile will navigate to the GroceryItem activity. 

If the app is being opened for the first time or no list are present in the database, all you get is a "+" button to add Item to the List. After this, we can add the names and items inside of the grocery list.

Entrance Criteria: Name of the new list, and buttons to delete a list


Exit Criteria: Added items would show up in home page. Also, deleted items would disappear from the user's view, and in data. When a list has its name changed, and once the user confirms, the list's name will be altered to reflect the change. If the user clicks on a list tile, the current activity will be changed with the GroceryItems activity.


appendListActivity

description: Users will be able to add grocery list to the application using this action.

Entrance Criteria: clicking on add icon/button. 

Exit Criteria: “form” will be shown to input list name and other details. 



modifyListActivity

description: This activity lets users edit a selected grocery list.

Entrance Criteria: pressing on the edit button next to grocery list name

Exit Criteria: click on the done button, the editing “form” will then be closed and returned to homepage



searchGroceryListActivity

description: Users can utilize this function to look for particular grocery Lists across present lists.

Entrance Criteria: typing the list name and pressing search icon/button.

Exit Criteria: return the list of matching grocery list name and show in “results” page



AddItemActivity

description: This activity allow users to search for and  add an item to an already existing list

Entrance Criteria: User must be in a specified list and search for an item

Exit Criteria: The app will add an item to the shopping list



deleteItemActivity

Description: This activity deletes an existing item in a list. Upon clicking on the list shown there will be a Toast popup to say which list has just been deleted. 

Entrance Criteria: list must exist, and delete button must be clicked.

Exit Criteria: the list is removed from users app and “homepage”



groceryListActivity

Description: shows lists of grocery lists with various buttons to add

Entrance Criteria: opening the app from the app launcher

Exit Criteria: closing the app, pressing back/home button from the homepage, etc..



modifyItemActivity

Description: modifies the quantity of a particular item.

Entrance Criteria: choosing the quanity under an item.

Exit Criteria: after selecting a quantity activity is stopped.


## 3 Team

Team members: Mohommed Islam, Shane O'Neill, Pal Chouhan, Turan Ates, Dorjee Lama

*QA Testers is responsible for creating the test plan, executing the tests, documenting the results and working with the developers and architect to address deficiencies.

*Developer programs the frontend and backend of the app

*Documentor is responsible for the documentation of the project.

| QA Tester | Developer | Documentor |
| --------- | --------- | ------------ |
|  | Mohommed Islam | Mohommed Islam |
| | Shane O'Neill | Shane O'Neill |
|  Dorjee Lama|  Dorjee Lama|  |
| Turan Ates| Turan Ates |  |
|Pal Chouhan | | Pal Chouhan |
