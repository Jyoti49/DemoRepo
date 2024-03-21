package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage 
{
	WebDriver driver;

	public HomePage(WebDriver rdriver) 
	{

		// line of code executed
		// this.driver = driver;

		this.driver = driver;

		PageFactory.initElements(rdriver, this);

	}

// Identification
	
	@FindBy(xpath = "//p[contains(text(),'Customers')]//i")
	WebElement cust1;
	
	@FindBy(xpath = "//a[@href='/Admin/Customer/List']")
	WebElement cust2;
	
	Actions ac = new Actions(driver);
	
	  //By cust1 = By.xpath("//p[contains(text(),'Customers')]//i"); 
	 // By cust2 = By.xpath("//a[@href='/Admin/Customer/List']"); 
	  
	  
// methods
	    public void clickFirstCust() throws InterruptedException 
		{
	    	
	    	
	    	
	    	Thread.sleep(2000);
	    	
	    	ac.moveToElement(cust1).click().build().perform();
	    	//driver.findElement(cust1).click();
			

		}

		public void clickSecondCust() throws InterruptedException 
		{
		
			Thread.sleep(2000);
			ac.moveToElement(cust2).click().build().perform();
		}


		public void verifyHomePage(String title)
		{
			Assert.assertEquals(driver.getTitle(), title);
		}
	

}
