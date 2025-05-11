package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;


public class TestCase07_VerifyTestCases extends TestBase {
	HomePage home = new HomePage(driver);
	TestCasePage testPageObject = new TestCasePage(driver);
  @Test
  public void f() {

	home.clickTestCasesPage();
	Assert.assertEquals("TEST CASES", testPageObject.testCasesText.getText());
				
		
		
}}
