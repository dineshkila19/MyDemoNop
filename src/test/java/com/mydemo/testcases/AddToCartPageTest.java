/**
 * 
 */
package com.mydemo.testcases;

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
import com.mydemo.pageobjects.SearchReasultPage;
import com.mydemo.utility.Log;

/**
 * @author Dinesh
 *
 */
public class AddToCartPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	RegisterPage registerPage;
	HomePage homePage;
	AddToCartPage addToCartPage;
	SearchReasultPage searchReasultPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	
	@Test(groups= {"Sanity", "Regression"})
	public void AddToCartTest() throws InterruptedException {
		Log.startTestCase("AddToCartTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clikOnLoginAccount();
		homePage=loginPage.logIn(prop.getProperty("email"), prop.getProperty("password"));
		searchReasultPage=homePage.searchProduct("Lenovo Thinkpad X1 Carbon Laptop");
		Log.info("user is successfully entered the product name");
		addToCartPage=searchReasultPage.searchProductLap();
		Log.info("user search the product");
		Thread.sleep(2000);
		addToCartPage.selectMacProduct();
		Log.info("user successfully select the mac");
		Thread.sleep(2000);
		addToCartPage.getProductAddMsg();
		Log.info("user is getting allert msg");
		Thread.sleep(2000);
		addToCartPage.clickOnShoppingCart();
		Log.info("user is successfully select the shopping cart");
		Log.info("AddToCartTest testcase is passed");
		Log.endTestCase("AddToCartTest");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
