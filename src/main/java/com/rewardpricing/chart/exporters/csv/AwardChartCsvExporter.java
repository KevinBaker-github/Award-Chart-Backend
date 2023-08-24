package com.rewardpricing.chart.exporters.csv;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import com.rewardpricing.chart.model.reports.RewardChartReportItem;

@Component
public class AwardChartCsvExporter {

  public Resource exportCsv(List<RewardChartReportItem> data) {

    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

    try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(byteArrayOutputStream), format);) {
      populateUserData(csvPrinter, data);
      csvPrinter.flush();
      return new ByteArrayResource(byteArrayOutputStream.toByteArray());
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException("Error while generating the csv file: " + e.getMessage());
    }
  }

  private void populateUserData(CSVPrinter csvPrinter, List<RewardChartReportItem> data)
      throws IOException {
    for (RewardChartReportItem item : data) {
      List<String> dataItem =
          Arrays.asList(String.valueOf(item.getCategory()), String.valueOf(item.getRewardSaver()),
              String.valueOf(item.getStandard()), String.valueOf(item.getBasePeak()),
              String.valueOf(item.getPremium()), String.valueOf(item.getPremiumPeak()));

      csvPrinter.printRecord(dataItem);
    }
  }

}
