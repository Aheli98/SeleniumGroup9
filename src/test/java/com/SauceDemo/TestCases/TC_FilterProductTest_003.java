package com.SauceDemo.TestCases;

import org.testng.annotations.Test;

import com.SauceDemo.PageObjects.FilterProduct;
import com.SauceDemo.PageObjects.LoginPage;

public class TC_FilterProductTest_003 extends BaseClass {

	@Test	
	public void productfiltering() throws InterruptedException
	{
			driver.manage().window().maximize();
			LoginPage lp = new LoginPage(driver);
			Thread.sleep(3000);
			lp.OpenMenu();
			Thread.sleep(3000);
			lp.ClickOnLogoutButton();
			Thread.sleep(3000);
			lp.setUserName(UserName);
			lp.setPassword(Password);
			lp.ClickOnLoginButton();
			Thread.sleep(3000);
			
			FilterProduct fp = new FilterProduct(driver);
			fp.FilteringProduct();
			Thread.sleep(3000);
			
			fp.SelectFirstProduct();
	}
}
