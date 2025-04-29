package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponent.SeleniumUtility;

public class GoogleHomePage extends SeleniumUtility{

	public GoogleHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//search input field
	@FindBy(name="q")
	private WebElement searchInputField;
	
	//Suggestion list
	@FindBy(css="ul.G43f7e>li>div>*:nth-child(2)>div>*:first-child>span")
	private List<WebElement> suggestionList;

	public WebElement getSearchInputField() {
		return searchInputField;
	}

	public List<WebElement> getSuggestionList() {
		return suggestionList;
	}
	
	public int getSuggestionCount() {
		return suggestionList.size();
	}
	
	public String getHomePageTitle() {
		return getCurrentTitleOfApplication();
	}
	
	public void typeRequiredTextToSearch(String text) {
		typeInput(searchInputField, text);
	}
}
