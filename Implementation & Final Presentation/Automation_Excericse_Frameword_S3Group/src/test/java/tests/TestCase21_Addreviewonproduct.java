package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductsPage;

public class TestCase21_Addreviewonproduct extends TestBase{
	
  HomePage homeObject = new HomePage(driver);
  ProductsPage ProductsPageObject = new ProductsPage(driver);
  
  @Test(priority = 5)
  public void TestCase21() throws InterruptedException {
	  
	  homeObject.openProductsPage();
	 
	  Assert.assertEquals("ALL PRODUCTS", ProductsPageObject.VerificationOfproductsPage.getText());
	 
	  ProductsPageObject.productDisplayed();
	  
	  Assert.assertEquals("WRITE YOUR REVIEW", ProductsPageObject.WriteYourReviewText.getText());	 
	  
	  ProductsPageObject.userCanAddReview("IslamHamdy452@gmail.com", "IslamHamdy", "This is a good product");
	  
	  Assert.assertEquals("", ProductsPageObject.SuccessMessage.getText());  
  }
}
