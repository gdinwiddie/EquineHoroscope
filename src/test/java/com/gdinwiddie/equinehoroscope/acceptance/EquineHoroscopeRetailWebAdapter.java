package com.gdinwiddie.equinehoroscope.acceptance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gdinwiddie.creditcardprocessor.CreditCardInfo;
import com.gdinwiddie.equinehoroscope.acceptance.pages.PurchasePage;
import com.gdinwiddie.retail.HorseSelection;

public class EquineHoroscopeRetailWebAdapter implements EquineHoroscopeRetailAdapter {

	@Override
	public String purchaseHoroscope(HorseSelection horseSelection, CreditCardInfo customerCard) {
        PurchasePage page = new PurchasePage(getDriver());
        page.open();
        page.enterCreditCardInfo(customerCard);
        page.enterHorseSelection(horseSelection);
        page.purchase();
		return page.getHoroscope();
	}

	public WebDriver getDriver() {
		String browserName = System.getProperty("browser.name");
//		System.out.println("Using browser: "+browserName);

		WebDriver driver = null;
		if ("chrome".equalsIgnoreCase(browserName)) {
//			System.out.println("Using driver: "+System.getProperty("webdriver.chrome.driver"));
			driver = new ChromeDriver();
		} else {
//			System.out.println("Using driver: "+System.getProperty("webdriver.gecko.driver"));
			driver = new FirefoxDriver();
		}
		return driver;
	}

}
