Feature: Buy Functionality of MagicBricks
	I want to test the Buy Functionality of MagicBricks
	
	Scenario: Search for Popular Choices in Buy
		Given User is on the Home Page
		When User selects Buy
		And User selects required option from Popular Choices
		Then User should navigate to the desired page
		
	Scenario: Search for Property types in Buy
		Given User is on the Home Page
		When User selects Buy
		And User selects required option from Property types
		Then User should navigate to the desired page
		
	Scenario: Search for Budget in Buy
		Given User is on the Home Page
		When User selects Buy
		And User selects required option from Budget
		Then User should navigate to the desired page
		
	Scenario: Search for Explore in Buy
		Given User is on the Home Page
		When User selects Buy
		And User selects required option from Explore
		Then User should navigate to the desired page
		
	Scenario: Search for Buying Tools in Buy
		Given User is on the Home Page
		When User selects Buy
		And User selects required option from Buying Tools
		Then User should navigate to the desired page