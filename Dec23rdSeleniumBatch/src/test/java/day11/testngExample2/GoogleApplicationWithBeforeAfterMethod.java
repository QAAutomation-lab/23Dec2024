package day11.testngExample2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import reusableComponent.SeleniumUtility;

public class GoogleApplicationWithBeforeAfterMethod extends SeleniumUtility {
	WebDriver driver;
	@BeforeMethod
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
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

/*
Pre-condition: before each test case open browser and enter application url
	TC1: validation google search page opened or not
	TC2: search SQL and validate SQL search page opened or not
Post-condition: after each test cases execution close the browser
*/
