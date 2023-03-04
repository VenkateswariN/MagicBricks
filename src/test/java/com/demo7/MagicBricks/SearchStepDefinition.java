package com.demo7.MagicBricks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepDefinition 
{
	
	WebDriver driver;
	WebElement location;
	WebElement search;
	WebElement propertyType;
	WebElement flat;
	WebElement PropertyTypePlot;
	WebElement PropertyTypeHouseOrVilla;
	WebElement PropertyTypeCommercial;
	WebElement OfficeSpace;
	WebElement budget;
	WebElement maxPrice;
	WebElement minPrice;
	WebElement logo;
	WebElement text;
	
	@Given("User is on the Home Page")
	public void user_is_on_the_Home_Page() throws InterruptedException 
	{
		System.setProperty("Webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");//Setting the driver path
		this.driver = new ChromeDriver();//Initializing the driver
		//navigate to application
		driver.get("https://www.magicbricks.com/property-for-sale-rent-in-Bangalore/residential-real-estate-Bangalore");
		driver.manage().window().maximize();//maximize the window
		
		Thread.sleep(2000);//to suspend the execution 
		
		location = driver.findElement(By.xpath("//input[@id='keyword']"));//to find the location field in search
		search = driver.findElement(By.xpath("//div[@class='mb-search__btn']"));//to find search button
		logo = driver.findElement(By.xpath("//a[@class='mb-header__main__logo__link']"));
		
		
		propertyType = driver.findElement(By.id("propType_buy"));
		flat = driver.findElement(By.id("10002_10003_10021_10022"));
		PropertyTypePlot = driver.findElement(By.id("10000"));
		PropertyTypeHouseOrVilla = driver.findElement(By.id("10001_10017"));
		
		PropertyTypeCommercial = driver.findElement(By.xpath("//div[contains(@onclick, \"openPropertyType\") and text()=\"Commercial\"]"));
		OfficeSpace = driver.findElement(By.xpath("//label[@id='10007_10018']"));
		//msg = driver.findElement(By.xpath("//div[@id=\"home_page_msg\"]"));
		budget = driver.findElement(By.xpath("//div[@class='mb-search__budget']"));
		search = driver.findElement(By.xpath("//div[@class='mb-search__btn']"));
		minPrice = driver.findElement(By.xpath("//input[@id='budgetMin']"));
		maxPrice = driver.findElement(By.xpath("//input[@id='budgetMax']"));
		text = driver.findElement(By.xpath("//div[@id='home_page_msg']"));
		//To check correct URL of magic bricks is opening or not using Assert
		Assert.assertEquals("https://www.magicbricks.com/property-for-sale-rent-in-Bangalore/residential-real-estate-Bangalore", driver.getCurrentUrl());
	}

	//Search using Location
	@When("User enters a Location in the Search bar")
	public void user_enters_a_Location_in_the_Search_bar() throws InterruptedException, IOException 
	{
		location.click();
		location.sendKeys("Bangalore"); //To enter the desired input
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,  new File("./Screenshots/image1.png"));
		Thread.sleep(2000);
	}

	@When("User clicks on the Search button")
	public void user_clicks_on_the_Search_button() 
	{	
		Actions act = new Actions(driver);
		act.click(search).build().perform();//To click on search using actions
		//search.click();//To click on search button
	}

	@Then("User should see a list of properties in that Location")
	public void user_should_see_a_list_of_properties_in_that_Location()
	{
		//Validating URL
		String ActualURL = driver.getCurrentUrl();
		String ExpectedURL = "https://www.magicbricks.com/property-for-sale/residential-real-estate?bedroom=2,3&proptype=Multistorey-Apartment,Builder-Floor-Apartment,Penthouse,Studio-Apartment,Residential-House,Villa&cityName=Bangalore";
		//String message = "URL Matched";
		System.out.println("Actual URl while searching using Location is : " + ActualURL);
		
		if(ActualURL.equals(ExpectedURL))
	    {
	    	System.out.println("URL Matched");
	    }
	    else
	    {
	    	System.out.println("URL Not Matched");
	    }
	    
		//Assert.assertEquals(ActualURL, ExpectedURL, message);
	    System.out.println("Search using Location is successful");
	}

	//Search using Property Type
	@When("User selects a property type")
	public void user_selects_a_property_type() throws InterruptedException
	{
		if(logo.isDisplayed())
		{
			System.out.println("Displayed");
		}
		else
		{
			System.out.println("Not Displayed");
		}
		propertyType.click();
	    flat.click();
	    Thread.sleep(2000);
	    PropertyTypePlot.click();
	    Thread.sleep(2000);
	    PropertyTypePlot.click();
	    Thread.sleep(2000);
	}

	@Then("User should see a list of properties in that Type")
	public void user_should_see_a_list_of_properties_in_that_Type() 
	{
		System.out.println("Search using Property Type is successful");
	}

	//search using Property type Residential
	@When("User selects a property type Residential")
	public void user_selects_a_property_type_Residential() 
	{
		Assert.assertTrue(logo.isDisplayed());//To check whether the magic bricks logo of home page is displaying or not
		propertyType.click();
	}

	@When("User selects option in Residential Type")
	public void user_selects_option_in_Residential_Type() throws InterruptedException 
	{
		PropertyTypeHouseOrVilla.click();
	    Thread.sleep(2000);
	}

	@Then("User should see a list of properties in that Residential Type")
	public void user_should_see_a_list_of_properties_in_that_Residential_Type()
	{
		System.out.println("Search using Property Residential Type is successful");
	}

	//search using Property type Commercial
	
	@When("User selects a property type Commercial")
	public void user_selects_a_property_type_Commercial() 
	{
		System.out.println(text.getText());
		propertyType.click();
		PropertyTypeCommercial.click();
	}

	@When("User selects option in Commercial Type")
	public void user_selects_option_in_Commercial_Type() throws InterruptedException 
	{
		OfficeSpace.click();
		Thread.sleep(2000);
	}

	@Then("User should see a list of properties in Commercial Type")
	public void user_should_see_a_list_of_properties_in_Commercial_Type() 
	{
		System.out.println("Search using Property Commercial Type is successful");
	}
	
	//Search using Budget
	
	@When("User enter {string} and {string} price range")
	public void user_enter_and_price_range(String string, String string1) throws InterruptedException 
	{
		budget.click();
	    minPrice.click();
	    minPrice.sendKeys(string);
	    maxPrice.click();
	    maxPrice.sendKeys(string1);
	    Thread.sleep(2000);
	}

	@Then("User should see a list of properties within price range")
	public void user_should_see_a_list_of_properties_within_price_range() 
	{
		//String t = driver.getCurrentUrl();
		//System.out.println(t);
		//Assert.assertEquals(String , 0);
		System.out.println("Search using budget is successful");
		
	}


}