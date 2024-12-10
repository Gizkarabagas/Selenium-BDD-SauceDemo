Feature: Product Homepage

  Scenario: user want to go product page
    Given User is on the Login page
    When User logs in using username "standard_user" and password "secret_sauce"
    Then User redirected to the Inventory page

  Scenario: user want go to product detail
    Given User is on the Login page
    When User logs in using username "standard_user" and password "secret_sauce"
    And user select "Sauce Labs Backpack"
    And user add to cart
    Then user verify QTY "1"