package com.rewardpricing.chart.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rewardpricing.chart.model.RewardPricingEntity;

@Repository
public interface RewardRepository extends JpaRepository<RewardPricingEntity, Long>{
	
	
	public void deleteByCategory(int category);
	
	public List<RewardPricingEntity> findByCategory(int category);
	
	public Optional<RewardPricingEntity> findByCategoryAndRoomCategoryAndPricingLevel(int category, String roomCategory, String pricingLevel);
	
	
}
