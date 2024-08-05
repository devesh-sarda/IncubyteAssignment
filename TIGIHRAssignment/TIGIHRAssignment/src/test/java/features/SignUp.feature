Feature: Sign Up Test Case

  Scenario: User creates an account to sign up with invalid details
    Given user opens the Magento homepage
    When user clicks on create an account button
    Then verify that user lands on "Create New Customer Account" page
    When user fills the account details with invalid details
    Then verify the required field message displays

  Scenario: User creates an account to sign up with valid details
    Given user opens the Magento homepage
    When user clicks on create an account button
    Then verify that user lands on "Create New Customer Account" page
    When user fills the account details with valid details
    Then verify that user account has been created
    Then verify the success message