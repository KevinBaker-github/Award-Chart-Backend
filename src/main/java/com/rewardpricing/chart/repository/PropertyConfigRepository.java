package com.rewardpricing.chart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rewardpricing.chart.entity.PropertyConfigEntity;

@Repository
public interface PropertyConfigRepository extends JpaRepository<PropertyConfigEntity, Long> {
  
}
