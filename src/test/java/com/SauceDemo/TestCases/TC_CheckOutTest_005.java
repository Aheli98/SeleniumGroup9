package com.SauceDemo.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.PageObjects.AddToCart;
import com.SauceDemo.PageObjects.CheckOut;
import com.SauceDemo.PageObjects.FilterProduct;
import com.SauceDemo.PageObjects.LoginPage;

public class TC_CheckOutTest_005 extends BaseClass{
	
	@Test
	public void checkout() throws InterruptedException
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
		logger.info("Password is provided");

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

		
		CheckOut chk = new CheckOut(driver);
		chk.ClickOnCheckOutBox();
		
		logger.info("providing checkout details....");
		
		
		chk.setFirstName(FirstName);
		
		chk.setLastName(LastName);
	
		chk.setZip(Zip);
	
		
		chk.ClickOnContinue();
		
		
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)", "");
        
        chk.getShippingInfo();
		
		chk.ClickOnFinishButton();
		
		logger.info("validation started....");

		
		String head = chk.getHeader();
		Assert.assertEquals(head, "THANK YOU FOR YOUR ORDER");
		
		logger.info("test case passed....");

	}
	

}
