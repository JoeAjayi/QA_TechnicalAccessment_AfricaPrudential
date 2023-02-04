package com.africaprudential.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import com.africaprudential.base.BasePage;
import com.africaprudential.pages.DashBoardPage;
import com.africaprudential.pages.HomePage;
import com.africaprudential.pages.LoginPage;


public class LoginPageTest extends BasePage{

	HomePage homePage;
	LoginPage loginPage;
	DashBoardPage dashBoardPage;




	public LoginPageTest() 
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
	}




	@Test(priority = 1)
	public void verifyUserCanLoginWith_ValideCredentials() throws Exception
	{
		
		loginPage = homePage.validateClickOnLoginButton();		
		Thread.sleep(3000);

		dashBoardPage = loginPage.validateUserLoginWith(prop.getProperty("userName"), prop.getProperty("password"));

		//      <--- Validating user can successfully login and running an assertion ---->

		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://oasis-investor-dev.africaprudential.net/dashboard", "URL does not matched");
		System.out.println(url);		
	}

	
	
	@Test(priority = 2)
	public void verifyUserCannotLoginWith_ValidUsername_InvalidPasswor() throws Exception
	{
		
		loginPage = homePage.validateClickOnLoginButton();		
		Thread.sleep(3000);

		dashBoardPage = loginPage.validateUserLoginWith(prop.getProperty("userName"), prop.getProperty("invalidPassword"));

		String invalidLoginPrompt = loginPage.validateInvalidLoginCredentials();
		Assert.assertEquals(invalidLoginPrompt, "Username or Password not correct.", "Text displayed does not matched");
		System.out.println(invalidLoginPrompt);	
	}

	
	
	@Test(priority = 3)
	public void verifyUserCannotLoginWith_invalidUsername_ValidPassword() throws Exception
	{
		loginPage = homePage.validateClickOnLoginButton();		
		Thread.sleep(3000);

		dashBoardPage = loginPage.validateUserLoginWith(prop.getProperty("invalidUserName"), prop.getProperty("password"));

		String invalidLoginPrompt = loginPage.validateInvalidEmailErrorPrompt();
		AssertJUnit.assertEquals(invalidLoginPrompt, "Email is not valid", "Text displayed does not matched");
		System.out.println(invalidLoginPrompt);	
	}


	
	
	@Test(priority = 4)
	public void verifyUserCannotLoginWith_EmptyUsernameField_EmptyPasswordField() throws Exception
	{
		loginPage = homePage.validateClickOnLoginButton();		
		Thread.sleep(3000);

		dashBoardPage = loginPage.validateUserLoginWith(prop.getProperty("usernameFieldEmpty"), prop.getProperty("passwordFieldEmpty"));

		String usernameFieldEmpty = loginPage.validateLoginWithEmpty_EmailField();
		String passwordFieldEmpty = loginPage.validateLoginWithEmpty_PasswordField();
		AssertJUnit.assertEquals(usernameFieldEmpty, "Email is required", "Text displayed does not matched");
		AssertJUnit.assertEquals(passwordFieldEmpty, "Password is required", "Text displayed does not matched");
		System.out.printf(usernameFieldEmpty, passwordFieldEmpty);	
	}




	@AfterMethod 
	public void tearDown() throws Exception
	{
		Thread.sleep(2000);
		driver.quit(); 
	}


}
