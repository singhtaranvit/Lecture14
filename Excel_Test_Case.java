package com.Lecture14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Excel_Test_Case {
	WebDriver driver;
	SoftAssert sA;

	public class Rediff_Login {

		@Test(priority = 1, dataProvider = "rediff", dataProviderClass = Excel_Data.class)
		public void enterLoginIdAndPasssword(String username, String password) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.rediff.com");
			driver.findElement(By.linkText("Rediffmail")).click();
			driver.findElement(By.id("login1")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.className("signinbtn")).click();

		}

		@Test(priority = 2, dataProvider = "TNinja", dataProviderClass = Excel_Data.class)
		public void loginCheckTNinja(String username, String password) {
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
			//driver.findElement(By.linkText("My Account")).click();
			//driver.findElement(By.linkText("Login")).click();
			driver.findElement(By.id("input-email")).sendKeys(username);
			driver.findElement(By.id("input-password")).sendKeys(password);
			driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
			//WebElement Logout = driver.findElement(By.linkText("Logout"));
			//sA.assertTrue(Logout.isDisplayed(), "Element is not displayed");
			//sA.assertAll();
			driver.quit();
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}