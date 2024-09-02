Feature: Login en tienda online

  As a user
  I want to be able to add a product to my shopping cart
  So that I can purchase the product later

  Scenario: login en tienda

    Given that Alex is on the product page
    And the user enters valid credentials
    And the user should be redirected to the home page
    When Alex adds the product Sauce Labs Backpack
    Then the quantity of added products should be 1
    When Alex navigates to the shopping cart and proceeds to checkout entering his first last name Guernizo and zip code 12345