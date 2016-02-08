package com.gdinwiddie.equinehoroscope.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public abstract class HoroscopeCacheTestTemplate {
	private HoroscopeCache cache;

	protected void setCache(HoroscopeCache cache) {
		this.cache = cache;
	}

	@Test
	public void emptyCacheReturnsNull() throws Exception {
		assertNull(cache.horoscopeFor("", ""));
	}

	@Test
	public void ensureCanGetOneValue() throws Exception {
		cache.putHoroscope("horse", "date", "horoscope");
		assertEquals("horoscope", cache.horoscopeFor("horse", "date"));
	}

	@Test
	public void ensureCanGetThreeValuesOutOfOrder() throws Exception {
		cache.putHoroscope("horse1", "date1", "horoscope1");
		cache.putHoroscope("horse2", "date2", "horoscope2");
		cache.putHoroscope("horse3", "date3", "horoscope3");
		assertEquals("horoscope2", cache.horoscopeFor("horse2", "date2"));
		assertEquals("horoscope3", cache.horoscopeFor("horse3", "date3"));
		assertEquals("horoscope1", cache.horoscopeFor("horse1", "date1"));
	}

	@Test
	public void ensureCanNotGetValueNotThere() throws Exception {
		cache.putHoroscope("horse1", "date1", "horoscope1");
		cache.putHoroscope("horse2", "date2", "horoscope2");
		cache.putHoroscope("horse3", "date3", "horoscope3");
		assertNull(cache.horoscopeFor("horse1", "date3"));
	}
}
