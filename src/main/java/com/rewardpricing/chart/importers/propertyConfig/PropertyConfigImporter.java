package com.rewardpricing.chart.importers.propertyConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.rewardpricing.chart.exception.FileUploadException;
import com.rewardpricing.chart.model.PropertyConfig;
import com.rewardpricing.chart.model.RecordStatus;

@Component
public class PropertyConfigImporter {
  String[] HEADERS = { "PROPERTY", "CATEGORY", "OCCUPANCY", "VALUEPERPOINT" };
  
  public List<RecordStatus> importCsvRecords(MultipartFile file) throws FileUploadException {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<RecordStatus> recordStatus = new ArrayList<RecordStatus>();
      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      setPropertiesConfig(recordStatus, csvRecords);

      return recordStatus;
    } catch (IOException e) {
      e.printStackTrace();
      throw new FileUploadException("There was an error parsing the CSV");
    }
  }
  
  private void setPropertiesConfig(List<RecordStatus> recordStatus, Iterable<CSVRecord> csvRecords) {
      for (CSVRecord csvRecord : csvRecords) {
        PropertyConfig propertyConfig = null;
        boolean isError = false;
        List<String> errorList = new ArrayList<>();
        try {
          propertyConfig = PropertyConfig.builder()
              .property(csvRecord.get("PROPERTY"))
              .category(Integer.parseInt(csvRecord.get("CATEGORY")))
              .occupancy(Double.parseDouble(csvRecord.get("OCCUPANCY")))
              .valuePerPoint(Double.parseDouble(csvRecord.get("VALUEPERPOINT")))
              .build();
        } catch (Exception e) {
          e.printStackTrace();
          isError = true;
          errorList.add("There was an error processing the record");
        }
        
        recordStatus.add(RecordStatus.builder()
            .recordNumber(csvRecord.getRecordNumber())
            .propertyConfig(propertyConfig)
            .isError(isError)
            .messages(errorList)
            .build());
      }
  }

}
