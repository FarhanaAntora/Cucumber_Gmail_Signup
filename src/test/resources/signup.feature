Feature: Signup to Gmail
  Scenario Outline: Signup to the portal with invalid password
    Given user visits to the Signup page
    When user inputs invalid "<Password1>"
    Then user can not Signup
    Examples:
      | Password1 |
      | 123 |
      | abc |
      | 4*5 |
      | cdef |
  Scenario Outline: Signup to the portal with invalid password
    Given user visits to the Signup page
    When user inputs invalid "<Password2>"
    Then user can not Signup
    Examples:
      | Password2 |
      | 12345678 |
      | abcdefgh |
      | password |
      | cdefghij |