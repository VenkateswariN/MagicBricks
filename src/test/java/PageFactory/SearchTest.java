package PageFactory;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SearchTest 
{
	@Test
	public void verification1() throws InterruptedException
	{
		 
		System.setProperty("Webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.magicbricks.com/property-for-sale-rent-in-Bangalore/residential-real-estate-Bangalore");
		driver.manage().window().maximize();
		SearchPageFactory search = new SearchPageFactory(driver); 
		
	 	search.searchUsingLocation();
	 	Thread.sleep(2000);
	 	
	 	search.searchUsingPropertyType();
	 	Thread.sleep(2000);
	 	
	 	search.searchUsingResidenceType();
	 	Thread.sleep(2000);
	 	
	 	search.searchUsingCommercialType();
	 	Thread.sleep(2000);
	 	
	 	search.searchUsingBudget();
	 	Thread.sleep(2000);
	 	
	}
	
}