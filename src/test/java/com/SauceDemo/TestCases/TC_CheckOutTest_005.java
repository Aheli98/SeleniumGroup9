package com.SauceDemo.TestCases;

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
		
		CheckOut chk = new CheckOut(driver);
		chk.ClickOnCheckOutBox();
		
		chk.setFirstName(FirstName);
		Thread.sleep(3000);
		chk.setLastName(LastName);
		Thread.sleep(3000);
		chk.setZip(Zip);
		Thread.sleep(3000);
		
		chk.ClickOnContinue();
		Thread.sleep(3000);
		
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)", "");
        
        chk.getShippingInfo();
		
		chk.ClickOnFinishButton();
		Thread.sleep(3000);
		
		String head = chk.getHeader();
		Assert.assertEquals(head, "THANK YOU FOR YOUR ORDER");
		Thread.sleep(3000);
	}
	

}
