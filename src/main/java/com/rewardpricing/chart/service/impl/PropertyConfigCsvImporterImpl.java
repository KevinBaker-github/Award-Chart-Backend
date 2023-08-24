package com.rewardpricing.chart.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.rewardpricing.chart.dto.FileUploadResponseDto;
import com.rewardpricing.chart.exception.InvalidFileTypeException;
import com.rewardpricing.chart.importers.propertyConfig.PropertyConfigImporter;
import com.rewardpricing.chart.mapper.PropertyConfigMapper;
import com.rewardpricing.chart.model.RecordStatus;
import com.rewardpricing.chart.repository.PropertyConfigRepository;
import com.rewardpricing.chart.service.CSVImporter;
import com.rewardpricing.chart.util.CustomValidator;

@Service("propertyConfigImporterService")
public class PropertyConfigCsvImporterImpl
    implements CSVImporter<MultipartFile, FileUploadResponseDto> {

  @Autowired
  private CustomValidator validator;

  @Autowired
  private PropertyConfigMapper mapper;

  @Autowired
  private PropertyConfigImporter importer;

  @Autowired
  private PropertyConfigRepository repository;

  @Override
  public FileUploadResponseDto importCsv(MultipartFile file) {
    if (!validator.hasCSVFormat(file)) {
      throw new InvalidFileTypeException("CSV files accepted only.");
    }

    List<RecordStatus> records = importer.importCsvRecords(file);
    
    // Only send to DB the successful csv records.
    for (RecordStatus recordStatus : records) {
      if (recordStatus.isError()) {
        continue;
      }
      
      try {
        persistPropertyConfig(recordStatus);
      } catch (Exception e) {
        recordStatus.setError(true);
        recordStatus.getMessages().add("Database insertion error");
      }
    }
    
    return FileUploadResponseDto.builder()
        .fileName(file.getOriginalFilename())
        .recordStatus(records)
        .build();
  }



  /**
   * Individual transaction per record operation.
   * Rollback in case of error.
   * 
   * @param recordStatus
   */
  @Transactional
  private void persistPropertyConfig(RecordStatus recordStatus) {
    repository
          .save(mapper.mapPropertyConfigToPropertyConfigEntity(recordStatus.getPropertyConfig()));
  }

}
