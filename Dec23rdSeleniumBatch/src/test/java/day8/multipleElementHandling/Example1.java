package day8.multipleElementHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Example1 {

	public static void main(String[] args) {
		WebDriver driver=setUp("chrome", "https://www.demoblaze.com/");
		
		//identify number links present in the page using findElement(By) method
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Number of links in the page: "+links.size());
		for(int i=0;i<links.size();i++) {
			WebElement element=links.get(i);
			String href=element.getAttribute("href");
			System.out.println(i+ " Href: "+href);
				//or
			//System.out.println("Href: "+links.get(i).getAttribute("href"));
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
