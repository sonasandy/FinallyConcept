package com.practicemaventest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AllTestCases {
	
	@Test
	public void logincase()
	{
	     WebDriver driver;
		 String baseURL = "https://demo.guru99.com/V1";
		 System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sandeep.kumar\\Downloads\\SoftwareSele\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.findElement(By.name("uid")).sendKeys("mngr409844");
		driver.findElement(By.name("password")).sendKeys("tUgurUb");
		driver.findElement(By.name("btnLogin")).click();
		driver.quit();
	
	}
}
