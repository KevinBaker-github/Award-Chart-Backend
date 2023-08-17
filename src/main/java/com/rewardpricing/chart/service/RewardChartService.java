package com.rewardpricing.chart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.rewardpricing.chart.entity.RewardPricingEntity;
import com.rewardpricing.chart.model.ResponseRewardChart;

public interface RewardChartService {

  public List<ResponseRewardChart> listAll();

  public List<ResponseRewardChart> findByCategory(int category);

  public ResponseEntity<RewardPricingEntity> updateCategory(RewardPricingEntity request);

  public ResponseEntity<RewardPricingEntity> addCategory(RewardPricingEntity request);

  public void deleteCategory(int Category);

}
