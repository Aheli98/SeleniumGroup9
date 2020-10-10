package com.SauceDemo.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.PageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void LoginTest() throws InterruptedException
	{
		driver.manage().window().maximize();

		
		
		
		//create object of LoginPage with driver parameter
		LoginPage lp = new LoginPage(driver);
		lp.OpenMenu();
		lp.ClickOnLogoutButton();
		lp.setUserName(UserName);
		

		lp.setPassword(Password);
		
		
		lp.ClickOnLoginButton();
		
		if(driver.getTitle().equals("Swag Labs"))
		{
			Assert.assertTrue(true);
			
		}
		else
		{
			Assert.assertTrue(false);
			
		}
	}
	

}