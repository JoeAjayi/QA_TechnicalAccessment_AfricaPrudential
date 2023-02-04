package com.africaprudential.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.africaprudential.base.BasePage;
import com.africaprudential.pages.HomePage;
import com.africaprudential.pages.LoginPage;

public class HomePageTest extends BasePage {



	HomePage homePage;
	LoginPage loginPage;


	//	This constructor will call TestBase class constructor
	public HomePageTest()   
	{
		super();
	}



	@BeforeMethod
	public void setUp() throws Exception
	{  
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
	}



	@Test(priority = 1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle = homePage.validateInvearnHomePageTitle();
		Assert.assertEquals(homePageTitle, "Invearn - Track and Claim Your Dividends on the go"); 
		System.out.println(homePageTitle);
	}




	@Test(priority = 2)
	public void verifyUserCanClickOnLoginButton() throws Exception
	{
		loginPage = homePage.validateClickOnLoginButton();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals(url, "https://oasis-investor-dev.africaprudential.net/?auth_action=login");

	}




	@AfterMethod
	public void tearDown() throws Exception
	{	
		Thread.sleep(3000);
		driver.quit();
	}

}
