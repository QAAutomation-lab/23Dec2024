package stepdef;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.SeleniumUtility;
import webpages_orangehrm.AddEmployeePage;
import webpages_orangehrm.HomePage;
import webpages_orangehrm.LoginPage;
import webpages_orangehrm.PimHomePage;

public class OrangeHrmPIM_Step extends SeleniumUtility{
	LoginPage getLoginPage;
	HomePage getHomePage;
	AddEmployeePage getAddEmployeePage;
	PimHomePage getPimHomePage;
	WebDriver driver;
	static int empId;
	@Given("User is on OrnageHRM login page")
	public void user_is_on_ornage_hrm_login_page() {
		driver=setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    getLoginPage=new LoginPage(driver);
	    getHomePage=new HomePage(driver);
	    getAddEmployeePage=new AddEmployeePage(driver);
	    getPimHomePage=new PimHomePage(driver);
	    
	}

	@Given("User logged in with valid data")
	public void user_logged_in_with_valid_data() {
		getLoginPage.loginIntoOrangeHrm("Admin", "admin123");
	    
	}

	@Given("User clicked on PIM link")
	public void user_clicked_on_pim_link() {
		getHomePage.clickOnPIM();
	    
	}

	@When("From the left panner click on PIM link")
	public void from_the_left_panner_click_on_pim_link() {
		getHomePage=new HomePage(driver);
		getHomePage.clickOnPIM();
	}

	@And("Click on Add button")
	public void click_on_add_button() {
		getPimHomePage.clickOnAddButton();
	    
	}

	@And("^Fill employee details as (.+),(.+) and (.+)$")
	public void fill_employee_details_as_shailesh_kumar_and(String fname, String lname, String id) {
		empId=Integer.parseInt(id);
	    getAddEmployeePage.createEmployee(fname, lname, empId);
	    
	}

	@And("click on Save button")
	public void click_on_save_button() {
	    
		getAddEmployeePage.clickOnSaveButton();
	}

	@And("Enter created Employee ID in Employee Id input field")
	public void enter_created_employee_id_in_employee_id_input_field() {

		getPimHomePage.searchCreatedEmployee(empId);
	    
	}

	@And("click on Search button")
	public void click_on_search_button() {
		getPimHomePage.clickOnSearchButton();
	    
	}

	@Then("Validate Employee Details are displayed or not")
	public void validate_employee_details_are_displayed_or_not() {
	    
		String msg=getPimHomePage.getSearchResultMsg();
		Assert.assertEquals(msg, "(1) Record Found");
	}

}
