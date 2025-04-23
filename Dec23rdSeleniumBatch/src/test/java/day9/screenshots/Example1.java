package day9.screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import reusableComponent.SeleniumUtility;

public class Example1 extends SeleniumUtility{

	public static void main(String[] args) throws IOException {
		Example1 ref=new Example1();
		ref.takeScreenshotOfGooglePage();
	}

	void takeScreenshotOfGooglePage() throws IOException {
		WebDriver driver=setUp("chrome", "https://www.google.com");
		//convert driver instance into TakesScreenshot interface
		TakesScreenshot ts=(TakesScreenshot)driver;
		//get screenshot into required format
		File screenshot=ts.getScreenshotAs(OutputType.FILE);
		//save above screenshot into the required location
		FileUtils.copyFile(screenshot, new File(".\\src\\test\\resources\\Screenshots\\Google.jpg"));
	}
}
