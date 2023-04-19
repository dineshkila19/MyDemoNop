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
public class OrderConfirmPage extends BaseClass{
	
	@FindBy(xpath="//*[@class='button-1 confirm-order-next-step-button']")
	WebElement confirmBtn;
	
	@FindBy(xpath="//*[contains(text(),'Your order has been successfully processed!')]")
	WebElement confirmMSG;
	
	@FindBy(xpath="//*[@class='buttons']/button")
	WebElement finalContinueBtn;
	
	public OrderConfirmPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnConfirmBtn() {
		Action.click(getDriver(), confirmBtn);
	}
	public void getConfirmMsg() {
		Action.isDisplayed(getDriver(), confirmMSG);
	}
	public void clickOnFinalContinueBtn() {
		Action.click(getDriver(), finalContinueBtn);
	}
	
	
	
	
	
	

}
