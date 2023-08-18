package com.rewardpricing.chart.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PricingLevels {
  REWARD_SAVER("RewardSaver"),
  STANDARD("Standard"),
  BASE_PEAK("BasePeak"),
  PREMIUM("Premium"),
  PREMIUM_PEAK("PremiumPeak");
  
  private String name;
}
