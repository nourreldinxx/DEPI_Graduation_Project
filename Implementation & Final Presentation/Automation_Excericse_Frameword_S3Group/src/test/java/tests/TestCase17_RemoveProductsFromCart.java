package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Data.LoadProparties;
import pages.*;

public class TestCase17_RemoveProductsFromCart extends TestBase{
	 String email=LoadProparties.userData.getProperty("email");
	 String password=LoadProparties.userData.getProperty("password");
	String nameOnCardInput=LoadProparties.userData.getProperty("nameOnCardInput");
		String	cardNumberInput=LoadProparties.userData.getProperty("cardNumberInput");
			String cvcInput=LoadProparties.userData.getProperty("cvcInput");
			String expiredInput=LoadProparties.userData.getProperty("expiredInput");
			String dataInput=LoadProparties.userData.getProperty("dataInput");
  @Test
  public void Check_cart() throws InterruptedException {
	  
	  HomePage home = new HomePage(driver);
	  Assert.assertTrue(home.isHomeAppear());
	  
	  LoginPage login = new LoginPage(driver);
      home.openLoginPage();
      login.userCanLogin("nourreldinahmed@gmail.com","123456789");
      Assert.assertTrue(home.logincheck());
      
      
	  home.openProductsPage();
      ProductsPage product=new ProductsPage(driver);
      product.addFirstProductToCart();
     
      home.openCartPage();
      CartPage cart=new CartPage(driver);
      Assert.assertTrue(cart.isCartDisplayed()); 
      
      
      cart.removeitems();
      
      if( cart.CartIsEmpty()) {
 		 System.out.println("cart is empty");
 	 }else {
 		 
 		 System.out.println("cart is not empty");
 	 }
 	  
	
  }
}
