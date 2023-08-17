package com.rewardpricing.chart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rewardpricing.chart.dto.AwardChartCsvRequestDto;
import javassist.bytecode.ByteArray;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("exports")
public class ExportsController {
  
  
  
  @PostMapping("/awardChart/csv")
  public ResponseEntity<ByteArray> generateAwardChartCsv(@RequestBody AwardChartCsvRequestDto request) {
    return null;
  }

}
