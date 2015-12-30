package com.gdinwiddie.equinehoroscope;

public class CrystalBall {

	private HoroscopeProvider horoscopeProvider;

	CrystalBall(HoroscopeProvider horoscopeProvider) {
		this.horoscopeProvider = horoscopeProvider;
	}

	CrystalBall() {
		this(new HoroscopeProvider() {
			
			@Override
			public String horoscopeFor(String horse, String date) {
				return "Situation cloudy, try again later";
			}
		});
	}

	public static CrystalBall instance() {
		return new CrystalBall();
	}

	public String fetchHoroscope(String horse, String effectiveDate) {
		return horoscopeProvider.horoscopeFor(horse, effectiveDate);
	}

}
