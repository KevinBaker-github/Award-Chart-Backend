package com.rewardpricing.chart.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import com.rewardpricing.chart.dto.AwardChartCsvRequestDto;
import com.rewardpricing.chart.dto.ResourceResponseDto;
import com.rewardpricing.chart.entity.RewardPricingEntity;
import com.rewardpricing.chart.exporters.csv.AwardChartCsvExporter;
import com.rewardpricing.chart.repository.RewardRepository;
import com.rewardpricing.chart.service.GenerateReportService;

@Service
public class AwardChartReportServiceImpl
    implements GenerateReportService<AwardChartCsvRequestDto, ResourceResponseDto> {

  @Autowired
  private RewardRepository repository;
  
  @Autowired
  private AwardChartCsvExporter exporter;

  @Override
  public ResourceResponseDto generate(AwardChartCsvRequestDto dto) {
    List<RewardPricingEntity> entities = repository.findByCategoryIn(dto.getCategories());
    
    Resource resource = exporter.exportCsv(entities);
    return ResourceResponseDto.builder()
        .resource(resource)
        .mediaType(MediaType
            .parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
        .build();
  }

}
