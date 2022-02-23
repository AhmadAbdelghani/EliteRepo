Feature: Update Trade record 
        User should be able to update existing record 
        
  
  
  @ValidUpdateRecordAllFields
  Scenario: User should be able to update a record in the table records
  Given User looged in to trade Journal app and on the homepage
  When User creat new record with the following data and 
  |Sell to Open|UFCStock|01-02-2019|50.0|01-09-2020|100.0| 
  And User save the record
  Then Record should be saved
  When User update this new created record with the following data 
  |Buy to Open|MMAStock|09-10-2020|160.0|08-07-2022|200.0|
  Then Record should be updated on the UI table
  And Record is updated on the database
  And record should be deleted
  
  
  
  
  
  
  