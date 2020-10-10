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
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		lp.OpenMenu();
	
		lp.ClickOnLogoutButton();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		lp.setUserName(UserName);
		logger.info("User name is provided");

		lp.setPassword(Password);
		logger.info("Passsword is provided");

		lp.ClickOnLoginButton();
	
		FilterProduct fp = new FilterProduct(driver);

		
		fp.FilteringProduct();
		logger.info("Product is filtered");

		fp.SelectFirstProduct();
		logger.info("First product is selected");

		
		AddToCart atc = new AddToCart(driver);

		atc.ClickOnAddtocartButton();
		atc.ClickOnCartIcon();
		logger.info("Selected product is added to the cart");
		logger.info("test case passed....");

		
	}

}
