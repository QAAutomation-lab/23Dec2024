package day8.keyboardAndMouseOps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import reusableComponent.GenericFunctions;

public class MouseExample4 {

	public static void main(String[] args) throws InterruptedException {
		GenericFunctions g1=new GenericFunctions();
		WebDriver driver=g1.setup("chrome");
		
		driver.get("https://jqueryui.com/draggable/");
		//moving control inside the frame
		driver.switchTo().frame(0);
		
		//create an instance of actions class and pass driver instance to its constructor
		Actions action=new Actions(driver);
		
		//first identify source and target
		WebElement src=driver.findElement(By.id("draggable"));

		
		action.dragAndDropBy(src, 300,0).build().perform();
	}
}


