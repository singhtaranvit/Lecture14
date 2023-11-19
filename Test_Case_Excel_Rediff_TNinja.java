package com.Lecture14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test_Case_Excel_Rediff_TNinja {
	WebDriver driver;
	SoftAssert sA;

	@Test()
	public void enterLoginIdAndPasssword() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rediff.com");
		driver.findElement(By.linkText("Rediffmail")).click();
		driver.findElement(By.id("login1")).sendKeys("seleniumpanda@rediffmail.com");
		driver.findElement(By.id("password")).sendKeys("Selenium@123");
		driver.findElement(By.className("signinbtn")).click();
	}



	@Test()
	public void loginCheckTNinja() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		WebElement Logout = driver.findElement(By.linkText("Logout"));
		sA.assertTrue(Logout.isDisplayed(), "Element is not displayed");
		sA.assertAll();
	}

}
