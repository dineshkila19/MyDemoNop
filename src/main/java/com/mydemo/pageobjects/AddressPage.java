/**
 * 
 */
package com.mydemo.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mydemo.actiondriver.Action;
import com.mydemo.base.BaseClass;

/**
 * @author Dinesh
 *
 */
public class AddressPage extends BaseClass{
	
	@FindBy(xpath="//select[@id='BillingNewAddress_CountryId']")
	WebElement countryName;
	
	@FindBy(id="BillingNewAddress_City")
	WebElement txtCity;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement txtAddress1;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement txtZipCode;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement txtPhoneNumber;
	
	@FindBy(xpath="//*[@id='billing-buttons-container']/button[4]")
	WebElement continueBtn;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void selectCountry() {
		Action.selectByVisibleText(countryName, "India");
	}
	public void setCity(String scity) {
		Action.type(txtCity, scity);
	}
	public void setAddress1(String saddress) {
		Action.type(txtAddress1, saddress);
	}
	public void setZipCode(String szip) {
		Action.type(txtZipCode, szip);
	}
	public void setPhoneNumber(String sphno) {
		Action.type(txtPhoneNumber, sphno);
	}
	public ShippingMethodPage clickOnContinueBtn() {
		Action.click(getDriver(), continueBtn);
		return new ShippingMethodPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
