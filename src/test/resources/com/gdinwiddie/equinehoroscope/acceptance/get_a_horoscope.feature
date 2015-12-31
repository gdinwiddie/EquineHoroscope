Feature: Customer can get a horoscope
  
  Business rule: Horoscopes are for a given horse on a given day

  Scenario: Arbitrary horse and day
    Make sure we get something.
    This is a great starting point, but will be unnecessary when
    we've implemented the later scenarios

    When we request an arbitrary horoscope
    Then the horoscope should not be empty

  @ignore
  Scenario: Same horse, same day
    This should return the same horoscope as before

    When we request a horoscope for "Man o' War" for "next Tuesday"
    And we request a horoscope for "Man o' War" for "next Tuesday"
    Then the horoscopes should be the same
