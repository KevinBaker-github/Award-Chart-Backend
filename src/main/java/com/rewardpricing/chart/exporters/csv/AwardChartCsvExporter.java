package com.rewardpricing.chart.exporters.csv;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import com.rewardpricing.chart.entity.RewardPricingEntity;

@Component
public class AwardChartCsvExporter {

  public Resource exportCsv(List<RewardPricingEntity> data) {
    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("AWARD-CHARTS");

    prepareHeaders(workbook, sheet, "Category", "Reward Saver", "Standard", "Base Peak", "Premium",
        "Premium Peak");
    populateUserData(workbook, sheet, data);

    try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
      workbook.write(byteArrayOutputStream);
      return new ByteArrayResource(byteArrayOutputStream.toByteArray());
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException("Error while generating excel.");
    }
  }


  private void prepareHeaders(Workbook workbook, Sheet sheet, String... headers) {
    Row headerRow = sheet.createRow(0);
    Font font = workbook.createFont();
    font.setBold(true);
    font.setFontName("Arial");

    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setFont(font);

    int columnNumber = 0;
    for (String header : headers) {
      Cell headerCell = headerRow.createCell(columnNumber++);
      headerCell.setCellValue(header);
      headerCell.setCellStyle(cellStyle);
    }
  }

  private void populateUserData(Workbook workbook, Sheet sheet, List<RewardPricingEntity> data) {
    int rowNo = 1;
    Font font = workbook.createFont();
    font.setFontName("Arial");

    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setFont(font);

    for (RewardPricingEntity item : data) {
      int columnNumber = 0;
      Row row = sheet.createRow(rowNo);
      populateCell(sheet, row, columnNumber++, String.valueOf(item.getCategory()), cellStyle);
      populateCell(sheet, row, columnNumber++, item.getRoomCategory(), cellStyle);
      populateCell(sheet, row, columnNumber++, item.getPricingLevel(), cellStyle);
      populateCell(sheet, row, columnNumber++, String.valueOf(item.getPoints()), cellStyle);
      rowNo++;
    }
  }

  private void populateCell(Sheet sheet, Row row, int columnNo, String value, CellStyle cellStyle) {
    Cell cell = row.createCell(columnNo);
    cell.setCellStyle(cellStyle);
    cell.setCellValue(value);
    sheet.autoSizeColumn(columnNo);
  }

}
