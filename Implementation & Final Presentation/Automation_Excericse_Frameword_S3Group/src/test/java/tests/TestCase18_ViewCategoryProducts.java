package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class TestCase18_ViewCategoryProducts extends TestBase{
  @Test
  public void f() throws InterruptedException {
	  HomePage home = new HomePage(driver);
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0, 400)"); 
	  assertTrue(home.isCategoryVisible(), "category not found");
	  home.clickOnWomanCategory();
	  Thread.sleep(500);
	  home.clickOntopsCategory();
	  Assert.assertEquals(home.topsLabel.getText(), "WOMEN - TOPS PRODUCTS");
	  home.clickOnmenCategory();
	  Thread.sleep(500);
	  home.clickOnshirtCategory();
	  Assert.assertEquals(home.menLabel.getText(), "MEN - TSHIRTS PRODUCTS");
  }
}
