package day4.componentvalidation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://online.actitime.com/dec23/login.do");
		
		WebElement usernameInputField=driver.findElement(By.id("username"));
		System.out.println("Is username input field visible or not? "+usernameInputField.isDisplayed());
		System.out.println("Is username input field in functional or not? "+usernameInputField.isEnabled());
		System.out.println("what is default value in username input field? "+usernameInputField.getAttribute("placeholder"));
		
		WebElement keepMeLoggedInCheckBox=driver.findElement(By.id("keepLoggedInCheckBox"));
		System.out.println("Is keepMeLoggedInCheckBox visible or not? "+keepMeLoggedInCheckBox.isDisplayed());
		System.out.println("Is keepMeLoggedInCheckBox in functional or not? "+keepMeLoggedInCheckBox.isEnabled());
		System.out.println("Is keepMeLoggedInCheckBox by default selected? "+keepMeLoggedInCheckBox.isSelected());
		keepMeLoggedInCheckBox.click();
		System.out.println("after click, is keepMeLoggedInCheckBox by default selected? "+keepMeLoggedInCheckBox.isSelected());
		
		WebElement forgotPasswordLink=driver.findElement(By.id("toPasswordRecoveryPageLink"));
		System.out.println("Is forgotPasswordLink visible or not? "+forgotPasswordLink.isDisplayed());
		System.out.println("Is forgotPasswordLink in clicking or not? "+forgotPasswordLink.isEnabled());
		System.out.println("forgotPasswordLink name is: "+forgotPasswordLink.getText());
		
	}

}
/**
Open browser and enter application url
validate:
	username field is visible or not
	username field default text is "Username" or not
	keep me loggedin check box by default not selected
	click on Keep me loggedin check box and validate its selected or not
	validate "Forgot your password?" link text is same or not
*/