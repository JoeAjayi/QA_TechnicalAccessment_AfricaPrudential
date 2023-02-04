package com.africaprudential.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.africaprudential.base.BasePage;


public class LoginPage extends BasePage{

	
//	PageFactory - Object Repository 
	
		
//	@FindBy(xpath = "//h2[normalize-space()='Welcome Back!']")
	@FindBy(xpath = "//h2[contains(text(),'Welcome Back!')]")
	@CacheLookup
	WebElement loginPageWelcomeText; 
	
	

	@FindBy(css = "#email")   
	@CacheLookup
	WebElement email_Field;


	@FindBy(css= "#password")   
	@CacheLookup
	WebElement password_Field;


	@FindBy(css= "button[type='submit']")   
	@CacheLookup
	WebElement signIn_Button;
	
	
	@FindBy(xpath= "//p[normalize-space()='Email is required']")   
	@CacheLookup
	WebElement emailIsRequiredErrorPrompt;
	
	
	@FindBy(xpath= "//p[contains(text(),'Password is required')]")   
	@CacheLookup
	WebElement passwordIsRequiredErrorPrompt;
	
	
	@FindBy(xpath= "//p[contains(text(),'Email is not valid')]")   
	@CacheLookup
	WebElement invalidEmailErrorPrompt;
	
	
	
	@FindBy(xpath= "//p[contains(text(),'Username or Password not correct.')]")   
	@CacheLookup
	WebElement invalidLoginErrorPrompt;
	
	
	

	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	

	public String validateLoginPageTitle()
	{
		return driver.getTitle(); 
	}
	
	
	public String validateLoginWithEmpty_EmailField()
	{
		return emailIsRequiredErrorPrompt.getText();
	}
	
	
	public String validateLoginWithEmpty_PasswordField()
	{
		return passwordIsRequiredErrorPrompt.getText();
	}
	
	
	public String validateInvalidEmailErrorPrompt()
	{
		return  invalidEmailErrorPrompt.getText();
	}
	
	
	public String validateInvalidLoginCredentials()
	{
		return invalidLoginErrorPrompt.getText();
	}
	
	
	
	public DashBoardPage validateUserLoginWith(String userName, String password) throws Exception
	{
		email_Field.sendKeys(userName);
		Thread.sleep(1000);
		password_Field.sendKeys(password);
		Thread.sleep(1000); 
		signIn_Button.click();
		Thread.sleep(1000); 
		return new DashBoardPage();
	}
	
	
	
}
