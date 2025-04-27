package orangehrmwebpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponent.SeleniumUtility;

public class DashboardPage extends SeleniumUtility{

	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".oxd-userdropdown-name")
	private WebElement userProfileIcon;
	
	@FindBy(linkText="Logout")
	private WebElement logoutLink;
	
	@FindBy(css="ul.oxd-main-menu>li>a>span")
	private List<WebElement> menuList;

	public WebElement getUserProfileIcon() {
		return userProfileIcon;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public List<WebElement> getMenuList() {
		return menuList;
	}
	
	public void logoutFromOrangeHRM() {
		clickOnElement(userProfileIcon);
		clickOnElement(logoutLink);
	}
	
	public void selectOptionFromMenuList(String name) {		
		for(int i=0;i<menuList.size();i++) {
			if(menuList.get(i).getText().equals(name)) {
				clickOnElement(menuList.get(i));
				break;
			}
		}
	}
	
	public String getDashboardPageUrl() {
		return getCurrentUrlOfApplication();
	}
}
/*
userprofile
logout
menuList
pageTitle
*/