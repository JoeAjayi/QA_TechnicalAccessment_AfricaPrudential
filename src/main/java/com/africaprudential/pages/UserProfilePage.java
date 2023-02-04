package com.africaprudential.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.africaprudential.base.BasePage;

public class UserProfilePage extends BasePage {


	@FindBy(xpath= "//div[@class='sc-pkHUE fIcDpF']//img[@class='sc-ptfmh gtVEMN nav-icon']")   
	@CacheLookup
	WebElement avatar;


	@FindBy(xpath= "//div[@class='sc-plVHf bQXXtq']//span[contains(text(),'Account Settings')]")   
	@CacheLookup
	WebElement userAccountSetting;


	@FindBy(xpath= "//p[contains(text(),'Personal Information')]")   
	@CacheLookup
	WebElement personal_Info;


	@FindBy(xpath= "//input[@placeholder='City']")   
	@CacheLookup
	WebElement city_Field;

	@FindBy(xpath= "//p[contains(text(),'KYC Information')]")   
	@CacheLookup
	WebElement kycInformation;


	@FindBy(xpath= "//input[@placeholder='080 0000 0000']")   
	@CacheLookup
	WebElement nextOfKinPhoneNumber_Field;


	@FindBy(xpath= "//p[contains(text(),'Employment Details')]")   
	@CacheLookup
	WebElement  employmentDetails;


	@FindBy(xpath= "//input[@placeholder='Tax Rate']")   
	@CacheLookup
	WebElement taxRate;


	@FindBy(xpath= "//p[normalize-space()='Account']")   
	@CacheLookup
	WebElement accountTab;


	@FindBy(xpath= "//button[normalize-space()='Add Bank Account']")   
	@CacheLookup
	WebElement add_BankAccountButton;


	@FindBy(xpath= "//input[@id='accountNo']")   
	@CacheLookup
	WebElement accountNo_Field;



	public UserProfilePage()
	{
		PageFactory.initElements(driver, this);
	} 



	//	Actions:


	public UserProfilePage validateUserCanUpdateCity(String updateCity) throws Exception
	{
		avatar.click();
		Thread.sleep(1000);
		userAccountSetting.click();
		Thread.sleep(1000);
		personal_Info.click();
		Thread.sleep(1000);
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("arguments[0].scrollIntoView(true)", city_Field);
		Thread.sleep(1000);
		city_Field.clear();
		Thread.sleep(2000);
		city_Field.sendKeys(updateCity);

		return new UserProfilePage();
	}



	public UserProfilePage validateUserCanUpdateNextOfKinsPhoneNumber(String nextOfKinPhoneNo) throws Exception
	{
		avatar.click();
		Thread.sleep(1000);
		userAccountSetting.click();
		Thread.sleep(1000);
		kycInformation.click();
		Thread.sleep(1000);
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("arguments[0].scrollIntoView(true)", nextOfKinPhoneNumber_Field);
		Thread.sleep(1000);
		nextOfKinPhoneNumber_Field.clear();
		Thread.sleep(2000);
		nextOfKinPhoneNumber_Field.sendKeys(nextOfKinPhoneNo);

		return new UserProfilePage();
	}


	public UserProfilePage validateUserCanUpdateTaxRate(String tax_Rate) throws Exception
	{
		avatar.click();
		Thread.sleep(1000);
		userAccountSetting.click();
		Thread.sleep(1000);
		employmentDetails.click();
		Thread.sleep(1000);
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("arguments[0].scrollIntoView(true)", taxRate);
		Thread.sleep(1000);
		taxRate.clear();
		Thread.sleep(2000);
		taxRate.sendKeys(tax_Rate);

		return new UserProfilePage();
	}



	public UserProfilePage validateUserCanAddAccountNumber(String account_Number) throws Exception
	{
		avatar.click();
		Thread.sleep(1000);
		userAccountSetting.click();
		Thread.sleep(1000);
		accountTab.click();
		Thread.sleep(1000);
		add_BankAccountButton.click();
		Thread.sleep(1000);
		accountNo_Field.sendKeys(account_Number);

		return new UserProfilePage();
	}

}
