package com.gdinwiddie.equinehoroscope.acceptance;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.gdinwiddie.creditcardprocessor.CreditCardInfo;
import com.gdinwiddie.creditcardprocessor.PaymentProcessor;
import com.gdinwiddie.creditcardprocessor.PaymentResult;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreditCardStepDefinitions {
	private PaymentResult result;

	@When("^a bad card is presented to the Payment Processor$")
	public void a_bad_card_is_presented_to_the_Payment_Processor() throws Throwable {
		CreditCardInfo badCard = new CreditCardInfo("4444444444444448", "123", "09/99");
		result = PaymentProcessor.instance().acceptPayment(badCard);
	}

	@When("^an invalid card number is presented to the Payment Processor$")
	public void an_invalid_card_number_is_presented_to_the_Payment_Processor() throws Throwable {
		CreditCardInfo invalidCardNumber = new CreditCardInfo("4444444444444408", "123", "09/99");
		result = PaymentProcessor.instance().acceptPayment(invalidCardNumber);
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
}
