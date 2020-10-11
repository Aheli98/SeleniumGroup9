package com.SauceDemo.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.PageObjects.AddToCart;
import com.SauceDemo.PageObjects.CheckOut;
import com.SauceDemo.PageObjects.FilterProduct;
import com.SauceDemo.PageObjects.LoginPage;
import com.aventstack.extentreports.Status;

public class TC_CheckOutTest_005 extends BaseClass{
	
	
	
	@Test
	public void checkout() throws InterruptedException
	{
		logger = extent.createTest("Checkout");
		
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
	
		
		chk.ClickOnContinue();
		
		
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)", "");
        
        chk.getShippingInfo();
		
		chk.ClickOnFinishButton();
		
		
		String head = chk.getHeader();
		Assert.assertEquals(head, "THANK YOU FOR YOUR ORDER");
		logger.log(Status.PASS, "Test Case checkout is passed");
		log.info("Shipping info written in the excelsheet");
		log.info("Test Case checkout is passed");

		
		
	}
	

}
