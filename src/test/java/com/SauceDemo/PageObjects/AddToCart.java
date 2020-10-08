package com.SauceDemo.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {
	
	WebDriver driver;
	
	public AddToCart(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By AddtocartButton = By.xpath("//button[text()='ADD TO CART']");
	By CartIcon = By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']");
	
	public void ClickOnAddtocartButton()
	{
		driver.findElement(AddtocartButton).click();
	}
	
	public void ClickOnCartIcon()
	{
		driver.findElement(CartIcon).click();
	}
	
}
