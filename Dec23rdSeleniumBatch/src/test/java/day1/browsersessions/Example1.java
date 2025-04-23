package day1.browsersessions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Example1 {

	public static void main(String[] args) {
		//Open chrome browser - ChromeDriver
		ChromeDriver cdriver=new ChromeDriver();
		//Open firefox - FirefoxDriver
		FirefoxDriver fdriver=new FirefoxDriver();
		//Open Edge browser -  EdgeDriver
		EdgeDriver edriver=new EdgeDriver();
	}
}
/*
For each run- selenium will open new browser instance it won't work on already opened browser
New browser instance will not be having
	- No History
	- No Plugins
	- No Download history
*/