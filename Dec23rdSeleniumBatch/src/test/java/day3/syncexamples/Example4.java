package day3.syncexamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Example4 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//0-30 sec
		driver.get("https://online.actitime.com/dec23/login.do");
		//As login page takes time to load, our sprint will failed to identify username input field
		//to overcome this issue we need to use implicit wait, 0-30 sec
		WebElement usernameInputField=driver.findElement(By.id("username"));
		usernameInputField.sendKeys("admin01");
		//0-30sec
		WebElement passwordInputField=driver.findElement(By.name("pwd"));
		passwordInputField.sendKeys("admin01");
		//0-30sec
		WebElement loginButton=driver.findElement(By.id("loginButton"));
		loginButton.click();
		
		String expectedTitle="actiTIME - Enter Time-Track";
		
		//explicit wait- FluentWait
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(30))//total waiting time
					.pollingEvery(Duration.ofSeconds(5))//retry time
					.ignoring(NoSuchElementException.class);//exception to ignore if it comes
		
		//now you can implement required condition based on the need
		wait.until(ExpectedConditions.titleIs(expectedTitle));
		
		String actualTitle=driver.getTitle();//0-30sec
		System.out.println("Actual Home page title: "+actualTitle);
		System.out.println("Is login successful? "+actualTitle.equals(expectedTitle));
		
		//wait for logout link
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logoutLink")));
		
		WebElement logoutLink=driver.findElement(By.id("logoutLink"));
		logoutLink.click();
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
	- logout from application
1. https://online.actitime.com/dec23/login.do
*/