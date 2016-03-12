package com.gdinwiddie.equinehoroscope.acceptance;

import java.util.ArrayList;
import java.util.List;

public class HoroscopeCollector extends ArrayList<String> implements List<String> {

	private static final long serialVersionUID = 1L;
	private static HoroscopeCollector instance;

	public static HoroscopeCollector instance() {
		if (null == instance) {
			instance = new HoroscopeCollector();
		}
		instance.clear();
		return instance;
	}

}
