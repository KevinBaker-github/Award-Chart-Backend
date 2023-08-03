package com.rewardpricing.chart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rewardpricing.chart.model.ResponseRewardChart;
import com.rewardpricing.chart.model.RewardPricingEntity;

public interface RewardChartService {
	
	public List<ResponseRewardChart> listAll();
	
	public List<ResponseRewardChart> findByCategory(int category);
	
	public ResponseEntity<RewardPricingEntity> updateCategory(RewardPricingEntity request);
	
	public ResponseEntity<RewardPricingEntity> addCategory(RewardPricingEntity request);
	
	public void deleteCategory(int Category);
	
}
