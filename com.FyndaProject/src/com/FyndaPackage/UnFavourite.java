package com.FyndaPackage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnFavourite {
	
	public static void main(String[] args) {
		Logger log = Logger.getLogger(SignUpWithValidation.class.getName());

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sandeep.kumar\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);
		driver.get("https://fynda.devtechnosys.info/home");
		
		driver.findElement(By.xpath("//a[@class='btn btn-orange']")).click();
		
		driver.findElement(By.id("email")).sendKeys("wedcustomer20@getnada.com");
		driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);

		// enter password
		driver.findElement(By.id("password")).sendKeys("12345678");

		driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@class='btn login']")).click();
		driver.manage().timeouts().implicitlyWait(21,TimeUnit.SECONDS);
		//click on search clinick
		driver.findElement(By.xpath("//button[@class='search_icon']")).click();
		
		//click on booking.
		driver.findElement(By.xpath("(//a[@id='BookAppointment'])[last()-9]")).click();
		
		//click on favourite
		driver.findElement(By.xpath("//a[@class='btn heart-check']")).click();
		
	}

}
