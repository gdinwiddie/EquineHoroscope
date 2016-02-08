package com.gdinwiddie.equinehoroscope;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.gdinwiddie.equinehoroscope.cache.HoroscopeCache;
import com.gdinwiddie.equinehoroscope.cache.InMemoryHoroscopeCache;

public class CachingHoroscopeProviderTest {
    private FakeHoroscopeProvider provider;
    private HoroscopeCache cache;

    @Before
    public void setup() {
        provider = new FakeHoroscopeProvider();
        cache = new InMemoryHoroscopeCache();
    }

    @Test
    public void canReceiveHoroscopeNotInCache() {
        provider.addHoroscope("this is the horoscope for horse on date");
        HoroscopeProvider cachingProvider = new CachingHoroscopeProvider(
                provider, cache);
        assertThat(cachingProvider.horoscopeFor("horse", "date"),
                is("this is the horoscope for horse on date"));
    }

    @Test
    public void canReceiveCachedHoroscope() {
        HoroscopeProvider cachingProvider = new CachingHoroscopeProvider(
                provider, cache);
        provider.addHoroscope("first horoscope");
        provider.addHoroscope("second horoscope");
        cachingProvider.horoscopeFor("horse", "date");
        assertThat(cachingProvider.horoscopeFor("horse", "date"),
                is("first horoscope"));
    }

    @Test
    public void ensureWeGetANewHoroscopeFromProviderForDifferentHorse() {
        String horoscope = "some canned horoscope";
        String differentHoroscope = "A different canned horoscope.";
        provider.addHoroscope(horoscope);
        provider.addHoroscope(differentHoroscope);
        HoroscopeProvider cachingProvider = new CachingHoroscopeProvider(
                provider, cache);
        assertEquals(horoscope,
                cachingProvider.horoscopeFor("Doesn't Matter", "today"));
        assertEquals(differentHoroscope,
                cachingProvider.horoscopeFor("Different Horse", "today"));
    }
}
