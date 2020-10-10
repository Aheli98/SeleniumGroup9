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
			
			lp.OpenMenu();
			lp.ClickOnLogoutButton();
			
			lp.setUserName(UserName);
			lp.setPassword(Password);
			lp.ClickOnLoginButton();
		
			
			FilterProduct fp = new FilterProduct(driver);
			fp.FilteringProduct();
	
			
			fp.SelectFirstProduct();
	}
}
