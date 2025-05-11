package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Data.LoadProparties;
import pages.*;

public class TestCase23_VerifyAddressDetailsincheckoutpage extends TestBase{
	String name=LoadProparties.userData.getProperty("name");
	String email=LoadProparties.userData.getProperty("email");
	 String password=LoadProparties.userData.getProperty("password");
	 String  firstname=LoadProparties.userData.getProperty("firstName");
	 String  lastname=LoadProparties.userData.getProperty("lastName");
	 String  company=LoadProparties.userData.getProperty("company");
	 String  address=LoadProparties.userData.getProperty("address");
	 String  country=LoadProparties.userData.getProperty("country");
	 String  state=LoadProparties.userData.getProperty("state");
	 String  City=LoadProparties.userData.getProperty("City");
	 String  Zipcode=LoadProparties.userData.getProperty("Zipcode");
	 String  Mobile=LoadProparties.userData.getProperty("Mobile");
  @Test
  public void SignUp() throws InterruptedException {
	  
	  HomePage home = new HomePage(driver);
	   	 home.openLoginPage();
	        RegisterPage register=new RegisterPage(driver);
	        register.userCanRegister(name,email);
	        register.enterAccountInformation(password,5,"4","2015",
	        		firstname,
	        		lastname,
	        		company,
	        		address,
	        		country,
	        		state,
	        		City,
	        		Zipcode,
	        		Mobile);
	        Assert.assertTrue(register.isAccountCreatedVisible());
	        register.continueAccount();
	        Thread.sleep(2000);
	        ProductsPage product=new ProductsPage(driver);
	        product.addFirstProductToCart();
	        home.openCartPage();
	        CartPage cart=new CartPage(driver);
	        Assert.assertTrue(cart.isCartDisplayed()); 
	        Thread.sleep(2000);

	        cart.ProceedToCheckout();
	        cart.verifyAddressDetails();
	        register.deleteAccount();
	        Assert.assertTrue(register.isAccountDeletedVisible());
  }
}
