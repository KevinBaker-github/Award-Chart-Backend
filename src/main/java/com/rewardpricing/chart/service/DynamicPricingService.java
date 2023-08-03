package com.rewardpricing.chart.service;

import com.rewardpricing.chart.model.DynamicPricingRequest;
import com.rewardpricing.chart.model.DynamicPricingResponse;

public interface DynamicPricingService {
	
	public DynamicPricingResponse getPricing(DynamicPricingRequest request);

}
