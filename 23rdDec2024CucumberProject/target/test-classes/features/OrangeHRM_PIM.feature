Feature: This feature file consist of test cases to validate PIM finctionality in OrangeHRM

  Background: 
    Given User is on OrnageHRM login page
    And User logged in with valid data
    And User clicked on PIM link

  @Regression
  Scenario Outline: Validate PIM creation in OrangeHRM
    When From the left panner click on PIM link
    And Click on Add button
    And Fill employee details as <fname>,<lname> and <empId>
    And click on Save button
    And From the left panner click on PIM link
    And Enter created Employee ID in Employee Id input field
    And click on Search button
    Then Validate Employee Details are displayed or not

    Examples: 
      | fname    | lname | empId |
      | Shailesh | Kumar |  1003 |
