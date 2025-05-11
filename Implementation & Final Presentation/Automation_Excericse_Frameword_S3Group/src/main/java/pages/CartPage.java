package pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage extends PageBase {

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")
	public WebElement SubscriptionText;
	
	@FindBy(id = "susbscribe_email")
	WebElement emailText;
	
	@FindBy(id = "subscribe")
	WebElement subscribeBtn;
	
	@FindBy(id = "success-subscribe")
	public WebElement SuccessSubscribeMessage;
	
	@FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]")
	public WebElement ShoppingCartTxt;
	
	@FindBy(xpath = "//*[@id=\"do_action\"]/div[1]/div/div/a")
	WebElement ProceedToCheckoutBtn;
	
	@FindBy(xpath = "//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u")
	WebElement LoginLink;
	
	@FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[2]/h2")
	public WebElement AddressDetailsTxt;
	
	@FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[4]/h2")
	public WebElement ReviewYourOrderTxt;
	
	@FindBy(name = "message")
	WebElement CommentField;
	
	@FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[7]/a")
	WebElement PlaceOrderBtn;
	
	@FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]")
	public WebElement PaymentTxt;
	
	@FindBy(name = "name_on_card")
	WebElement NameOnCardField;
	
	@FindBy(name = "card_number")
	WebElement CardNumberField;
	
	@FindBy(name = "cvc")
	WebElement CVCField;
	
	@FindBy(name = "expiry_month")
	WebElement ExpiryMonthField;
	
	@FindBy(name = "expiry_year")
	WebElement ExpiryYearField;
	
	@FindBy(id = "submit")
	WebElement SubmitBtn;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
	public WebElement OrderPlacedMessage;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
	WebElement DeleteAccount;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
	public WebElement AccountDeletedMessage;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
	WebElement ContinueBtn;
	
	@FindBy(css="#checkoutModal > div > div > div.modal-body > p:nth-child(2) > a > u")
	WebElement registerLink;
	
	@FindBy(css="#form > div > div > div > a")
	WebElement downloadbtn;
	
	By cartTitle = By.xpath("//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]");
	
	public void clickdownload() {
		downloadbtn.click();
	}
	public void userCanSubscript(String email) {
		emailText.sendKeys(email);
		subscribeBtn.click();
	}
	public void ClickRegisterLink() {
		registerLink.click();
	}
	
	public void ProceedToCheckout()
	{
		ProceedToCheckoutBtn.click();
	}
	
	public void LoginandRegister()
	{
		LoginLink.click();
	}
	
	public void Comment(String Comment)
	{
		CommentField.sendKeys(Comment);
	}
	
	public void ClickOnPlaceOrderBtn()
	{
		PlaceOrderBtn.click();
	}
	
	public void FillPaymentInformation(String Name,String CardNumber,String CVC,String month,String year)
	{
		NameOnCardField.sendKeys(Name);
		CardNumberField.sendKeys(CardNumber);
		CVCField.sendKeys(CVC);
		ExpiryMonthField.sendKeys(month);
		ExpiryYearField.sendKeys(year);
		
		SubmitBtn.click();
	}
	
	public void DeleteAccount()
	{
		DeleteAccount.click();
	}
	
	public void ClickOnContinueBtn()
	{
		ContinueBtn.click();
	}

	public boolean isOrderSuccessVisible() {
        return OrderPlacedMessage.isDisplayed();
	}
	 public boolean isCartDisplayed() {
	        return driver.findElement(cartTitle).isDisplayed();
	    }
	 
	 public void verifyAddressDetails() {
		   
		    List<WebElement> addressBlocks = driver.findElements(By.cssSelector(".checkout-information .col-sm-6"));

		    Assert.assertTrue(addressBlocks.size() >= 2, "Expected at least 2 address blocks (Delivery and Billing).");

		    WebElement deliveryAddress = addressBlocks.get(0);
		    WebElement billingAddress = addressBlocks.get(1);

		    // Verify both are displayed
		    Assert.assertTrue(deliveryAddress.isDisplayed(), "Delivery address block is not displayed.");
		    Assert.assertTrue(billingAddress.isDisplayed(), "Billing address block is not displayed.");

		    // Log or compare text for debug
		    String deliveryText = deliveryAddress.getText().trim();
		    String billingText = billingAddress.getText().trim();

		    System.out.println("Delivery Address:\n" + deliveryText);
		    System.out.println("Billing Address:\n" + billingText);

		    // dynamic verification
		    Assert.assertTrue(deliveryText.contains("Malak") && deliveryText.contains("India"), "Delivery address does not contain expected dynamic content.");
		    Assert.assertTrue(billingText.contains("Malak") && billingText.contains("India"), "Billing address does not contain expected dynamic content.");

		    // Fill description
		    WebElement description = driver.findElement(By.name("message")); 
		    description.sendKeys("Thanks");

		    
		    WebElement placeOrder = driver.findElement(By.linkText("Place Order"));
		    placeOrder.click();
		}
	 public void testOrderPlacementSuccess() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//*[@id=\"form\"]/div/div/div/p")
	        ));
	       // Assert.assertTrue(successMessage.isDisplayed(), "Success message is not displayed");
	        Assert.assertEquals(successMessage.getText().trim(), "Congratulations! Your order has been confirmed!");
	    }
	 public boolean CartIsEmpty() {
		    try {
		        WebElement emptyCartMessage = driver.findElement(By.id("empty_cart"));

		        String expectedText = "Cart is empty!";
		        boolean isCartEmpty = emptyCartMessage.getText().contains(expectedText);
		        
		        Assert.assertTrue(isCartEmpty, "Cart is not empty as expected.");

		        return isCartEmpty;
		    } catch (NoSuchElementException e) {
		        System.out.println("Empty cart message not found");
		        return false;
		    }
		}
	 
	 WebElement table = driver.findElement(By.id("cart_info_table"));
	 public void removeitems() throws InterruptedException {
			List<WebElement> productRows = table.findElements(By.xpath(".//tbody/tr[starts-with(@id, 'product-')]"));

			for (WebElement row : productRows) {
			    try {
			        
			        WebElement deleteButton = row.findElement(By.className("cart_quantity_delete"));
			        deleteButton.click();

			        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			        wait.until(ExpectedConditions.stalenessOf(row));
			    } catch (Exception e) {
			        System.out.println("Failed to delete product: " + e.getMessage());
			    }
			}
	
}}
