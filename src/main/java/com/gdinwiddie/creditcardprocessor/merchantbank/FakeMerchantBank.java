package com.gdinwiddie.creditcardprocessor.merchantbank;

import com.gdinwiddie.creditcardprocessor.CreditCardInfo;
import com.gdinwiddie.creditcardprocessor.MerchantBank;
import com.gdinwiddie.creditcardprocessor.PaymentResult;

public class FakeMerchantBank implements MerchantBank {

	public PaymentResult processPayment(int dollars, CreditCardInfo creditCard) {
		if ("4111111111111111".equals(creditCard.getCardNumber())) {
			return new PaymentResult(true, "");
		}
		PaymentResult paymentResult = new PaymentResult(false, "Declined for lack of merchant account");
		return paymentResult;
	}

}
