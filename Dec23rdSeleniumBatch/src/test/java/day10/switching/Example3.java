package day10.switching;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import reusableComponent.SeleniumUtility;

public class Example3 extends SeleniumUtility{

	public static void main(String[] args) {
		Example3 ref=new Example3();
		//ref.testJavaScriptAlertPopup();
		//ref.testJavaScriptConfirmationPopup();
		ref.testJavaScriptPromptPopup();
	}
	
	
	public void testJavaScriptAlertPopup() {
		/*
		 * Write a script to click on selectable and select item4 dn click logo
		 */
		driver=setUp("chrome", "https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		driver.switchTo().frame("iframeResult");
		clickOnElement(driver.findElement(By.xpath("//button[text()='Try it']")));
		System.out.println("Alert msg: "+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	
	
	public void testJavaScriptConfirmationPopup() {
		/*
		 * Write a script to click on selectable and select item4 dn click logo
		 */
		driver=setUp("chrome", "https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.switchTo().frame("iframeResult");
		clickOnElement(driver.findElement(By.xpath("//button[text()='Try it']")));
		System.out.println("Alert msg: "+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();
		System.out.println("Alert selection result: "+getTextFromElement(driver.findElement(By.id("demo"))));
	}
	
	
	public void testJavaScriptPromptPopup() {
		/*
		 * Write a script to click on selectable and select item4 dn click logo
		 */
		driver=setUp("chrome", "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.switchTo().frame("iframeResult");
		clickOnElement(driver.findElement(By.xpath("//button[text()='Try it']")));
		System.out.println("Alert msg: "+driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("Pune");
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		System.out.println("Alert selection result: "+getTextFromElement(driver.findElement(By.id("demo"))));
	}
	
}
