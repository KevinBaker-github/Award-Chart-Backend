package com.rewardpricing.chart.service;

public interface CSVImporter<T, R> {
  R importCsv(T t);
}
