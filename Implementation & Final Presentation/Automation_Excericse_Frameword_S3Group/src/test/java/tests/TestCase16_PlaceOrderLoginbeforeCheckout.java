package tests;
 

import org.testng.Assert;
import org.testng.annotations.Test;

import Data.LoadProparties;
import pages.*;

public class TestCase16_PlaceOrderLoginbeforeCheckout extends TestBase {
	 
	 String email=LoadProparties.userData.getProperty("email");
	 String password=LoadProparties.userData.getProperty("password");
	 String nameOnCardInput=LoadProparties.userData.getProperty("nameOnCardInput");
	 String cardNumberInput=LoadProparties.userData.getProperty("cardNumberInput");
	 String cvcInput=LoadProparties.userData.getProperty("cvcInput");
	 String dataInput=LoadProparties.userData.getProperty("dataInput");
	 String expiredInput=LoadProparties.userData.getProperty("expiredInput");

	 
    @Test
    public void testUserCanLogin() throws InterruptedException {
    	HomePage home = new HomePage(driver);
   	 LoginPage login = new LoginPage(driver);
   	 RegisterPage register= new RegisterPage(driver);
        home.openLoginPage();
        login.userCanLogin("malakhussienosman@gmail.com",password);
        Assert.assertTrue(home.logincheck());
        
        home.openProductsPage();
        ProductsPage product=new ProductsPage(driver);
        product.addFirstProductToCart();
       
        home.openCartPage();
        CartPage cart=new CartPage(driver);
       Assert.assertTrue(cart.isCartDisplayed()); 
        cart.ProceedToCheckout();
        cart.verifyAddressDetails();
        cart.FillPaymentInformation(nameOnCardInput,
       		 cardNumberInput,
       		 cvcInput,
       		 expiredInput,
       		 dataInput);
        cart.testOrderPlacementSuccess();
        register.deleteAccount();
        Assert.assertTrue(register.isAccountDeletedVisible());
        
    }
}
