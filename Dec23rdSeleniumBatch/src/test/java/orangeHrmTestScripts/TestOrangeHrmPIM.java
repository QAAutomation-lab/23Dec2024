package orangeHrmTestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import orangehrmwebpages.AddEmployeePage;
import orangehrmwebpages.DashboardPage;
import orangehrmwebpages.LoginPage;
import orangehrmwebpages.PersonalDetailsPage;
import orangehrmwebpages.PimHomePage;
import reusableComponent.SeleniumUtility;

public class TestOrangeHrmPIM extends SeleniumUtility{
	
	WebDriver driver;
	LoginPage getLoginPage;
	DashboardPage getDashboardPage;
	PersonalDetailsPage getPersonalDetailsPage;
	PimHomePage getPimHomePage;
	AddEmployeePage getAddEmployeePage;
	
	
	@BeforeTest
	public void openBrowser() {
		driver = setUp("chrome", "https://opensource-demo.orangehrmlive.com/");
		getLoginPage=new LoginPage(driver);
		getDashboardPage=new DashboardPage(driver);
		getPersonalDetailsPage=new PersonalDetailsPage(driver);
		getPimHomePage =new PimHomePage(driver);
		getAddEmployeePage =new AddEmployeePage(driver);
	}

	@BeforeMethod
	public void loginIntoOrangeHrm() {
		getLoginPage.loginIntoOrnageHrm("Admin", "admin123");
	}

	@Test(priority = 1)
	public void testPimCreation() {
	}

	@Test(priority = 2)
	public void testPimUpdate() {
	}

	@Test(priority = 3)
	public void testPimDelete() {
	}

	@AfterMethod
	public void logoutFromOrangeHrm() {
		getDashboardPage.logoutFromOrangeHRM();
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
