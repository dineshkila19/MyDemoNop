/**
 * 
 */
package com.mydemo.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mydemo.base.BaseClass;
import com.mydemo.dataprovider.DataProviders;
import com.mydemo.pageobjects.AddToCartPage;
import com.mydemo.pageobjects.AddressPage;
import com.mydemo.pageobjects.HomePage;
import com.mydemo.pageobjects.IndexPage;
import com.mydemo.pageobjects.LoginPage;
import com.mydemo.pageobjects.RegisterPage;
import com.mydemo.pageobjects.SearchReasultPage;
import com.mydemo.pageobjects.ShoppingCartPage;
import com.mydemo.utility.Log;

/**
 * @author Lenovo
 *
 */
public class AddressPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	RegisterPage registerPage;
	HomePage homePage;
	AddToCartPage addToCartPage;
	SearchReasultPage searchReasultPage;
	ShoppingCartPage shoppingCartPage;
	AddressPage addressPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider="NopAddressData", dataProviderClass=DataProviders.class, groups= {"Sanity","Regression"})
	public void AddressPageTest(String scity, String saddress, String szip, String sphno) throws InterruptedException {
		Log.startTestCase("AddressPageTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clikOnLoginAccount();
		homePage=loginPage.logIn(prop.getProperty("email"), prop.getProperty("password"));
		searchReasultPage=homePage.searchProduct("Lenovo Thinkpad X1 Carbon Laptop");
		addToCartPage=searchReasultPage.searchProductLap();
		Thread.sleep(3000);
		addToCartPage.selectMacProduct();
		Thread.sleep(3000);
		addToCartPage.getProductAddMsg();
		Thread.sleep(3000);
		shoppingCartPage=addToCartPage.clickOnShoppingCart();
		Thread.sleep(3000);
		addressPage=shoppingCartPage.clickOnCheckOut();
		addressPage.selectCountry();
		addressPage.setCity(scity);
		addressPage.setAddress1(saddress);
		addressPage.setZipCode(szip);
		addressPage.setPhoneNumber(sphno);
		addressPage.clickOnContinueBtn();
		Log.info("user is successfully entered the address");
		Log.info("AddressPageTest testcase is passed");
		Log.endTestCase("AddressPageTest");
		
	}
	
	
	
	
	
	

}

	
	
	
	
	
	
	
	
	
	
	


