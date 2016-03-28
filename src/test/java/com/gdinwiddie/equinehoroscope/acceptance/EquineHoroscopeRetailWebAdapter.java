package com.gdinwiddie.equinehoroscope.acceptance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gdinwiddie.creditcardprocessor.CreditCardInfo;
import com.gdinwiddie.equinehoroscope.acceptance.pages.PurchasePage;
import com.gdinwiddie.retail.HorseSelection;

public class EquineHoroscopeRetailWebAdapter implements EquineHoroscopeRetailAdapter {

	@Override
	public String purchaseHoroscope(HorseSelection horseSelection, CreditCardInfo customerCard) {
        WebDriver driver = new FirefoxDriver();
        PurchasePage page = new PurchasePage(driver);
        page.open();
        page.enterCreditCardInfo(customerCard);
        page.enterHorseSelection(horseSelection);
        page.purchase();
		return page.getHoroscope();
	}

}
