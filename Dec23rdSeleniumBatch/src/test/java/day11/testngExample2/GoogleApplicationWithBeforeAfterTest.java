package day11.testngExample2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import reusableComponent.SeleniumUtility;


public class GoogleApplicationWithBeforeAfterTest extends SeleniumUtility {

	WebDriver driver;
	@BeforeTest
	public void startUp() {
		driver = setUp("chrome", "https://www.google.com/");
	}
	@Test(priority=1)
	public void testGoogleLandingPage() {
		String expectedTitle = "Google";
		String actualTitle = getCurrentTitleOfApplication();
		Assert.assertEquals(actualTitle, expectedTitle, "Google Search page not opened or its title got changed");
	}
	@Test(priority=2)
	public void testSearch() {
		driver.findElement(By.name("q")).sendKeys("SQL", Keys.ENTER);
		Assert.assertTrue(getCurrentTitleOfApplication("SQL").contains("SQL"), "SQL search is failed");
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
/*
	Pre-condition: for all test cases open browser and enter application url once
		TC1: validation google search page opened or not
		TC2: search SQL and validate SQL search page opened or not
	Post-condition: once all the test cases are executed close the browser
*/