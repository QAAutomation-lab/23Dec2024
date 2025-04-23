package day10.switching;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import reusableComponent.SeleniumUtility;

public class Assignments extends SeleniumUtility{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignments ref=new Assignments();
		ref.rearrangeElements();
	}
	
	void rearrangeElements() {
		WebDriver driver=setUp("chrome", "https://jqueryui.com/sortable/");
		driver.switchTo().frame(0);
		
		List<WebElement> itemList=driver.findElements(By.cssSelector("ul#sortable>li"));
		
		for(int i=0;i<itemList.size()-1;i++) {
			itemList=driver.findElements(By.cssSelector("ul#sortable>li"));
			WebElement src=itemList.get(itemList.size()-1);
			WebElement target=itemList.get(i);
			action.dragAndDrop(src, target).build().perform();
			setSleepTime(1000);
		}
	}
}
/*
TC1: https://the-internet.herokuapp.com/javascript_alerts
Handle all JAVA Script popups


TC2: Open browser and enter URL as https://jqueryui.com
click on sortable 
sort the element from 7 to 1

*/