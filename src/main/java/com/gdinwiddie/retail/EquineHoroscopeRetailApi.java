package com.gdinwiddie.retail;

import com.gdinwiddie.creditcardprocessor.CreditCardInfo;
import com.gdinwiddie.creditcardprocessor.PaymentProcessor;
import com.gdinwiddie.equinehoroscope.CrystalBall;

public class EquineHoroscopeRetailApi {
	PaymentProcessor paymentProcessor = PaymentProcessor.instance();
	CrystalBall crystalBall = CrystalBall.instance();

	public String purchaseHoroscope(HorseSelection horseSelection, CreditCardInfo customerCard) {
		String horoscope = "Sorry, but there is a problem with your payment.";
		if (paymentProcessor.acceptPayment(customerCard).isSuccessful()) {
			horoscope = crystalBall.fetchHoroscope(horseSelection.getHorseName(), horseSelection.getEffectiveDate());
		}
		return horoscope;
	}

}
