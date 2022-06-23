package com.FyndaPackage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginWithValidation {

	
	public static void main(String[] args) {
		Logger log = Logger.getLogger(SignUpWithValidation.class.getName());

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sandeep.kumar\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);
		driver.get("https://fynda.devtechnosys.info/home");

		driver.findElement(By.xpath("//a[@class='btn btn-white']")).click();

		// case 1 submit empty form
		driver.findElement(By.xpath("//button[@class='btn login']")).click();

		// case 2 verifying alert message
		String strr = driver.findElement(By.id("email-error")).getText();

		Assert.assertEquals(strr, "This field is required.");

		log.debug("Alert message verified successfully");

		// case 3 login with invalidemail id.

		driver.findElement(By.id("email")).sendKeys("webconsultant@getnada");

		// verifying alert message
		String str2 = driver.findElement(By.id("email-error")).getText();

		Assert.assertEquals(str2, "Please enter vaild email address.");

		log.debug("Invalid Email message verified successfully");

		// case 4 login without password.
		driver.navigate().refresh();
		driver.findElement(By.id("email")).sendKeys("webconsultant@getnada.com");

		// submit form
		driver.findElement(By.xpath("//button[@class='btn login']")).click();

		// verifying alert message
		String str3 = driver.findElement(By.id("password-error")).getText();

		Assert.assertEquals(str3, "This field is required.");

		log.debug("Alert message verified successfully");

		// case 5 login with wrong password.

		driver.navigate().refresh();
		driver.findElement(By.id("email")).sendKeys("webconsultant@getnada.com");
		driver.findElement(By.id("password")).sendKeys("1234567");

		// submit form
		driver.findElement(By.xpath("//button[@class='btn login']")).click();
		// verifying alert message
		String str4 = driver.findElement(By.xpath("//span[@class='invalid-feedback']")).getText();

		Assert.assertEquals(str4, "These credentials do not match our records.");

		log.debug(" with wrong password message verified successfully");

		// case 6 login with valid id.
		// enter first name
		driver.navigate().refresh();
		driver.findElement(By.id("email")).sendKeys("webconsultant@getnada.com");
		driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);

		// enter password
		driver.findElement(By.id("password")).sendKeys("12345678");

		driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@class='btn login']")).click();
	}
}
