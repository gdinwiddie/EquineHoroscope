package com.gdinwiddie.equinehoroscope.mumbler;

import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MumblerAdapterTest {

	@Test
	public void assureDefaultGeneratesStrings() {
		MumblerAdapter uut = MumblerAdapter.instance();
		assertThat(uut.horoscopeFor("any horse", "any date"), not(isEmptyOrNullString()));
	}

}
