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
		this.repository.save(new RewardPricingEntity("1","Standard","Reward Saver","2000",null, "neelima"));
		this.repository.save(new RewardPricingEntity("1","Standard","Base","1000",null, "neelima"));
		this.repository.save(new RewardPricingEntity("1","Standard","Base Peak","2000",null, "neelima"));
		this.repository.save(new RewardPricingEntity("1","Premium","Premium","10000",null, "neelima"));
		this.repository.save(new RewardPricingEntity("1","Premium","Premium Peak","20000",null, "neelima"));
		this.repository.save(new RewardPricingEntity("2","Standard","Base","1000",null, "neelima"));
		this.repository.save(new RewardPricingEntity("2","Standard","Base Peak","2000",null, "neelima"));
		this.repository.save(new RewardPricingEntity("2","Premium","Premium","10000",null, "neelima"));
		this.repository.save(new RewardPricingEntity("2","Premium","Premium Peak","20000",null, "neelima"));
	}
	
	
}
