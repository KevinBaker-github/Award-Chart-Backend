package com.rewardpricing.chart.dto;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ResourceResponseDto {
  private Resource resource;
  private MediaType mediaType;
}
