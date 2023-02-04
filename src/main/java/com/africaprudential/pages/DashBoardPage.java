package com.africaprudential.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.africaprudential.base.BasePage;

public class DashBoardPage extends BasePage {



	@FindBy(xpath = "//strong[normalize-space()='Welcome']")
//	@FindBy(xpath = "//p[@class='sc-AxhUy gUCAUW']")
	@CacheLookup
	WebElement dashboardPageWelcomeText; 



	public DashBoardPage()
	{
		PageFactory.initElements(driver, this);
	}

	
	public String validateDashboardPageWelcomeText() 
	{
		return dashboardPageWelcomeText.getText();
	}




}
