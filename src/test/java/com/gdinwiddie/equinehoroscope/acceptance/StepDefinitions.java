package com.gdinwiddie.equinehoroscope.acceptance;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

import com.gdinwiddie.equinehoroscope.CrystalBall;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	
	private CrystalBall crystalBall;
	private String horoscope;

	@Before
	public void setup() {
		this.crystalBall = CrystalBall.instance();
	}

	@When("^we request an arbitrary horoscope$")
	public void we_request_an_arbitrary_horoscope() throws Throwable {
		String horse = "Horse's Name";
		String effectiveDate = "Next Wednesday";
		horoscope = crystalBall.fetchHoroscope(horse, effectiveDate);
	}

	@Then("^the horoscope should not be empty$")
	public void the_horoscope_should_not_be_empty() throws Throwable {
		assertThat(horoscope, not(isEmptyOrNullString()));
	}
}
