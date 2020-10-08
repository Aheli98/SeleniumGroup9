package com.SauceDemo.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertiesRead {
	
	Properties prop;
	
	public ConfigPropertiesRead()
	{
		File src =new File(".\\Configuration\\config.properties");   //Read  data from config.properties file

				
		try 
		{
			FileInputStream fis =new FileInputStream(src);   //Read  data from config.properties file
			
			prop= new Properties(); // prop is object of properties class
			prop.load(fis);  //load the complete file
			

		}
		catch(IOException io)    //By chance couldnt read
		{
			io.printStackTrace();
		}
			
	}
	
	public String getBrowser()
	{
		String Browser= prop.getProperty("Browser");
		return Browser;
	}
	
	public String getURL()
	{
		String BaseUrl= prop.getProperty("BaseUrl");
		return BaseUrl;
	}
			
	public String getName()
	{
		String 	UserName= prop.getProperty("UserName");
		return UserName;
	}
	
	public String getPass()
	{
		String 	Password= prop.getProperty("Password");
		return Password;
	}
	
	public String getFirstName()
	{
		String FirstName = prop.getProperty("FirstName");
		return FirstName;
	}
	
	public String getLastName()
	{
		String LastName = prop.getProperty("LastName");
		return LastName;
	}
	
	public String getZip()
	{
		String Zip = prop.getProperty("Zip");
		return Zip;
	}

}
