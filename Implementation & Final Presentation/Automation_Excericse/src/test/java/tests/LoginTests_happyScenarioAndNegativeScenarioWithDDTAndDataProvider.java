package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTests_happyScenarioAndNegativeScenarioWithDDTAndDataProvider extends TestBase {
	HomePage homeObject = new HomePage(driver);
	LoginPage loginObject = new LoginPage(driver);
	
	@DataProvider (name="testData")
	public Object[][] loginData(){
		Object[][] testData = new Object[][] {
			{"abdelrahmanosama7651111@gmail.com","12345678",true},
			{"abdelrahmanosama22@gmail.com","123456",false},
			{"abdelrahmanosama20@gmail.com","1234568",false},
		};	
		return testData;
	}
	
    @Test (priority = 1,dataProvider = "testData")
    public void testAllLoginScenario(String email,String password,boolean success) throws InterruptedException {
    	Thread.sleep(2000);
    	homeObject.openLoginPage();
    	
    	Thread.sleep(2000);
    	
    	Assert.assertEquals("Login to your account", loginObject.loginMessage.getText());
    	
    	loginObject.userCanLogin(email, password);
    	Thread.sleep(2000);
    	
    	if(success == true) {
    		Assert.assertEquals("Logout", loginObject.logoutBtn.getText()); 	
        	loginObject.userCanLogout();
    	}
    	else {
    		Assert.assertEquals("Your email or password is incorrect!", loginObject.failedMessage.getText());
    	}
    	
    	Thread.sleep(2000);
    }
}
