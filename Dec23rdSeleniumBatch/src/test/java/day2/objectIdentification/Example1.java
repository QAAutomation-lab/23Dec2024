package day2.objectIdentification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example1 {

	public static void main(String[] args) {
		/*open browser*/
		WebDriver driver=new ChromeDriver();
		/*enter url*/
		driver.get("https://www.saucedemo.com/");
		
		/*identify username input field*/
		WebElement usernameInputField=driver.findElement(By.id("user-name"));
		/*enter username*/
		usernameInputField.sendKeys("standard_user");
		
		/*identify password input field*/
		WebElement passwordInputField=driver.findElement(By.id("password"));
		/*enter password*/
		passwordInputField.sendKeys("secret_sauce");
		
		/*identify login input field*/
		WebElement loginButton=driver.findElement(By.id("login-button"));
		/*click on login button*/
		loginButton.click();
		
		/*Validate home page with url*/
		String expectedUrl="https://www.saucedemo.com/inventory.html";
		String actualUrl=driver.getCurrentUrl();
		System.out.println("is login successful? "+actualUrl.equals(expectedUrl));
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
	- enter application url as https://www.saucedemo.com/
	- enter username as "standard_user"
	- enter password as "secret_sauce"
	- click on login button
	- validation home page
*/