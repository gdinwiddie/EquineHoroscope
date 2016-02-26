package com.gdinwiddie.creditcardprocessor.merchantbank;

import com.gdinwiddie.creditcardprocessor.CreditCardInfo;
import com.gdinwiddie.creditcardprocessor.MerchantBank;
import com.gdinwiddie.creditcardprocessor.PaymentResult;

/**
 * This adapter will interface with a Merchant Bank server running on localhost.
 * 
 */
public class LocalhostMerchantBankAdapter implements MerchantBank {

	@Override
	public PaymentResult processPayment(int dollars, CreditCardInfo creditCard) {
		throw new RuntimeException("Not yet implemented");
	}

}
