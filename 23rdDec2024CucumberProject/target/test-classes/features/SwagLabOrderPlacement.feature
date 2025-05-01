#Feature: This feature file is create to cover testing of Swaglab order placements
#
#Scenario: Check products are getting added in to cart or not
#Given user is already loggin in SwagLab application
#When user selected to product and added them into the cart
#And click on Cart icon
#Then Validate same products with price are getting displayed in checkout page
#
#Scenario: Check overview page
#When user clicks on checkout button
#And user provides information for delivery
#And user clicks on continue button
#Then validate added products with price are getting displayed
#
#Scenario: Check order confirmation
#When user clicks on finish button
#Then user should be able to see "Thank you for your order!"
#And user click on logout from navigation pannel
#And close the browser