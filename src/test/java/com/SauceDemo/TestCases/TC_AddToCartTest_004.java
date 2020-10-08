package com.SauceDemo.TestCases;

import org.testng.annotations.Test;

import com.SauceDemo.PageObjects.AddToCart;
import com.SauceDemo.PageObjects.FilterProduct;
import com.SauceDemo.PageObjects.LoginPage;

public class TC_AddToCartTest_004 extends BaseClass {
	
	@Test
	public void Addingtocart() throws InterruptedException
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
		
		AddToCart atc = new AddToCart(driver);
		atc.ClickOnAddtocartButton();
		atc.ClickOnCartIcon();
		Thread.sleep(3000);
		
	}

}
