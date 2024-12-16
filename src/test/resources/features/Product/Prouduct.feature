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

    Scenario: user want to verify all product
      Given User is on the Login page
      When User logs in using username "standard_user" and password "secret_sauce"
      Then verify all product
        | Sauce Labs Backpack             |
        |Sauce Labs Bike Light            |
        |Sauce Labs Bolt T-Shirt          |
        |Sauce Labs Fleece Jacket         |
        |Sauce Labs Onesie                |
        |Test.allTheThings() T-Shirt (Red)|

    Scenario: user want to see price on product
      Given User is on the Login page
      When User logs in using username "standard_user" and password "secret_sauce"
      Then verify all product
        |$29.99  |
        |$9.99   |
        |$15.99  |
        |$49.99  |
        |$7.99   |
        |$15.99  |

    Scenario: user want to see price in product and detail product
      Given User is on the Login page
      When User logs in using username "standard_user" and password "secret_sauce"
      And verify all product
        | $29.99 |
      And user select "Sauce Labs Backpack"
      And user add to cart
      And verify all product
        | $29.99 |

    Scenario: user want to remove cart form product detail
      Given User is on the Login page
      When User logs in using username "standard_user" and password "secret_sauce"
      And user select "Sauce Labs Backpack"
      And user add to cart
      And user remove cart
      Then cart empty