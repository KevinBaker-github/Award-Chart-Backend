package com.rewardpricing.chart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rewardpricing.chart.model.RewardPricingEntity;
import com.rewardpricing.chart.repository.RewardRepository;

@SpringBootApplication
public class RewardApplication implements CommandLineRunner{
	
	@Autowired
	private RewardRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(RewardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		this.repository.save(new RewardPricingEntity(1,"Standard","RewardSaver",10000,null, "neelima"));
		this.repository.save(new RewardPricingEntity(1,"Standard","Standard",40000,null, "neelima"));
		this.repository.save(new RewardPricingEntity(1,"Standard","BasePeak",20000,null, "neelima"));
		this.repository.save(new RewardPricingEntity(1,"Premium","Premium",75000,null, "neelima"));
		this.repository.save(new RewardPricingEntity(1,"Premium","PremiumPeak",20000,null, "neelima"));
		
		this.repository.save(new RewardPricingEntity(3, "Standard", "Standard", 40000, null, "neelima"));
		//this.repository.save(new RewardPricingEntity(3, "Premium", "Premium", 50000, null, "neelima"));
		
		this.repository.save(new RewardPricingEntity(2,"Standard","RewardSaver",1000,null, "neelima"));
		this.repository.save(new RewardPricingEntity(2,"Standard","Standard",1000,null, "neelima"));
		this.repository.save(new RewardPricingEntity(2,"Standard","BasePeak",2000,null, "neelima"));
		this.repository.save(new RewardPricingEntity(2,"Premium","Premium",10000,null, "neelima"));
		this.repository.save(new RewardPricingEntity(2,"Premium","PremiumPeak",20000,null, "neelima"));
		
		this.repository.save(new RewardPricingEntity(5,"Standard","RewardSaver",35000,null, "neelima"));
		this.repository.save(new RewardPricingEntity(5,"Standard","Standard",40000,null, "neelima"));
		this.repository.save(new RewardPricingEntity(5,"Standard","BasePeak",75000,null, "neelima"));
		this.repository.save(new RewardPricingEntity(5,"Premium","Premium",75000,null, "neelima"));
		this.repository.save(new RewardPricingEntity(5,"Premium","PremiumPeak",150000,null, "neelima"));
	}
}

