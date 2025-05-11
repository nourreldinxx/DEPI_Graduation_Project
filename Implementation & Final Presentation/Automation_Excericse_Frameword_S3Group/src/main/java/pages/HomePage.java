package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends PageBase {



	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Signup / Login")
	WebElement signUpBtn;
	
	@FindBy(linkText = "Home")
	public WebElement homeLink;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUsBtn;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
	WebElement ProductsBtn;
	
	@FindBy(css="#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a")
	WebElement testcaseLink;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")
	WebElement CartBtn;
	
	@FindBy(xpath = "/html/body/section[2]/div/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[1]/a")
	WebElement ProductNo1;
	
	@FindBy(xpath = "/html/body/section[2]/div/div[1]/div[2]/div[1]/div[3]/div/div[1]/div[1]/a")
	WebElement ProductNo2;
	
	@FindBy(xpath = "/html/body/section[2]/div/div[1]/div[2]/div[1]/div[4]/div/div[1]/div[1]/a")
	WebElement ProductNo3;
	
	@FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[3]/button")
	WebElement continueshoppingBtn;
	 
	@FindBy(id="susbscribe_email")
	WebElement subscribetxt;
	
	@FindBy(id = "subscribe")
	WebElement subscribebtn;
	
	@FindBy(xpath = "//h2[contains(text(),'Subscription')]")
    WebElement subscriptionText;
	
	@FindBy(xpath = "//div[contains(text(),'You have been successfully subscribed!')]")
    WebElement subscriptionSuccessMessage;
	
	@FindBy(css="body > section > div > div.row > div.col-sm-3 > div.left-sidebar > h2")
	WebElement categorytext;
	
	@FindBy(css="#accordian > div:nth-child(1) > div.panel-heading > h4 > a > span > i")
	WebElement womenCategory;
	@FindBy(css="#Women > div > ul > li:nth-child(2) > a")
	WebElement womenTopsCategory;
	@FindBy(css="body > section > div > div.row > div.col-sm-9.padding-right > div > h2")
	public WebElement topsLabel;
	@FindBy(css="#accordian > div:nth-child(2) > div.panel-heading > h4 > a")
	WebElement menCategory;
	@FindBy(css="#Men > div > ul > li:nth-child(1) > a")
	WebElement shirt;
	@FindBy(css="body > section > div > div.row > div.col-sm-9.padding-right > div > h2")
	public WebElement menLabel;
	
	@FindBy(css="#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a")
	WebElement loggedincheck;
	
	
	@FindBy(css="#cartModal > div > div > div.modal-body > p:nth-child(2) > a > u")
	WebElement cartlink;
	
	@FindBy(css="#cartModal > div > div > div.modal-footer > button")
	WebElement continueshoppingbtn2;
	
	@FindBy (xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a")
    WebElement homeAppear;
  
    public boolean isHomeAppear() {
    	return homeAppear.isDisplayed(); }
	
	public void continueshopping2() {
		continueshoppingbtn2.click();
	}
	
	public void opencartlink() {
		cartlink.click();
	}
	public void clickOnWomanCategory() {
		womenCategory.click();
	}
	public void clickOntopsCategory() {
		womenTopsCategory.click();
	}
	public void clickOnmenCategory() {
		menCategory.click();
	}
	public void clickOnshirtCategory() {
		shirt.click();
	}
	
	public boolean logincheck() {
        return loggedincheck.isDisplayed();
    }
	
	
	
    public boolean isSubscriptionVisible() {
        return subscriptionText.isDisplayed();
    }
    public boolean isCategoryVisible() {
        return categorytext.isDisplayed();
    }
	
	public void subscribe(String email) {
	        subscribetxt.sendKeys(email);
	        subscribebtn.click();
	    }
	public void openRegisterationPage() {
		signUpBtn.click();
	}
	
	public void openLoginPage() {
		signUpBtn.click();
	}
	
	public void openContactPage() {
		contactUsBtn.click();
	}
	
	public void openProductsPage() {
		ProductsBtn.click();
	}
	
	public void openCartPage() {
		CartBtn.click();
	}
	
	public void scrollToFooter() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void SelectProducts() {
		((JavascriptExecutor)driver).executeScript(
		        "arguments[0].click();", 
		        ProductNo1
		        
		    );
	}
	
	public void continueShopping()
	{
		continueshoppingBtn.click();
	}

	public boolean isSubscriptionSuccessVisible() {
        return subscriptionSuccessMessage.isDisplayed();
    }
	public void clickTestCasesPage() {
		testcaseLink.click();		
	}
	
	

}
