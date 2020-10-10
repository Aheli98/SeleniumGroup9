package com.SauceDemo.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	
	public static void ProductName(String pname)
	{
		try
		{
			File src = new File(".\\src\\test\\java\\com\\SauceDemo\\TestData\\SauceDemo_outputdata.xlsx");
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			
			sheet.createRow(0).createCell(1).setCellValue(pname);
			
			FileOutputStream fos = new FileOutputStream(src);
			wb.write(fos);
			fos.close();
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
		
	






	public static void ProductPrice(String price)
	{
	try
	{
		File src = new File(".\\src\\test\\java\\com\\SauceDemo\\TestData\\SauceDemo_outputdata.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		sheet.createRow(1).createCell(1).setCellValue(price);
		
		FileOutputStream fos = new FileOutputStream(src);
		wb.write(fos);
		fos.close();
		wb.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}

	}
	


	public static void Shipinfo(String info)
	{
		try
		{
			File src = new File(".\\src\\test\\java\\com\\SauceDemo\\TestData\\SauceDemo_outputdata.xlsx");
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet2");
			
			sheet.createRow(1).createCell(0).setCellValue(info);
			
			FileOutputStream fos = new FileOutputStream(src);
			wb.write(fos);
			fos.close();
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		}
		
	

	}
