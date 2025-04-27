package orangeHrmTestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import orangehrmwebpages.DashboardPage;
import orangehrmwebpages.LoginPage;
import reusableComponent.SeleniumUtility;

public class OrangeHrmLoginLogout extends SeleniumUtility {
	WebDriver driver;
	LoginPage getLoginPage;
	DashboardPage getDashboardPage;
	
	@BeforeMethod
	public void precondition() {
		driver = setUp("chrome", "https://opensource-demo.orangehrmlive.com/");
		getLoginPage=new LoginPage(driver);
		getDashboardPage=new DashboardPage(driver);
	}

	@Test(priority=1)
	public void testLoginPage() {
		String actualUrl=getLoginPage.getLoginPageUrl();
		String expectedUrl="login";
		Assert.assertTrue(actualUrl.contains(expectedUrl),"Either login page not opened or url changed");
	}
	
	@Test(priority=2)
	public void testLoginLougoutOfOrangeHrm() {
		getLoginPage.loginIntoOrnageHrm("Admin", "admin123");
		String actualUrl=getDashboardPage.getDashboardPageUrl();
		String expectedUrl="dashboard";
		Assert.assertTrue(actualUrl.contains(expectedUrl),"Either login failed or dashboard url changed");
		getDashboardPage.logoutFromOrangeHRM();
	}
	
	@AfterMethod
	public void postCondition() {
		driver.quit();
	}
}
