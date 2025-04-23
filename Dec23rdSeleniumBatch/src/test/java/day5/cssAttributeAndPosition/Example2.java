package day5.cssAttributeAndPosition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Example2 {

	public static void main(String[] args) {
		WebDriver driver=setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//As login page takes time to load, our sprint will failed to identify username iput field
		WebElement usernameInputField=driver.findElement(By.name("username"));
		usernameInputField.sendKeys("Admin");
		
		WebElement passwordInputField=driver.findElement(By.name("password"));
		passwordInputField.sendKeys("admin123");
		
		WebElement loginButton=driver.findElement(By.className("orangehrm-login-button"));
		loginButton.click();
		
		driver.findElement(By.cssSelector(".oxd-userdropdown-img")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	public static WebDriver setUp(String browserName,String appUrl) {
		WebDriver driver=null;
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(appUrl);
		return driver;
	}
}
