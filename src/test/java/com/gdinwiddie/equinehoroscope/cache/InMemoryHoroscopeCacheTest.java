package com.gdinwiddie.equinehoroscope.cache;

import org.junit.Before;

public class InMemoryHoroscopeCacheTest extends HoroscopeCacheTestTemplate {

	@Before
	public void setUp() {
		setCache(new InMemoryHoroscopeCache());
	}

}
