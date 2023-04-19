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
public class PaymentPage extends BaseClass{
	
	@FindBy(xpath="//*[@class='button-1 payment-method-next-step-button']")
	WebElement methodContinueBtn;
	
	@FindBy(xpath="//*[@class='button-1 payment-info-next-step-button']")
	WebElement infoContinueBtn;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnMethodContinue() {
		Action.click(getDriver(), methodContinueBtn);
	}
	
	public OrderConfirmPage clickOnInfoContinue() {
		Action.click(getDriver(), infoContinueBtn);
		return new OrderConfirmPage();
	}

}
