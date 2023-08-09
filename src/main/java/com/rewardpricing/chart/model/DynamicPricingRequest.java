package com.rewardpricing.chart.model;

import java.math.BigDecimal;

public class DynamicPricingRequest {
	
	private int category;
	private String roomCategory;
	//private String pricingLevel;
	//private String roomType;
	private double forecastedBar;
	private double forecastedOccupancy;
	private double rewardSaverOccupancy;
	private double propertyValue;
	
	public DynamicPricingRequest() {
		
	}
	
	public DynamicPricingRequest(int category, String roomCategory, double forecastedBar, double forecastedOccupancy, double rewardSaverOccupancy,
			double propertyValue) {
		super();
		this.category = category;
		this.roomCategory = roomCategory;
		this.forecastedBar = forecastedBar;
		this.forecastedOccupancy = forecastedOccupancy;
		this.rewardSaverOccupancy = rewardSaverOccupancy;
		this.propertyValue = propertyValue;
	}

	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public double getForecastedBar() {
		return forecastedBar;
	}
	public void setForecastedBar(double forecastedBar) {
		this.forecastedBar = forecastedBar;
	}
	public double getForecastedOccupancy() {
		return forecastedOccupancy;
	}
	public void setForecastedOccupancy(double forecastedOccupancy) {
		this.forecastedOccupancy = forecastedOccupancy;
	}
	public double getRewardSaverOccupancy() {
		return rewardSaverOccupancy;
	}
	public void setRewardSaverOccupancy(double rewardSaverOccupancy) {
		this.rewardSaverOccupancy = rewardSaverOccupancy;
	}
	public double getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(double propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String getRoomCategory() {
		return roomCategory;
	}

	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}

}
