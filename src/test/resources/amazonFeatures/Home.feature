Feature: Home Page
 
 Scenario: Verify Home page title
  Given User is on home page
  Then Expected page title should match actual title
  
 Scenario: Verify Amazon logo is displayed
  Given User is on home page
  Then Amazon logo should be displayed
  
 Scenario: Verify search box is present and enabled
  Given User is on home page
  Then search box should be present
  And search box should be enabled
 
 Scenario: Verify cart icon is visible
  Given User is on home page
  Then cart icon should be visible
  
 Scenario: Verify sign-in option is available
  Given User is on home page
  Then sign-in option should be available  