package com.FyndaPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginWithAllCasesPractice {
	
	 public static WebDriver driver; 
	 public String username;
	 public String password;
	 
	
	public String  logincaseRightCrederntial() throws IOException, InterruptedException
	{
		
	  	//create object of local file address.
			FileInputStream fis=new FileInputStream("C:\\Users\\sandeep.kumar\\Downloads\\SeleniumTest.xlsx");
			
			//open file in read mode
			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			//take control onsheet
			XSSFSheet sh = workbook.getSheet("Sheet1");
			
			int rowcount=sh.getLastRowNum();
			
			System.out.println(rowcount);
			for(int i=0;i<=rowcount-1;i++)
			{
				
				
			
			//save username and passwordString
			String username=sh.getRow(1).getCell(i).getStringCellValue();
			 String password=sh.getRow(rowcount).getCell(i+1).getStringCellValue();
			 
		 driver.manage().timeouts().implicitlyWait(21,TimeUnit.SECONDS);
		
		 driver.findElement(By.name("password")).sendKeys(password);
		 driver.findElement(By.name("btnLogin")).click();
		 Thread.sleep(3000);
			
		 try
		 {
			 
		 
		 if(driver.getTitle()=="GTPL Bank Manager HomePage")
		 {
			 Assert.assertTrue(false);
			 driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a")).click();
			 driver.switchTo().alert().accept();
			 driver.switchTo().defaultContent();
		 }
		 
		 else
		 {
			 Assert.assertTrue(true);
			 driver.switchTo().alert().accept();
			 driver.switchTo().defaultContent();
			 
		 }
		 }
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
			}
		 return logincaseRightCrederntial();
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		
		
		 
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\sandeep.kumar\\Downloads\\SoftwareSele\\chromedriver_win32\\chromedriver.exe"); 
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://demo.guru99.com/v1/");
		  driver.manage().timeouts().implicitlyWait(21,TimeUnit.SECONDS);
		 
			/*
			 * //create object of local file address. FileInputStream fis=new
			 * FileInputStream("C:\\Users\\sandeep.kumar\\Downloads\\SeleniumTest.xlsx");
			 * 
			 * //open file in read mode
			 * 
			 * XSSFWorkbook workbook = new XSSFWorkbook(fis);
			 * 
			 * //take control onsheet XSSFSheet sh = workbook.getSheet("Sheet1");
			 * 
			 * //save username and password String
			 * username=sh.getRow(1).getCell(0).getStringCellValue(); String
			 * password=sh.getRow(1).getCell(1).getStringCellValue();
			 */
		LoginWithAllCasesPractice okk=new	LoginWithAllCasesPractice();
		
		okk.logincaseRightCrederntial();
		
		//get control on row.
		//Row rw=sh.getRow(1);
		//Cell cll = rw.getCell(0);
		
		 //Cell usern=(sh.getRow(1).getCell(0));
		 //Cell pwd=(sh.getRow(1).getCell(1));
		 
		 
		 
		 
		// String username=sh.getRow(2).getCell(0).getStringCellValue();
		// String username=sh.getRow(2).getCell(1).getStringCellValue();
		 
		 //System.out.println(username1);
		 //System.out.println(pwd1);
		 
		// Cell username2=(sh.getRow(1).getCell(1));
		// Cell pwd2=(sh.getRow(2).getCell(0));
		 
		//System.out.println(sh.getRow(1).getCell(0));
		//take control on row.
		//int rowcount=sh.getLastRowNum();
		
		
		 

	}

}
