package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;

public class TestCase11_VerifySubscriptioninCartpage extends TestBase {
	
	HomePage homeObject = new HomePage(driver);
	CartPage CartPageObject = new CartPage(driver);
	
  @Test(priority = 4)
  public void Subscription() throws InterruptedException {
	  
  	homeObject.openCartPage();
  	
  	homeObject.scrollToFooter();
  	
  	assertEquals("SUBSCRIPTION",CartPageObject.SubscriptionText.getText());
  	
  	CartPageObject.userCanSubscript("IslamHamdy252@gmail.com");
  	
  	assertEquals("", CartPageObject.SuccessSubscribeMessage.getText());
  }
}
