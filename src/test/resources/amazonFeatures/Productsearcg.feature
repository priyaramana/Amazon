Feature: Product Search
 
 Scenario: Search for product
  Given User is on product search page
  When user enters a product name in search bar
  And should be able to click on search
  
 Scenario: Verify search results are displayed
  Given User is on product search page
  When  user searches for product
  Then product search results should display
  
 Scenario: Verify product titles contain search term
  Given User is on product search page
  When user searches for product
  Then product search results should display
  And should contain search text in the title
  
 Scenario: Apply filters
  Given User is on product search page
  When user applies filters
  Then products that match filters only should get displayed
  
 Scenario: Sort results by price
  Given User is on product search page
  When user sorts results by low to high
  Then products should display accordingly  