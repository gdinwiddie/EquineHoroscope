package com.gdinwiddie.retail;

public class HorseSelection {

	private String horseName;
	private String effectiveDate;

	public HorseSelection(String horseName, String effectiveDate) {
		this.horseName = horseName;
		this.effectiveDate = effectiveDate;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public String getHorseName() {
		return horseName;
	}

}
