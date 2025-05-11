package tests;

import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

public class TestCase24_downloadInvoiceAfterPurchaseOrder extends TestBase{
  
	HomePage home=new HomePage(driver);
	CartPage cart= new CartPage(driver);
	RegisterPage register=new RegisterPage(driver);
	 String email = "test1qewe23@ex" + System.currentTimeMillis() + "11le.com";
	    String password = "password123";
	@Test
  public void f() throws Exception {
		  home.SelectProducts();
		  Thread.sleep(3000);
	      home.opencartlink();
	      cart.ProceedToCheckout();
	      cart.ClickRegisterLink();
	      
	      register.userCanRegister("Test User", email);
		    register.enterAccountInformation(
	        		password, 15, "5", "2020", password, 
	        		password, password, password, "India",
	        		password, password, password, password);
		    Assert.assertTrue(register.isAccountCreatedVisible(), "Account not created");
		    register.continueAccount();
		    assertTrue(home.logincheck());
		    home.openCartPage();
		    cart.ProceedToCheckout();
		    
		    cart.Comment("Please deliver as soon as possible");
	        cart.ClickOnPlaceOrderBtn();
	        cart.FillPaymentInformation("Test User", "4111111111111111", "123", "12", "2030");
	        
	        Assert.assertTrue(cart.isOrderSuccessVisible(), "Order not placed successfully");
	        
	        cart.clickdownload();
			Robot robot = new Robot();

			robot.delay(4000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
