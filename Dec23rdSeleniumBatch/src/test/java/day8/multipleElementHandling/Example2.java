package day8.multipleElementHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Example2 {

	public static void main(String[] args) {
		WebDriver driver=setUp("chrome", "https://demo.automationtesting.in/Register.html");
		
		//identify all menu present in menu bar in the page using findElement(By) method
		List<WebElement> menuList=driver.findElements(By.cssSelector(".navbar-nav>li>a"));
		System.out.println("Number of menu items: "+menuList.size());
		for(int i=0;i<menuList.size();i++) {
			WebElement element=menuList.get(i);
			String href=element.getText();
			System.out.println(i+ " Menu name: "+href);
				//or
			//System.out.println("Menu name: "+menuList.get(i).getText());
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
