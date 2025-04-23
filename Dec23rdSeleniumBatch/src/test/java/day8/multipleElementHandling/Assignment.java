package day8.multipleElementHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment {

	public static void main(String[] args) {
		WebDriver driver=setUp("chrome", "https://www.gsmarena.com/");
		
		driver.findElement(By.cssSelector(".brandmenu-v2>ul>li:nth-of-type(1)>a")).click();
		List<WebElement> deviceList=driver.findElements(By.cssSelector(".makers>ul>li>a>strong>span"));
		for(int i=0;i<deviceList.size();i++) {
			System.out.println(deviceList.get(i).getText());
		}
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
/*
TC1:
Write a script to print device name and price from the application https://www.demoblaze.com/

TC2:
Write a script to print brand names present inside phone finder https://www.gsmarena.com/

TC3:
Open browser and enter application url as https://www.gsmarena.com/
click on Samsung link present inside phone finder
print device name

TC4: 
Open Browser and enter google url
type Selenium
get all suggestion count and print it
print suggestion name one by one

TC5:
login into https://demowebshop.tricentis.com/
tester01@vomoto.com & Abc@12345
print product name and price
*/