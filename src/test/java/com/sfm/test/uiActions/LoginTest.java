package com.sfm.test.uiActions;





import com.sfm.objectRepository.uiActions.LoginPage;
import com.sfm.testBase.TestBase;

 public class LoginTest extends TestBase{
	
	
	public static void main(String[] args) {
		setUp();
		implicitWait();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("pavan");
		loginPage.enterpassword("123");
		loginPage.navigateToHomePage();
		tearDown();
		
	}

}
