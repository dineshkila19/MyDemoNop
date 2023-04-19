/**
 * 
 */
package com.mydemo.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mydemo.base.BaseClass;
import com.mydemo.pageobjects.IndexPage;
import com.mydemo.pageobjects.LoginPage;
import com.mydemo.pageobjects.RegisterPage;
import com.mydemo.utility.Log;

/**
 * @author Lenovo
 *
 */
public class RegisterPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	RegisterPage registerPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Sanity")
	public void registerTest() {
		Log.startTestCase("registerTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clikOnLoginAccount();
		registerPage=loginPage.clickOnRegister();
		registerPage.clickOnMale();
		registerPage.setFirstName("dinesh");
		registerPage.setLastName("kila");
		registerPage.selectDob();
		registerPage.setEmail("dineshkila19@gmail.com");
		registerPage.uncheckBox();
		registerPage.setCompanyName("capgemini");
		registerPage.setPassword("dinesh19");
		registerPage.setConfirmPwd("dinesh19");
		registerPage.clickOnRegister();
		Log.info("user is successfully clicon the register button");
		registerPage.successMSG();
		Log.info("user is getting success msg");
		registerPage.clickOnContinue();
		Log.info("registerTest testcase is passed");
		Log.endTestCase("registerTest");
	}
	
	
	

}
