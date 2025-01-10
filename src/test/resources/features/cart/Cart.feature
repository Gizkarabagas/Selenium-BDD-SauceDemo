@cart @regression
Feature: Cart Functionality

  Background: User is logged in and on the inventory page
    Given User is on the Login page
    When User logs in using username "standard_user" and password "secret_sauce"
    Then The Product page is displayed

  @high
  Scenario: Add a single item to the cart
    Given The Product page is displayed
    When the user adds the following items to the cart:
      | Sauce Labs Backpack   |
    Then the cart badge shows "1" item
    And the cart contains
      | Sauce Labs Backpack |

  @high
  Scenario: Add multiple items to the cart
    Given The Product page is displayed
    When the user adds the following items to the cart:
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
    Then the cart badge shows "2" item
    And the cart contains
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |

  @high
  Scenario: Remove an item from the cart
    Given The Product page is displayed
    And the user adds the following items to the cart:
      | Sauce Labs Backpack |
    When the user removes the following item
      | Sauce Labs Backpack |
    Then the cart badge shows no items
    And the cart does not contain "Sauce Labs Backpack"

  @medium
  Scenario: View cart contents
    Given the user adds the following items to the cart:
      | Sauce Labs Backpack |
    When the user views the cart
    Then the cart page displays "Sauce Labs Backpack" product details

  @high
  Scenario: Attempt checkout with empty cart
    Given the cart is empty
    When the user attempts to proceed to checkout
    Then the user is prevented from proceeding checkout

  @high
  Scenario: Verify cart badge updates correctly
    When the user adds the following items to the cart:
      | Sauce Labs Backpack |
    Then the cart badge shows "1" item
    When the user adds the following items to the cart:
      | Sauce Labs Bike Light |
    Then the cart badge shows "2" item
    When the user removes the following item
      | Sauce Labs Backpack |
    Then the cart badge shows "1" item

  @high
  Scenario: Ensure cart persists after logout and login
    Given the user adds the following items to the cart:
      | Sauce Labs Backpack |
    When the user logs out
    And User logs in using username "standard_user" and password "secret_sauce"
    Then the cart badge shows "1" item
    And the cart contains
      | Sauce Labs Backpack |