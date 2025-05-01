package stepdef;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.SeleniumUtility;

public class GoogleSearchDef extends SeleniumUtility{
	
	@Given("^Browser is already opened with valid url$")
	public void browser_is_already_opened_with_valid_url() {
	    setUp("chrome", "https://www.google.com");
	    
	}

	@When("user types {string} in search input field")
	public void user_types_in_search_input_field(String searchText) {
	    typeInput(driver.findElement(By.name("q")), searchText);
	    
	}

	@Then("user should get {string} suggestions")
	public void user_should_get_suggestions(String count) {
	   int suggestionCount= driver.findElements(By.cssSelector(".G43f7e>li>div>*:nth-child(2)>*:nth-child(1)>*:nth-child(1)>span")).size();
	   int expectedSuggestionCount=Integer.parseInt(count);
	   Assert.assertEquals(suggestionCount, expectedSuggestionCount);
	}

	@When("user selects {string} from suggestion")
	public void user_selects_from_suggestion(String string) {
		List<WebElement> suggestions=driver.findElements(By.cssSelector(".G43f7e>li>div>*:nth-child(2)>*:nth-child(1)>*:nth-child(1)>span"));
	    for(int i=0;i<suggestions.size();i++) {
	    	suggestions=driver.findElements(By.cssSelector(".G43f7e>li>div>*:nth-child(2)>*:nth-child(1)>*:nth-child(1)>span"));
	    	if(suggestions.get(i).getText().equals(string)) {
	    		clickOnElement(suggestions.get(i));
	    		break;
	    	}
	    }
	}

	@Then("user should be able to see {string} in search input field of next page")
	public void user_should_be_able_to_see_in_search_input_field_of_next_page(String expectedText) {
	    String actualText=getTextFromElement(driver.findElement(By.name("q")));
	    Assert.assertEquals(actualText, expectedText);
	}

	@When("^user types (.+) in search input field of google$")
	public void user_types_in_search_input_field_of_google(String searchText) {
		 typeInput(driver.findElement(By.name("q")), searchText);
	}
	@And("^user selects (.+) from suggestion given by google$")
	public void user_selects_from_suggestion_given_by_google(String selectedText) {
		List<WebElement> suggestions=driver.findElements(By.cssSelector(".G43f7e>li>div>*:nth-child(2)>*:nth-child(1)>*:nth-child(1)>span"));
	    for(int i=0;i<suggestions.size();i++) {
	    	if(suggestions.get(i).getText().equals(selectedText)) {
	    		clickOnElement(suggestions.get(i));
	    		break;
	    	}
	    }
	}
	@Then("^user should be able to see (.+) in search input field of serched page$")
	public void user_should_be_able_to_see_in_search_input_field_of_serched_page(String selectedText) {
		 String actualText=getTextFromElement(driver.findElement(By.name("q")));
		    Assert.assertEquals(actualText, selectedText);
	}
	@And("close the browser")
	public void close_the_browser() {
		driver.quit();
	}
}
