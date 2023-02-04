package com.africaprudential.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.africaprudential.base.BasePage;
import com.africaprudential.pages.DashBoardPage;
import com.africaprudential.pages.HomePage;
import com.africaprudential.pages.LoginPage;
import com.africaprudential.pages.UserProfilePage;

public class UserProfilePageTest extends BasePage {


	HomePage homePage;
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	UserProfilePage userProfilePage;




	public UserProfilePageTest() 
	{
		super();
	}


	@BeforeMethod
	public void setUp()
	{
		initialization();
		homePage = new HomePage();  
		loginPage = new LoginPage(); 
		dashBoardPage = new DashBoardPage();
		userProfilePage = new UserProfilePage();
	}

	
	
	@Test(priority = 1)
	public void verifyUserCanUpdateCity() throws Exception
	{
		loginPage = homePage.validateClickOnLoginButton();		
		Thread.sleep(3000);

		dashBoardPage = loginPage.validateUserLoginWith(prop.getProperty("userName"), prop.getProperty("password"));
		Thread.sleep(3000);
		
		userProfilePage.validateUserCanUpdateCity(prop.getProperty("updateCity"));
	}


	

	@Test(priority = 2)
	public void verifyUserCanUpdateNextOfKinPhoneNumber() throws Exception
	{
		loginPage = homePage.validateClickOnLoginButton();		
		Thread.sleep(3000);

		dashBoardPage = loginPage.validateUserLoginWith(prop.getProperty("userName"), prop.getProperty("password"));
		Thread.sleep(3000);
		
		userProfilePage.validateUserCanUpdateNextOfKinsPhoneNumber(prop.getProperty("nextOfKinPhoneNo"));
	}

	
	
	

	@Test(priority = 3)
	public void verifyUserCanUpdateTaxRate() throws Exception
	{
		loginPage = homePage.validateClickOnLoginButton();		
		Thread.sleep(3000);

		dashBoardPage = loginPage.validateUserLoginWith(prop.getProperty("userName"), prop.getProperty("password"));
		Thread.sleep(3000);
		
		userProfilePage.validateUserCanUpdateTaxRate(prop.getProperty("tax_Rate"));
	}


	
	
	@Test(priority = 4)
	public void verifyUserCanAddAccountNumber() throws Exception
	{
		loginPage = homePage.validateClickOnLoginButton();		
		Thread.sleep(3000);

		dashBoardPage = loginPage.validateUserLoginWith(prop.getProperty("userName"), prop.getProperty("password"));
		Thread.sleep(3000);
		
		userProfilePage.validateUserCanAddAccountNumber(prop.getProperty("account_Number"));
	}
	
	
	

	@AfterMethod 
	public void tearDown() throws Exception
	{
		Thread.sleep(2000);
		driver.quit(); 
	}


}
