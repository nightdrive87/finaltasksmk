Feature: Buying sweater

  Scenario Outline: Buying sweater based on given params
    Given user is registered on "https://mystore-testlab.coderslab.pl/index.php" page
    When user signs in the account
    When user goes to homepage
    When user picks "Hummingbird Printed Sweater"
    When user checks if there is "20%" discount
    When user selects "<size>" and "<quantity>"
    When user adds purchase to cart
    When user goes to checkout
    When user confirms address
    When user picks delivery method
    When user picks payment method
    When user clicks on order with an obligation to pay
    Then takes screenshot

    Examples:
    | size   | quantity |
    | M      |  5       |