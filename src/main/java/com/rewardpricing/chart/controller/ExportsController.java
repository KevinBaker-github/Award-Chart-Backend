package com.rewardpricing.chart.controller;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rewardpricing.chart.dto.AwardChartCsvRequestDto;
import com.rewardpricing.chart.dto.ResourceResponseDto;
import com.rewardpricing.chart.service.GenerateReportService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("exports")
public class ExportsController {

  @Autowired
  private GenerateReportService<AwardChartCsvRequestDto, ResourceResponseDto> generator;

  @PostMapping("/awardChart/csv")
  public ResponseEntity<Resource> generateAwardChartCsv(
      @RequestBody AwardChartCsvRequestDto request) {
    ResourceResponseDto resource = generator.generate(request);

    HttpHeaders headers = new HttpHeaders();
    String filename = "award-charts-" + UUID.randomUUID().toString() + ".xlsx";
    headers.add("Content-Disposition", "attachment; filename=" + filename);

    return ResponseEntity.ok().contentType(resource.getMediaType()).headers(headers)
        .body(resource.getResource());
  }

}
