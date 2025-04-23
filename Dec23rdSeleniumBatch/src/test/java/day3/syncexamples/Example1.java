package day3.syncexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//As login page takes time to load, our sprint will failed to identify username iput field
		WebElement usernameInputField=driver.findElement(By.name("username"));
		usernameInputField.sendKeys("Admin");
		
		WebElement passwordInputField=driver.findElement(By.name("password"));
		passwordInputField.sendKeys("admin123");
		
		WebElement loginButton=driver.findElement(By.className("orangehrm-login-button"));
		loginButton.click();
		
		String expectedUrl="dashboard";
		String actualUrl=driver.getCurrentUrl();
		
		System.out.println("Is login successful? "+actualUrl.concat(expectedUrl));
	}

}
/*
WASS to perform below operation 
	- open any browser
	- enter application url(below url)
	- clear existing text and enter username as "Admin"
	- clear existing text and enter password as "Admin"
	- click on login button
	- validation home page
1. https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
*/