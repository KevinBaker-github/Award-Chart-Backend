package com.rewardpricing.chart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DynamicPricingRequest {

  private int category;
  private String roomCategory;
  private double forecastedBar;
  private double forecastedOccupancy;
  private double rewardSaverOccupancy;
  private double propertyValue;

}
