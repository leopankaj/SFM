package com.sfm.objectRepository.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.sfm.testBase.TestBase;

 public class LoginPage extends TestBase {
	 WebDriver driver; 
	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="/html/body/div/form/button")
	WebElement login_button;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String username){
		userName.click();
		userName.clear();
		userName.sendKeys(username);
		Reporter.log("enter userName",true);
	}
	public void enterpassword(String password){
		this.password.click();
		this.password.clear();
		this.password.sendKeys(password);
		Reporter.log("enter password",true);
	}
	public void navigateToHomePage(){
		this.login_button.click();
		Reporter.log("click on login button",true);
		
	}
	
	
	

}
