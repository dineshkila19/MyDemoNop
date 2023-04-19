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
public class SearchReasultPage extends BaseClass{
	
	@FindBy(xpath="//*[@class='item-box']/div/div/a/img")
	WebElement productLap;
	
	
	
	public SearchReasultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public AddToCartPage searchProductLap() {
		Action.click(getDriver(), productLap);
		return new AddToCartPage();
	}
	
	
	
	
	
	
	
	
	
	

}
