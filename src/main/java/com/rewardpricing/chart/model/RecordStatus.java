package com.rewardpricing.chart.model;

import java.util.List;
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
public class RecordStatus {
  private long recordNumber;
  private PropertyConfig propertyConfig;
  private boolean isError;
  private List<String> messages;
}
