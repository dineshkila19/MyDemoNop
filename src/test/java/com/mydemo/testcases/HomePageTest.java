/**
 * 
 */
package com.mydemo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mydemo.base.BaseClass;
import com.mydemo.pageobjects.AddToCartPage;
import com.mydemo.pageobjects.HomePage;
import com.mydemo.pageobjects.IndexPage;
import com.mydemo.pageobjects.LoginPage;
import com.mydemo.pageobjects.RegisterPage;
import com.mydemo.utility.Log;

/**
 * @author Dinesh
 *
 */
public class HomePageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	RegisterPage registerPage;
	HomePage homePage;
	AddToCartPage addToCartPage;
	
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Smoke")
	public void verifyComputersLink() {
		Log.startTestCase("verifyComputersLink");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clikOnLoginAccount();
		homePage=loginPage.logIn(prop.getProperty("email"), prop.getProperty("password"));
		boolean reasult=homePage.validateComputersLink();
		Assert.assertTrue(reasult);
		Log.info("verifyComputersLink testcase is passed");
		Log.endTestCase("verifyComputersLink");
	}
	
	@Test(groups="Smoke")
	public void verifyElectronicsLink() {
		Log.startTestCase("verifyElectronicsLink");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clikOnLoginAccount();
		homePage=loginPage.logIn(prop.getProperty("email"), prop.getProperty("password"));
		boolean reasult=homePage.validateElectronicsLink();
		Assert.assertTrue(reasult);
		Log.info("verifyElectronicsLink testcase is passed");
		Log.endTestCase("verifyElectronicsLink");
	}
	
	
	
	
	

}
