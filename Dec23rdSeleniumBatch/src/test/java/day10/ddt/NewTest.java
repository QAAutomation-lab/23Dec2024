package day10.ddt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import reusableComponent.ExcelUtility;
import reusableComponent.SeleniumUtility;

public class NewTest extends SeleniumUtility {

	String url,userName,password,expectTitle,actualTitle,status;
	@BeforeTest
	public void precondition() {
		 url=ExcelUtility.getCellValue(".\\src\\test\\resources\\testData\\AppData.xlsx", "TC", 1, 0);
		 userName=ExcelUtility.getCellValue(".\\src\\test\\resources\\testData\\AppData.xlsx", "TC", 1, 1);
		 password=ExcelUtility.getCellValue(".\\src\\test\\resources\\testData\\AppData.xlsx", "TC", 1, 2);
		 expectTitle=ExcelUtility.getCellValue(".\\src\\test\\resources\\testData\\AppData.xlsx", "TC", 1, 3);
		 driver=setUp("chrome", url);
	}

	@Test
	public void testActitimeLogin() {
		typeInput(driver.findElement(By.id("username")),userName);
		typeInput(driver.findElement(By.name("pwd")),password);
		clickOnElement(driver.findElement(By.id("loginButton")));
		
		actualTitle=getCurrentTitleOfApplication(expectTitle);
		if(actualTitle.equals(expectTitle)) {
			status="PASS";
		}else {
			status="FAIL";
		}
		Assert.assertEquals(actualTitle,expectTitle, "Either login failed or page title got changed....");
	}
	@AfterTest
	public void postCondition() {
		ExcelUtility.updateCellValue(".\\src\\test\\resources\\testData\\AppData.xlsx", "TC", 1,4 , actualTitle);
		ExcelUtility.updateCellValue(".\\src\\test\\resources\\testData\\AppData.xlsx", "TC", 1,5 , status);
		driver.quit();
	}

}
//Data should be taken from Excel and result should be update on excel