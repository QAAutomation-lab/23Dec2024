package day8.multipleElementHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomDropdown {

	public static void main(String[] args) {
		WebDriver driver=setUp("chrome", "https://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		
		//identify dropdown
		driver.findElement(By.id("menu1")).click();
		//now use the same approach as we use to handle multiple elements
		List<WebElement> options=driver.findElements(By.cssSelector("ul.dropdown-menu>li>a"));
		System.out.println("Option count: "+options.size());
		for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
		}
		//to select any option
		options.get(2).click();
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

/**
 * Open browser and enter URL
 * Validate skill dropdown
 * 	- is this dropdown allow to select more than one option
 * 	- default value
 * 	- number of options
 * 	- print options
 * 	- select required option and validate that is selected or not
 */
