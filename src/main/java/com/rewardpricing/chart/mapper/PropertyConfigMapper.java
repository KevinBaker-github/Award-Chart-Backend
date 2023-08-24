package com.rewardpricing.chart.mapper;

import org.springframework.stereotype.Component;
import com.rewardpricing.chart.entity.PropertyConfigEntity;
import com.rewardpricing.chart.model.PropertyConfig;

@Component
public class PropertyConfigMapper {
  
  public PropertyConfigEntity mapPropertyConfigToPropertyConfigEntity(PropertyConfig model) {
    return PropertyConfigEntity.builder()
        .property(model.getProperty())
        .category(model.getCategory())
        .occupancy(model.getOccupancy())
        .valuePerPoint(model.getValuePerPoint())
        .build();
  }

}
