package day2.objectIdentification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example2 {

	public static void main(String[] args) {
		/*open browser*/
		WebDriver driver=new ChromeDriver();
		/*enter url*/
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");
		
		/*identify username input field*/
		WebElement usernameInputField=driver.findElement(By.id("username"));
		/*delete existing text*/
		usernameInputField.clear();
		/*enter username*/
		usernameInputField.sendKeys("admin");
		
		/*identify password input field*/
		WebElement passwordInputField=driver.findElement(By.id("password"));
		/*delete existing text*/
		passwordInputField.clear();
		/*enter password*/
		passwordInputField.sendKeys("admin");
		
		/*identify login input field*/
		WebElement loginButton=driver.findElement(By.className("buttonBlue"));
		/*click on login button*/
		loginButton.click();
		
		/*Validate home page with title*/
		String expectedTitle="Dashboard";
		String actualTitle=driver.getTitle();
		System.out.println("is login successful? "+actualTitle.equals(expectedTitle));
	}
}
/*
findElement(By)- this will help you to identify required element and return in the form of WebElement
	- this method contains argument of type By class, this call has various static methods to locate the element
	  thats why these method are also known as locators in selenium
	
	WebElement element=driver.findElement(By.____);
											.id(String)
											.name(String)
											.linkText(String)
											.partialLinkText(String)
											.className(String)
											.tagName(String)
											.cssSelector(String)
											.xpath(String)
	
	WebElement element=driver.findElement(By.id(""));
	
	Once element is identified you can perform any required operation on WebElement like-
		element.sendKeys(String): need to type some text
		element.click(): want to click on link/button/image/checkbox/radiobutton
		element.clear(): want to delete existing text from the text field
*/

/*
WASS to perform below operation 
	- open any browser
	- enter application url as https://demo.vtiger.com/vtigercrm/index.php
	- clear existing text and enter username as "Admin"
	- clear existing text and enter password as "Admin"
	- click on login button
	- validation home page
*/