package com.SauceDemo.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Create driver object
	WebDriver driver;
	
	//Create constructor with parameter driver
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By UserName = By.xpath("//input[@id='user-name']");
	By Password = By.xpath("//input[@id='password']");
	By LoginButton =By.xpath("//input[@id='login-button']");
	By Error = By.xpath("//*[@id=\"login_button_container\"]/div/form/h3");
	By Menu = By.xpath("//button[text()='Open Menu']");
	By LogoutButton = By.xpath("//*[@id=\"logout_sidebar_link\"]");
	
	
	public void setUserName(String uname)
	{
		
		driver.findElement(UserName).sendKeys(uname);
	}
	
	public void ClearUserName()
	{
		driver.findElement(UserName).clear();
	}
	
	public void setPassword(String pwd)
	{
		driver.findElement(Password).sendKeys(pwd);
	}
	
	public void ClearPassword()
	{
		driver.findElement(Password).clear();
	}
	
	public void ClickOnLoginButton()
	{
		driver.findElement(LoginButton).click();
	}

	/*public String CaptureError()
	{
		return driver.findElement(Error).getText();
		
	}*/
	
	public void OpenMenu()
	{
		driver.findElement(Menu).click();
	}
	
	public void ClickOnLogoutButton()
	{
		driver.findElement(LogoutButton).click();
	}
}
