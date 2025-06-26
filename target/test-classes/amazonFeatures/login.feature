Feature: Login feature
 
 Scenario: Click on Login button
  Given user is on home page
  When user clicks on signin in home page
  Then user should redirect to login page
 
 Scenario: Verify login with valid creds
  Given user is on login page
  When user enter username "priyat908@yahoo.com"
  And clicks on continue
  Then user should redirect to password page
  When user enters password "Wonder@2023"
  And clicks on signin button in login page
  Then user should redirect to home page
   