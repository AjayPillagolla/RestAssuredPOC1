Feature: Testing different requests of user application

Scenario: Get list of users
When user sends a GET request to the list endpoint ,They must get back a valid status code 200

Scenario Outline: Create a new User and check 201 created response
    When I create a new user providing the information name<name> job<job> 
    
    Examples:
    | name | job |
    | Ajay | QA  |

Scenario Outline: Update an existing user 
     When I provide the id<id> information the name<name>, job<job> of user will be updated
     
     Examples:
     |name | job|
     |TestUser1| TestQA |

Scenario: Get single user
     When GET user information of id<id>


     
     