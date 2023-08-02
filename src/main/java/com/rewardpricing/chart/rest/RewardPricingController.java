package com.rewardpricing.chart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rewardpricing.chart.model.ResponseAwardChart;
import com.rewardpricing.chart.service1.AwardChartService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("awardCharts")
public class RewardPricingController {
	
//	@Autowired
//	private RewardRepository rewardRepository;
	
	@Autowired
	private AwardChartService awardChartService;

	@GetMapping
	public List<ResponseAwardChart> getAllCategories() {
			List<ResponseAwardChart> awardChartList = awardChartService.listAll();
		return awardChartList;
	}
	
	//	@PostMapping()
//	public ResponseEntity<RewardPricingEntity> saveCategory(@RequestBody RewardPricingEntity request) {
//		Optional<RewardPricingEntity> data = this.rewardRepository.findById(Long.parseLong(request.getCategory()));
//		System.out.println("check ------------------" + data.isPresent());
//		try {
//		if(!data.isPresent()) {
//			return new ResponseEntity<>(rewardRepository.save(request), HttpStatus.CREATED);
//		}
//		else {
//			RewardPricingEntity reward_data = data.get();
//			if(reward_data.getRoomCategory().equalsIgnoreCase(request.getRoomCategory()) && reward_data.getPricingLevel().equalsIgnoreCase(request.getPricingLevel())) {
//				return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
//			}
//			else {
//			return new ResponseEntity<>(rewardRepository.save(request), HttpStatus.CREATED);
//			}
//		}
//		}catch (Exception e) {
//			System.out.println("exception occured");
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	@GetMapping("/{category}")
//    public ResponseEntity<RewardPricingEntity> getCategoryById(@PathVariable  long category){
//			Optional<RewardPricingEntity> rewardCategory = rewardRepository.findById(category);
//		
//		if (rewardCategory.isPresent()) {
//			return new ResponseEntity<>(rewardCategory.get(), HttpStatus.OK);
//		}
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//	@PutMapping("/{category}")
//	public ResponseEntity<RewardPricingEntity> updateCategory(@PathVariable("category") String category, @RequestBody RewardPricingEntity rewardPricingModel){
//		Optional<RewardPricingEntity> data = this.rewardRepository.findById(Long.parseLong(category));
//		
//		if(data.isPresent()) {
//			RewardPricingEntity reward_data = data.get();
//			reward_data.setCategory(rewardPricingModel.getCategory());
//			reward_data.setRoomCategory(rewardPricingModel.getRoomCategory());
//			reward_data.setPricingLevel(rewardPricingModel.getPricingLevel());
//			reward_data.setPoints(rewardPricingModel.getPoints());
//			reward_data.setUpdateUser(rewardPricingModel.getUpdateUser());
//			return new ResponseEntity<>(this.rewardRepository.save(reward_data), HttpStatus.OK);
//		}
//		else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//	
//	@DeleteMapping("/{category}")
//	public ResponseEntity<RewardPricingEntity> deleteCategory(@PathVariable("category") long category){ 
//		try {
//			this.rewardRepository.deleteById(category);
//			return new ResponseEntity<RewardPricingEntity>(HttpStatus.NO_CONTENT);
//		}
//		catch (Exception e) {
//			return new ResponseEntity<RewardPricingEntity>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	

}
