package com.sfm.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {
	public static WebDriver driver;
	
	
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver","D:/Workspace_Pankaj/SFM/src/main/java/com/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://103.231.43.144");
		
	}
	
	public static  void implicitWait(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void tearDown(){
		driver.quit();
	}
	
	
	
	

}
