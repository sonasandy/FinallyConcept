package com.FyndaPackage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class VerifyDataAfterSignUpAnd extends Onlydata {
	
	public static void main(String[] args) throws Exception {
		
		Logger log = Logger.getLogger(SignUpWithValidation.class.getName());

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sandeep.kumar\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);
		driver.get("https://fynda.devtechnosys.info/home");

		// clcik on sign in 
		WebElement okclickk=driver.findElement(By.xpath("//a[@class='btn dropdown-toggle']"));
		
		Actions act=new Actions(driver);
		
		
		act.doubleClick(okclickk).build().perform();
		
		
		// signup for the customer.

		driver.findElement(By.xpath("//a[text()='As Customer']")).click();
		
		driver.findElement(By.xpath("//a[@href='https://fynda.devtechnosys.info/register']")).click();
		
          Thread.sleep(5000);
		
		// enter first name and last name
		driver.findElement(By.id("first_name")).sendKeys(firstname);
		driver.findElement(By.id("last_name")).sendKeys(Lastname);

		// enter valid email id.
		driver.findElement(By.id("email")).sendKeys(EmailId);
		driver.findElement(By.id("phone")).sendKeys(MobileNumber);

		driver.findElement(By.id("password")).sendKeys("Test@12345");
        
		driver.findElement(By.id("password_confirmation")).sendKeys("Test@12345");

		// select gender.
		WebElement selectgender = driver.findElement(By.id("gender"));

		Select sel = new Select(selectgender);
		sel.selectByIndex(1);
        
		// enter passport number
		driver.findElement(By.id("passport")).sendKeys(passportnumber);

		// select country.

		WebElement selectcountryr = driver.findElement(By.id("country"));

		Select sel2 = new Select(selectcountryr);
		sel2.selectByIndex(1);
		Thread.sleep(3000);
		// select state.

		WebElement selectcity = driver.findElement(By.id("state"));

		Select sel3 = new Select(selectcity);
		sel3.selectByIndex(1);
		Thread.sleep(3000);
		// dob
		driver.findElement(By.name("DOB")).sendKeys("12-04-2021");

		// select question.

		WebElement selectq = driver.findElement(By.name("question_id"));

		Select sel4 = new Select(selectq);
		sel4.selectByIndex(1);

		// eneter answer
		driver.findElement(By.name("answer")).sendKeys("zidd");
		
		
		driver.findElement(By.xpath("(//button[@type='submit'])[last()-0]")).click();
		
		log.debug("Sign up successfully");
	}

}
