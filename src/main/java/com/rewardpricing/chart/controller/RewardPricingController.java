package com.rewardpricing.chart.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.rewardpricing.chart.dto.DynamicPricingRequest;
import com.rewardpricing.chart.dto.DynamicPricingResponse;
import com.rewardpricing.chart.entity.RewardPricingEntity;
import com.rewardpricing.chart.model.ResponseRewardChart;
import com.rewardpricing.chart.service.DynamicPricingService;
import com.rewardpricing.chart.service.RewardChartService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("awardCharts")
public class RewardPricingController {
	
	@Autowired
	private RewardChartService rewardChartService;
	@Autowired
	private DynamicPricingService dynamicPricingService;

	@GetMapping
	public List<ResponseRewardChart> getAllCategories() {
		return rewardChartService.listAll();
	}
	
	@Transactional
	@DeleteMapping("/{category}")
	public void deleteCategory(@PathVariable("category") int category){ 
		rewardChartService.deleteCategory(category);
	}

	@PostMapping()
	public ResponseEntity<RewardPricingEntity> saveCategory(@RequestBody RewardPricingEntity request) {
		return rewardChartService.addCategory(request);
	}
	
	
	@GetMapping("/{category}")
    public List<ResponseRewardChart> getCategoryById(@PathVariable  int category){
			return rewardChartService.findByCategory(category);
    }

	@PutMapping()
	public ResponseEntity<RewardPricingEntity> updateCategory(@RequestBody RewardPricingEntity rewardPricingModel){
		return rewardChartService.updateCategory(rewardPricingModel);
	}
	
	@PostMapping("/dynamicPricing")
	public ResponseEntity<DynamicPricingResponse> getDynamicPricing(@RequestBody DynamicPricingRequest request) {
	    return this.dynamicPricingService.getPricing(request);
		
	}
}
