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
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		LoginPage lp = new LoginPage(driver);
		
		lp.OpenMenu();
		logger.log(Status.INFO, "Clicked navMenu");
		
		lp.ClickOnLogoutButton();
		logger.log(Status.INFO, "Clicked on Logout");		
		lp.setUserName(UserName);
		logger.log(Status.INFO, "UserName entered");
		lp.setPassword(Password);
		logger.log(Status.INFO, "Password entered");
		
		lp.ClickOnLoginButton();
		
		
		FilterProduct fp = new FilterProduct(driver);
		fp.FilteringProduct();
		
		fp.SelectFirstProduct();
		
		AddToCart atc = new AddToCart(driver);
		atc.ClickOnAddtocartButton();
		atc.ClickOnCartIcon();
		
		
		CheckOut chk = new CheckOut(driver);
		chk.ClickOnCheckOutBox();
		logger.log(Status.INFO, "Clicked On checkout");
		
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
		
		
		
	}
	

}
