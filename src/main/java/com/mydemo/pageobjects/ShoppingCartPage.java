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
public class ShoppingCartPage extends BaseClass{
	
	@FindBy(id="termsofservice")
	WebElement confirmCheckBox;
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkOutBtn;
	
	public ShoppingCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public AddressPage clickOnCheckOut() {
		Action.click(getDriver(), confirmCheckBox);
		Action.click(getDriver(), checkOutBtn);
		return new AddressPage(); 
	}
	
	
	
	
	
	
	
	
	

}
