/**
 * 
 */
package com.mydemo.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mydemo.base.BaseClass;
import com.mydemo.pageobjects.HomePage;
import com.mydemo.pageobjects.IndexPage;
import com.mydemo.pageobjects.LoginPage;
import com.mydemo.pageobjects.SearchReasultPage;
import com.mydemo.utility.Log;


/**
 * @author Dinesh
 *
 */
public class SearchReasultPageTest extends BaseClass{
	
    IndexPage indexPage;
    SearchReasultPage searchReasultPage;
    LoginPage loginPage;
    HomePage homePage;
    
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
	public void searchProductTest() {
		Log.startTestCase("searchProductTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clikOnLoginAccount();
		homePage=loginPage.logIn(prop.getProperty("email"), prop.getProperty("password"));
		searchReasultPage=homePage.searchProduct("Lenovo Thinkpad X1 Carbon Laptop");
		searchReasultPage.searchProductLap();
		Log.info("searchProductTest testcase is passed");
		Log.endTestCase("searchProductTest");
	}
	
	
	
	
	

}
