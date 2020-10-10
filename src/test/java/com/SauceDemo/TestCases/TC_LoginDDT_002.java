package com.SauceDemo.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SauceDemo.PageObjects.LoginPage;
import com.SauceDemo.Utilities.XLUtils;
import com.aventstack.extentreports.Status;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		driver.manage().window().maximize();
		logger = extent.createTest("Login Check");
		driver.get(BaseUrl);
		LoginPage lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
	
		lp.OpenMenu();
		logger.log(Status.INFO, "Clicked navMenu");
		
		lp.ClickOnLogoutButton();
		logger.log(Status.INFO, "Clicked on Logout");
		
		lp.setUserName(user);
		logger.log(Status.INFO, "UserName entered");

		lp.setPassword(pwd);
		logger.log(Status.INFO, "Password entered");

		lp.ClickOnLoginButton();
		logger.log(Status.INFO, "Clicked On login button");

	
		
		if(isErrorPresent()== true)
		{
			logger.log(Status.FAIL, "Wrong Credentials");
			//Assert.assertTrue(false);
			

			
	//lp.ClearUserName();
			//lp.ClearPassword();
		}
		else
		{
			Assert.assertTrue(true);
			lp.OpenMenu();
			lp.ClickOnLogoutButton();
			logger.log(Status.PASS, "Login Successfully");
		}
	}
	
	
	public boolean isErrorPresent()
	{
		LoginPage lp = new LoginPage(driver);
		try
		{
			String ab = lp.CaptureError();
			Assert.assertEquals(ab, "Epic sadface: Username and password do not match any user in this service");
			
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
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
