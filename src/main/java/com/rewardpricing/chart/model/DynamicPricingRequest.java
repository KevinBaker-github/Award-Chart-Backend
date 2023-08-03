package com.rewardpricing.chart.model;

import java.math.BigDecimal;

public class DynamicPricingRequest {
	
	private int category;
	private String roomCategory;
	private String pricingLevel;
	private BigDecimal forecastedBar;
	private BigDecimal forecastedOccupancy;
	private BigDecimal rewardSaverOccupancy;
	private BigDecimal propertyValue;
	
	public DynamicPricingRequest() {
		
	}
	
	public DynamicPricingRequest(int category, String roomCategory, String pricingLevel, BigDecimal forecastedBar, BigDecimal forecastedOccupancy, BigDecimal rewardSaverOccupancy,
			BigDecimal propertyValue) {
		super();
		this.category = category;
		this.setRoomCategory(roomCategory);
		this.setPricingLevel(pricingLevel);
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
	public BigDecimal getForecastedBar() {
		return forecastedBar;
	}
	public void setForecastedBar(BigDecimal forecastedBar) {
		this.forecastedBar = forecastedBar;
	}
	public BigDecimal getForecastedOccupancy() {
		return forecastedOccupancy;
	}
	public void setForecastedOccupancy(BigDecimal forecastedOccupancy) {
		this.forecastedOccupancy = forecastedOccupancy;
	}
	public BigDecimal getRewardSaverOccupancy() {
		return rewardSaverOccupancy;
	}
	public void setRewardSaverOccupancy(BigDecimal rewardSaverOccupancy) {
		this.rewardSaverOccupancy = rewardSaverOccupancy;
	}
	public BigDecimal getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(BigDecimal propertyValue) {
		this.propertyValue = propertyValue;
	}

	public String getPricingLevel() {
		return pricingLevel;
	}

	public void setPricingLevel(String pricingLevel) {
		this.pricingLevel = pricingLevel;
	}

	public String getRoomCategory() {
		return roomCategory;
	}

	public void setRoomCategory(String roomCategory) {
		this.roomCategory = roomCategory;
	}

}
