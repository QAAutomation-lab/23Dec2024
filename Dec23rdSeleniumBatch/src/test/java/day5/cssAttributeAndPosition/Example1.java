package day5.cssAttributeAndPosition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Example1 {
	public static void main(String[] args) {
		WebDriver driver=setUp("chrome", "https://online.actitime.com/dec23/login.do");
		
		driver.findElement(By.id("loginButton")).click();
		
		String expectedError="Username or Password is invalid. Please try again.";
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBe(By.className("errormsg"), expectedError));
		
		WebElement errorMsg=driver.findElement(By.className("errormsg"));
		String actualErrorMsg=errorMsg.getText();
		System.out.println("Error msg validation : "+actualErrorMsg.equals(expectedError));
		System.out.println("Error msg color: "+errorMsg.getCssValue("color"));//color might come in hexa/RGBA form
		System.out.println("Error msg font size: "+errorMsg.getCssValue("font-size"));
		System.out.println("Error msg font color: "+errorMsg.getCssValue("font-family"));
		//position check
		Point errorMsgLocation=errorMsg.getLocation();
		int error_x=errorMsgLocation.getX();
		int error_y=errorMsgLocation.getY();
		System.out.println("Error msg x-cords: "+error_x);
		System.out.println("Error msg y-cords: "+error_y);
		
		WebElement usernameInputField=driver.findElement(By.id("username"));
		Point usernameLocation=usernameInputField.getLocation();
		int username_x=usernameLocation.getX();
		int username_y=usernameLocation.getY();
		System.out.println("usernameInputField x-cords: "+username_x);
		System.out.println("usernameInputField y-cords: "+username_y);
		
		System.out.println("is error msg displayed above username input field? "+(error_y<username_y));
	}
	
	public static WebDriver setUp(String browserName,String appUrl) {
		WebDriver driver=null;
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(appUrl);
		return driver;
	}
}
/*
Open browser, enter app URL
click on login button
validate 
	error msg text
	error msg color
	error msg font size
	error msg font family
	error msg is getting displayed above username field


*/