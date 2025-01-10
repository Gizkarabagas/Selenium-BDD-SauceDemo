Feature: Login function

  Scenario: User logs in using valid credentials
    Given User is on the Login page
    When User logs in using username "standard_user" and password "secret_sauce"
    Then User redirected to the Inventory page

  Scenario Outline: User logs in using invalid credentials
    Given User is on the Login page
    When User logs in using username "<username>" and password "<password>"
    Then Error message is displayed with text "<error-message>"
    Examples:
      | username        | password         | error-message                                               |
      | locked_out_user | secret_sauce     | Sorry, this user has been locked out                        |
      | standard_user   |                  | Password is required                                        |
      |                 | secret_sauce     | Username is required                                        |
      | invalid_user    | secret_sauce     | Username and password do not match any user in this service |
      | standard_user   | invalid_password | Username and password do not match any user in this service |