package day7.propertyfile;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownExample3 {

	public static void main(String[] args) {
		WebDriver driver=setUp("chrome", "https://demo.automationtesting.in/Register.html");
		
		//identify dropdown
		WebElement dropdown=driver.findElement(By.id("yearbox"));
		//create instance of Select class
		Select slt=new Select(dropdown);
		List<WebElement> optionList=slt.getOptions();
		System.out.println("List option count: "+optionList.size());
		
		List<Integer> actualYearList=new ArrayList<Integer>();
		for(int i=1;i<optionList.size();i++) {
			actualYearList.add(Integer.parseInt(optionList.get(i).getText()));
		}		
		List<Integer> expectedYearList=new ArrayList<Integer>(actualYearList);
		Collections.sort(expectedYearList);		
		System.out.println("are years getting displayed as expected? "+actualYearList.equals(expectedYearList));
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
