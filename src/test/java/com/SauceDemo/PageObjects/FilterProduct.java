package com.SauceDemo.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FilterProduct {
	
	WebDriver driver;
	
	public FilterProduct(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By FilterList = By.xpath("//select[@class='product_sort_container']");
	By FilterLowToHigh = By.className("product_sort_container");

	By FirstProduct = By.xpath("//div[text()='Sauce Labs Onesie']");
	By FirstProductPrice = By.xpath("//div[@class='inventory_details_price']");
	
	
	
	public void FilteringProduct() throws InterruptedException
	{
		driver.findElement(FilterList).click();
		Thread.sleep(3000);
		Select listbox = new Select(driver.findElement(FilterLowToHigh));
		listbox.selectByValue("lohi");
	}

	public void SelectFirstProduct() throws InterruptedException
	{
		driver.findElement(FirstProduct).click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");
	
        System.out.println(driver.findElement(FirstProduct).getText());
        System.out.println(driver.findElement(FirstProductPrice).getText());
	}

}
