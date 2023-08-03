package com.rewardpricing.chart.reponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.rewardpricing.chart.model.PricingLevel;
import com.rewardpricing.chart.model.ResponseRewardChart;
import com.rewardpricing.chart.model.RewardPricingEntity;
import com.rewardpricing.chart.model.RoomCategory;

public class RewardChartResponseMapper {

	public static List<ResponseRewardChart> buildAwardChartResponse(List<RewardPricingEntity> awardChartEntities) {
		Map<Integer, Map<String, Map<String, List<RewardPricingEntity>>>> map = awardChartEntities.stream()
				.collect(Collectors.groupingBy(RewardPricingEntity::getCategory,
						Collectors.groupingBy(RewardPricingEntity::getRoomCategory,
								Collectors.groupingBy(RewardPricingEntity::getPricingLevel))));

		List<ResponseRewardChart> responseList = new ArrayList<>();
		for (Entry<Integer, Map<String, Map<String, List<RewardPricingEntity>>>> entry : map.entrySet()) {
			Map<String, Map<String, List<RewardPricingEntity>>> firstChildMap = entry.getValue();
			ResponseRewardChart awardChart = new ResponseRewardChart();
			awardChart.setCategory(entry.getKey());
			List<RoomCategory> roomCategoryList = new ArrayList<>();
			for (Entry<String, Map<String, List<RewardPricingEntity>>> entry1 : firstChildMap.entrySet()) {
				Map<String, List<RewardPricingEntity>> secondChildMap = entry1.getValue();
				RoomCategory roomCategory = new RoomCategory();
				roomCategory.setName(entry1.getKey());
				List<PricingLevel> pricingLevelList = new ArrayList<>();

				for (Entry<String, List<RewardPricingEntity>> entry2 : secondChildMap.entrySet()) {
					PricingLevel pricingLevel = new PricingLevel();
					pricingLevel.setPricingLevel(entry2.getKey());
					for (RewardPricingEntity model1 : entry2.getValue()) {
						pricingLevel.setPoints(model1.getPoints());
					}
					pricingLevelList.add(pricingLevel);
				}
				roomCategory.setPricingLevels(pricingLevelList);
				roomCategoryList.add(roomCategory);
			}
			awardChart.setRoomCategories(roomCategoryList);

			responseList.add(awardChart);
		}
		return responseList;

	}

}
