package com.gdinwiddie.creditcardprocessor;

public class TestingCreditCards {

	public static final CreditCardInfo badCard = new CreditCardInfo("4444444444444448", "123", "09/99");
	public static final CreditCardInfo invalidCard = new CreditCardInfo("4444444444444408", "123", "09/99");
	public static final CreditCardInfo invalidCard2 = new CreditCardInfo("4222222222222220", "123", "09/99");
	public static final CreditCardInfo goodCard = new CreditCardInfo("4111111111111111", "123", "09/99");

}
