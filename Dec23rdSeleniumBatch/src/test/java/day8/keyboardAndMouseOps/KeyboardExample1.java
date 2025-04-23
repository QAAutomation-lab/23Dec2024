package day8.keyboardAndMouseOps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import reusableComponent.GenericFunctions;

public class KeyboardExample1 {

	public static void main(String[] args) throws InterruptedException {
		GenericFunctions g1=new GenericFunctions();
		WebDriver driver=g1.setup("chrome");
		
		driver.get("https://online.actitime.com/dec23/login.do");
		//type user name
		driver.findElement(By.id("username")).sendKeys("admin01");
		//type password and press enter button
		driver.findElement(By.name("pwd")).sendKeys("admin01",Keys.ENTER);
	}
}
