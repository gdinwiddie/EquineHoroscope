package com.gdinwiddie.creditcardprocessor;

import com.gdinwiddie.creditcardprocessor.merchantbank.FakeMerchantBank;

public class PaymentProcessor {

	private static final int HOROSCOPE_PRICE_IN_DOLLARS = 2;
	private static PaymentProcessor theProcessor;
	private MerchantBank merchantBankAdapter = new FakeMerchantBank();

	public static PaymentProcessor instance() {
		if (null == theProcessor) {
			theProcessor = new PaymentProcessor();
		}
		return theProcessor;
	}

	public PaymentResult acceptPayment(CreditCardInfo creditCard) {
		if (!creditCard.validate()) {
			return new PaymentResult(false, "Invalid card information");
		}
		PaymentResult paymentResult = merchantBankAdapter.processPayment(HOROSCOPE_PRICE_IN_DOLLARS, creditCard);
		return paymentResult ;
	}

}
