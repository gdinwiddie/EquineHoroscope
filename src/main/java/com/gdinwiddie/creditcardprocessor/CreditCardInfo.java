package com.gdinwiddie.creditcardprocessor;

import org.apache.commons.validator.routines.CreditCardValidator;

public class CreditCardInfo {

	private String cardNumber;
	private String cvv2;
	private String expirationDate;

	public CreditCardInfo(String cardNumber, String CVV2, String expirationDate) {
		this.cardNumber = cardNumber;
		this.cvv2 = CVV2;
		this.expirationDate = expirationDate;
	}

	public boolean validate() {
		return new CreditCardValidator().isValid(cardNumber);
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getCvv2() {
		return cvv2;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

}
