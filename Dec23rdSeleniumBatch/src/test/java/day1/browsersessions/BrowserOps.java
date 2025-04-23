package day1.browsersessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserOps {

	public static void main(String[] args) {
		//open browser- chorme
		WebDriver driver=new ChromeDriver();
		//enter require application URL
		driver.get("https://www.google.com");
		//get application title using getTitle() that will return title in String form
		String actualTitle=driver.getTitle();
		String expectedTitle="Google";
		System.out.println("Application title: "+actualTitle);
		System.out.println("No of char in Application title: "+actualTitle.length());
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Application opened, Test Case");
		}else {
			System.out.println("Application not opened, Test Case failed");
		}
		//get application current title url using getCurrentUrl() that will return url in String form
		System.out.println("Current url: "+driver.getCurrentUrl());
		//get application page source code using getPageSource() that will return in String form
		String source=driver.getPageSource();
		System.out.println("Source code size: "+source.length());
		//close current browser instance
		driver.close();
	}
}
