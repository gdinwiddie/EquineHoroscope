package com.gdinwiddie.equinehoroscope.acceptance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gdinwiddie.creditcardprocessor.CreditCardInfo;
import com.gdinwiddie.retail.HorseSelection;

public class PurchasePage {

	private WebDriver driver;

	public PurchasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void open() {
		driver.get("http://localhost:20002/buy");
	}

	public void enterCreditCardInfo(CreditCardInfo customerCard) {
		driver.findElement(By.name("credit_card_number")).sendKeys(customerCard.getCardNumber());
	    driver.findElement(By.name("credit_card_CVV2")).sendKeys(customerCard.getCvv2());
	    driver.findElement(By.name("credit_card_expiration")).sendKeys(customerCard.getExpirationDate());
	}

	public void enterHorseSelection(HorseSelection horseSelection) {
		driver.findElement(By.name("horse_name")).sendKeys(horseSelection.getHorseName());
	    driver.findElement(By.name("horoscope_date")).sendKeys(horseSelection.getEffectiveDate());
	}

	public void purchase() {
		driver.findElement(By.name("horoscope_date")).submit();
	    
	    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver d) {
	            return !d.findElement(By.name("horoscope")).getText().isEmpty();
	        }
	    });
	}

	public String getHoroscope() {
		return driver.findElement(By.name("horoscope")).getText();
	}

}
