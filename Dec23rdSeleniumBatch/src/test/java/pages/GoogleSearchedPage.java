package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponent.SeleniumUtility;

public class GoogleSearchedPage extends SeleniumUtility{
	public GoogleSearchedPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//textarea[@aria-label='Search']")
	private WebElement searchInputField;

	public WebElement getSearchInputField() {
		return searchInputField;
	}
	
	public String getSearchedTextFromUi() {
		String value=getRequiredAttributeValue(searchInputField, "value");
		return value;
	}
}
