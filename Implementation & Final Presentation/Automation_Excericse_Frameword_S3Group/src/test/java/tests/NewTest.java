package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;

public class NewTest extends TestBase {
	HomePage homeObject = new HomePage(driver);
	CartPage CartPageObject = new CartPage(driver);
	
  @Test
  public void Subscription() {
	  
  	homeObject.openCartPage();
  	
  	homeObject.scrollToFooter();
  	
  	assertEquals("SUBSCRIPTION",CartPageObject.SubscriptionText.getText());
  	
  	CartPageObject.userCanSubscript("IslamHamdy252@gmail.com");
  	
  	assertEquals("", CartPageObject.SuccessSubscribeMessage.getText());
  }
}
