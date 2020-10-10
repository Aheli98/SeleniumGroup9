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
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		LoginPage lp = new LoginPage(driver);
		
		lp.OpenMenu();
		
		lp.ClickOnLogoutButton();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		lp.setUserName(UserName);
		lp.setPassword(Password);
		lp.ClickOnLoginButton();
		
		
		FilterProduct fp = new FilterProduct(driver);
		fp.FilteringProduct();
		
		fp.SelectFirstProduct();
		
		AddToCart atc = new AddToCart(driver);
		atc.ClickOnAddtocartButton();
		atc.ClickOnCartIcon();
		
		
		CheckOut chk = new CheckOut(driver);
		chk.ClickOnCheckOutBox();
		
		chk.setFirstName(FirstName);
		
		chk.setLastName(LastName);
	
		chk.setZip(Zip);
	
		
		chk.ClickOnContinue();
		
		
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)", "");
        
        chk.getShippingInfo();
		
		chk.ClickOnFinishButton();
		
		
		String head = chk.getHeader();
		Assert.assertEquals(head, "THANK YOU FOR YOUR ORDER");
		
	}
	

}
