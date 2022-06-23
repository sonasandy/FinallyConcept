package com.FyndaPackage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateProfilePic {
	
	public static void main(String[] args) throws Exception {
		
		
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

		WebElement searchButton = driver.findElement(By.xpath("//li[@class='dropdown profile-drop']"));

		Actions act = new Actions(driver);
		act.doubleClick(searchButton).build().perform();

		log.info("Clicked on profile");
		driver.manage().timeouts().implicitlyWait(21, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@class='dropdown-menu dropdown-menu-right show']/a[1]")).click();

		Thread.sleep(3000);

		WebElement upload2 = driver.findElement(By.xpath("//div[@class='edit-profile-btn']"));

		upload2.click();
		Thread.sleep(3000);

		WebElement upload = driver.findElement(By.id("profileImage"));

		upload.sendKeys(
				"C:\\Users\\sandeep.kumar\\Downloads\\AllTestData\\Testing Files\\Testing Files\\Images\\Asmalsize.jpg");

		// click on save change.

		driver.findElement(By.id("profilePictureSave")).click();

		log.info("profile updated");
	}

}
