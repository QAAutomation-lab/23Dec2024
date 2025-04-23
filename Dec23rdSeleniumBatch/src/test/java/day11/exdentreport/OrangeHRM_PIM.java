package day11.exdentreport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import reusableComponent.SeleniumUtility;

public class OrangeHRM_PIM extends SeleniumUtility {

	ExtentReports extentReports;
	ExtentTest extentTest;
	boolean result;
	
	@BeforeClass
	public void precondition() {
		extentReports=new ExtentReports(".\\ExtentReport\\OrangeHrmPIM.html");
	}
	
	@BeforeMethod
	public void startUp() {
		//setup
		//login
		//navigate to Orange HRM PIM page
	}
	
	@Test
	public void testPimCreation() {
		extentTest=extentReports.startTest("OrangrHRM_PIM_Creation");
		//Code to create PIM and validate
	}	
	
	@Test
	public void testPimUpdate() {
		extentTest=extentReports.startTest("OrangrHRM_PIM_Update");
		//Code to update PIM and validate
	}	
	
	@Test
	public void testPimDelete() {
		extentTest=extentReports.startTest("OrangrHRM_PIM_Delete");
		//Code to delete PIM and validate
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {		
		if(result.getStatus() == ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(screenShot(driver)), "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}else if(result.getStatus() == ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS,extentTest.addScreenCapture(screenShot(driver)), "Test Case pass is "+result.getName());
		}
		extentReports.endTest(extentTest);
	}
	
	@AfterClass
	public void postcondition() {		
		
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
