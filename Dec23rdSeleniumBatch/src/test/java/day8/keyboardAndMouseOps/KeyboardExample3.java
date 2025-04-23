package day8.keyboardAndMouseOps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import reusableComponent.GenericFunctions;

public class KeyboardExample3 {

	public static void main(String[] args) throws InterruptedException {
		GenericFunctions g1=new GenericFunctions();
		WebDriver driver=g1.setup("chrome");
		
		driver.get("https://www.amazon.in/");
		
//		driver.findElement(By.xpath("//body")).sendKeys(Keys.PAGE_DOWN);
//		driver.findElement(By.xpath("//body")).sendKeys(Keys.PAGE_DOWN);
//		driver.findElement(By.xpath("//body")).sendKeys(Keys.PAGE_DOWN);
//		driver.findElement(By.xpath("//body")).sendKeys(Keys.PAGE_DOWN);
//		g1.setSleep(1000);
		
				//or bottom of the page
		driver.findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.CONTROL, Keys.END));
		g1.setSleep(2000);
		driver.findElement(By.xpath("//body")).sendKeys(Keys.HOME);
	}
}
