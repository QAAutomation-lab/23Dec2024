package day11.exdentreport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import reusableComponent.SeleniumUtility;

public class ActitimeLoginValidation extends SeleniumUtility {

	ExtentReports extentReports;
	ExtentTest extentTest;
	boolean result;
	
	@BeforeClass
	public void precondition() {
		extentReports=new ExtentReports(".\\ExtentReport\\TestReport.html");
		extentTest=extentReports.startTest("TestingActitimeLogin");
	}
	
	@Test
	public void testActitimeLogin() {
		setUp("chrome", "https://online.actitime.com/dec23/login.do");
		String expectedTitle="actiTIME - Login";
		String actualTitle=getCurrentTitleOfApplication();
		result=actualTitle.equals(expectedTitle);
		Assert.assertTrue(result, "Login validation failed");
	}	
	
	@AfterClass
	public void postcondition() {
		
		if(result) {
			extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(screenShot(driver)), "Login validation is successfull");
		}else {
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenShot(driver)), "Login validation is not successfull");
		}		
		extentReports.endTest(extentTest);
		extentReports.flush();
	}
	public static String screenShot(WebDriver driver) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../BStackImages/" + System.currentTimeMillis()+ ".png");
		String errflpath = Dest.getAbsolutePath();
		try {
			FileUtils.copyFile(scrFile, Dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return errflpath;
		}
}
