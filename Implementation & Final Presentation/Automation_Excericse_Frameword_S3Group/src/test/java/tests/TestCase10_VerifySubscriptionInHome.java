package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class TestCase10_VerifySubscriptionInHome extends TestBase{
  HomePage home = new HomePage(driver);
	
	@Test
	public void testcase10() throws InterruptedException {
		home.scrollToFooter();
        home.subscribe("test@example.com");
		 Assert.assertTrue(home.isSubscriptionVisible(),"Subscription text not visible");
		 Thread.sleep(1000);
		 Assert.assertTrue(home.isSubscriptionSuccessVisible(), "Subscription success message not visible");
	}
}
