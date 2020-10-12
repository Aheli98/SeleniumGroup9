package com.SauceDemo.TestCases;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

import com.SauceDemo.PageObjects.AddToCart;

import com.SauceDemo.PageObjects.CheckOutCancelContinue;
import com.SauceDemo.PageObjects.FilterProduct;
import com.SauceDemo.PageObjects.LoginPage;
import com.aventstack.extentreports.Status;


public class TC_ContinueShopping_006 extends BaseClass {
	@Test
	public void shopping() throws InterruptedException
	{

		logger = extent.createTest("Continue shopping");
		
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
	
		FilterProduct fp = new FilterProduct(driver);

		fp.FilteringProduct();
		logger.log(Status.INFO, "filtered");
		log.info("Product filtered");

		fp.SelectFirstProduct();
		logger.log(Status.INFO, "First product selected");
		log.info("First product selected");

		AddToCart atc = new AddToCart(driver);

		atc.ClickOnAddtocartButton();
		atc.ClickOnCartIcon();
		logger.log(Status.PASS, "Added to Cart");
		log.info("Product added to cart");
		
		CheckOutCancelContinue cc = new CheckOutCancelContinue(driver);
		cc.continue_shopping();
		logger.log(Status.INFO, "Clicked continue_shopping");
	
		log.info("Test Case continue shopping is passed");
	}
}