package com.rewardpricing.chart.service1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rewardpricing.chart.model.ResponseAwardChart;
import com.rewardpricing.chart.model.RewardPricingEntity;
import com.rewardpricing.chart.reponse.RewardChartResponseMapper;
import com.rewardpricing.chart.repository.RewardRepository;

@Service
public class AwardChartServiceImpl implements AwardChartService{
	
	@Autowired
	private RewardRepository repository;

	@Override
	public List<ResponseAwardChart> listAll() {
		List<RewardPricingEntity> entitiesList = repository.findAll();
		List<ResponseAwardChart> reponse = RewardChartResponseMapper.build(entitiesList);
		
		return reponse;
	}


}
