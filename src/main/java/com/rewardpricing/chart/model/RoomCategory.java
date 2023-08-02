package com.rewardpricing.chart.model;

import java.util.List;

public class RoomCategory {

	private String name;
	private List<PricingLevel> pricingLevels;
	
	public RoomCategory() {
	}

	public RoomCategory(String name, List<PricingLevel> pricingLevels) {
		super();
		this.name = name;
		this.pricingLevels = pricingLevels;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PricingLevel> getPricingLevels() {
		return pricingLevels;
	}

	public void setPricingLevels(List<PricingLevel> pricingLevels) {
		this.pricingLevels = pricingLevels;
	}

}
