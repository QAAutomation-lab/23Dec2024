package day11.advancetestng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import reusableComponent.SeleniumUtility;


public class DataProviderExample2 extends SeleniumUtility {


	@Test(dataProvider = "getTextForSearch")
	public void testGoogleSearch(String textToBeSearched) {
		setUp("chrome", "https://www.google.com");
		typeInput(driver.findElement(By.name("q")), textToBeSearched);
		getActiveElementFromUI().sendKeys(Keys.ENTER);
		driver.quit();
	}
	
	@DataProvider
	public Object[] getTextForSearch() {
		Object[] obj= {"Selenium","Manual Testing","API Testing"};
		return obj;
	}
}
/**
Create a method with return type as Multidimension array of Object type
and also add @DataProvider tag
*/