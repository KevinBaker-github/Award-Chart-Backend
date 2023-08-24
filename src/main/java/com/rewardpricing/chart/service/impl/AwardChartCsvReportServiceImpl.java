package com.rewardpricing.chart.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import com.rewardpricing.chart.dto.AwardChartExportRequestDto;
import com.rewardpricing.chart.dto.ResourceResponseDto;
import com.rewardpricing.chart.entity.RewardPricingEntity;
import com.rewardpricing.chart.exporters.csv.AwardChartCsvExporter;
import com.rewardpricing.chart.mapper.reports.RewardChartsReportMapper;
import com.rewardpricing.chart.model.reports.RewardChartReportItem;
import com.rewardpricing.chart.repository.RewardRepository;
import com.rewardpricing.chart.service.CsvReportGeneratorService;

@Service("awardChartCommonCsvService")
public class AwardChartCsvReportServiceImpl
    implements CsvReportGeneratorService<AwardChartExportRequestDto, ResourceResponseDto> {

  @Autowired
  private RewardRepository repository;
  
  @Autowired
  private AwardChartCsvExporter exporter;
  
  @Autowired
  private RewardChartsReportMapper mapper;

  @Override
  public ResourceResponseDto generateCsv(AwardChartExportRequestDto dto) {
    List<RewardPricingEntity> entities = repository.findByCategoryIn(dto.getCategories());
    List<RewardChartReportItem> filteredByCategories = mapper.mapFromRewardChartEntitiesToReportItems(entities);
    
    Resource resource = exporter.exportCsv(filteredByCategories);
    return ResourceResponseDto.builder()
        .resource(resource)
        .mediaType(MediaType
            .parseMediaType("application/csv"))
        .build();
  }

}
