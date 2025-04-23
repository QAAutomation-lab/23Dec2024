package day3.syncexamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//0-30 sec
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//As login page takes time to load, our sprint will failed to identify username input field
		//to overcome this issue we need to use implicit wait, 0-30 sec
		WebElement usernameInputField=driver.findElement(By.name("username"));
		usernameInputField.sendKeys("Admin");
		//0-30sec
		WebElement passwordInputField=driver.findElement(By.name("password"));
		passwordInputField.sendKeys("admin123");
		//0-30sec
		WebElement loginButton=driver.findElement(By.className("orangehrm-login-button"));
		loginButton.click();
		
		String expectedUrl="dashboard";
		String actualUrl=driver.getCurrentUrl();//0-30sec
		
		System.out.println("Is login successful? "+actualUrl.contains(expectedUrl));
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