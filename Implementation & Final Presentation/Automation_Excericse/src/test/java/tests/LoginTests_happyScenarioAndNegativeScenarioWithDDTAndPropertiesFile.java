package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.LoadLoginProperties;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests_happyScenarioAndNegativeScenarioWithDDTAndPropertiesFile extends TestBase {
	HomePage homeObject = new HomePage(driver);
	LoginPage loginObject = new LoginPage(driver);
	
	String email = LoadLoginProperties.userData.getProperty("email");
	String password = LoadLoginProperties.userData.getProperty("password");
	boolean success = Boolean.parseBoolean(LoadLoginProperties.userData.getProperty("success"));	
	
    @Test (priority = 1)
    public void testAllLoginScenario() throws InterruptedException {
    	Thread.sleep(2000);
    	homeObject.openLoginPage();
    	
    	Thread.sleep(2000);
    	
    	Assert.assertEquals("Login to your account", loginObject.loginMessage.getText());
    	
    	loginObject.userCanLogin(email, password);
    	Thread.sleep(2000);
    	
    	if(success) {
    		Assert.assertEquals("Logout", loginObject.logoutBtn.getText()); 	
        	loginObject.userCanLogout();
    	}
    	else {
    		Assert.assertEquals("Your email or password is incorrect!", loginObject.failedMessage.getText());
    	}
   	
    	Thread.sleep(2000);
    }
}
