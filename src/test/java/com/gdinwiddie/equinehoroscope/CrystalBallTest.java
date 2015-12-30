package com.gdinwiddie.equinehoroscope;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class CrystalBallTest {

	@Test
	public void assureWeGetHoroscopeFromProvider() {
		CrystalBall uut = new CrystalBall(new FakeHoroscopeProvider());
		String horoscope = uut.fetchHoroscope("Stewball", "today");
		assertThat(horoscope, equalTo("This is a fake horoscope."));
	}
	
	static class FakeHoroscopeProvider implements HoroscopeProvider {
		/* (non-Javadoc)
		 * @see com.gdinwiddie.equinehoroscope.HoroscopeProvider#horoscopeFor(java.lang.String, java.lang.String)
		 */
		@Override
		public String horoscopeFor(String horse, String date) {
			return "This is a fake horoscope.";
		}
	}

}
