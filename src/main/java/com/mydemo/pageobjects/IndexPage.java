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
public class IndexPage extends BaseClass{
	
	@FindBy(xpath="//*[@class='header-lower']/div/a/img")
	WebElement nopLogo;
	
	@FindBy(xpath="//*[@class='header-links']/ul/li[2]/a")
	WebElement loginAccount;
	
	
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateMyNopLogo() {
		return Action.isDisplayed(getDriver(), nopLogo);
	}
	
	public String getTitle() {
		String getMyTitle=getDriver().getTitle();
		return getMyTitle;
	}
	
	public LoginPage clikOnLoginAccount() {
		Action.click(getDriver(), loginAccount);
		return new LoginPage();
	}
	
	
	

	
	
	
	
	
	
	
	
}
