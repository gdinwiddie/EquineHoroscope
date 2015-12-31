package com.gdinwiddie.equinehoroscope;

import java.util.HashMap;
import java.util.Map;

public class InMemoryHoroscopeCache implements HoroscopeCache {
	private Map<String, String> horoscopes = new HashMap<String, String>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gdinwiddie.equinehoroscope.HoroscopeCache#horoscopeFor(java.lang.
	 * String, java.lang.String)
	 */
	public String horoscopeFor(String horsename, String effectiveDate) {
		return horoscopes.get(makeKey(horsename, effectiveDate));
	}

	private String makeKey(String horsename, String effectiveDate) {
		return horsename + "~" + effectiveDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gdinwiddie.equinehoroscope.HoroscopeCache#putHoroscope(java.lang.
	 * String, java.lang.String, java.lang.String)
	 */
	public void putHoroscope(String horsename, String effectiveDate, String horoscope) {
		horoscopes.put(makeKey(horsename, effectiveDate), horoscope);
	}

}
