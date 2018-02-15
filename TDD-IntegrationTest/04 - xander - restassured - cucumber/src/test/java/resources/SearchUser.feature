Feature: rest API validation

Scenario: Looking for user by username on /users page
    Given I have a user with the username Bret
    When I get all the users info
    Then then the user should have a email address

Scenario Outline: Looking at known users with known email addresses
    Given I have a user with the username <username>
    When I get all the users info
    Then the users email should match <email>

    Examples:
        | username | email |
    |   Bret               |     Sincere@april.biz          |
    |   Antonette          |     Shanna@melissa.tv          |
    |   Samantha           |     Nathan@yesenia.net         |
    |   Karianne           |     Julianne.OConner@kory.org  |




    Scenario: Looking for users with living in certain city
    Given I have a list of users
    When I get all the users info
    Then there is at least one user living in Wisokyburgh

