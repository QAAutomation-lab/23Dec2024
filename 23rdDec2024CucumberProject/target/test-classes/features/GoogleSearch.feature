Feature: Testing Google search functionality
	@Smoke
  Scenario: Validate suggestion count in google search
    Given Browser is already opened with valid url
    When user types "Selenium" in search input field
    Then user should get "10" suggestions
	@Smoke
  Scenario: Validate suggestion selection in google
    When user selects "selenium interview questions" from suggestion
    Then user should be able to see "selenium interview questions" in search input field of next page
    And close the browser
	@Regression
  Scenario Outline: Search required text in google
    Given Browser is already opened with valid url
    When user types <searchText> in search input field of google
    And user selects <selectedText> from suggestion given by google
    Then user should be able to see <selectedText> in search input field of serched page
    And close the browser

    Examples: 
      | searchText     | selectedText                       |
      | selenium       | selenium interview questions       |
      | manual testing | manual testing interview questions |
      | API testing    | api testing interview questions    |
