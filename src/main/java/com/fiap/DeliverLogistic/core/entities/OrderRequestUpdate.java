package com.fiap.DeliverLogistic.core.entities;

public class OrderRequestUpdate {

	private String status;
	private String expectedTimeToDeliver;
	private String localization;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExpectedTimeToDeliver() {
		return expectedTimeToDeliver;
	}

	public void setExpectedTimeToDeliver(String expectedTimeToDeliver) {
		this.expectedTimeToDeliver = expectedTimeToDeliver;
	}

	public String getLocalization() {
		return localization;
	}

	public void setLocalization(String localization) {
		this.localization = localization;
	}

}
