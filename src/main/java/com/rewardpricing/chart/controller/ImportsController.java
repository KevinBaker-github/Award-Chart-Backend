package com.rewardpricing.chart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.rewardpricing.chart.dto.FileUploadResponseDto;
import com.rewardpricing.chart.service.CSVImporter;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("imports")
public class ImportsController {

  @Qualifier("propertyConfigImporterService")
  @Autowired
  private CSVImporter<MultipartFile, FileUploadResponseDto> csvImporter;

  @PostMapping("/propertyConfig/csv/bulk")
  public ResponseEntity<FileUploadResponseDto> importAwardChartCommonCsv(
      @RequestParam("file") MultipartFile file) {
    FileUploadResponseDto dto = csvImporter.importCsv(file);
    
    return ResponseEntity.ok().body(dto);
  }


}
