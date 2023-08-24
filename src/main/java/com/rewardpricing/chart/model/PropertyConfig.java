package com.rewardpricing.chart.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class PropertyConfig {
  private long id;
  private String property;
  private int category;
  private double occupancy;
  private double valuePerPoint;

}
