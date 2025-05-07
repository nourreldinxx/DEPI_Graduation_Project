package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.LoadExcelLoginData;
import data.LoadLoginProperties;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests_happyScenarioAndNegativeScenarioWithDDTAndExcelFile extends TestBase {
	HomePage homeObject = new HomePage(driver);
	LoginPage loginObject = new LoginPage(driver);
	
	@DataProvider(name="LoginExcelData")
	public Object[][] getExcelData() throws IOException{
		LoadExcelLoginData loginData = new LoadExcelLoginData();
		return loginData.getExcelLoginData();
	}
	
	
    @Test (priority = 1,dataProvider = "LoginExcelData")
    public void testAllLoginScenario(String email , String password,String success) throws InterruptedException {
    	Thread.sleep(2000);
    	homeObject.openLoginPage();
    	
    	Thread.sleep(2000);
    	
    	Assert.assertEquals("Login to your account", loginObject.loginMessage.getText());
    	
    	loginObject.userCanLogin(email, password);
    	Thread.sleep(2000);
    	
		Assert.assertEquals("Logout", loginObject.logoutBtn.getText()); 	
    	loginObject.userCanLogout();
    	
    	boolean successBoolean = Boolean.parseBoolean(success);
    	
    	if(successBoolean) {
    		Assert.assertEquals("Logout", loginObject.logoutBtn.getText()); 	
        	loginObject.userCanLogout();
    	}
    	else {
    		Assert.assertEquals("Your email or password is incorrect!", loginObject.failedMessage.getText());
    	}
   	
    	Thread.sleep(2000);
    }
}
