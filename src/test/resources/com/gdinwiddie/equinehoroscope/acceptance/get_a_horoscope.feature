Feature: Customer can get a horoscope

	Business rule: Horoscopes are for a given horse on a given day
	
Scenario: Arbitrary horse and day--temporary
		Make sure we get something.
		This is a great starting point, but will be unnecessary when
		we've implemented the later scenarios
	When we request an arbitrary horoscope
	Then the horoscope should not be empty

Scenario: Different horse, same day
		This should return a different horoscope from before
    When we request a horoscope for "Seabiscuit" for "today"
    And we request a horoscope for "Seabiscuit" for "tomorrow"
    Then the horoscopes should be different

@Ignore
Scenario: Same horse, different day
	This should return a different horoscope from before

@Ignore
Scenario: Same horse, same day
	This should return the same horoscope as before