package com.rewardpricing.chart.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rewardpricing.chart.model.RewardPricingEntity;

@Repository
public interface RewardRepository extends JpaRepository<RewardPricingEntity, Long>{
	
}
