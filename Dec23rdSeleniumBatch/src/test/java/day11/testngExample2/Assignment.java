package day11.testngExample2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment {

	@BeforeTest
	public void openBrowser() {
		
	}
	
	@BeforeMethod
	public void loginAndNavigateToPimPage() {
		
	}
	
	@Test(priority=1)
	public void createPim() {
		
	}
	
	@Test(priority=2, dependsOnMethods = "createPim")
	public void updatePim() {
		
	}
	
	@Test(priority=3, dependsOnMethods = "createPim")
	public void deletePim() {
		
	}
	
	
	@AfterMethod
	public void logout() {
		
	}
	@AfterTest
	public void closeBrowser() {
		
	}
}
