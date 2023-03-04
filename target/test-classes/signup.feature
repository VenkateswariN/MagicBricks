Feature: SignUp Functionality of MagicBricks
	I want to test the SignUp Functionality of MagicBricks
	
	Scenario: Successful SignUp with valid credentials
		Given User is on SignUp Page
		When User selcts radio button
		And User enters valid Name, Email, Password, country code and contact number
		And User selects the checkbox
		And clicks on SignUp Button
		And User enters the OTP
		Then User SignUp and navigate to the HomePage
	
	Scenario: Unsuccessful SignUp with invalid Name
		Given User is on SignUp Page
		When User enters invalid Name
		And User should see an error message
		Then User should not be redirected to the MagicBricks HomePage
		
	Scenario: Unsuccessful SignUp with duplicate email
		Given User is on SignUp Page
		When User enters an email that is already in use
		And User should see an error message
		Then User should not be redirected to the MagicBricks HomePage
		
	 Scenario Outline: Unsuccessful SignUp with invalid email and password
    Given User is on SignUp Page
    When  User enter "<email>" as email
    And User enter "<password>" as password
    And User should see an error message
    Then User should not be redirected to the MagicBricks HomePage

    Examples: 
      | email             |	password | status  |
      | 123@gmail.com     |	123456 	 | Fail    |
      | abc,123@gmail.com |	abcdef 	 | Fail    |

   Scenario: Unsuccessful SignUp with invalid contact number
    Given User is on SignUp Page
    When User enters invalid contact number 
    And User should see an error message
    Then User should not be redirected to the MagicBricks HomePage
