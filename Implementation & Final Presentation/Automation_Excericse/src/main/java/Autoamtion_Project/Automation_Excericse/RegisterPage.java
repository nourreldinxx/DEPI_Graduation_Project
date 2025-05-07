package Autoamtion_Project.Automation_Excericse;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends PageBase {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name="name")
	WebElement usernameTxt;
	
	@FindBy(name="email")
	List<WebElement> emails;
	
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/button")
	WebElement signUpBtn;
	
	@FindBy(id ="id_gender1")
	WebElement maleGenderBtn;
	
	@FindBy(id="password")
	WebElement passwordTxt;
	
	@FindBy(id="days")
	WebElement daysList;
	
	@FindBy(id="months")
	WebElement monthsList;
	
	@FindBy(id="years")
	WebElement yearsList;
	
	@FindBy(id="newsletter")
	WebElement newsLetterBtn;
	
	@FindBy(id="optin")
	WebElement specialOfferBtn;
	
	@FindBy(id="first_name")
	WebElement firstNameTxt;
	
	@FindBy(id="last_name")
	WebElement lastNameTxt;
	
	@FindBy(id="company")
	WebElement companyTxt;
	
	@FindBy(id="address1")
	WebElement addressTxt1;
	
	@FindBy(id="country")
	WebElement countryList;
	
	@FindBy(id="state")
	WebElement stateTxt;
	
	@FindBy(id="city")
	WebElement cityTxt;
	
	@FindBy(id="zipcode")
	WebElement zipCodeTxt;
	
	@FindBy(id="mobile_number")
	WebElement mobileNumberTxt;
	
	@FindBy(css="#form > div > div > div > div.login-form > form > button")
	WebElement creartAccountBtn;
	
	public void userCanRegister() {
		usernameTxt.sendKeys("abdelrahmanosama123");
		emails.get(1).sendKeys("abdelrahmanosama7610@gmail.com");
		
		signUpBtn.click();
	}
	
	public void enterAccountInformation() {
		maleGenderBtn.click();
		
		passwordTxt.sendKeys("123456789");
		
		Select makeDaysList = new Select(daysList);
		Select makeMonthsList = new Select(monthsList);
		Select makeYearsList = new Select(yearsList);
		Select makeCountryList = new Select(countryList);
		
		makeDaysList.selectByIndex(25);
		makeMonthsList.selectByValue("12");
		makeYearsList.selectByVisibleText("2002");
		
		newsLetterBtn.click();
		specialOfferBtn.click();
		
		firstNameTxt.sendKeys("Abdelrahman");
		lastNameTxt.sendKeys("Osama");
		companyTxt.sendKeys("ItWorx");
		addressTxt1.sendKeys("fostat city");
		
		makeCountryList.selectByValue("United States");
		
		stateTxt.sendKeys("newyork");
		cityTxt.sendKeys("aaaa");
		
		zipCodeTxt.sendKeys("17600");
		mobileNumberTxt.sendKeys("010124698798");
		
		creartAccountBtn.click();
	}
	
}
