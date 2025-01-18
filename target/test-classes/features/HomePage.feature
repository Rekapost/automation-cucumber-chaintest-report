Feature: HomePage logging
    Scenario: Verify user is able to Login the homepage
      Given Launch browser
        When Navigate to url 'http://automationexercise.com'
        Then Verify that home page is visible successfully
        Then Click on 'Signup / Login' button
        And User should see 'New User Signup!' text
        Then Enter name and email address
        And  Click 'Signup' button