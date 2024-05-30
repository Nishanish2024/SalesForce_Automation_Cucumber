Feature: SalesForce application
Scenario Outline: Create & Edit Individuals functionality in sales force application
Given Load the URL
Given Enter the username
And Enter the password
When click on the Login button

When click on AppLaunch
When click on the View All icon
Given Enter search as individuals
When click on the individuals link


When click on New Button
Given Enter First Name as <firstName>
Given Enter Last Name as <lastName>
When click on Save Button
Then verify Individual is created or not


When Search for an Individual
When click Edit from the dropdown
Given Enter Salutaion
Given Enter First Name for Edit
When click on EditSave Button
Then verify Individual is Edited or not




Examples:
|firstName|lastName|
|Nisha|Anish|

