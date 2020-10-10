package com.SauceDemo.TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.PageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void LoginTest() throws InterruptedException
	{
		
		driver.manage().window().maximize();

		
		logger.info("URL is opened");
		
		//create object of LoginPage with driver parameter
		LoginPage lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		lp.OpenMenu();
		lp.ClickOnLogoutButton();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		lp.setUserName(UserName);
		logger.info("Entered username");

		lp.setPassword(Password);
		logger.info("Entered password");
		
		lp.ClickOnLoginButton();
		
		if(driver.getTitle().equals("Swag Labs"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}
	

}