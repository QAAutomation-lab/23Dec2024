package stepdef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRMLogin{

	WebDriver driver;
	@Given("^Browser is already opened$")
	public void browser_is_already_opened() {
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	    
	}

	@When("user enters application url for OrangeHRM")
	public void user_enters_application_url_for_orange_hrm() {
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");   
	}

	@And("user enters valid user name in OrangeHRM")
	public void user_enters_valid_user_name_in_orange_hrm() {
	    driver.findElement(By.name("username")).sendKeys("Admin");
	}

	@And("user enters valid password in OrangeHRM")
	public void user_enters_valid_password_in_orange_hrm() {
		driver.findElement(By.name("password")).sendKeys("admin123");
	}

	@And("user clicks on login button  in OrangeHRM")
	public void user_clicks_on_login_button_in_orange_hrm() {
	    driver.findElement(By.cssSelector(".orangehrm-login-button")).click();
	    
	}

	@Then("user should navigate to home page for OrangeHRM")
	public void user_should_navigate_to_home_page_for_orange_hrm() {
	    String expectedUrl="dashboard/index";
	    String actualUrl=driver.getCurrentUrl();
	    Assert.assertTrue(actualUrl.contains(expectedUrl), "Either login failed or URL got changed");
	    
	}
}
