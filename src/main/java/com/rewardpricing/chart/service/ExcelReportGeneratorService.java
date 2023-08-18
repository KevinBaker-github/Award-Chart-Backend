package com.rewardpricing.chart.service;

public interface ExcelReportGeneratorService<T, R> {
  R generateExcel(T t); 
}
