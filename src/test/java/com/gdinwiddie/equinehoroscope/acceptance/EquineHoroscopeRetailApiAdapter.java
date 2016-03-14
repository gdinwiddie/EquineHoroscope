package com.gdinwiddie.equinehoroscope.acceptance;

import com.gdinwiddie.creditcardprocessor.CreditCardInfo;
import com.gdinwiddie.retail.EquineHoroscopeRetailApi;
import com.gdinwiddie.retail.HorseSelection;

public class EquineHoroscopeRetailApiAdapter implements EquineHoroscopeRetailAdapter {

	@Override
	public String purchaseHoroscope(HorseSelection horseSelection, CreditCardInfo customerCard) {
		EquineHoroscopeRetailApi retailApi = new EquineHoroscopeRetailApi();
		return retailApi.purchaseHoroscope(horseSelection, customerCard);
	}

}
