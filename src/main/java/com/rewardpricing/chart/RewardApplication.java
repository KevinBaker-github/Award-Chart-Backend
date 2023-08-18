package com.rewardpricing.chart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.rewardpricing.chart.entity.RewardPricingEntity;
import com.rewardpricing.chart.repository.RewardRepository;

@SpringBootApplication
public class RewardApplication implements CommandLineRunner {

  @Autowired
  private RewardRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(RewardApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    repository.save(new RewardPricingEntity(1, "Standard", "RewardSaver", 10000, null, "neelima"));
    repository.save(new RewardPricingEntity(1, "Standard", "Standard", 40000, null, "neelima"));
    repository.save(new RewardPricingEntity(1, "Standard", "BasePeak", 20000, null, "neelima"));
    repository.save(new RewardPricingEntity(1, "Premium", "Premium", 75000, null, "neelima"));
    repository.save(new RewardPricingEntity(1, "Premium", "PremiumPeak", 20000, null, "neelima"));

    repository.save(new RewardPricingEntity(2, "Standard", "RewardSaver", 1000, null, "neelima"));
    repository.save(new RewardPricingEntity(2, "Standard", "Standard", 1000, null, "neelima"));
    repository.save(new RewardPricingEntity(2, "Standard", "BasePeak", 2000, null, "neelima"));
    repository.save(new RewardPricingEntity(2, "Premium", "Premium", 10000, null, "neelima"));
    repository.save(new RewardPricingEntity(2, "Premium", "PremiumPeak", 20000, null, "neelima"));

    repository.save(new RewardPricingEntity(3, "Standard", "RewardSaver", 30000, null, "neelima"));
    repository.save(new RewardPricingEntity(3, "Standard", "Standard", 10000, null, "neelima"));
    repository.save(new RewardPricingEntity(3, "Standard", "BasePeak", 50000, null, "neelima"));
    repository.save(new RewardPricingEntity(3, "Premium", "Premium", 87000, null, "neelima"));
    repository.save(new RewardPricingEntity(3, "Premium", "PremiumPeak", 98000, null, "neelima"));

    repository.save(new RewardPricingEntity(4, "Standard", "RewardSaver", 20000, null, "neelima"));
    repository.save(new RewardPricingEntity(4, "Standard", "Standard", 20000, null, "neelima"));
    repository.save(new RewardPricingEntity(4, "Standard", "BasePeak", 30000, null, "neelima"));
    repository.save(new RewardPricingEntity(4, "Premium", "Premium", 67000, null, "neelima"));
    repository.save(new RewardPricingEntity(4, "Premium", "PremiumPeak", 88000, null, "neelima"));

    repository.save(new RewardPricingEntity(5, "Standard", "RewardSaver", 35000, null, "neelima"));
    repository.save(new RewardPricingEntity(5, "Standard", "Standard", 40000, null, "neelima"));
    repository.save(new RewardPricingEntity(5, "Standard", "BasePeak", 75000, null, "neelima"));
    repository.save(new RewardPricingEntity(5, "Premium", "Premium", 75000, null, "neelima"));
    repository.save(new RewardPricingEntity(5, "Premium", "PremiumPeak", 150000, null, "neelima"));

    repository.save(new RewardPricingEntity(6, "Standard", "RewardSaver", 35000, null, "neelima"));
    repository.save(new RewardPricingEntity(6, "Standard", "Standard", 40000, null, "neelima"));
    repository.save(new RewardPricingEntity(6, "Standard", "BasePeak", 75000, null, "neelima"));
    repository.save(new RewardPricingEntity(6, "Premium", "Premium", 75000, null, "neelima"));
    repository.save(new RewardPricingEntity(6, "Premium", "PremiumPeak", 150000, null, "neelima"));

    repository.save(new RewardPricingEntity(7, "Standard", "RewardSaver", 35000, null, "neelima"));
    repository.save(new RewardPricingEntity(7, "Standard", "Standard", 40000, null, "neelima"));
    repository.save(new RewardPricingEntity(7, "Standard", "BasePeak", 75000, null, "neelima"));
    repository.save(new RewardPricingEntity(7, "Premium", "Premium", 75000, null, "neelima"));
    repository.save(new RewardPricingEntity(7, "Premium", "PremiumPeak", 150000, null, "neelima"));

    repository.save(new RewardPricingEntity(8, "Standard", "RewardSaver", 35000, null, "neelima"));
    repository.save(new RewardPricingEntity(8, "Standard", "Standard", 40000, null, "neelima"));
    repository.save(new RewardPricingEntity(8, "Standard", "BasePeak", 75000, null, "neelima"));
    repository.save(new RewardPricingEntity(8, "Premium", "Premium", 75000, null, "neelima"));
    repository.save(new RewardPricingEntity(8, "Premium", "PremiumPeak", 150000, null, "neelima"));

    repository.save(new RewardPricingEntity(9, "Standard", "RewardSaver", 35000, null, "neelima"));
    repository.save(new RewardPricingEntity(9, "Standard", "Standard", 40000, null, "neelima"));
    repository.save(new RewardPricingEntity(9, "Standard", "BasePeak", 75000, null, "neelima"));
    repository.save(new RewardPricingEntity(9, "Premium", "Premium", 75000, null, "neelima"));
    repository.save(new RewardPricingEntity(9, "Premium", "PremiumPeak", 150000, null, "neelima"));

    repository.save(new RewardPricingEntity(10, "Standard", "RewardSaver", 35000, null, "neelima"));
    repository.save(new RewardPricingEntity(10, "Standard", "Standard", 40000, null, "neelima"));
    repository.save(new RewardPricingEntity(10, "Standard", "BasePeak", 75000, null, "neelima"));
    repository.save(new RewardPricingEntity(10, "Premium", "Premium", 75000, null, "neelima"));
    repository.save(new RewardPricingEntity(10, "Premium", "PremiumPeak", 150000, null, "neelima"));
  }
}

