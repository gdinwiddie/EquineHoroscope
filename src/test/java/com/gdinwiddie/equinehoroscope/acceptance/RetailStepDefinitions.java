package com.gdinwiddie.equinehoroscope.acceptance;

import com.gdinwiddie.creditcardprocessor.CreditCardInfo;
import com.gdinwiddie.creditcardprocessor.TestingCreditCards;
import com.gdinwiddie.retail.HorseSelection;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class RetailStepDefinitions {
	private CreditCardInfo customerCard;
	private EquineHoroscopeRetailAdapter retailApi;
	private HoroscopeCollector horoscopes;
	
	public RetailStepDefinitions(EquineHoroscopeRetailAdapter retailApi) {
		super();
		this.retailApi = retailApi;
	}

	@Before
	public void setUp() {
		this.horoscopes = HoroscopeCollector.instance();
	}

	@Given("^a customer provides a valid credit card$")
	public void a_customer_provides_a_valid_credit_card() throws Throwable {
		customerCard = TestingCreditCards.goodCard;
	}

	@When("^they request an arbitrary horoscope$")
	public void they_request_an_arbitrary_horoscope() throws Throwable {
		HorseSelection arbitraryHorseSelection = new HorseSelection("Any Horse Name", "any day now");
		horoscopes.add(retailApi.purchaseHoroscope(arbitraryHorseSelection, customerCard));
	}

}
