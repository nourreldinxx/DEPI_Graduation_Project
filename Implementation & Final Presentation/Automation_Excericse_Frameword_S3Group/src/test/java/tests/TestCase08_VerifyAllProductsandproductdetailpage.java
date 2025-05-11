package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductsPage;


public class TestCase08_VerifyAllProductsandproductdetailpage extends TestBase {
	
	HomePage homeObject = new HomePage(driver);
	ProductsPage ProductsPageObject = new ProductsPage(driver);
	
			
  @Test (priority = 3)
  public void VerificationOfProductsPage() throws InterruptedException {
	  
  	homeObject.openProductsPage();
  	
  	Assert.assertEquals("ALL PRODUCTS", ProductsPageObject.VerificationOfproductsPage.getText());
  	
  	ProductsPageObject.productDisplayed();
	
	Assert.assertEquals("Add to cart", ProductsPageObject.VerifyByAddToCartBtn.getText());
  	
  	Assert.assertEquals("Men Tshirt", ProductsPageObject.productName.getText());
  	
  	Assert.assertEquals("Category: Men > Tshirts", ProductsPageObject.productCategory.getText());
  	
  	Assert.assertEquals("Rs. 400", ProductsPageObject.productprice.getText());
  	
  	Assert.assertEquals("Availability:", ProductsPageObject.productavailability.getText());
  	
  	Assert.assertEquals("Condition:", ProductsPageObject.productcondition.getText());
  	
  	Assert.assertEquals("Brand:", ProductsPageObject.productBrand.getText());
  	
  }
}
