package test;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Utility.ReadConfig;
import pages.LoginPage;

public class BaseTest {
    

    WebDriver driver;
    Actions act;
    LoginPage lp ;
    public Logger log;
    ReadConfig conf;
    
    @BeforeTest
    public void launchApp() throws Exception 
    {
    	
    	log = Logger.getLogger("NOP Comm Application");
        PropertyConfigurator.configure(".\\testData\\log4j.properties");
        
        
        log.info("===============info=======================");
        log.warn("===============warn=======================");
        log.error("===============error=======================");
        
        
        log.info("launching a chrome browser");
        
        
        driver = new ChromeDriver();
        
        driver.manage().window().maximize();
       
      //  conf = new ReadConfig();
       // log.info("Read application url from config  file: " + conf.getAppURL());
        
        
        driver.get(Utility.Constants.nopComm);
        
        log.info("application launched sucessfully.");
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
        
        
        
        act = new Actions(driver);
        
        lp = new LoginPage(driver);
        
        
        
    }

    
    @AfterTest
    public void CloseApp() throws Exception
    {
    	 log.info("closing an application");
        
        Thread.sleep(7000);
        //driver.close();
        //driver.quit();
    }
    
    
    
}
