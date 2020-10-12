package com.SauceDemo.TestCases;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.PageObjects.AddToCart;
import com.SauceDemo.PageObjects.CheckOut;
import com.SauceDemo.PageObjects.CheckOutCancelContinue;
import com.SauceDemo.PageObjects.FilterProduct;
import com.SauceDemo.PageObjects.LoginPage;
import com.aventstack.extentreports.Status;

public class TC_Cancel_007 extends BaseClass{

	@Test
	public void click_to_cancel() throws InterruptedException {
		logger = extent.createTest("Cancel order");
		
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
		
		
		CheckOut chk = new CheckOut(driver);
		chk.ClickOnCheckOutBox();
		logger.log(Status.INFO, "Clicked On checkout");
		
		log.info("Filling checkout details.........");
		chk.setFirstName(FirstName);
		logger.log(Status.INFO, "First Name Entered");
		
		chk.setLastName(LastName);
		logger.log(Status.INFO, "Last Name Entered");
	
		chk.setZip(Zip);
		
		CheckOutCancelContinue cc = new CheckOutCancelContinue(driver);

		cc.clickOnCancel();
		
		String subhead = cc.getSubHeader();
		Assert.assertEquals(subhead, "Your Cart");

		logger.log(Status.INFO, "Clicked cancel");
		

		
		log.info("Test Case cancel is passed");
	}
}