package com.gdinwiddie.equinehoroscope.mumbler;

import java.io.IOException;
import java.io.InputStream;

import com.gdinwiddie.equinehoroscope.HoroscopeProvider;

import main.Mumbler;

public class MumblerAdapter implements HoroscopeProvider {

	private Mumbler mumbler;
	private static final String DEFAULT_RULES = "{<start>Outlook cloudy, try again later.}";

	MumblerAdapter(String grammarRules) {
		this.mumbler = new Mumbler();
		mumbler.loadRules(grammarRules);
	}

	MumblerAdapter(InputStream stream) {
		this.mumbler = new Mumbler();
        try {
            mumbler.loadStream(stream);
        } catch (IOException e) {
            mumbler.loadRules(DEFAULT_RULES);
        }
	}

	@Override
	public String horoscopeFor(String horse, String date) {
		return mumbler.generate();
	}

	public static MumblerAdapter instance() {
		String resourceName = "/com/gdinwiddie/equinehoroscope/mumbler/MumblerHoroscopeRules.g";
		ResourceLoader loader = new ResourceLoader();
		InputStream stream = loader.loadResourceStream(resourceName);
		return new MumblerAdapter(stream);
	}

	static class ResourceLoader {
		InputStream loadResourceStream(String name) {
			return getClass().getResourceAsStream(name);
		}
	}
}
