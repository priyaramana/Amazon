Feature: Cart feature
 
 Scenario: Add product to cart
  Given User is on cart product details page
  Then user should be able to add product to cart on clicking add to cart button
 
 Scenario: Verify product is added to cart
  Given User is on cart product details page
  When User clicks on add to cart
  Then product should be added to cart
  
 Scenario: Increase product quantity in cart
  Given User is on cart page
  When user clicks on + next to product quantity
  Then quantity should get increased by 1
  
 Scenario: Remove product quantity
  Given User is on cart page
  When quantity is greater than 1
  When user clicks on minus next to product quantity
  Then quantity should get decreased by 1
  
 Scenario: Verify cart empty message
  Given User is on cart page
  When no product is added to cart
  Then cart empty message should display 