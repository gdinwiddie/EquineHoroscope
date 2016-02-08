package com.gdinwiddie.equinehoroscope.cache;

public interface HoroscopeCache {

	public abstract String horoscopeFor(String horsename, String effectiveDate) throws Exception;

	public abstract void putHoroscope(String horsename, String effectiveDate, String horoscope) throws Exception;

}