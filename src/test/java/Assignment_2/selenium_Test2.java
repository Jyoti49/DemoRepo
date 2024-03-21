package Assignment_2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.junit.After;
//import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class selenium_Test2 
{
	
  
    
    WebDriver driver;
    
    @BeforeTest
    public void launchApp() throws Exception 
    {
        
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        Thread.sleep(7000);
    }

    
    @AfterTest
    public void CloseApp() throws Exception 
    {
        
        
        Thread.sleep(7000);
       // driver.close();
        //driver.quit();
    }
    
    
    @Test
    public void verifyTitle() throws Exception
    {
        
        
        WebElement usernam = driver.findElement(By.xpath("//input[@id='Email']"));
        Thread.sleep(2000);
        
        usernam.clear();
        usernam.sendKeys("admin@yourstore.com");
        
        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        Thread.sleep(2000);
        
        password.clear();
        password.sendKeys("admin");
        
        Thread.sleep(2000);
        
        WebElement loginbtn = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginbtn.click();
        
        Thread.sleep(2000);
        String expectedtitle = "Dashboard / nopCommerce administration";
        String ActualTitle=	driver.getTitle();
        
        
        		
        Assert.assertEquals(ActualTitle, expectedtitle);
        
        //click on cutomer
        
        Actions ac = new Actions(driver);
        
        Thread.sleep(2000);
        WebElement custbtn = driver.findElement(By.xpath("//p[contains(text(),'Customers')]//i"));
        
       // (//li[@class='nav-item has-treeview menu-is-opening menu-open']//a)[1]
      
        ac.moveToElement(custbtn).click().perform();
        Thread.sleep(500);
        //custbtn.click();
        
        Thread.sleep(2000);
        WebElement custbtn1 = driver.findElement(By.xpath("(//a[@href='/Admin/Customer/List'])[1]"));
        custbtn1.click();
        
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='/Admin/Customer/Create']")).click();
        Thread.sleep(3000);
      
        
        Thread.sleep(2000);
        
        String expectedtitle1 = "Add a new customer / nopCommerce administration";
        String ActualTitle1=	driver.getTitle();
        
        //Verified the title 
        Assert.assertEquals(ActualTitle1, expectedtitle1);
        
        
        //Add new customer 
        
        Thread.sleep(2000);
        WebElement Email = driver.findElement(By.xpath("//input[@type='email']"));
        
        Actions ac1 = new Actions(driver);
        //ac1.moveToElement(Email).sendKeys("abc@gmail.com").build().perform();
         Email.sendKeys("Jhon1@gmail.com");
        
        Thread.sleep(2000);
        WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
        Password.sendKeys("12345");
        
        
        Thread.sleep(2000);
        WebElement First_nm = driver.findElement(By.xpath("//label[text()='First name']/following::input"));
        First_nm.sendKeys("Jhon");
        
        Thread.sleep(2000);
        WebElement Last_nm = driver.findElement(By.xpath("//label[text()='Last name']/following::input"));
        Last_nm.sendKeys("Smith");
        
        Thread.sleep(2000);
        WebElement Gender = driver.findElement(By.xpath("//label[text()[normalize-space()='Male']]"));
        Gender.click();
        
        Thread.sleep(2000);
        WebElement DOB = driver.findElement(By.xpath("//label[text()='Date of birth']/following::input"));
        DOB.sendKeys("12-01-1990");
        
        Thread.sleep(2000);
        WebElement Companyname = driver.findElement(By.xpath("//label[text()='Company name']/following::input"));
        Companyname.sendKeys("TCS");
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        
        
        Thread.sleep(2000);
        WebElement tax = driver.findElement(By.xpath("//input[@class='check-box']"));
        tax.click();
        
        
        // Select the value
        Thread.sleep(2000);
        WebElement Newsletter = driver.findElement(By.xpath("(//div[@role='listbox'])[1]"));
        Thread.sleep(2000);
        ac.moveToElement(Newsletter).clickAndHold().pause(100).sendKeys(Keys.ARROW_DOWN.ARROW_DOWN.ARROW_DOWN).click().click(Newsletter).build().perform();
       
                
     // Select the Customerroles
                
        Thread.sleep(2000);
        
       // WebElement Customerroles = driver.findElement(By.xpath("(//div[@role='listbox'])[2]"));
        
        //ac.moveToElement(Customerroles).clickAndHold().sendKeys(Keys.ARROW_DOWN.ARROW_DOWN.ARROW_DOWN).click().build().perform();
        

        
         
        
        
        WebElement test = driver.findElement(By.xpath("//textarea[@name='AdminComment']"));
        test.sendKeys("Test");
        test.click();
        
        
        
        /*Thread.sleep(3000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,-500)", "");
        */
        Thread.sleep(2000);
        
        
        WebElement Savebtn = driver.findElement(By.xpath("//button[@name='save']"));
        Thread.sleep(2000);
        Savebtn.click();
        
        
        
        //Verified the success message 
        
        
        String expectedurl = "https://admin-demo.nopcommerce.com/Admin/Customer/List";
        String Actuaurl=	driver.getCurrentUrl();
        
        //Verified the title 
        Assert.assertEquals(Actuaurl, expectedurl);
        
        
       
    }

}
