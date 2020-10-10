package com.SauceDemo.TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.SauceDemo.Utilities.ConfigPropertiesRead;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.SauceDemo.Utilities.DateUtil;




public class BaseClass {
	
	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest logger;
	
	
	ConfigPropertiesRead readconfig = new ConfigPropertiesRead();
	public String BaseUrl = readconfig.getURL();
	public String UserName = readconfig.getName();
	public String Password = readconfig.getPass();
	public String FirstName = readconfig.getFirstName();
	public String LastName = readconfig.getLastName();
	public String Zip = readconfig.getZip();
	
	
	public static WebDriver driver;      //driver object
	
	@BeforeTest
	public void startTest()
	{   
		String reportName = DateUtil.getTimeStamp() + ".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+ reportName );
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
//		htmlReporter.config().setDocumentTitle("SauceDemo Fetch Results");
		htmlReporter.config().setReportName("SauceDemo Test Report");
	}
	
	@AfterTest
	public void EndTest()
	{
		extent.flush();
	}
	
	
	@BeforeClass
	public void setup()
	{
		String driverName = readconfig.getBrowser();
		if(driverName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver1.exe");
			//object instantiation
			driver = new ChromeDriver();
		
			//logger = Logger.getLogger("SauceDemo");
			//PropertyConfigurator.configure("log4j.properties");
		}
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
//	@Test
//	public void test()
//	{
//		System.out.println("jhcb");
//		
//		logger.log(Status.INFO, "Check");
//		
//	}
//	
	
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

