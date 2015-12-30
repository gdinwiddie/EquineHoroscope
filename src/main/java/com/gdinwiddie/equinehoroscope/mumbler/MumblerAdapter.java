package com.gdinwiddie.equinehoroscope.mumbler;

import com.gdinwiddie.equinehoroscope.HoroscopeProvider;

import main.Mumbler;

public class MumblerAdapter implements HoroscopeProvider {

	private Mumbler mumbler;
	private static final String DEFAULT_RULES = "{<start>Outlook cloudy, try again later.}";

	MumblerAdapter(String grammarRules) {
		this.mumbler = new Mumbler();
		mumbler.loadRules(grammarRules);
	}

	@Override
	public String horoscopeFor(String horse, String date) {
		return mumbler.generate();
	}

	public static MumblerAdapter instance() {
		return new MumblerAdapter(DEFAULT_RULES);
	}
}
