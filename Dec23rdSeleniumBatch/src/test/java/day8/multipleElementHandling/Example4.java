package day8.multipleElementHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Example4 {

	public static void main(String[] args) {
		WebDriver driver=setUp("chrome", "https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		
		//identify all menu present in menu bar in the page using findElement(By) method
		List<WebElement> suggList=driver.findElements(By.cssSelector(".G43f7e>li>div>*:nth-child(2)>*:first-child>*:first-child>span"));
		System.out.println("Number of suggList: "+suggList.size());
		for(int i=0;i<suggList.size();i++) {
			//re-identify the Suggestion list to avoid StaleElementException
			suggList=driver.findElements(By.cssSelector(".G43f7e>li>div>*:nth-child(2)>*:first-child>*:first-child>span"));
			WebElement element=suggList.get(i);
			String deviceName=element.getText();
			System.out.println(i+ " Suggestion: "+deviceName);
				//or
			//System.out.println("deviceList name: "+deviceList.get(i).getText());
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
