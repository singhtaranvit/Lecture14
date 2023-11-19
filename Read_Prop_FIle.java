package com.Lecture14;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Read_Prop_FIle {
	public static SoftAssert sA;
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream ip;
	
	public static void main(String[] args) throws IOException {
		tNinjaLoginTest();
		//rediffLogin();
	}
	@Test(priority = 1)
	public static void tNinjaLoginTest() throws IOException {
		prop = new Properties();
		sA = new SoftAssert();
		ip = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\com\\Lecture14\\firstfile.properties");
		prop.load(ip);
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validusername"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validpassword"));
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		WebElement Logout = driver.findElement(By.linkText("Logout"));
		sA.assertTrue(Logout.isDisplayed(), "Element is not displayed");
		sA.assertAll();
	
	}
	@Test(priority = 2)
	public static void rediffLogin() throws IOException, InterruptedException {
		{
		
			prop = new Properties();
			sA = new SoftAssert();
			ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\java\\com\\Lecture14\\firstfile.properties");
			prop.load(ip);
			driver.get(prop.getProperty("urlR"));
			driver.findElement(By.linkText("Rediffmail")).click();
			driver.findElement(By.id("login1")).sendKeys(prop.getProperty("validusernameR"));
			driver.findElement(By.id("password")).sendKeys(prop.getProperty("validpasswordR"));
			driver.findElement(By.className("signinbtn")).click();
			WebElement LogoutR = driver.findElement(By.className("rd_logout"));
			sA.assertTrue(LogoutR.isDisplayed());
			sA.assertAll();
			driver.quit();
		}
	}
}
