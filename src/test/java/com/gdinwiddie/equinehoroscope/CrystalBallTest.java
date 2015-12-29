package com.gdinwiddie.equinehoroscope;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

import org.junit.Test;

public class CrystalBallTest {

	@Test
	public void assureWeGetHoroscopeFromProvider() {
		CrystalBall uut = new CrystalBall();
		String horoscope = uut.fetchHoroscope("Stewball", "today");
		assertThat(horoscope, not(isEmptyOrNullString()));
	}

}
