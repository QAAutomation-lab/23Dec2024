Feature: Test Feature file is created to validate login functionality of OrangeHRM
	@Smoke
  Scenario: Validate Login with valid test data in OrangeHRM
    Given Browser is already opened
    When user enters application url for OrangeHRM
    And user enters valid user name in OrangeHRM
    And user enters valid password in OrangeHRM
    And user clicks on login button  in OrangeHRM
    Then user should navigate to home page for OrangeHRM
    And close the browser
