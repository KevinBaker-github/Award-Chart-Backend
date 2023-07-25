package com.reactpoc.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactpoc.springboot.model.RewardPricingModel;
import com.reactpoc.springboot.repository.RewardRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("awardCharts")
public class RewardController {
	
	@Autowired
	private RewardRepository rewardRepository;

	@GetMapping
	public ResponseEntity<List<RewardPricingModel>> getAllCategories() {
		try {
			List<RewardPricingModel> list = rewardRepository.findAll();

			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping()
	public ResponseEntity<RewardPricingModel> saveCategory(@RequestBody RewardPricingModel rewardPricingModel) {
		
		try {
			return new ResponseEntity<>(rewardRepository.save(rewardPricingModel), HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("exception occured");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<RewardPricingModel> getCategoryById(@PathVariable  long id){
			Optional<RewardPricingModel> rewardCategory = rewardRepository.findById(id);
		
		if (rewardCategory.isPresent()) {
			return new ResponseEntity<>(rewardCategory.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

	@PutMapping("/{id}")
	public ResponseEntity<RewardPricingModel> updateCategory(@PathVariable("id") long id, @RequestBody RewardPricingModel rewardPricingModel){
		Optional<RewardPricingModel> data = this.rewardRepository.findById(id);
		
		if(data.isPresent()) {
			RewardPricingModel reward_data = data.get();
			reward_data.setCategory(rewardPricingModel.getCategory());
			reward_data.setRoomCategory(rewardPricingModel.getRoomCategory());
			reward_data.setPricingLevel(rewardPricingModel.getPricingLevel());
			reward_data.setPoints(rewardPricingModel.getPoints());
			reward_data.setUpdateUser(rewardPricingModel.getUpdateUser());
			return new ResponseEntity<>(this.rewardRepository.save(reward_data), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<RewardPricingModel> deleteCategory(@PathVariable("id") long id){ 
		try {
			this.rewardRepository.deleteById(id);
			return new ResponseEntity<RewardPricingModel>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			return new ResponseEntity<RewardPricingModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}
