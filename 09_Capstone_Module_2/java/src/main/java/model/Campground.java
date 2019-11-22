package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Campground {

	private Long id;
	private Long parkId;
	private String name;
	private String openFrom;
	private String openTo;
	private String dailyFee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParkId() {
		return parkId;
	}

	public void setParkId(Long parkId) {
		this.parkId = parkId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpenFrom() {
		return openFrom;
	}

	public void setOpenFrom(String openFrom) {
		this.openFrom = openFrom;
	}

	public String getOpenTo() {
		return openTo;
	}

	public void setOpenTo(String openTo) {
		this.openTo = openTo;
	}

	public String getDailyFee() {
		return dailyFee;
	}

	public void setDailyFee(String dailyFee) {
		this.dailyFee = dailyFee;
	}

}
