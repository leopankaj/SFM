package com.sfm.test.uiActions;

import org.testng.annotations.Test;

import com.sfm.objectRepository.uiActions.LoginPage;
import com.sfm.testBase.TestBase;

public class LoginTest  extends TestBase  {
	
	@Test
	public void test() throws InterruptedException{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("pavan", "123");
		Thread.sleep(3000);
		loginPage.navigateToHomePage();
	}
	

	 }
