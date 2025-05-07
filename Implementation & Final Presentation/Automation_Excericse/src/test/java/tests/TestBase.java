package tests;

import org.testng.annotations.Test;

import data.LoadDriverProperties;
import data.LoadLoginProperties;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class TestBase {
	WebDriver driver;
	
	TestBase(){
		String browserName = LoadDriverProperties.driverData.getProperty("BrowserName");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		
	}
	
	String baseURL = LoadDriverProperties.driverData.getProperty("baseURL");
   @BeforeTest
   public void openBrowser() { 
	   long timeOut = Long.parseLong(LoadDriverProperties.driverData.getProperty("timeout")) ;
	   
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	   driver.manage().window().maximize();
	   driver.navigate().to(baseURL);
   }

   @AfterTest
   public void closeBrowser() {
	   driver.quit();
   }

}
