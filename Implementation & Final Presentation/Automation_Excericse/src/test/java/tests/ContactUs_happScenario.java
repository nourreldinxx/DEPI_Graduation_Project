package tests;

import java.awt.AWTException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ContactUsPageWithDirectWay;
import pages.ContactUsPageWithRobotWay;
import pages.HomePage;

public class ContactUs_happScenario extends TestBase {
	WebDriver driver = new FirefoxDriver();
	String baseURL = "https://the-internet.herokuapp.com/nested_frames";
	
	@BeforeTest
	public void openBrowser() {
		driver.navigate().to(baseURL);
		driver.manage().window().maximize();
	}

	
	@Test
	public void testFrames() throws InterruptedException, TimeoutException {
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		
		WebElement left = driver.findElement(By.tagName("body"));
		Assert.assertEquals("LEFT", left.getText());
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame(2);
		
		WebElement right = driver.findElement(By.tagName("body"));
		Assert.assertEquals("RIGHT", right.getText());
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame-bottom");
		WebElement bottom = driver.findElement(By.tagName("body"));
		
		Assert.assertEquals("BOTTOM", bottom.getText());
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
