package com.rewardpricing.chart.model.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RewardChartReportItem {
  private int category;
  private double rewardSaver;
  private double Standard;
  private double basePeak;
  private double premium;
  private double premiumPeak;
}
