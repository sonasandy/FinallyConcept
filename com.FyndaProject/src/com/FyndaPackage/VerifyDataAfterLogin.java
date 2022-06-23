package com.FyndaPackage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

        public class VerifyDataAfterLogin extends Onlydata{
	    public static void main(String[] args) {
		
		Logger log = Logger.getLogger(SignUpWithValidation.class.getName());

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sandeep.kumar\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);
		driver.get("https://fynda.devtechnosys.info/home");

		 // click on sign in 
		 WebElement okclickk=driver.findElement(By.xpath("//a[@class='btn dropdown-toggle']"));
		
         Actions act=new Actions(driver);
		
		
		 act.doubleClick(okclickk).build().perform();
		
		
		 // signup for the customer.

		 driver.findElement(By.xpath("//a[text()='As Customer']")).click();
		
		
		  //enter email name
		  driver.findElement(By.id("email")).sendKeys(EmailId);
		  driver.manage().timeouts().implicitlyWait(21,TimeUnit.SECONDS);
		  
		  // enter password 
		  driver.findElement(By.id("password")).sendKeys(pwd);
		  
		  driver.manage().timeouts().implicitlyWait(21,TimeUnit.SECONDS);
		  
		  driver.findElement(By.xpath("//button[@class='btn login']")).click();
		  
		  log.info("Login successfully");
		  
		  //verify profile data.
		
		  String reademail=driver.findElement(By.id("email")).getAttribute("value");

		  
		 // reademail2.click();
		  
		 //  String reademail=reademail2.getText();
		  Assert.assertEquals(reademail, EmailId);
		  
		  log.info("successfully  verify email id");
		  
          
          String mobileno=driver.findElement(By.id("mobile")).getAttribute("value");
		  
		  Assert.assertEquals(mobileno, MobileNumber);
		  
		  log.info("successfully  verify mobile number");
		
	}

}
