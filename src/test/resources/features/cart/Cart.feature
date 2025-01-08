Feature: Cart Functionality

  Background: User is logged in and on the inventory page
    Given User is on the Login page
    When User logs in using username "standard_user" and password "secret_sauce"
    Then The Product page is displayed

  Scenario: Add a single item to the cart
    Given The Product page is displayed
    When User adds the "Sauce Labs Backpack" to the cart
    Then the cart badge shows 1 item
    And the cart contains "Sauce Labs Backpack"

  Scenario: Add multiple items to the cart
    Given The Product page is displayed
    When the user adds the following items to the cart:
      | Item Name             |
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
    Then the cart badge shows 2 items
    And the cart contains:
      | Item Name             |
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |

  Scenario: Remove an item from the cart
    Given The Product page is displayed
    And the user has added "Sauce Labs Backpack" to the cart
    When the user removes the "Sauce Labs Backpack" from the cart
    Then the cart badge shows no items And the cart does not contain "Sauce Labs Backpack"

  Scenario: View cart contents
    Given the user has added "Sauce Labs Backpack" to the cart
    When the user views the cart
    Then the cart page displays "Sauce Labs Backpack"

  Scenario: Proceed to checkout with items in the cart
    Given the user has added "Sauce Labs Backpack" to the cart
    When the user proceeds to checkout
    Then the checkout page is displayed
    And the checkout page lists "Sauce Labs Backpack"

  Scenario: Complete checkout process
    Given the user is on the checkout page
    When the user enters the following checkout information:
      | First Name | Last Name | Postal Code |
      | John       | Doe       | 12345       |
    And the user continues to the overview page And the user finishes the checkout
    Then the confirmation page is displayed
    And the confirmation message "THANK YOU FOR YOUR ORDER" is shown

  Scenario: Attempt checkout with empty cart
    Given the cart is empty
    When the user attempts to proceed to checkout
    Then the user is prevented from proceeding
    And an error message "Your cart is empty" is displayed

  Scenario: Verify cart badge updates correctly
    Given the inventory page is displayed
    When the user adds "Sauce Labs Backpack" to the cart
    Then the cart badge shows 1 item
    When the user adds "Sauce Labs Bike Light" to the cart
    Then the cart badge shows 2 items
    When the user removes "Sauce Labs Backpack" from the cart
    Then the cart badge shows 1 item

  Scenario: Ensure cart persists after logout and login
    Given the user has added "Sauce Labs Backpack" to the cart
    When the user logs out
    And the user logs in with username "standard_user" and password "secret_sauce"
    Then the cart badge shows 1 item And the cart contains "Sauce Labs Backpack"

  Scenario: Cancel checkout process
    Given the user is on the checkout page
    When the user cancel the checkout
    Then the user redicected to the Product page
    And the cart badge remain unchanged