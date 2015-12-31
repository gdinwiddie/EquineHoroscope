package com.gdinwiddie.equinehoroscope;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

public class CrystalBallTest {

	private FakeHoroscopeProvider horoscopeProvider;
	private CrystalBall uut;

	@Before
	public void setUp() {
		horoscopeProvider = new FakeHoroscopeProvider();
		uut = new CrystalBall(horoscopeProvider);
	}

	@Test
	public void assureWeGetHoroscopeFromProvider() {
		horoscopeProvider.addHoroscope("This is a fake horoscope.");
		String horoscope = uut.fetchHoroscope("Stewball", "today");
		assertThat(horoscope, equalTo("This is a fake horoscope."));
	}

	@Test
	public void assureWeCallProviderTwiceForTwoDates() {
		horoscopeProvider.addHoroscope("horoscope#1");
		horoscopeProvider.addHoroscope("horoscope#2");
		assertThat(uut.fetchHoroscope("Stewball", "today"), equalTo("horoscope#1"));
		assertThat(uut.fetchHoroscope("Stewball", "tomorrow"), equalTo("horoscope#2"));
	}

	@Test
	public void assureWeCallProviderTwiceForTwoHorses() {
		horoscopeProvider.addHoroscope("horoscope#1");
		horoscopeProvider.addHoroscope("horoscope#2");
		assertThat(uut.fetchHoroscope("Stewball", "today"), equalTo("horoscope#1"));
		assertThat(uut.fetchHoroscope("Barney", "today"), equalTo("horoscope#2"));
	}

}
