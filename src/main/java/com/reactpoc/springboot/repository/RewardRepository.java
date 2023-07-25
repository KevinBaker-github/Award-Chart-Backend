package com.reactpoc.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reactpoc.springboot.model.RewardPricingModel;

@Repository
public interface RewardRepository extends JpaRepository<RewardPricingModel, Long>{
	
}
