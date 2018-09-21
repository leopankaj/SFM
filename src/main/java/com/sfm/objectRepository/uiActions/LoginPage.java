package com.sfm.objectRepository.uiActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.sfm.testBase.TestBase;





 public class LoginPage extends TestBase {
	
	
	@FindBy(id="Username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="/html/body/div/form/button")
	WebElement login_button;
	
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterUserName(String un){
		userName.click();
		userName.clear();
		userName.sendKeys(un);
		System.out.println("click");
		Reporter.log("enter userName",true);
	}
	public void enterpassword(String pw){
		password.click();
		password.clear();
		password.sendKeys(pw);
		Reporter.log("enter password",true);
	}
	public void navigateToHomePage(){
		login_button.click();
		Reporter.log("click on login button",true);
		Assert.assertEquals("http://192.168.2.245:8282/SFM/home", driver.getCurrentUrl());
		Reporter.log("Current url is : "+driver.getCurrentUrl()+" ",true);
		
	}

	public void login(String username,String password){
		enterUserName(username);
		enterpassword(password);
		
	}
	
	
	

}
