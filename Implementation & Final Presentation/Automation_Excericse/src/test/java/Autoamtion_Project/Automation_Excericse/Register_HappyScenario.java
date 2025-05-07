package Autoamtion_Project.Automation_Excericse;

import org.testng.annotations.Test;

public class Register_HappyScenario extends TestBase{
	HomePage homeObject = new HomePage(driver);
	RegisterPage registerObject = new RegisterPage(driver);
  @Test
  public void tetRegister_NewUserName_MandatoryAndOptional() throws InterruptedException {
	  Thread.sleep(3000);
	  homeObject.openRegisterationPage();
	  Thread.sleep(3000);
	  
	  registerObject.userCanRegister();
	  Thread.sleep(3000);
	  
	  registerObject.enterAccountInformation();
	  Thread.sleep(3000);
  }
}
