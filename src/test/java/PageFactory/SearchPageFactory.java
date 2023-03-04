package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactory
{
	WebDriver driver = null;
	
	@FindBy(xpath="//input[@id='keyword']")
	WebElement location;
	
	@FindBy(xpath="//div[@id=\"propType_buy\"]")
	WebElement propertyType;
	
	@FindBy(xpath="//div[@class='mb-search__budget']")
	WebElement budget;
	
	@FindBy(xpath="//div[@class='mb-search__btn']")
	WebElement search;
	
	@FindBy(xpath="//label[@id='10000']")
	WebElement PropertyTypePlot;
	
	@FindBy(xpath="//label[@id='10001_10017']")
	WebElement PropertyTypeHouseOrVilla;
	
	@FindBy(xpath="//div[contains(@onclick, \"openPropertyType\") and text()=\"Commercial\"]")
	WebElement PropertyTypeCommercial;
	
	@FindBy(xpath="//label[@id='10007_10018']")
	WebElement OfficeSpace;
	
	@FindBy(xpath="//input[@id='budgetMin']")
	WebElement minPrice;
	
	@FindBy(xpath="//input[@id='budgetMax']")
	WebElement maxPrice;
	
	public SearchPageFactory(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchUsingLocation()
	{
		location.click();
		location.sendKeys("Mumbai");
		search.click();
	}
	
	public void searchUsingPropertyType()
	{
		propertyType.click();
		PropertyTypePlot.click();
		search.click();
	}
	
	public void searchUsingResidenceType()
	{
		propertyType.click();
		PropertyTypeHouseOrVilla.click();
		search.click();
	}
	
	public void searchUsingCommercialType()
	{
		propertyType.click();
		PropertyTypeCommercial.click();
		OfficeSpace.click();
		search.click();
	}
	
	public void searchUsingBudget()
	{
		budget.click();
		minPrice.click();
		minPrice.sendKeys("70000");
		maxPrice.click();
		maxPrice.sendKeys("90000");
		search.click();
	}

}
