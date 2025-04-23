package day7.propertyfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Example1 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testData\\AppData.properties");
		Properties prop=new Properties();
		prop.load(fis);
	
		WebDriver driver=setUp(prop.getProperty("browsername"), prop.getProperty("url"));
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("pwd")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("loginButton")).click();
		
		String expectedTitle=prop.getProperty("expectedTitle");
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleIs(expectedTitle));
		String actualTitle=driver.getTitle();
		System.out.println("is login done? "+actualTitle.equals(expectedTitle));

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
