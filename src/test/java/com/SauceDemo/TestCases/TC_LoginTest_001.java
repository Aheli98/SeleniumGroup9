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

		
		
		
		//create object of LoginPage with driver parameter
		LoginPage lp = new LoginPage(driver);
		logger.log(Status.INFO, "Clicked navMenu");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	
		lp.OpenMenu();
	
		lp.ClickOnLogoutButton();
		logger.log(Status.INFO, "Clicked on Logout");
		lp.setUserName(UserName);
		logger.log(Status.INFO, "UserName entered");
		

		lp.setPassword(Password);
		logger.log(Status.INFO, "Password entered");
		
		lp.ClickOnLoginButton();
		logger.log(Status.INFO, "Clicked On login button");
		
		
		if(driver.getTitle().equals("Swag Labs"))
		{
			Assert.assertTrue(true);
			logger.log(Status.PASS, "Passed");
			
		}
		else
		{
			logger.log(Status.FAIL, "FAILED");
			Assert.assertTrue(false);
			
		}
	}
	

}