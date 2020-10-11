package com.SauceDemo.TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.PageObjects.LoginPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class TC_LoginTest_001 extends BaseClass{
	

	@Test
	public void LoginTest() throws InterruptedException
	{
		logger = extent.createTest("Login Check");
		driver.manage().window().maximize();
		log.info("URL is opened");

		LoginPage lp = new LoginPage(driver);
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		lp.OpenMenu();
		logger.log(Status.INFO, "Clicked navMenu");
	
		lp.ClickOnLogoutButton();
		logger.log(Status.INFO, "Clicked on Logout");	
		//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		lp.setUserName(UserName);
		logger.log(Status.INFO, "UserName entered");
		log.info("Entered username");

		lp.setPassword(Password);
		logger.log(Status.INFO, "Password entered");
		log.info("Entered password");

		lp.ClickOnLoginButton();
		logger.log(Status.INFO, "Clicked On login button");
		
		
		
		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		if(driver.getTitle().equals("Swag Labs"))
		{
			Assert.assertTrue(true);
			logger.log(Status.PASS, "Passed");
			log.info("Login test passed");

			
		}
		else
		{
			logger.log(Status.FAIL, "FAILED");
			log.info("Login test failed");

			Assert.assertTrue(false);
			
		}
	}
	

}