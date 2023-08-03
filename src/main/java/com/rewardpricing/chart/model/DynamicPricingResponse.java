package com.rewardpricing.chart.model;

import java.math.BigDecimal;

public class DynamicPricingResponse {
	
	private String selectedPricingLevel;
	private BigDecimal pricing;
	
	public DynamicPricingResponse() {
		
	}
	public DynamicPricingResponse(String selectedPricingLevel, BigDecimal pricing) {
		super();
		this.selectedPricingLevel = selectedPricingLevel;
		this.pricing = pricing;
	}
	public String getSelectedPricingLevel() {
		return selectedPricingLevel;
	}
	public void setSelectedPricingLevel(String selectedPricingLevel) {
		this.selectedPricingLevel = selectedPricingLevel;
	}
	public BigDecimal getPricing() {
		return pricing;
	}
	public void setPricing(BigDecimal pricing) {
		this.pricing = pricing;
	}

}
