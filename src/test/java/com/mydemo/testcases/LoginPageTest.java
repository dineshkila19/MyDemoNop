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
import com.mydemo.dataprovider.DataProviders;
import com.mydemo.pageobjects.HomePage;
import com.mydemo.pageobjects.IndexPage;
import com.mydemo.pageobjects.LoginPage;
import com.mydemo.pageobjects.RegisterPage;
import com.mydemo.utility.Log;

/**
 * @author Dinesh
 *
 */
public class LoginPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	RegisterPage registerPage;
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
	
	@Test(dataProvider = "NopLoginData" , dataProviderClass=DataProviders.class, groups= {"Smoke", "Sanity"})
	public void loginTest(String uemail, String upassword) {
		Log.startTestCase("loginTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clikOnLoginAccount();
		Log.info("user is clickon the loging ");
		//homePage=loginPage.logIn(prop.getProperty("email"), prop.getProperty("password"));
		homePage=loginPage.logIn(uemail, upassword);
		Log.info("user is successfully entered the email and password");
		String actURL=homePage.getCurrentUrl();
		String curURL="https://demo.nopcommerce.com/";
		Assert.assertEquals(actURL, curURL);
		Log.info("loginTest test case is passed");
		Log.endTestCase("loginTest");
	}
	
	
	
	

}
