package com.rewardpricing.chart.service;

import org.springframework.http.ResponseEntity;
import com.rewardpricing.chart.dto.DynamicPricingRequest;
import com.rewardpricing.chart.dto.DynamicPricingResponse;

public interface DynamicPricingService {

  public ResponseEntity<DynamicPricingResponse> getPricing(DynamicPricingRequest request);

}
