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
public class RegisterPage extends BaseClass{
	
	@FindBy(id="gender-male")
	WebElement radioMale;
	
	@FindBy(id="FirstName")
	WebElement txtFirstName;
	
	@FindBy(id="LastName")
	WebElement txtLastName;
	
	@FindBy(xpath="//*[@name='DateOfBirthDay']")
	WebElement dobDay;
	
	@FindBy(xpath="//*[@name='DateOfBirthMonth']")
	WebElement dobMonth;
	
	@FindBy(xpath="//*[@name='DateOfBirthYear']")
	WebElement dobYear;
	
	@FindBy(id="Email")
	WebElement txtEmail;
	
	@FindBy(id="Newsletter")
	WebElement uncheckBox;
	
	@FindBy(id="Company")
	WebElement txtCompany;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	WebElement txtConfirmPwd;
	
	@FindBy(xpath="//button[@id='register-button']")
    WebElement registerBtn1;
	
	@FindBy(xpath="//*[contains(text(),'Your registration completed')]")
	WebElement successMsg;
	
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	WebElement continueBtn;
	
	public RegisterPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnMale() {
		Action.click(getDriver(), radioMale);
	}
	public void setFirstName(String ufname) {
		Action.type(txtFirstName, ufname);
	}
	public void setLastName(String ulname) {
		Action.type(txtLastName, ulname);
	}
	public void selectDob() {
		Action.selectByVisibleText(dobDay, "19");
		Action.selectByIndex(dobMonth, 5);
		Action.selectByVisibleText(dobYear, "1995");
	}
	public void setEmail(String uemail) {
		Action.type(txtEmail, uemail);
	}
	public void uncheckBox() {
		Action.click(getDriver(), uncheckBox);
	}
	public void setCompanyName(String ucompanyname) {
		Action.type(txtCompany, ucompanyname);
	}
	public void setPassword(String upwd) {
		Action.type(txtPassword, upwd);
	}
	public void setConfirmPwd(String ucpwd) {
		Action.type(txtConfirmPwd, ucpwd);
	}
	public void clickOnRegister() {
		Action.click(getDriver(), registerBtn1);
	}
	public String successMSG() {
		String regMsg=successMsg.getText();
		return regMsg;
	}
	
	public IndexPage clickOnContinue() {
		Action.click(getDriver(), continueBtn);
		return new IndexPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
