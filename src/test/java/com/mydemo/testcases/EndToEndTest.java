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
import com.mydemo.pageobjects.OrderConfirmPage;
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
public class EndToEndTest extends BaseClass{

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
	OrderConfirmPage orderConfirmPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Regression")
	public void EndToEndTest() throws InterruptedException {
		Log.startTestCase("EndToEndTest");
		IndexPage indexPage=new IndexPage();
		Log.info("user is clic on the account logging");
		loginPage=indexPage.clikOnLoginAccount();
		Log.info("user is going to enter the email and password");
		homePage=loginPage.logIn(prop.getProperty("email"), prop.getProperty("password"));
		Log.info("user is successfullyt entered the credentials");
		searchReasultPage=homePage.searchProduct("Lenovo Thinkpad X1 Carbon Laptop");
		addToCartPage=searchReasultPage.searchProductLap();
		Log.info("user is going to search the product");
		Thread.sleep(3000);
		addToCartPage.selectMacProduct();
		Log.info("user is searching the mac prodct");
		Thread.sleep(3000);
		addToCartPage.getProductAddMsg();
		Log.info("user is getting success addtocart message");
		Thread.sleep(3000);
		shoppingCartPage=addToCartPage.clickOnShoppingCart();
		Log.info("user successfully click on the shopping page");
		Thread.sleep(3000);
		addressPage=shoppingCartPage.clickOnCheckOut();
		Log.info("user is successfully checkout the product");
		addressPage.selectCountry();
		addressPage.setCity("Tirupati1");
		addressPage.setAddress1("Ragigunta1");
		addressPage.setZipCode("500066");
		addressPage.setPhoneNumber("8978675600");
		Log.info("user is successfully entered the address");
		Thread.sleep(2000);
		shippingMethodPage=addressPage.clickOnContinueBtn();
		Log.info("user is going to click on the continue ");
		Thread.sleep(3000);
		paymentPage=shippingMethodPage.setShippingMethod();
		Log.info("user click on the shippingmethod");
		Thread.sleep(3000); 
		paymentPage.clickOnMethodContinue();
		Thread.sleep(3000);
		orderConfirmPage=paymentPage.clickOnInfoContinue();
		Thread.sleep(3000);
		orderConfirmPage.clickOnConfirmBtn();
		Thread.sleep(3000);
		orderConfirmPage.getConfirmMsg();
		Log.info("user is successfully getting the success message");
		Thread.sleep(3000);
		orderConfirmPage.clickOnFinalContinueBtn();
		Log.info("EndToEndTest test case is passed");
		Log.endTestCase("EndToEndTest");
		
		
	}
	
	
	
	
	

}
