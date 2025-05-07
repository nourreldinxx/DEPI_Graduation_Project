package Autoamtion_Project.Automation_Excericse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Signup / Login")
	WebElement signUpBtn;
	
	public void openRegisterationPage() {
		signUpBtn.click();
	}
}
