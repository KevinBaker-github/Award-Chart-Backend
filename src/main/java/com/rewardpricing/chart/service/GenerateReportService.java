package com.rewardpricing.chart.service;

public interface GenerateReportService<T, R> {
  R generate(T t); 
}
