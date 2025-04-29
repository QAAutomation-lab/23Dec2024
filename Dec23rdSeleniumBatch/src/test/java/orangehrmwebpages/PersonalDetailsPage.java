package orangehrmwebpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponent.SeleniumUtility;

public class PersonalDetailsPage extends SeleniumUtility {

	public PersonalDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
	//Job Link
	@FindBy(xpath="//a[text()='Job']")
	private WebElement jobTab;
	
	//Job Title Dropdown
	@FindBy(xpath="//div[contains(@class,'oxd-select-text--focus')]")
	private WebElement jobDropdown;
	
	//Job Title Dropdown Elements
	@FindBy(xpath="//div[contains(@class,'oxd-select-text--focus')]/following-sibling::div/div/span")
	private List<WebElement> jobOptionList;
	
	//Save Button
	
	//Function: Update PIM
}
