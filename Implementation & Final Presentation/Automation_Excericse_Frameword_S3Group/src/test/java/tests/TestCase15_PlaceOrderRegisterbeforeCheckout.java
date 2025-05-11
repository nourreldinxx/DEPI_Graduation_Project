package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
public class TestCase15_PlaceOrderRegisterbeforeCheckout extends TestBase{
	
  @Test
  public void placeOrderRegisterBeforeCheckout() throws Exception {
	  
	  	HomePage home = new HomePage(driver);
	    CartPage cartPage = new CartPage(driver);
	    RegisterPage register= new RegisterPage(driver);
	    String email = "test1qewe23@ex" + System.currentTimeMillis() + "11le.com";
	    String password = "password123";
	    
	    home.openRegisterationPage();
	    register.userCanRegister("Test User", email);
	    register.enterAccountInformation(
        		password, 15, "5", "2020", password, 
        		password, password, password, "India",
        		password, password, password, password);
	    Assert.assertTrue(register.isAccountCreatedVisible(), "Account not created");
	    register.continueAccount();
        Assert.assertTrue(register.isLoggedInVisible(), "Not logged in");
        home.SelectProducts();
        Thread.sleep(2000);
        home.continueshopping2();
        home.openCartPage();
        cartPage.ProceedToCheckout();
        Thread.sleep(1000);
        cartPage.Comment("Please deliver as soon as possible");
        cartPage.ClickOnPlaceOrderBtn();
        cartPage.FillPaymentInformation("Test User", "4111111111111111", "123", "12", "2030");
        
        Assert.assertTrue(cartPage.isOrderSuccessVisible(), "Order not placed successfully");
        
        register.deleteAccount();
        Assert.assertTrue(register.isAccountDeletedVisible(), "Account not deleted");
        cartPage.ClickOnContinueBtn();


  }}
