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
	WebElement male;
	
	@FindBy(id="gender-female")
	WebElement female;
	
	@FindBy(id="FirstName")
	WebElement txtFirstName;
	
	@FindBy(id="LastName")
	WebElement txtLastName;
	
	@FindBy(xpath="//*[@class='inputs date-of-birth']/div/select[1]")
	WebElement dobDay;
	
	@FindBy(xpath="//*[@class='inputs date-of-birth']/div/select[2]")
	WebElement dobMonth;
	
	@FindBy(xpath="//*[@class='inputs date-of-birth']/div/select[3]")
	WebElement dobYear;
	
	@FindBy(id="Email")
	WebElement txtEmail;
	
	@FindBy(id="Newsletter")
	WebElement uncheckBox;
	
	@FindBy(xpath="//input[@id='Company']")
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
	
	public void createAccount(String gender, String fname,
								String lname,
								String day,
								String month,
								String year,
								String email,
								String companyname,
								String password,
								String cpwd) {
		
		
		if(gender.equalsIgnoreCase("male")) {
			Action.click(getDriver(), male);
		}else {
			Action.click(getDriver(), female);
		}
		
		Action.type(txtFirstName, fname);
		Action.type(txtLastName, lname);
		Action.selectByValue(dobDay, day);
		Action.selectByVisibleText(dobMonth, month);
		Action.selectByVisibleText(dobYear, year);
		Action.type(txtEmail, email);
		Action.type(txtCompany, companyname);
		Action.click(getDriver(), uncheckBox);
		Action.type(txtPassword, password);
		Action.type(txtConfirmPwd, cpwd);
		
		
		
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
