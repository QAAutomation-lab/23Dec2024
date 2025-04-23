package day3.syncexamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserOps {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//0-30 sec
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//maximize browser window - fill screen
		driver.manage().window().maximize();
		//set browser window based on required size
		driver.manage().window().setSize(new Dimension(500, 300));
		//to minimize browser window
		driver.manage().window().minimize();
		//maximize browser window - fill screen
		driver.manage().window().maximize();
		
//		WebElement link=driver.findElement(By.className("orangehrm-login-forgot"));
//		link.click();
			//or
		driver.findElement(By.className("orangehrm-login-forgot")).click();
		
		System.out.println("Forgot password page url: "+driver.getCurrentUrl());
		
		//go back to login page
		driver.navigate().back();
		System.out.println("Login page url: "+driver.getCurrentUrl());
		
		//go to forgot password page
		driver.navigate().forward();
		System.out.println("Forgot password page url: "+driver.getCurrentUrl());
		
		//reload current page
		driver.navigate().refresh();
		
		//need to move to another url
		driver.navigate().to("https://www.google.com");
	}

}
