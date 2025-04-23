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

public class DropdownExample1 {

	public static void main(String[] args) {
		WebDriver driver=setUp("chrome", "https://demo.automationtesting.in/Register.html");
		
		//identify dropdown
		WebElement dropdown=driver.findElement(By.id("Skills"));
		//create instance of Select class
		Select slt=new Select(dropdown);
		
		System.out.println("is dropdown allow multiple selection? "+slt.isMultiple());
		System.out.println("Default value: "+slt.getFirstSelectedOption().getText());
		List<WebElement> optionList=slt.getOptions();
		System.out.println("List option count: "+optionList.size());
		for(int i=0;i<optionList.size();i++) {
			System.out.println(optionList.get(i).getText());
		}
		/*to select option we can use 
		- selectByVisibleText("");
		- selectByValue("");
		- selectByIndex("")
		*/
		//slt.selectByIndex(2); //or
		//slt.selectByValue("Adobe Photoshop");//or
		slt.selectByVisibleText("Adobe Photoshop");		
		System.out.println("is Default selection changed to 'Adobe Photoshop'? : "+slt.getFirstSelectedOption().getText());
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
