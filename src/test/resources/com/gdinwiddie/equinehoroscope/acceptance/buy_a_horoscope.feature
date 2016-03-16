Feature: Buy a horoscope
  
  When a customer requests a horoscope, we'll take their credit
  card information and charge their card before delivering the
  horoscope.

  @Web @Api
  Scenario: Simple purchase
    Given a customer provides a valid credit card
    When they request an arbitrary horoscope
    Then the horoscope should not be empty
