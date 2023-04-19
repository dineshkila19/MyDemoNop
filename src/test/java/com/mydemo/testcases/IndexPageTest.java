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
import com.mydemo.pageobjects.IndexPage;
import com.mydemo.utility.Log;

/**
 * @author Dinesh
 *
 */
public class IndexPageTest extends BaseClass{
	IndexPage indexPage;
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
	public void verifyMyNopLogo() {
		Log.startTestCase("verifyMyNopLogo");
		IndexPage indexPage=new IndexPage();
		Log.info("user is going to validate NopLogo");
		boolean reasult=indexPage.validateMyNopLogo();
		Assert.assertTrue(reasult);
		Log.info("verifyMyNopLogo testcase is passed");
		Log.endTestCase("verifyMyNopLogo");
	}
	
	@Test(groups="Smoke")
	public void getTitleTest() {
		Log.startTestCase("getTitleTest");
		IndexPage indexPage=new IndexPage();
		Log.info("user is validating the Title");
		String actTitle=indexPage.getTitle();
		String expTitle="nopCommerce demo store";
		Assert.assertEquals(actTitle, expTitle);
		Log.info("getTitleTest testcase is passed");
		Log.endTestCase("getTitleTest");
	}
	
	
	
	
	
	
	
	
	
	
	

}
