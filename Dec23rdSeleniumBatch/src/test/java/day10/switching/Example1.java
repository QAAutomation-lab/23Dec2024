package day10.switching;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import reusableComponent.SeleniumUtility;

public class Example1 extends SeleniumUtility{

	public static void main(String[] args) {
		Example1 ref=new Example1();
		ref.testActiveElementFromApplication();
		ref.testLoginWithoutIdentifyingAnyElement();
	}
	public void testActiveElementFromApplication() {
		driver=setUp("chrome", "https://demowebshop.tricentis.com/login");
		//get element on which current we have focus
		WebElement element= driver.switchTo().activeElement();		
		String actual=getRequiredAttributeValue(element, "name");
		String expected="Email";
		System.out.println("Is mouse pointer in emailid input field? "+actual.equals(expected));
		driver.quit();	
	}
	
	public void testLoginWithoutIdentifyingAnyElement() {
		driver=setUp("chrome", "https://demowebshop.tricentis.com/login");
		//get element on which current we have focus
		driver.switchTo().activeElement().sendKeys("tester01@vomoto.com",Keys.TAB);
		driver.switchTo().activeElement().sendKeys("Abc@12345",Keys.ENTER);
		driver.quit();
	}
}
