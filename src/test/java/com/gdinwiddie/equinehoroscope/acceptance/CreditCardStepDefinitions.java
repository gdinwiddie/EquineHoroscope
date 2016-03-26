package com.gdinwiddie.equinehoroscope.acceptance;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertThat;

import com.gdinwiddie.creditcardprocessor.MerchantBank;
import com.gdinwiddie.creditcardprocessor.PaymentProcessor;
import com.gdinwiddie.creditcardprocessor.PaymentResult;
import com.gdinwiddie.creditcardprocessor.TestingCreditCards;
import com.gdinwiddie.creditcardprocessor.merchantbank.FakeMerchantBank;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreditCardStepDefinitions {
	private PaymentResult result;
	private PaymentProcessor paymentProcessor;
	
	@Before
	public void setUp() {
		paymentProcessor = PaymentProcessorWithFakeMerchantBank.instance();
	}

	@When("^a bad card is presented to the Payment Processor$")
	public void a_bad_card_is_presented_to_the_Payment_Processor() throws Throwable {
		result = paymentProcessor.acceptPayment(TestingCreditCards.badCard);
	}

	@When("^an invalid card number is presented to the Payment Processor$")
	public void an_invalid_card_number_is_presented_to_the_Payment_Processor() throws Throwable {
		result = paymentProcessor.acceptPayment(TestingCreditCards.invalidCard);
	}

	@When("^a good card is presented to the Payment Processor$")
	public void a_good_card_is_presented_to_the_Payment_Processor() throws Throwable {
		result = paymentProcessor.acceptPayment(TestingCreditCards.goodCard);
	}

	@Then("^the Payment Processor declines the transaction$")
	public void the_Payment_Processor_declines_the_transaction() throws Throwable {
		assertThat(result.isSuccessful(), is(false));
		assertThat(result.getReason().toLowerCase(), containsString("declined"));
	}

	@Then("^the Payment Processor rejects the transaction$")
	public void the_Payment_Processor_rejects_the_transaction() throws Throwable {
		assertThat(result.isSuccessful(), is(false));
		assertThat(result.getReason().toLowerCase(), containsString("invalid"));
	}

	@Then("^the Payment Processor accepts the transaction$")
	public void the_Payment_Processor_accepts_the_transaction() throws Throwable {
		assertThat(result.isSuccessful(), is(true));
		assertThat(result.getReason(), isEmptyString());
	}

	static class PaymentProcessorWithFakeMerchantBank extends PaymentProcessor {
		public PaymentProcessorWithFakeMerchantBank(MerchantBank merchantBank) {
			super(merchantBank);
		}

		public static PaymentProcessor instance() {
			theProcessor = new PaymentProcessor(new FakeMerchantBank());
			return theProcessor;
		}
	}
}
