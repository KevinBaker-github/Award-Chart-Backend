package com.rewardpricing.chart.service;

public interface CsvReportGeneratorService<T, R> {
  R generateCsv(T t); 
}
