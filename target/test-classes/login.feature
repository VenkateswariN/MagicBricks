Feature: Login Functionality of MagicBricks
	I want to test the Login Functionality of MagicBricks
	
	Scenario: Successful Login with valid credentials
		Given User is on Login Page
		When User enters valid email
		And User clicks on Login Button
		And User clicks on continue Button
		Then User Login and navigate to the HomePage
	
	Scenario: Successful Login with valid credentials
		Given User is on Login Page
		When User enters valid password
		And User clicks on Login Button
		And User clicks on continue Button
		Then User Login and navigate to the HomePage
		
	Scenario: Unsuccessful Login with invalid email
		Given User is on Login Page
		When User enters invalid email
		And User should see an error message
		Then User should not be redirected to the MagicBricks HomePage
		
	 Scenario Outline: Unsuccessful Login with invalid email and password
    Given User is on Login Page
    When  User enter "<email>" as email
    And User enter "<password>" as password
    And User should see an error message
    Then User should not be redirected to the MagicBricks HomePage

    Examples: 
      | email             |	password | status  |
      | 123@gmail.com     |	123456 	 | Fail    |
      | abc,123@gmail.com |	abcdef 	 | Fail    |

   Scenario: Successful Login 
    Given User is on Login Page
    When User enters email and password 
    And User clicks on Login button
    Then User should be redirected to the MagicBricks HomePage