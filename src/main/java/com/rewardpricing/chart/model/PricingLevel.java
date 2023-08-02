package com.rewardpricing.chart.model;

public class PricingLevel {

	private String pricingLevel;
	private String points;
	
	public PricingLevel() {
		
	}
	public PricingLevel(String pricingLevel, String points) {
		super();
		this.pricingLevel = pricingLevel;
		this.points = points;
	}

	public String getPricingLevel() {
		return pricingLevel;
	}

	public void setPricingLevel(String pricingLevel) {
		this.pricingLevel = pricingLevel;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}
	
}
