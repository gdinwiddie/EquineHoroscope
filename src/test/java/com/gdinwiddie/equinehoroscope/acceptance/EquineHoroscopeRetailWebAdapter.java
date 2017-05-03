package com.gdinwiddie.equinehoroscope.acceptance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gdinwiddie.creditcardprocessor.CreditCardInfo;
import com.gdinwiddie.retail.HorseSelection;

public class EquineHoroscopeRetailWebAdapter implements EquineHoroscopeRetailAdapter {
	
	@Override
	public String purchaseHoroscope(HorseSelection horseSelection, CreditCardInfo customerCard) {
		WebDriver driver;
		if("firefox".equals(System.getProperty("EquineHoroscope.browserDriver"))) {
	        driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
        
        driver.get("http://localhost:20002/buy");
        driver.findElement(By.name("credit_card_number")).sendKeys(customerCard.getCardNumber());
        driver.findElement(By.name("credit_card_CVV2")).sendKeys(customerCard.getCvv2());
        driver.findElement(By.name("credit_card_expiration")).sendKeys(customerCard.getExpirationDate());
        driver.findElement(By.name("horse_name")).sendKeys(horseSelection.getHorseName());
        driver.findElement(By.name("horoscope_date")).sendKeys(horseSelection.getEffectiveDate());
        driver.findElement(By.name("horoscope_date")).submit();
        
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return !d.findElement(By.name("horoscope")).getText().isEmpty();
            }
        });
		return driver.findElement(By.name("horoscope")).getText();
	}

}
