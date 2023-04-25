/**
 * 
 */
package com.mydemo.testcases;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mydemo.base.BaseClass;
import com.mydemo.dataprovider.DataProviders;
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
	
	@Test(groups="Smoke", dataProvider="newAcountDetailsData", dataProviderClass=DataProviders.class)
	public void registerTest(HashMap<String,String> hashMapValue) {
		Log.startTestCase("registerTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clikOnLoginAccount();
		registerPage=loginPage.clickOnRegister();
		registerPage.createAccount(hashMapValue.get("Gender"),
									hashMapValue.get("FirstName"),
									hashMapValue.get("LastName"),
									hashMapValue.get("Day"),
									hashMapValue.get("Month"),
									hashMapValue.get("Year"),
									hashMapValue.get("Email"),
									hashMapValue.get("CompanyName"),
									hashMapValue.get("Password"),
									hashMapValue.get("ConfirmPassword"));
		registerPage.clickOnRegister();
		Log.info("user is successfully clicon the register button");
		registerPage.successMSG();
		Log.info("user is getting success msg");
		registerPage.clickOnContinue();
		Log.info("registerTest testcase is passed");
		Log.endTestCase("registerTest");
	}
	
	
	

}
