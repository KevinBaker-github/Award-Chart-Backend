package com.rewardpricing.chart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DynamicPricingResponse {

  private String roomType;
  private int floatingPointLevel;
  private boolean isFloatingAboveStandard;
  private boolean isPremium;
  private boolean isFloatingAboveBasePeak;
  private boolean isoccupancyThresholdAbove;
  private String calculatedPricingLevel;
  private double pricing;
}
