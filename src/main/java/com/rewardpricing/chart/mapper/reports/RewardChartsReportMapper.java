package com.rewardpricing.chart.mapper.reports;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.rewardpricing.chart.entity.RewardPricingEntity;
import com.rewardpricing.chart.model.reports.RewardChartReportItem;
import com.rewardpricing.chart.util.RoomCategories;

@Component
public class RewardChartsReportMapper {


  public List<RewardChartReportItem> mapFromRewardChartEntitiesToReportItems(
      List<RewardPricingEntity> entities) {

    Map<Integer, List<RewardPricingEntity>> map =
        entities.stream().collect(Collectors.groupingBy(RewardPricingEntity::getCategory));

    List<RewardChartReportItem> result = new ArrayList<>();
    for (Entry<Integer, List<RewardPricingEntity>> categoryEntry : map.entrySet()) {
      RewardChartReportItem reportItem = new RewardChartReportItem();
      reportItem.setCategory(categoryEntry.getKey()); // CategoryId extraction

      for (RewardPricingEntity entity : categoryEntry.getValue()) {
        if (entity.getRoomCategory().equals(RoomCategories.STANDARD.getName())) {
          setStandardPricingLevels(entity, reportItem);
        } else {
          setPremiumPricingLevels(entity, reportItem);
        }
      }
      result.add(reportItem);
    }
    
    return result;
  }

  private void setStandardPricingLevels(RewardPricingEntity entity, RewardChartReportItem reportItem) {
    switch (entity.getPricingLevel()) {
      case "RewardSaver":
        reportItem.setRewardSaver(entity.getPoints());
        break;
      case "Standard":
        reportItem.setStandard(entity.getPoints());
        break;
      case "BasePeak":
        reportItem.setBasePeak(entity.getPoints());
        break;
      default:
        break;
    }
  }

  private void setPremiumPricingLevels(RewardPricingEntity entity, RewardChartReportItem reportItem) {
    switch (entity.getPricingLevel()) {
      case "Premium":
        reportItem.setPremium(entity.getPoints());
        break;
      case "PremiumPeak":
        reportItem.setPremiumPeak(entity.getPoints());
        break;
      default:
        break;
    }
  }

}
