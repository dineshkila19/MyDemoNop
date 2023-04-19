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
import com.mydemo.pageobjects.AddressPage;
import com.mydemo.pageobjects.HomePage;
import com.mydemo.pageobjects.IndexPage;
import com.mydemo.pageobjects.LoginPage;
import com.mydemo.pageobjects.PaymentPage;
import com.mydemo.pageobjects.RegisterPage;
import com.mydemo.pageobjects.SearchReasultPage;
import com.mydemo.pageobjects.ShippingMethodPage;
import com.mydemo.pageobjects.ShoppingCartPage;
import com.mydemo.utility.Log;

/**
 * @author Dinesh
 *
 */
public class PaymentPageTest extends BaseClass{
	
	
	IndexPage indexPage;
	LoginPage loginPage;
	RegisterPage registerPage;
	HomePage homePage;
	AddToCartPage addToCartPage;
	SearchReasultPage searchReasultPage;
	ShoppingCartPage shoppingCartPage;
	AddressPage addressPage;
	ShippingMethodPage shippingMethodPage;
	PaymentPage paymentPage;
	
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
	public void PaymentPageTest() throws InterruptedException {
		Log.startTestCase("PaymentPageTest");
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
		addressPage.setCity("Tirupati1");
		addressPage.setAddress1("Ragigunta1");
		addressPage.setZipCode("500066");
		addressPage.setPhoneNumber("8978675600");
		Thread.sleep(2000);
		shippingMethodPage=addressPage.clickOnContinueBtn();
		Thread.sleep(3000);
		paymentPage=shippingMethodPage.setShippingMethod();
		Log.info("user is select the payment");
		Thread.sleep(3000); 
		paymentPage.clickOnMethodContinue();
		Log.info("user is click on the method continue");
		Thread.sleep(3000);
		paymentPage.clickOnInfoContinue();
		Log.info("user is click on the info continue");
		Log.info("PaymentPageTest test case is passed");
		Log.endTestCase("PaymentPageTest");
		
		
	}
	
	
	
	
	
	


}
