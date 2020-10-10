package com.SauceDemo.TestCases;

import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.SauceDemo.Utilities.ConfigPropertiesRead;





public class BaseClass {
	
	ConfigPropertiesRead readconfig = new ConfigPropertiesRead();
	public String Browser = readconfig.getBrowser();
	public String BaseUrl = readconfig.getURL();
	public String UserName = readconfig.getName();
	public String Password = readconfig.getPass();
	public String FirstName = readconfig.getFirstName();
	public String LastName = readconfig.getLastName();
	public String Zip = readconfig.getZip();
	
	
	public static WebDriver driver;      //driver object
	
	
	
	@BeforeClass
	public void setup()
	{
		//logger = Logger.getLogger("SauceDemo");
		//PropertyConfigurator.configure("log4j.properties");
		
		
		if(Browser.equalsIgnoreCase("Chrome"))
			{
			System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			}
			
		/*else if(br.equals("firefoxpath"))
			{
				System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe";
				driver = new FirefoxDriver();
			}
		
		else if(br.equals("iepath"))
		{
			System.setProperty("webdriver.gecko.driver",".\\Driver\\chromedriver.exe");
			driver = new InternetExplorerDriver();
		}*/
		driver.get(BaseUrl);
	}
	
	@AfterMethod
	
	public void screenShot(ITestResult result) {
		takesScreenShot(driver, result);
	}
	
	@AfterClass
	public void closebrowser()
	{
		driver.quit();
	}
	
	public static void takesScreenShot(WebDriver driver, ITestResult result) {

		try {
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd HH-MM-SS");
			String dateNow = formatter.format(currentDate.getTime());
			if (ITestResult.FAILURE == result.getStatus()) {
				System.out.println("Status =" + result.getStatus());
				String tc = result.getName();
				System.out.println("Test Case Name =" + tc);
				File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scr, new File(".\\Screenshots\\FailedTestCases\\" + tc + dateNow + ".jpg"));
			}
			if (ITestResult.SUCCESS == result.getStatus()) {
				System.out.println("Status =" + result.getStatus());
				String tc = result.getName();
				System.out.println("Test Case Name =" + tc);
				File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scr, new File(".\\Screenshots\\PassedTestCases\\" + tc + dateNow + ".jpg"));
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

}

