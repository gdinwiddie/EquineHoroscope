package com.gdinwiddie.equinehoroscope.acceptance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gdinwiddie.creditcardprocessor.CreditCardInfo;
import com.gdinwiddie.retail.HorseSelection;

public class EquineHoroscopeRetailWebAdapter implements EquineHoroscopeRetailAdapter {
	
	@Override
	public String purchaseHoroscope(HorseSelection horseSelection, CreditCardInfo customerCard) {
        WebDriver driver = new FirefoxDriver();
        open(driver);
        enterCreditCardInfo(driver, customerCard);
        enterHorseSelection(driver, horseSelection);
        purchase(driver);
		return getHoroscope(driver);
	}

	private String getHoroscope(WebDriver driver) {
		return driver.findElement(By.name("horoscope")).getText();
	}

	private void purchase(WebDriver driver) {
		driver.findElement(By.name("horoscope_date")).submit();
        
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return !d.findElement(By.name("horoscope")).getText().isEmpty();
            }
        });
	}

	private void enterHorseSelection(WebDriver driver, HorseSelection horseSelection) {
		driver.findElement(By.name("horse_name")).sendKeys(horseSelection.getHorseName());
        driver.findElement(By.name("horoscope_date")).sendKeys(horseSelection.getEffectiveDate());
	}

	private void enterCreditCardInfo(WebDriver driver, CreditCardInfo customerCard) {
		driver.findElement(By.name("credit_card_number")).sendKeys(customerCard.getCardNumber());
        driver.findElement(By.name("credit_card_CVV2")).sendKeys(customerCard.getCvv2());
        driver.findElement(By.name("credit_card_expiration")).sendKeys(customerCard.getExpirationDate());
	}

	private void open(WebDriver driver) {
		driver.get("http://localhost:20002/buy");
	}

}
