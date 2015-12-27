package com.gdinwiddie.equinehoroscope;

public class CrystalBall {

	public static CrystalBall instance() {
		return new CrystalBall();
	}

	public String fetchHoroscope(String horse, String effectiveDate) {
		return "Situation cloudy, try again later";
	}

}
