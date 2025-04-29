package testscripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.GoogleHomePage;
import pages.GoogleSearchedPage;
import reusableComponent.SeleniumUtility;



public class GoogeTest extends SeleniumUtility{
	
	GoogleHomePage getGoogleHomePage;
	GoogleSearchedPage getGoogleSearchedPage;
	WebDriver driver;
	@BeforeMethod
	public void precondition() {
		driver=setUp("chrome", "https://www.google.com");
		getGoogleHomePage=new GoogleHomePage(driver);
		getGoogleSearchedPage=new GoogleSearchedPage(driver);
	}

		@Test
		public void testGoogleSearchPage() {
			String actualTitle=getGoogleHomePage.getHomePageTitle();
			Assert.assertEquals(actualTitle, "Google");
			
		}
		
		@Test
		public void testGoogleSuggestionCount() {
			getGoogleHomePage.typeRequiredTextToSearch("Selenium");
			int count=getGoogleHomePage.getSuggestionCount();
			Assert.assertEquals(count, 10);
		}
		
		@Test
		public void testSuggestionSelection() {
			getGoogleHomePage.typeRequiredTextToSearch("Selenium");
			getActitveElement().sendKeys(Keys.ENTER);
			String text=getGoogleSearchedPage.getSearchedTextFromUi();
			Assert.assertEquals(text, "Selenium");
		}
		
		@AfterMethod
		public void postCondition() {
			driver.quit();
		}
}
