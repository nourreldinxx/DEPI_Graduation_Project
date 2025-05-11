package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;
import pages.RegisterPage;

public class TestCase14_PlaceOrderRegisterwhileCheckout extends TestBase{
	
	HomePage homeObject = new HomePage(driver);
	CartPage CartPageObject = new CartPage(driver);
	ProductsPage ProductsPageObject = new ProductsPage(driver);
	RegisterPage registerObject = new RegisterPage(driver);
	
  @Test
  public void TestCase14() throws InterruptedException {
	  
	  Thread.sleep(3000);
	  homeObject.SelectProducts();
	  Thread.sleep(3000);
	  
	  homeObject.continueShopping();
	  Thread.sleep(3000);
	  
	  homeObject.openCartPage();
	  Thread.sleep(3000);
	  
	  Assert.assertEquals("Shopping Cart",CartPageObject.ShoppingCartTxt.getText());
	  Thread.sleep(3000);
	  
	  CartPageObject.ProceedToCheckout();
	  Thread.sleep(3000);
	  
	  CartPageObject.LoginandRegister();
	  Thread.sleep(3000);
	  
	  Assert.assertEquals("New User Signup!", registerObject.newUserMessage.getText());
	  Thread.sleep(3000);
	  
	  registerObject.userCanRegister("IslamHamdyMohamed12","IslamHamdy526@gmail.com");
	  Thread.sleep(3000);
	  
	  Assert.assertEquals("ENTER ACCOUNT INFORMATION", registerObject.enterAccountMessage.getText());
	  Thread.sleep(3000);
	  
	  registerObject.enterAccountInformation("111222333",31,"10","2003","Islam","Hamdy","Google","Giza","Canada","Giza","Giza","1254","01099498552");
	  Thread.sleep(3000);
	  
	  String success = "Account Created!";
	  Assert.assertEquals(success.toUpperCase(), registerObject.successMesssage.getText());
	  Thread.sleep(3000);
	  
	  registerObject.continueAccount();
	  Thread.sleep(3000);
	  
	  Assert.assertEquals("Logged in as IslamHamdyMohamed12", registerObject.loggedInMessage.getText());
	  Thread.sleep(3000);
	  
	  homeObject.openCartPage();
	  Thread.sleep(3000);
	  
	  CartPageObject.ProceedToCheckout();
	  Thread.sleep(3000);
	  
	  Assert.assertEquals("Address Details", CartPageObject.AddressDetailsTxt.getText());
	  Thread.sleep(3000);
	  
	  Assert.assertEquals("Review Your Order", CartPageObject.ReviewYourOrderTxt.getText());
	  Thread.sleep(3000);
	  
	  CartPageObject.Comment("The product's matrial is very good");
	  Thread.sleep(3000);
	  
	  CartPageObject.ClickOnPlaceOrderBtn();
	  Thread.sleep(3000);
	  
	  Assert.assertEquals("Payment", CartPageObject.PaymentTxt.getText());
	  Thread.sleep(3000);
	  
	  CartPageObject.FillPaymentInformation("IslamHamdyMohamed","15963258","315","10","2029");
	  Thread.sleep(3000);
	  
	  Assert.assertEquals("ORDER PLACED!",CartPageObject.OrderPlacedMessage.getText());
	  Thread.sleep(3000);
	  
	  CartPageObject.DeleteAccount();
	  Thread.sleep(3000);
	  
	  Assert.assertEquals("ACCOUNT DELETED!",CartPageObject.AccountDeletedMessage.getText());
	  Thread.sleep(3000);
	  
	  CartPageObject.ClickOnContinueBtn();
	  Thread.sleep(3000);
	  
  }
}
