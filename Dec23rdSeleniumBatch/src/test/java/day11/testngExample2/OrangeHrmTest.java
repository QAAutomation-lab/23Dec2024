package day11.testngExample2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import reusableComponent.SeleniumUtility;

public class OrangeHrmTest extends SeleniumUtility {

	@Test(priority = 1, enabled = false)
	public void testLoginWithOutAssert() {
		setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		typeInput(driver.findElement(By.name("username")), "Admin");
		typeInput(driver.findElement(By.name("password")), "admin123");
		clickOnElement(driver.findElement(By.cssSelector(".orangehrm-login-button")));
		String expectedUrl="Dashboard";
		String actualUrl=getCurrentUrlOfApplication();
		System.out.println(actualUrl.contains(expectedUrl));
	}
	
	@Test(priority = 2)
	public void testLoginWithAssert1() {
		setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		typeInput(driver.findElement(By.name("username")), "Admin");
		typeInput(driver.findElement(By.name("password")), "admin123");
		clickOnElement(driver.findElement(By.cssSelector(".orangehrm-login-button")));
		String expectedUrl="Dashboard";
		String actualUrl=getCurrentUrlOfApplication();
		//System.out.println(actualUrl.contains(expectedUrl));
		//Assert.assertTrue(actualUrl.contains(expectedUrl));
		Assert.assertTrue(actualUrl.contains(expectedUrl),"Either application url got changed or login failed");
	}
	
	@Test(priority = 3)
	public void testLoginWithAssert2() {
		setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		typeInput(driver.findElement(By.name("username")), "Admin");
		typeInput(driver.findElement(By.name("password")), "admin123");
		clickOnElement(driver.findElement(By.cssSelector(".orangehrm-login-button")));
		String expectedUrl="dashboard";
		String actualUrl=getCurrentUrlOfApplication();
		//System.out.println(actualUrl.contains(expectedUrl));
		Assert.assertTrue(actualUrl.contains(expectedUrl));
		driver.quit();
	}
	
	@Test(priority = 4)
	public void testLoginWithAssert3() {
		setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		typeInput(driver.findElement(By.name("username")), "Admin");
		typeInput(driver.findElement(By.name("password")), "admin123");
		clickOnElement(driver.findElement(By.cssSelector(".orangehrm-login-button")));
		String expectedUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String actualUrl=getCurrentUrlOfApplication();
		//System.out.println(actualUrl.contains(expectedUrl));
		//Assert.assertEquals(actualUrl,expectedUrl);
		Assert.assertEquals(actualUrl,expectedUrl,"Either home page url changed or login failed..");
		driver.quit();
	}
	
	@BeforeSuite
	public void beforeSuiteTest() {
		System.out.println("***************BeforeSuite*****************");
	}
	@AfterSuite
	public void afterSuiteTest() {
		System.out.println("***************AfterSuite*****************");
	}
}
/*
Validation should be done using Assert class
	assertEquals(arg1,arg2)
	assertEquals(arg1,arg2,"Msg")
	
	assertTrue(boolean)
	assertTrue(boolean,"Msg")
	
	assertFalse(boolean);
	assertFalse(boolean,"Msg");
*/