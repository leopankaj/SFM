package com.sfm.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver event_driver;
	public static WebDriverEventListener eventListner;
	
	
	public TestBase() {
		try {
			 	prop = new Properties();
			 	FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/sfm/config/config.properties");
			 	prop.load(stream);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/com/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/main/java/com/drivers/chromedriver.exe");
			driver = new FirefoxDriver();
		}
		
		event_driver = new EventFiringWebDriver(driver);
		
		eventListner = new WebDriverEventListener(); 
		event_driver.register(eventListner);
		driver = event_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	    driver.get(prop.getProperty("url"));
			
		
	}
	
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
