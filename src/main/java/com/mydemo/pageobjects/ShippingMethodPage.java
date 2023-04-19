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
 * @author Lenovo
 *
 */
public class ShippingMethodPage extends BaseClass{
	
	@FindBy(xpath="//input[@id='shippingoption_1']")
	WebElement nextDayAir;
	
	@FindBy(xpath="//*[@class='button-1 shipping-method-next-step-button']")
	WebElement continueBtn2;
	
	public ShippingMethodPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public PaymentPage setShippingMethod() {
		Action.click(getDriver(), nextDayAir);
		Action.click(getDriver(), continueBtn2);
		return new PaymentPage();
	}
	
	
	

}
