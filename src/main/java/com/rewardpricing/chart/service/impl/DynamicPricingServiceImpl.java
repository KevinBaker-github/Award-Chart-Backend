package com.rewardpricing.chart.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rewardpricing.chart.model.DynamicPricingRequest;
import com.rewardpricing.chart.model.DynamicPricingResponse;
import com.rewardpricing.chart.model.RewardPricingEntity;
import com.rewardpricing.chart.repository.RewardRepository;
import com.rewardpricing.chart.service.DynamicPricingService;

@Service
public class DynamicPricingServiceImpl implements DynamicPricingService{
	
	
//	private int category;
//	private String pricingLevel;
//	private BigDecimal forecastedBar;
//	private BigDecimal forecastedOccupancy;
//	private BigDecimal rewardSaverOccupancy;
//	private BigDecimal propertyValue;
	
	@Autowired
	private RewardRepository repository;

	@Override
	public DynamicPricingResponse getPricing(DynamicPricingRequest request) {
		DynamicPricingResponse response = new DynamicPricingResponse();
		response.setSelectedPricingLevel(request.getPricingLevel());
		// fetch entity
		Optional<RewardPricingEntity> existingEntity = this.repository.findByCategoryAndRoomCategoryAndPricingLevel(request.getCategory(),
				request.getRoomCategory(), request.getPricingLevel());
		RewardPricingEntity entity = existingEntity.get();
		BigDecimal points = new BigDecimal(entity.getPoints());
		if (existingEntity.isPresent()) {
			//1. calculate floating level
			BigDecimal floatingPointLevel = request.getForecastedBar().divide(request.getPropertyValue());
			floatingPointLevel = floatingPointLevel.setScale(2, RoundingMode.HALF_UP);
			
			if (floatingPointLevel.compareTo(points) == 1) {
	            //floatingPointLevel is greater than points
			}
			else {
				if(request.getForecastedOccupancy().compareTo(request.getRewardSaverOccupancy()) == 1) {
					////ForecastedOccupancy is greater than RewardSaverOccupancy
					response.setPricing(points);
				}
			}
			
		}else {
			
		}
		
		
		return null;
	}

}
