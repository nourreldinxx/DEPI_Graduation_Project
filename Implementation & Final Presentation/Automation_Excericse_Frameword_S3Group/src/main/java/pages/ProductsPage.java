package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends PageBase {
	  WebDriverWait wait=new WebDriverWait(driver, null);

	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "/html/body/section[2]/div[1]/div/div[2]/div/h2")
	public WebElement VerificationOfproductsPage;
	
	@FindBy(xpath = "/html/body/section[2]/div[1]/div/div[2]/div/div[3]/div/div[2]/ul/li/a")
	WebElement ViewProductBtn;
	
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")
	public WebElement VerifyByAddToCartBtn;
	
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")
	public WebElement productName;
	
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]")
	public WebElement productCategory;
	
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span")
	public WebElement productprice;
	
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]/b")
	public WebElement productavailability;
	
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]/b")
	public WebElement productcondition;
	
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]/b")
	public WebElement productBrand;
	
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li/a")
	public WebElement WriteYourReviewText;
	
	@FindBy(id = "review")
	public WebElement ReviewField;
	
	@FindBy(id = "name")
	public WebElement NameField;
	
	@FindBy(id = "email")
	public WebElement EmailField;
	
	@FindBy(id = "button-review")
	public WebElement SubmitBtn;
	
	@FindBy(xpath = "//*[@id=\"review-section\"]/div/div")
	public WebElement SuccessMessage;
	
	
	@FindBy(id = "search_product")
	private WebElement searchInput;

	@FindBy(id = "submit_search")
	private WebElement searchButton;

    @FindBy(css = "body > section:nth-child(4) > div > div > div.col-sm-3 > div > div.brands_products > h2")
    private WebElement brandSection;  
    
    @FindBy(css= "body > section > div > div.row > div.col-sm-3 > div.left-sidebar > div.brands_products > div > ul > li:nth-child(1) > a")
    WebElement poloLink;
    
    @FindBy(css="body > section > div > div.row > div.col-sm-9.padding-right > div > h2")
    public WebElement poloSectionLabel;
    
    @FindBy(css="body > section > div > div.row > div.col-sm-3 > div > div.brands_products > div > ul > li:nth-child(2) > a")
    WebElement hmLink;
    
    @FindBy(css="body > section > div > div.row > div.col-sm-9.padding-right > div > h2")
    public WebElement HMSectionLabel;
    @FindBy(css="body > section:nth-child(4) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(3) > div > div.single-products > div.product-overlay > div > a")
    WebElement item;
    public void productDisplayed() {
    	ViewProductBtn.click();
    }
    public boolean isBrandSectionVisible() {
        return brandSection.isDisplayed();
    }   
   
    public void clickOnPolo() {
		poloLink.click();
	}
    
    public void clickOnHM() {
		hmLink.click();
	}
    
	
	public void userCanAddReview(String email,String name,String Review) {
		ReviewField.sendKeys(email);
		NameField.sendKeys(name);
		EmailField.sendKeys(email);
		
		SubmitBtn.click();
	}
	public void addFirstProductToCart() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    try {
	        // Scroll and wait for the button
	        js.executeScript("window.scrollBy(0, 250)");
	        
	        // Use more reliable CSS selector instead of XPath
	        By addToCartLocator = By.cssSelector("a.btn.btn-default.add-to-cart[data-product-id='1']");
	        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator));

	        // Enhanced scrolling and clicking
	        js.executeScript(
	            "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});", 
	            addToCartBtn
	        );
	        
	        // Multiple click attempts with different methods
	        try {
	            addToCartBtn.click();
	        } catch (ElementClickInterceptedException e) {
	            // Fallback to JavaScript click if normal click fails
	            js.executeScript("arguments[0].click();", addToCartBtn);
	        }

	        // Handle the continue shopping modal
	        By continueShoppingLocator = By.cssSelector("#cartModal button:not(.close)");
	        WebElement continueShopping = wait.until(ExpectedConditions.elementToBeClickable(continueShoppingLocator));
	        
	        // Use JavaScript click for the modal button to avoid similar issues
	        js.executeScript("arguments[0].click();", continueShopping);
	        
	        // Wait for modal to disappear
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("cartModal")));
	        
	    } catch (Exception e) {
	    }
	}
	 public void addtocart() {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0, 250)"); // Scrolls down 250 pixels
		 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", item);
	}
	
}




