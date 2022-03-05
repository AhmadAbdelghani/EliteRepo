@Regression
Feature: User should be able to add a trade 
          user can add a valid trade 
          user should not be able to add a trade invalid
          
  @AddTradeValid  @SmokeTest    
 Scenario: User should be able to add a trade when provide valid inputs 
 Given User is logged in to Trade Journal app and User is on homepage 
 When User clicks on add trade button 
 And Users enters the following data 
 |Sell to Open|UFCStock|09-10-2019|40.0|07-12-2020|30.0|
 And User clicks on save button 
 Then Trade is added on the UI table 
 And Trade is added on the database table
 And Record should be deleted  