Feature: Adding new address

  Scenario Outline: Verification of new addresses

    Given user has an account on "https://mystore-testlab.coderslab.pl/index.php" store
    When user logs into account
    When user clicks on Addresses module
    When user clicks on + Create new address option
    When user fills form with data "<alias>", "<address>", "<city>", "<zip_postal_code>", "<country>", "<phone>"
    And clicks Save button to add address
    Then new address is added and contains "<alias>", "<address>", "<city>", "<zip_postal_code>", "<country>", "<phone>"

    Examples:
      | alias | address   | city    | zip_postal_code | country        | phone     |
      | home  | Zamkowa 5 | Piastów | 05-820          | United Kingdom | 500500500 |