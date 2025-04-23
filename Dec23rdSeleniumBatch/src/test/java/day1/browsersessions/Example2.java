package day1.browsersessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Example2 {

	public static void main(String[] args) {
		//Generic Statement to open browser instance
		WebDriver driver1=new ChromeDriver();//Run time poly- Inheritance+Upcasting+Overriding
		
		WebDriver driver2=new FirefoxDriver();//Run time poly- Inheritance+Upcasting+Overriding
		
		WebDriver driver3=new EdgeDriver();//Run time poly- Inheritance+Upcasting+Overriding
		
	}
}
/*
For each run- selenium will open new browser instance it won't work on already opened browser
New browser instance will not be having
	- No History
	- No Plugins
	- No Download history
*/