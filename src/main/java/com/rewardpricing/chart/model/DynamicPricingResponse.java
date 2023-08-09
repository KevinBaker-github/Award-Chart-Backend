package com.rewardpricing.chart.model;

public class DynamicPricingResponse {
	
	
	//adding each step value output
	private String roomType;
	private int floatingPointLevel;
	private boolean isFloatingAboveStandard;
	private boolean isPremium;
	private boolean isFloatingAboveBasePeak;
	private boolean isoccupancyThresholdAbove;
	private String calculatedPricingLevel;
	private double pricing;
	
	public DynamicPricingResponse() {
		
	}

	public double getPricing() {
		return pricing;
	}
	public void setPricing(double pricing) {
		this.pricing = pricing;
	}

	public int getFloatingPointLevel() {
		return floatingPointLevel;
	}

	public void setFloatingPointLevel(int floatingPointLevel) {
		this.floatingPointLevel = floatingPointLevel;
	}

	public boolean isFloatingAboveStandard() {
		return isFloatingAboveStandard;
	}

	public void setFloatingAboveStandard(boolean isFloatingAboveStandard) {
		this.isFloatingAboveStandard = isFloatingAboveStandard;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public boolean isFloatingAboveBasePeak() {
		return isFloatingAboveBasePeak;
	}

	public void setFloatingAboveBasePeak(boolean isFloatingAboveBasePeak) {
		this.isFloatingAboveBasePeak = isFloatingAboveBasePeak;
	}

	public boolean isoccupancyThresholdAbove() {
		return isoccupancyThresholdAbove;
	}

	public void setOccupancyThresholdAbove(boolean occupancyThresholdAbove) {
		this.isoccupancyThresholdAbove = occupancyThresholdAbove;
	}

	public String getCalculatedPricingLevel() {
		return calculatedPricingLevel;
	}

	public void setCalculatedPricingLevel(String calculatedPricingLevel) {
		this.calculatedPricingLevel = calculatedPricingLevel;
	}

	public boolean isPremium() {
		return isPremium;
	}

	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}

}
