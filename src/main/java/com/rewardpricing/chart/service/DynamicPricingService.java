package com.rewardpricing.chart.service;

import org.springframework.http.ResponseEntity;

import com.rewardpricing.chart.model.DynamicPricingRequest;
import com.rewardpricing.chart.model.DynamicPricingResponse;

public interface DynamicPricingService {
	
	public ResponseEntity<DynamicPricingResponse> getPricing(DynamicPricingRequest request);

}
