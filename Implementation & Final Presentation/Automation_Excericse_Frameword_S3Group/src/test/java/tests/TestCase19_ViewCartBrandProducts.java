package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

public class TestCase19_ViewCartBrandProducts extends TestBase {

    @Test
    public void testViewAndCartBrandProducts() throws InterruptedException {
        HomePage home = new HomePage(driver);
        ProductsPage product = new ProductsPage(driver);

        home.openProductsPage();
        product.clickOnPolo();
        Assert.assertEquals(product.poloSectionLabel.getText(),"BRAND - POLO PRODUCTS");
        Thread.sleep(2000);
        product.clickOnHM();
        Assert.assertEquals(product.HMSectionLabel.getText(),"BRAND - H&M PRODUCTS");
        Thread.sleep(2000);
        
        
    }
}
