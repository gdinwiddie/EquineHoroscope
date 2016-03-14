package com.gdinwiddie.equinehoroscope.acceptance;

import com.gdinwiddie.creditcardprocessor.CreditCardInfo;
import com.gdinwiddie.retail.HorseSelection;

public interface EquineHoroscopeRetailAdapter {

	String purchaseHoroscope(HorseSelection horseSelection, CreditCardInfo customerCard);

}