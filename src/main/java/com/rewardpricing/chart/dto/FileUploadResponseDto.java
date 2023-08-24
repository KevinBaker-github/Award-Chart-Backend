package com.rewardpricing.chart.dto;

import java.util.List;
import com.rewardpricing.chart.model.RecordStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class FileUploadResponseDto {
  
  private String fileName;
  private List<RecordStatus> recordStatus;

}
