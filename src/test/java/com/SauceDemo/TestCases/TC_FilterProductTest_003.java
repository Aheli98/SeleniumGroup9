package com.SauceDemo.TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.SauceDemo.PageObjects.FilterProduct;
import com.SauceDemo.PageObjects.LoginPage;

public class TC_FilterProductTest_003 extends BaseClass {

	@Test	
	public void productfiltering() throws InterruptedException
	{
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			
			LoginPage lp = new LoginPage(driver);
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
			
			lp.OpenMenu();
			lp.ClickOnLogoutButton();
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

			lp.setUserName(UserName);
			logger.info("User name is provided");
			lp.setPassword(Password);
			logger.info("Passsword is provided");

			lp.ClickOnLoginButton();
		
			logger.info("filtering product....");
			FilterProduct fp = new FilterProduct(driver);
			fp.FilteringProduct();
	
			
			fp.SelectFirstProduct();
			logger.info("Name and price of the first product are written in the Excel sheet successfully");
			
			logger.info("test case passed....");

	}
}
