package com.SauceDemo.TestCases;

import java.util.concurrent.TimeUnit;

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
		FilterProduct fp = new FilterProduct(driver);
		AddToCart atc = new AddToCart(driver);
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		lp.OpenMenu();
	
		lp.ClickOnLogoutButton();
	
		lp.setUserName(UserName);
		lp.setPassword(Password);
		lp.ClickOnLoginButton();
	
		
		
		fp.FilteringProduct();

		fp.SelectFirstProduct();
		
		
		atc.ClickOnAddtocartButton();
		atc.ClickOnCartIcon();
	
		
	}

}
