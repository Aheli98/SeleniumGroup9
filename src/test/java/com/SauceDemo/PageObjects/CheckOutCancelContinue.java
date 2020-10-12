package com.SauceDemo.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class CheckOutCancelContinue {
	
	WebDriver driver;
	
	public CheckOutCancelContinue(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	By conti_shopping = By.xpath("//a[@class='btn_secondary']");
	By cancel = By.xpath("//a[@class='cart_cancel_link btn_secondary']");
	By Subheader = By.xpath("//div[@class='subheader']");
;	
	
	public void continue_shopping() 
	{
		driver.findElement(conti_shopping).click();
	}
	
	public void clickOnCancel()
	{
		driver.findElement(cancel).click();
	}
	
	
	public String getSubHeader()
	{
		return driver.findElement(Subheader).getText();
		
	}

}