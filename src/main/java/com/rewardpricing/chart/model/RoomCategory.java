package com.rewardpricing.chart.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoomCategory {

  private String name;
  private List<PricingLevel> pricingLevels;

}
