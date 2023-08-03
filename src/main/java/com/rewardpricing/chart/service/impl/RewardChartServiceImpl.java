package com.rewardpricing.chart.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rewardpricing.chart.model.ResponseRewardChart;
import com.rewardpricing.chart.model.RewardPricingEntity;
import com.rewardpricing.chart.reponse.RewardChartResponseMapper;
import com.rewardpricing.chart.repository.RewardRepository;
import com.rewardpricing.chart.service.RewardChartService;

@Service
public class RewardChartServiceImpl implements RewardChartService {

	@Autowired
	private RewardRepository repository;

	@Override
	public List<ResponseRewardChart> listAll() {
		List<RewardPricingEntity> entitiesList = repository.findAll();
		List<ResponseRewardChart> reponse = RewardChartResponseMapper.buildAwardChartResponse(entitiesList);

		return reponse;
	}

	@Override
	public void deleteCategory(String category) {
		this.repository.deleteByCategory(category);
	}

	@Override
	public ResponseEntity<RewardPricingEntity> addCategory(RewardPricingEntity request) {
		System.out.println(request.toString());
		Optional<RewardPricingEntity> existingEntity = this.repository.findByCategoryAndRoomCategoryAndPricingLevel(
				request.getCategory(), request.getRoomCategory(), request.getPricingLevel());
		if (existingEntity.isPresent()) {
			return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
		} else {
			return new ResponseEntity<>(this.repository.save(request), HttpStatus.CREATED);
		}
	}

	@Override
	public ResponseEntity<RewardPricingEntity> updateCategory(RewardPricingEntity request) {
		Optional<RewardPricingEntity> existingEntity = this.repository.findByCategoryAndRoomCategoryAndPricingLevel(
				request.getCategory(), request.getRoomCategory(), request.getPricingLevel());
		if (existingEntity.isPresent()) {
			RewardPricingEntity requestEntity = existingEntity.get();
			requestEntity.setCategory(request.getCategory());
			requestEntity.setRoomCategory(request.getRoomCategory());
			requestEntity.setPricingLevel(request.getPricingLevel());
			requestEntity.setPoints(request.getPoints());
			return new ResponseEntity<>(this.repository.save(requestEntity), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<ResponseRewardChart> findByCategory(String category) {
		List<RewardPricingEntity> entitiesList = this.repository.findByCategory(category);
		List<ResponseRewardChart> response = new ArrayList<>();
		if (entitiesList != null && entitiesList.size() > 0) {
			response = RewardChartResponseMapper.buildAwardChartResponse(entitiesList);
		}
		return response;
	}

}
