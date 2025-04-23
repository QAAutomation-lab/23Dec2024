package day10.jsexample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import reusableComponent.SeleniumUtility;
public class Example2 extends SeleniumUtility{
	
	public static void main(String[] args) {
		Example2 e1=new Example2();
		e1.testCase1();
	}

	public void testCase1() {
		WebDriver driver=setUp("chrome", "https://online.actitime.com/dec23/login.do");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//identifying elements from the UI using JavaScript and typing required value in it
		js.executeScript("document.getElementById('username').value='admin01'");
		
		//identifying elements from the UI using JavaScript and typing required value in it
		js.executeScript("document.getElementsByName('pwd')[0].value='admin01'");
		
		//identifying elements from the UI using JavaScript and click on it
		js.executeScript("document.getElementById('loginButton').click();");
		
//		WebElement element=driver.findElement(By.id("loginButton"));
//		element.click();
//		js.executeScript("arguments[0].click();", element);
	}
}
