package com.gdinwiddie.creditcardprocessor.merchantbank;

import java.io.IOException;

import org.apache.http.client.fluent.Request;

import com.gdinwiddie.creditcardprocessor.CreditCardInfo;
import com.gdinwiddie.creditcardprocessor.MerchantBank;
import com.gdinwiddie.creditcardprocessor.PaymentResult;
import com.google.gson.Gson;

/**
 * This adapter will interface with a Merchant Bank server using JSON transactions over the internet.
 * 
 */
public class JsonMerchantBankAdapter implements MerchantBank {
	private String bankURL = "http://localhost:12000";

	public void setBankURL(String bankURL) {
		this.bankURL = bankURL;
	}

	static class PaymentRequest {
		public int dollars;
		public CreditCardInfo creditCard;

		PaymentRequest(int dollars, CreditCardInfo creditCard) {
			this.dollars = dollars;
			this.creditCard = creditCard;
		}
	}

	@Override
	public PaymentResult processPayment(int dollars, CreditCardInfo creditCard) {
		try {
			String json = new Gson().toJson(new PaymentRequest(10, creditCard));
			String result = Request.Post(bankURL + "/pay").bodyString(json, null).execute().returnContent().asString();
			if ("success".equals(result)) {
				return new PaymentResult(true, "");
			}
			return new PaymentResult(false, result);
		} catch (IOException e) {
			e.printStackTrace();
			return new PaymentResult(false, e.getMessage());
		}
	}

}
