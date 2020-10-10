package com.SauceDemo.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SauceDemo.PageObjects.LoginPage;
import com.SauceDemo.Utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		driver.get(BaseUrl);
		LoginPage lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
	
		lp.OpenMenu();
		
		lp.ClickOnLogoutButton();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.ClickOnLoginButton();
	
		
		if(isErrorPresent()==false)
		{
			//Assert.assertTrue(false);
			
			logger.warn("Login failed");
		}
		if(isErrorPresent()==true)
		{
			//Assert.assertTrue(true);
			logger.info("Login passed");
			lp.OpenMenu();
			lp.ClickOnLogoutButton();
		}
	}
	
	
	public boolean isErrorPresent()
	{
		//LoginPage lp = new LoginPage(driver);
		//try
		//{
			//String ab = lp.CaptureError();
			//Assert.assertEquals(ab, "Epic sadface: Username and password do not match any user in this service");
		return	driver.findElement(By.xpath("//button[text()='Open Menu']")).isDisplayed();
			
		//}
		//catch(Exception e)
		//{
		//	return false;
		//}
	}
	
	
	
	
	
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException    //data provider method
	{
		String path = ".\\src\\test\\java\\com\\SauceDemo\\TestData\\SauceDemo_inputdata.xlsx";
		int rownum = XLUtils.getRowCount(path, "sheet1");
		int colcount = XLUtils.getCellCount(path, "sheet1", 1);
	
		String logindata[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		
		return logindata;
	}
}
