package com.sfm.test.uiActions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sfm.objectRepository.uiActions.LoginPage;
import com.sfm.testBase.TestBase;

public class LoginTest  extends TestBase  {
	
	LoginPage loginpage;
	
	public LoginTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		
	}
	@Test
	public void test() throws InterruptedException{
		loginpage = new LoginPage();
		loginpage.login("pavan", "123");
		Thread.sleep(3000);
		loginpage.navigateToHomePage();
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	

	 }
