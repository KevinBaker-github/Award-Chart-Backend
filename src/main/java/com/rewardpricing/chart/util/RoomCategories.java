package com.rewardpricing.chart.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoomCategories {
  STANDARD("Standard"),
  PREMIUM("Premium");
  
  private String name;
}
