package com.SauceDemo.TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.SauceDemo.PageObjects.AddToCart;
import com.SauceDemo.PageObjects.FilterProduct;
import com.SauceDemo.PageObjects.LoginPage;
import com.SauceDemo.Utilities.DateUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TC_AddToCartTest_004 extends BaseClass {
	
	
	
	@Test
	public void Addingtocart() throws InterruptedException
	{    
		logger = extent.createTest("Add to Cart");
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		FilterProduct fp = new FilterProduct(driver);
		AddToCart atc = new AddToCart(driver);
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		lp.OpenMenu();
		logger.log(Status.INFO, "Clicked navMenu");
	
		lp.ClickOnLogoutButton();
		logger.log(Status.INFO, "Clicked on Logout");	
		lp.setUserName(UserName);
		logger.log(Status.INFO, "UserName entered");
		
		lp.setPassword(Password);
		logger.log(Status.INFO, "Password entered");
		
		lp.ClickOnLoginButton();
		logger.log(Status.INFO, "Clicked On login button");
	
		fp.FilteringProduct();
		logger.log(Status.INFO, "filtered");

		fp.SelectFirstProduct();
		
		
		atc.ClickOnAddtocartButton();
		atc.ClickOnCartIcon();
		logger.log(Status.PASS, "Added to Cart");
	
		
	}
	@AfterTest
	public void EndTest()
	{
		extent.flush();
	}
	

}
