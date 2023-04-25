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
public class AddToCartPage extends BaseClass{
	
	@FindBy(id="product_enteredQuantity_9")
	WebElement txtQuantity;
	
	@FindBy(xpath="//button[@id='add-to-cart-button-9']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//*[contains(text(),'The product has been added to your ')]")
	WebElement productAddedMsg;
	
	@FindBy(xpath="//*[@class='ico-cart']/span[1]")
	WebElement shoppingCartBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public void enterQuantity(String quantity1) {
		Action.type(txtQuantity, quantity1);
	}
	
	public void clickOnAddToCart() {
		Action.click(getDriver(), addToCartBtn);
	}
	
	
	
	
	public String getProductAddMsg() {
		String addMSG=productAddedMsg.getText();
		return addMSG;
		
	}
	
	public ShoppingCartPage clickOnShoppingCart() {
		Action.click(getDriver(), shoppingCartBtn);
		return new ShoppingCartPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
