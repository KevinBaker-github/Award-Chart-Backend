package com.rewardpricing.chart.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rewardpricing.chart.model.Constants;
import com.rewardpricing.chart.model.DynamicPricingRequest;
import com.rewardpricing.chart.model.DynamicPricingResponse;
import com.rewardpricing.chart.model.RewardPricingEntity;
import com.rewardpricing.chart.repository.RewardRepository;
import com.rewardpricing.chart.service.DynamicPricingService;

@Service
public class DynamicPricingServiceImpl implements DynamicPricingService{
	

	@Autowired
	private RewardRepository repository;

	@Override
	public ResponseEntity<DynamicPricingResponse> getPricing(DynamicPricingRequest request) {
		DynamicPricingResponse response = new DynamicPricingResponse();
		response.setRoomType(request.getRoomCategory());
		// fetch entity
		Optional<RewardPricingEntity> finalStandardentity = this.repository.findByCategoryAndRoomCategoryAndPricingLevel(request.getCategory(),
				Constants.STANDARD, Constants.STANDARD);
		if (finalStandardentity.isPresent()) {
			RewardPricingEntity standardEntity = finalStandardentity.get();
			//1. calculate floating level
			double floatingPointLevelCheck = request.getForecastedBar()/(request.getPropertyValue());
			int floatingPointLevel = (int) (Math.round(floatingPointLevelCheck/1000)*1000);
			response.setFloatingPointLevel(floatingPointLevel);
			if (floatingPointLevel > standardEntity.getPoints()) {
	            //floatingPointLevel is greater than points
				response.setFloatingAboveStandard(true);
				//premium or not we need basepeak
				Optional<RewardPricingEntity> finalBasePeakEntity = this.repository.findByCategoryAndRoomCategoryAndPricingLevel(request.getCategory(),
						Constants.STANDARD, Constants.BASE_PEAK);
				if(finalBasePeakEntity.isPresent()) {
					RewardPricingEntity basePeakEntity = finalBasePeakEntity.get();
					//check shopping for premium roomtype
					if(request.getRoomCategory().equalsIgnoreCase(Constants.PREMIUM)) {
						response.setPremium(true);
						if(floatingPointLevel > basePeakEntity.getPoints()) {
							//return premium peak pricing
							Optional<RewardPricingEntity> finalPremiumPeakEntity = this.repository.findByCategoryAndRoomCategoryAndPricingLevel(request.getCategory(),
									Constants.PREMIUM, Constants.PREMIUM_PEAK);
							if(finalPremiumPeakEntity.isPresent()) {
								//set premiumPeak pricing
								RewardPricingEntity premiumPeakEntity = finalPremiumPeakEntity.get();
								response.setCalculatedPricingLevel(premiumPeakEntity.getPricingLevel());
								response.setPricing(premiumPeakEntity.getPoints());
							}
							else {
								System.out.println("no PremiumPeak data");
								response.setCalculatedPricingLevel("PremiumPeak Pricing Level data not found for category : " + request.getCategory());
								return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
							}
						}
						else {
							// return floating premium point level which is double the floatingpointlevel
							response.setCalculatedPricingLevel(Constants.FLOATING_POINT_LEVEL_PREMIUM);
							response.setPricing(floatingPointLevel*2);
							System.out.println("*********just to check ***********" + response.getPricing());
						}
					}
					else {
						//not premium 
						response.setPremium(false);
						if(floatingPointLevel > basePeakEntity.getPoints()) {
							//return Base peak pricing
							response.setCalculatedPricingLevel(basePeakEntity.getPricingLevel());
							response.setPricing(basePeakEntity.getPoints());
						}
						else {
							// return floating point level
							response.setCalculatedPricingLevel(Constants.FLOATING_POINT_LEVEL);
							response.setPricing(floatingPointLevel);
						}
						
					}
				}
				else {
					System.out.println("no BasePeak data");
					response.setCalculatedPricingLevel("BasePeak Pricing Level data not found for category : " + request.getCategory());
					return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
				}
				
			}
			else {
				//floatingPointLevel is below the awardchart standard points
				response.setFloatingAboveStandard(false);
				//check shopping for premium roomtype
				if(request.getRoomCategory().equalsIgnoreCase(Constants.PREMIUM)) {
					//yes premium room type
					response.setPremium(true);
					Optional<RewardPricingEntity> finalPremiumEntity = this.repository.findByCategoryAndRoomCategoryAndPricingLevel(request.getCategory(),
							Constants.PREMIUM, Constants.PREMIUM);
					if(finalPremiumEntity.isPresent()) {
						//set premium pricing
						RewardPricingEntity premiumEntity = finalPremiumEntity.get();
						response.setCalculatedPricingLevel(premiumEntity.getPricingLevel());
						response.setPricing(premiumEntity.getPoints());
					}
					else {
						System.out.println("no premium data");
						response.setCalculatedPricingLevel("Premium Pricing Level data not found for category : " + request.getCategory());
						return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
					}
				}else {
					//not premium room type so check for occupancy threshold
					response.setPremium(false);
					if(request.getForecastedOccupancy() > request.getRewardSaverOccupancy()) {
						//if greater occupancy then standard
						response.setOccupancyThresholdAbove(true);
							response.setCalculatedPricingLevel(standardEntity.getPricingLevel());
							response.setPricing(standardEntity.getPoints());
					}
					else {//not premium roomtype and occupancy below so reward pricing
						response.setOccupancyThresholdAbove(false);
						Optional<RewardPricingEntity> finalRewardSaverEntity = this.repository.findByCategoryAndRoomCategoryAndPricingLevel(request.getCategory(),
								Constants.STANDARD, Constants.REWARD_SAVER);
						if(finalRewardSaverEntity.isPresent()) {
							RewardPricingEntity rewardSaverEntity = finalRewardSaverEntity.get();
							response.setCalculatedPricingLevel(rewardSaverEntity.getPricingLevel());
							response.setPricing(rewardSaverEntity.getPoints());
						}
						else {
							System.out.println("no RewardSaver data");
							response.setCalculatedPricingLevel("RewardSaver Pricing Level data not found for category : " + request.getCategory());
							return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
						}
					}
				}
				
			}
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {
			//TODO what need to be returned
			System.out.println("no Standard Room Category data for category : " + request.getCategory());
			return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
		}
	}

}
