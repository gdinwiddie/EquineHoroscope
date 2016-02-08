package com.gdinwiddie.equinehoroscope;

import com.gdinwiddie.equinehoroscope.cache.HoroscopeCache;

public class CachingHoroscopeProvider implements HoroscopeProvider {
    private HoroscopeProvider horoscopeProvider;
    private HoroscopeCache horoscopeCache;

    public CachingHoroscopeProvider(HoroscopeProvider horoscopeProvider,
            HoroscopeCache horoscopeCache) {
        this.horoscopeProvider = horoscopeProvider;
        this.horoscopeCache = horoscopeCache;
    }

    @Override
    public String horoscopeFor(String horsename, String effectiveDate) {
        String horoscope = null;
        try {
            horoscope = horoscopeCache.horoscopeFor(horsename, effectiveDate);
        } catch (Exception e) {
            // TODO Log this
            System.err.println(e);
        }
        if (null == horoscope) {
            horoscope = horoscopeProvider
                    .horoscopeFor(horsename, effectiveDate);
            try {
                horoscopeCache
                        .putHoroscope(horsename, effectiveDate, horoscope);
            } catch (Exception e) {
                // TODO Log this
                System.err.println(e);
            }
        }
        return horoscope;
    }

}
