package com.africaprudential.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.africaprudential.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BasePage {

	/*---Reference Variables----*/
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream input; 
	public static WebDriverEventListener eventListener;


	public BasePage()
	{
		try  
		{
			prop = new Properties();
			input = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/africaprudential/config/config.properties");
			prop.load(input);	

		}
		catch (FileNotFoundException e) 
		{ 
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	public static void initialization()
	{
		String browserName = prop.getProperty("browser");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();            

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); 
		driver.get(prop.getProperty("url"));
	}
}
