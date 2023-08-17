package com.rewardpricing.chart.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AwardChartCsvRequestDto {
  
  private List<Integer> categories;
  
}
