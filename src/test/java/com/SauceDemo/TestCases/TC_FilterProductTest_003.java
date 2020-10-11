package com.SauceDemo.TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.SauceDemo.PageObjects.FilterProduct;
import com.SauceDemo.PageObjects.LoginPage;
import com.aventstack.extentreports.Status;

public class TC_FilterProductTest_003 extends BaseClass {

	@Test	
	public void productfiltering() throws InterruptedException
	{
		    logger = extent.createTest("Filtering Check");
			driver.manage().window().maximize();
			log.info("URL is opened");

			LoginPage lp = new LoginPage(driver);
			logger.log(Status.INFO, "Clicked navMenu");

			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			
			lp.OpenMenu();
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
		
			
			FilterProduct fp = new FilterProduct(driver);
			fp.FilteringProduct();
			logger.log(Status.INFO, "Product filtered successfully");
			log.info("Product filtered successfully");
	
			
			fp.SelectFirstProduct();
			logger.log(Status.INFO, "Test case passed");
			log.info("Name and Price of first product written in Excel sheet");
			log.info("Filtering testcase passed");
			
	}
}
