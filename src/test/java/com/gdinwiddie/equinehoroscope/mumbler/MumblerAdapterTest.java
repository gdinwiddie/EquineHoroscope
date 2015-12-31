package com.gdinwiddie.equinehoroscope.mumbler;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MumblerAdapterTest {

	private MumblerAdapter uut;

	@Before
	public void setUp() {
		uut = MumblerAdapter.instance();
	}
	
	@Test
	public void assureDefaultGeneratesStrings() {
		assertThat(generateHoroscope(), not(isEmptyOrNullString()));
	}

	private String generateHoroscope() {
		return uut.horoscopeFor("any horse", "any date");
	}

	@Ignore("Could have spurious failures")
	@Test
	public void assureGeneratorHasVariety() {
		Set<String> horoscopeset = new HashSet<String>();
		for (int count=0; count<5; count++) {
			horoscopeset.add(generateHoroscope());
		}
		assertThat(horoscopeset.size(), greaterThan(1));
	}
}
