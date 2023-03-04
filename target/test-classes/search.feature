Feature: Search Functionality of MagicBricks
	I want to test the Search Functionality of MagicBricks
	
	Scenario: Search for property by Location
		Given User is on the Home Page
		When User enters a Location in the Search bar
		And User clicks on the Search button
		Then User should see a list of properties in that Location
		
	Scenario: Search for properties by Type
		Given User is on the Home Page
		When User selects a property type
		And User clicks on the Search button
		Then User should see a list of properties in that Type
		
	Scenario: Search for properties by Type for Residential
		Given User is on the Home Page
		When User selects a property type Residential
		And User selects option in Residential Type
		And User clicks on the Search button
		Then User should see a list of properties in that Residential Type
		
	Scenario: Search for properties by Type for Commercial
		Given User is on the Home Page
		When User selects a property type Commercial
		And User selects option in Commercial Type
		And User clicks on the Search button
		Then User should see a list of properties in Commercial Type
		
	Scenario Outline: Search for properties by Price range
		Given User is on the Home Page
		When User enter "<minimum>" and "<maximum>" price range
		And User clicks on the Search button
		Then User should see a list of properties within price range

	Examples:
		|	minimum	|	maximum	|
		|	70000		|	100000	|
		|	90000		|	120000	|
	
		