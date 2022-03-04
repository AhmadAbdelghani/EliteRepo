@Regression
Feature: User should be able to login to Trade Journal app
        User should not be logged in with invalid credentials
        User should be able to loggin with valid credentioals

  @LoginValid
  Scenario Outline: As a user I shpuld be able to login with valid credential
    Given User is on Trade Joiurnal app login page
    When User inters valid username "<username>" and valid password "<password>"
    And User clicks the sign in button
    Then User should be directed to the homepage of Trade Journal app

    Examples: 
      | username | password       |
      | Ahmad    | SuperAhmad123! |
      | Ahmad    | SuperAhmad123! |
      | Ahmad    | SuperAhmad123! |
      | Ahmad    | SuperAhmad123! |



  @LoginInvalid
  Scenario Outline: User shoulb not be able to log in with invalid usename and valid password
    Given User is on Trade Joiurnal app login page
    When User enters invalid username "<username>" and valid password
    And User clicks the sign in button
    Then User sould not be directed to home page
    And User should see message "Bad credentials"

    Examples: 
      | username |
      | jab      |
      | Sultan   |
      | Makik    |



  @LoginInvalid
  Scenario Outline: User should not be able to log in with valid username and invalid password
    Given User is on Trade Joiurnal app login page
    When User enters valid username and invalid password "<password>"
    And User clicks the sign in button
    Then User sould not be directed to home page
    And User should see message "Bad credentials"

    Examples: 
      | password    |
      | ahndh7678   |
      | 768273js    |
      | mohakj62657 |
      
      
      
      
      
      @LoginInvalid
      Scenario Outline: User should not be able to log in with inalid username and invalid password 
       Given User is on Trade Joiurnal app login page
       When User enters invalid username "<username>" and invalid password "<password>" into the fields
       And User clicks the sign in button
       Then User sould not be directed to home page
       And User should see message "Bad credentials"
       Examples:
       |username|password|
       |Sulktan|sultan1234455|
       |Afeefy|098765|
       |Sabah|Masa2|
       |Kaother|Samasem|
       
       
      
      @Logout
      Scenario: User should be able to logout from Trade Journal app
      Given User is logged in to Journal app and on the home page 
      When User clicks oon the logout button 
      Then User should be directed to a page with message "Are you sure you want to log out?" 
      And User should see button "Log Out"
      When User clicks on the lougout button 
      Then User should be directed to the log in page 
      And user should see a message "You have been signed out" 
       
       
       
       
