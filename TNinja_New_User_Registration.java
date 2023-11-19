package com.Lecture14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TNinja_New_User_Registration {
WebDriver driver;
SoftAssert sA;

@BeforeMethod
public void openUrl() {
	driver = new ChromeDriver();
	sA = new SoftAssert();
	driver.manage().deleteAllCookies();
	driver.manage().window().fullscreen();
}
	@Test(dataProvider = "TNinja1" , dataProviderClass = TNinja_TestData.class)
	public void RegistrationCheck(String firstname, String lastname,String email,String telephone,String password, String cpassword) throws InterruptedException {
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		driver.findElement(By.id("input-firstname")).sendKeys(firstname);
		driver.findElement(By.id("input-lastname")).sendKeys(lastname);
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.id("input-confirm")).sendKeys(cpassword);
		driver.findElement(By.cssSelector("div.pull-right:nth-child(1) > input:nth-child(2)")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		WebElement Logout = driver.findElement(By.linkText("Logout"));
		sA.assertTrue(Logout.isDisplayed(), "Element is not displayed");
		sA.assertAll();
		
	}
@AfterMethod
public void tearDown() {
	//if(result.getStatus() == ITestResult.SUCCESS || result.getStatus() == ITestResult.FAILURE) {
	//File screenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//FileUtils.copyFile(screenshotFile, new File("./ScreenShots/" + result.getMethod().getMethodName() + ".png"));
	
	driver.quit();
}
}
