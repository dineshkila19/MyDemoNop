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
public class LoginPage extends BaseClass{
	
	@FindBy(xpath="//button[contains(text(),'Register')]")
	WebElement registerBtn;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='RememberMe']")
	WebElement checkBox;
	
	@FindBy(xpath="//button[contains(text(),'Log in')]")
	WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public RegisterPage clickOnRegister() {
		Action.click(getDriver(), registerBtn);
		return new RegisterPage();
	}
	
	public HomePage logIn(String uemail, String upwd) {
		Action.type(txtEmail, uemail);
		Action.type(txtPassword, upwd);
		Action.click(getDriver(), checkBox);
		Action.click(getDriver(), loginBtn);
		return new HomePage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
