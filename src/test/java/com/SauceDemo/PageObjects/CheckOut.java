package com.SauceDemo.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.SauceDemo.Utilities.ExcelWrite;

public class CheckOut {
	
	WebDriver driver;
	
	public CheckOut(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By CheckOutBox = By.xpath("//a[@class='btn_action checkout_button']");
	By FirstName = By.xpath("//input[@id='first-name']");
	By LastName = By.xpath("//input[@id='last-name']");
	By Zip = By.xpath("//input[@id='postal-code']");
	By ContinueButton = By.xpath("//input[@type='submit']");
	By ShippingInfo = By.xpath("//div[@class='summary_value_label']");
	By FinishButton = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]");
	By Header = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");
	
	public void ClickOnCheckOutBox()
	{
		driver.findElement(CheckOutBox).click();
	}
	
	public void setFirstName(String fname)
	{
		driver.findElement(FirstName).sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		driver.findElement(LastName).sendKeys(lname);
	}
	
	public void setZip(String zip)
	{
		driver.findElement(Zip).sendKeys(zip);
	}
	
	public void ClickOnContinue()
	{
		driver.findElement(ContinueButton).click();
	}
	
	public void getShippingInfo()
	{
		ExcelWrite.Shipinfo((driver.findElement(ShippingInfo).getText()));
	}
	
	public void ClickOnFinishButton()
	{
		
		
		driver.findElement(FinishButton).click();
	}
	
	public String getHeader()
	{
		return driver.findElement(Header).getText();
	}

}
