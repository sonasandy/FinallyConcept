package com.FyndaPackage;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.apache.log4j.Logger;  

public class SignUpWithValidation {
	
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

		// submit empty form.
		driver.findElement(By.xpath("(//button[@type='submit'])[last()-0]")).click();

		// verifying alert message
		String strr = driver.findElement(By.id("gender-error")).getText();

		Assert.assertEquals(strr, "Specify your gender");

		log.debug("Alert message verified successfully");

		// enter first name and last name
		driver.findElement(By.id("first_name")).sendKeys("firstname");
		driver.findElement(By.id("last_name")).sendKeys("Lastname");

		// enter invalid email id.
		driver.findElement(By.id("email")).sendKeys("firstname");

		// verif email alert message

		// verifying alert message
		String str1 = driver.findElement(By.id("email-error")).getText();

		Assert.assertEquals(str1, "Please enter a valid email address.");

		log.debug("Email message verified successfully");

		// enter phone number
		driver.findElement(By.id("phone")).sendKeys("87");

		driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);
		// verifying alert message
		String str2 = driver.findElement(By.id("phone-error")).getText();

		Assert.assertEquals(str2, "Please enter at least 7 characters.");

		log.debug("Phone message verified successfully");
		driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);
		driver.findElement(By.id("emirate_id")).sendKeys("54985698");

		driver.findElement(By.id("password")).sendKeys("54985");

		driver.findElement(By.id("password_confirmation")).sendKeys("54985698");

		// verify confirmation message.

		// verifying alert message
		String str3 = driver.findElement(By.id("password_confirmation-error")).getText();

		Assert.assertEquals(str3, "Please enter the same value password");

		log.debug("Password confirmation message verified successfully");
		
		driver.navigate().refresh();

		Thread.sleep(5000);
		
		// enter first name and last name
		driver.findElement(By.id("first_name")).sendKeys("firstname");
		driver.findElement(By.id("last_name")).sendKeys("Lastname");

		// enter valid email id.
		driver.findElement(By.id("email")).sendKeys("madhuram3@getnada.com");
		driver.findElement(By.id("phone")).sendKeys("8754896598");

		driver.findElement(By.id("password")).sendKeys("Test@12345");
        
		driver.findElement(By.id("password_confirmation")).sendKeys("Test@12345");

		// select gender.
		WebElement selectgender = driver.findElement(By.id("gender"));

		Select sel = new Select(selectgender);
		sel.selectByIndex(1);
        
		// enter passport number
		driver.findElement(By.id("passport")).sendKeys("8754kjuy");

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
