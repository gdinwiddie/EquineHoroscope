package com.gdinwiddie.equinehoroscope;

import org.junit.Before;

public class InMemoryHoroscopeCacheTest extends HoroscopeCacheTestTemplate {

	@Before
	public void setUp() {
		setCache(new InMemoryHoroscopeCache());
	}

}
