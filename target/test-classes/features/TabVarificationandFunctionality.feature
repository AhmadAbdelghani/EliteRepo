
@regressionMinor @regressionMajor @smoketest
Feature: The tab of the home page verification 
					There are few staff on the tab of the homepage which needs to be visible and functional

  @verifingTabItemVisibility
  Scenario: The Trading logo should be visible 
  Given that the user on the login page
  When user enters currect username 
  And user enters currect password
  Then user should click on the login button 
  And user should be logged in to home page
  

