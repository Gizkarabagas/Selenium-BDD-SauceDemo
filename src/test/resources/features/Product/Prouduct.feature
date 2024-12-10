Feature: Product Homepage

  Scenario: user want to go product page
    Given User is on the Login page
    When User logs in using username "standard_user" and password "secret_sauce"
    Then User redirected to the Inventory page

  Scenario: user want to add cart in product detail
    Given User is on the Login page
    When User logs in using username "standard_user" and password "secret_sauce"
    And user select "Sauce Labs Backpack"
    And user add to cart
    Then user verify QTY "1"

  Scenario: user want to multiple add cart in product detail
    Given User is on the Login page
    When User logs in using username "standard_user" and password "secret_sauce"
    And user select "Sauce Labs Backpack"
    And user add to cart
    And user back homepage
    And user select "Sauce Labs Bolt T-Shirt"
    And user add to cart
    Then user verify QTY "2"