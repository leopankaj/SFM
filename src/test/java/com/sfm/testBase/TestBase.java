package com.sfm.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {
	public static WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver","D:/Workspace_Pankaj/SFM/src/main/java/com/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://103.231.43.144/");
		driver.manage().window().maximize();
		implicitWait();
		Reporter.log("Application open successfully",true);
		
	}
	
	public void implicitWait(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("Implicit wait",true);
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
		Reporter.log("Browser closed successfully",true);
	}
	
	
	
	

}
