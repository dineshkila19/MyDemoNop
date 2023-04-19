package com.mydemo.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverInfo;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mydemo.actiondriver.Action;
import com.mydemo.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	//public static WebDriver driver1;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	@BeforeSuite(groups= {"Smoke","Sanity","Regression"})
	public void loadconfig() {
	ExtentManager.setExtent();
	DOMConfigurator.configure("log4j.xml");
	

	try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir")+"\\Configuration\\Config.properties");
		//driver=new ChromeDriver();
		prop.load(ip);

	} catch (FileNotFoundException e) {
		e.printStackTrace(); 
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	

	}
	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}



		
		
	
	
	public static void launchApp(String browserName)
	{
		 
		
		WebDriverManager.chromedriver().setup();
		
	//	String browserName=prop.getProperty("browser");
		
		if(browserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "C:/Users/Lenovo/Downloads/chromedriver_win32 (1)/chromedriver.exe");
			driver.set(new ChromeDriver());
			
		}else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			// driver = new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());
		}
		getDriver().manage().window().maximize();
		Action.implicitWait(getDriver(), 45);
		Action.pageLoadTimeOut(getDriver(), 55);
		getDriver().get(prop.getProperty("url"));	
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
}
