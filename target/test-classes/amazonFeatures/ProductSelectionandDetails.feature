Feature: Product selection & details
  
  
  Scenario: select a product from search results
   Given User is on product page
   When user enters product in search box
   Then search results should display
   And should be able to select product from search results
   
   
  Scenario: Verify product title, price , description on product page
   Given User is on product page
   When user clicks on product 
   Then product details page should display
   And should contain title, price, description
   
  
  Scenario: Verify Availability of add to cart button
   Given User is on product page
   When user clicks on product
   Then product details page should display 
   And it should cotain add to cart button
   
  Scenario: Verify product images carousel
   Given User is on product page
   When user clicks on product
   Then product details page should display
   And images should display as carousel
  
  Scenario: verify delivery options
   Given User is on product details page
   When user enters valid pincode 
   And clicks on verify
   Then success message should display 
   When user enters invalid pincode
   And clicks on verify
   Then error message should display
      