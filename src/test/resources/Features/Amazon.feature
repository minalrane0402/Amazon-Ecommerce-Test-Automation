Feature: Amazon End to End Automation

  Scenario: Verify login, product search, add to cart, cart page and logout
    Given User launches the Amazon application
    When User logs in using valid credentials
    And User searches for a product
    And User adds the product to the cart
    And User navigates to the cart page
    Then User logs out successfully