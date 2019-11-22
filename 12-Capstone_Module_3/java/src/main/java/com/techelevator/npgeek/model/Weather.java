package com.techelevator.npgeek.model;

public class Weather {
	private String parkcode;
	private int foreCastValue;
	private int low;
	private int high;
	private String foreCast;

	public String getParkCode() {
		return parkcode;
	}

	public void setParkCode(String parkCode) {
		this.parkcode = parkCode;
	}

	public int getForeCastValue() {
		return foreCastValue;
	}

	public void setForeCastValue(int foreCastValue) {
		this.foreCastValue = foreCastValue;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public String getForeCast() {
		return foreCast;
	}

	public void setForeCast(String foreCast) {
		this.foreCast = foreCast;
	}
}
