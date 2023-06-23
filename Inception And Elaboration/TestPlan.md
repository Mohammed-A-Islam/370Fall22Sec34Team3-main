# Test Plan

*This is the template for your test plan. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: Team3

## 1 Testing Strategy

### 1.1 Overall strategy

Overall, we will test if a list can be made to which items can be added. the list will hold the items which will then be added to the database. A test item entry in a test list will be done to check if the items are sent properly to the database. After that test is done we will check if the data is sent back to the user. 

### 1.2 Test Selection

The code of the app will also be tested by us thoroughly throughout its internal core programming. We will do both black-box testing - using system testing and white-box - using unit testing and integration testing. 

In **Unit testing**, we tested smaller functions that are required to properly use the app’s functionality. In breaking the testing to smaller modules, Individual testing would help accomplish checking if everything at “micro”    level is functional and error-free. 

```
Add a new grocery list. ~ test will determine if it is added
Add an item to list ~ test will determine if it is added
Rename a list ~ test will determine if it is modified
Modify quantity of a list ~ test will determine if quantity is modified.
Check off items in a list ~ test will determine if the items in a list are checked off.
Search item in the DB ~ test will determine if an existing item is found by searching.
Delete a list ~ test will determine if an existing list is deleted.
Delete item in a list ~ test will determine if an item in a list is deleted.
```

For **System Testing**, the application was used by a user multiple times with varying inputs and corresponding outputs were observed to conclude that testing went fine. As there aren’t any greatly complicated varying input scenarios and/or app transition combinations, this could be done manually and very quickly and simply.

With **Integration testing**, there comes the idea of integrating front end, different smaller parts of the frontend and backend i.e DB. Here we would test the transition between the smaller parts of the app and its connection to Backend and more. This was checked manually as there wasn't any complicated testing to be done.


### 1.3 Adequacy Criterion

We will make a list of exception cases and test them out individually one by one. We will ensure the app runs smoothly and doesn't crash on being passed with exceptions. 

### 1.4 Bug Tracking

bugs will be reported to us in a text file when windows detects that the app has crashed after collecting error data.

### 1.5 Technology

We will use JUnit for our testing technology. 

## 2 Test Cases




|TestCaseID|Description|Test procedure|Expected Outcome|Actual Outcome|Test Pass/Fail|
|--- |--- |--- |--- |--- |--- |
|01|Check to see if a user can add a Grocery List|Open the app. Click on the grocery list to open it. Then type in a list name and click “ADD LIST”|List is added|List is added|pass|
|02|Check to see if a user can delete a Grocery List|Open the app. Click grocery list. Click on the list you want to delete. A screen will open. Click delete.|List is deleted|List is deleted|pass|
|03|Check to see if a user can add an item in a particular list|Open the app. Click on the grocery list. Click on the list you want to add an item to. A screen will open. Click add item. In the textbox, type the item you want to add. Then click add. Select the quantity.|An item is added to the selected list.|An item is added to the selected list.|pass|
|04|Check to see if a user can add an item to the database that isn’t already present|Click grocerylist. Click on a list. Click add item. Type in a name that is not present in the app’s database.|An item is added to the database|An item is added to the database|pass|
|05|Check to see if a user can delete an item in a particular list|Click grocerylist. Click on the list you want to delete an item from . A screen will open. Click on “delete” besides the item you want to delete.|An item from a  particular list is deleted.|An item from a  particular list is deleted.|pass|
|06|Check to see if user can rename a list|Click grocery list. Click on the list you want to rename . A screen will open. CLick “RENAME” and type in the name you want to rename the list to.|A list is renamed to the desired name.|A list is renamed to the desired name.|pass|
|07|Check to see if user can add an item that is not in the database, It gives an error|Click grocerylist. Click on a list. Click add item. Type in random gibberish and try adding it.|An error message is displayed|An error message is displayed|pass|
|08|Check to see if user gets an error when adding an item in the database that is already there.|Open grocery list app. Click on a list. Click add item. Type in an item that is already there in the database|An error message is displayed|An error message is displayed|pass|
|09|Check to see if user can edit the quantity of an item in a list.|Open grocery list app. Click on a list. Click quantity button next to a list and enter the desired quantity.|Quantity of a particular item is edited.|Quantity of a particular item is edited.|pass|
|10|Check to see if user can check off desired items in a grocery list.|Open grocery list app. Select a list. Check off the item you want from the list.|Desired items are checked off|Desired items are checked off|pass|
|11|Check to see if user can uncheck all items at once.|Open grocery list app, Select a list. Click uncheck all items.|All items are unchecked.|All items are unchecked|pass|
|12|Check to see if user can save a list in the DB|Open grocery list app. Select a list. Save list by making use of the automated saveList method coded in the app.|A list is saved in the DB|A list is saved in the DB|pass|
|13|Check to to see if user can uncheck items on the grocerylist|Open grocery list app. Select a list. Uncheck the items you desire.|Items in a particular list are unchecked.|Items in a particular list are unchecked.|pass|
|14|Check to see if user can search for a particular item that is already present in the database.|Open grocery list app. Select a list. Search for item by clicking on search item button and type in the item in the text field.|Item, we are looking for exists in the DB|Item, we are looking for exists in the DB|pass|
