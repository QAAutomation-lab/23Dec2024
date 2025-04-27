package orangehrmwebpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponent.SeleniumUtility;

public class LoginPage extends SeleniumUtility{
	//initialize current page using pageFactory
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement usernameInputField;
	@FindBy(css="input[placeholder='Password']")
	private WebElement passwordInputField;
	@FindBy(css=".orangehrm-login-button")
	private WebElement loginButton;
	
	public WebElement getUsernameInputField() {
		return usernameInputField;
	}
	public WebElement getPasswordInputField() {
		return passwordInputField;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void loginIntoOrnageHrm(String username, String password) {
		typeInput(usernameInputField, username);
		typeInput(passwordInputField, password);
		clickOnElement(loginButton);
	}
	
	public String getLoginPageUrl() {
		return getCurrentUrlOfApplication();
	}
}
/*
username
password
login
pagetitle
*/