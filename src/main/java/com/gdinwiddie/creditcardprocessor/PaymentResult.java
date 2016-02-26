package com.gdinwiddie.creditcardprocessor;

public class PaymentResult {

	private boolean successful = false;
	private String reason = "";

	public PaymentResult(boolean success, String reason) {
		this.successful = success;
		this.reason = reason;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public String getReason() {
		return reason;
	}

}
