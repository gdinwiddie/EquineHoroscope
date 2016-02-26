package com.gdinwiddie.creditcardprocessor;

public interface MerchantBank {
	public PaymentResult processPayment(int dollars, CreditCardInfo creditCard);
}
