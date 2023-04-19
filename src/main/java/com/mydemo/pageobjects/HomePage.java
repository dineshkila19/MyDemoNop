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
public class HomePage extends BaseClass{
	
	@FindBy(xpath="//*[@class='header-menu']/ul[1]/li[1]/a")
	WebElement computersLink;
	
	@FindBy(xpath="//*[@class='header-menu']/ul[1]/li[2]/a")
	WebElement electronicsLink;
	
	@FindBy(id="small-searchterms")
	WebElement searchProductBox;
	
	@FindBy(xpath="//*[@class='button-1 search-box-button']")
	WebElement searchBoxBtn;
	
	
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String getCurrentUrl() {
		String currentURL=getDriver().getCurrentUrl();
		return currentURL;
	}
	
	public boolean validateElectronicsLink() {
		return Action.isDisplayed(getDriver(), electronicsLink);
	}
	
	public boolean validateComputersLink() {
		return Action.isDisplayed(getDriver(), computersLink);
	}
	
	public SearchReasultPage searchProduct(String searchProd) {
		Action.type(searchProductBox, searchProd);
		Action.click(getDriver(), searchBoxBtn);
		return new SearchReasultPage();
	}
	

}
