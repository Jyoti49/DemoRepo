package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage 

{
	WebDriver driver;

	public LoginPage(WebDriver driver) 
	{

		// line of code executed
		// this.driver = driver;

		this.driver = driver;

	   PageFactory.initElements(driver, this);

	}

// Identification
	  By txtEmail = By.id("Email"); 
	  By txtpass = By.cssSelector("input#Password"); 
	  By chk_rem   =By.cssSelector("input#RememberMe");
	  By btnLogin2 = By.tagName("button");
	  By btnLogout2 = By.partialLinkText("Logo");
	 
	 /* @FindBy(xpath = "//p[contains(text(),'Customers')]//i")
		WebElement cust1;
		
	  @FindBy(xpath = "//a[@href='/Admin/Customer/List']")
		WebElement cust2;
		*/
	  By cust1 = By.xpath("//p[contains(text(),'Customers')]//i"); 
	 By cust2 = By.xpath("//a[@href='/Admin/Customer/List']"); 
		Actions ac = new Actions(driver);
		
		
/*
	@FindBy(id = "Email")
	WebElement txt_Email;

	@FindBy(css = "input#Password")
	WebElement txt_Pass;

	@FindBy(css = "input#RememberMe")
	WebElement chkRem;

	@FindBy(tagName = "button")
	WebElement btnLogin;

	@FindBy(partialLinkText = "Logo")
	WebElement btnLogout;
*/
// methods/actions

	public void enterEmail(String email) 
	{
		driver.findElement(txtEmail).clear();
		driver.findElement(txtEmail).sendKeys(email);
		
		

	}

	public void enterpass(String pwd) 
	{
	
		driver.findElement(txtpass).clear();
		driver.findElement(txtpass).sendKeys(pwd);

	}

	public void clickRememberMeCheckbox() 
	{

		driver.findElement(chk_rem).click();
	}

	public void clickLogin() throws InterruptedException 
	{

		Thread.sleep(2000);
		driver.findElement(btnLogin2).click();
	}

	/*public void clickLogout()
    {

		driver.findElement(btnLogout2).click();
	}
*/
	public void verifyApplicationTitle(String expTitle) throws Exception 
	{

		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), expTitle);

	}

	
	public void clickFirstCust() throws InterruptedException 
	{
    	
    	
    	
    	Thread.sleep(2000);
    	
    	//ac.moveToElement(cust1).click().build().perform();
    	driver.findElement(cust1).click();
		

	}

	public void clickSecondCust() throws InterruptedException 
	{
	
		Thread.sleep(2000);
		//ac.moveToElement(cust2).click().build().perform();
		driver.findElement(cust2).click();
	}


	public void verifyHomePage(String title)
	{
		Assert.assertEquals(driver.getTitle(), title);
	}

}
