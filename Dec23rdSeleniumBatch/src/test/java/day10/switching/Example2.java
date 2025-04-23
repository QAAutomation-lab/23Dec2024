package day10.switching;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import reusableComponent.SeleniumUtility;

public class Example2 extends SeleniumUtility{

	public static void main(String[] args) {
		Example2 ref=new Example2();
		//ref.testFrameSwitchingWithElement();
		ref.testFrameSwitchingWithIndex();
	}

	public void testFrameSwitchingWithElement() {
		/*
		 * Write a script to click on selectable and select item4 dn click logo
		 */
		driver=setUp("chrome", "https://jqueryui.com/");
		
		clickOnElement(driver.findElement(By.linkText("Selectable")));
		//as Item4 present inside the frame,so we need to take our control inside the frame
		WebElement frame=driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(frame);
		clickOnElement(driver.findElement(By.xpath("//li[text()='Item 4']")));
		//in order to move control back to main page use
		driver.switchTo().defaultContent();
		clickOnElement(driver.findElement(By.cssSelector(".logo")));
	}

	public void testFrameSwitchingWithIndex() {
		/*
		 * Write a script to click on selectable and select item4 dn click logo
		 */
		driver=setUp("chrome", "https://jqueryui.com/");
		
		clickOnElement(driver.findElement(By.linkText("Selectable")));
		//as Item4 present inside the frame,so we need to take our control inside the frame
		driver.switchTo().frame(0);
		clickOnElement(driver.findElement(By.xpath("//li[text()='Item 4']")));
		//in order to move control back to main page use
		driver.switchTo().defaultContent();
		clickOnElement(driver.findElement(By.cssSelector(".logo")));
	}
	
}
