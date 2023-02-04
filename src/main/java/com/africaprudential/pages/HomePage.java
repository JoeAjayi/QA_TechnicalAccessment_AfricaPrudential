package com.africaprudential.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.africaprudential.base.BasePage;

public class HomePage extends BasePage {
	 
	
 
//	Page Factory | Object Repository 
	
	@FindBy(xpath= "//a[contains(text(),'Login')]")   
	@CacheLookup
	WebElement login_Button;

	
	
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	} 
	  
	
	
//	Actions:
	public String validateInvearnHomePageTitle() 
	{
		return driver.getTitle(); 
	}
	
	
	
	public LoginPage validateClickOnLoginButton()
	{
		login_Button.click();
		return new LoginPage();
	}

	
	
}
