package com.rewardpricing.chart.exporters.excel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import com.rewardpricing.chart.model.reports.RewardChartReportItem;

@Component
public class AwardChartExcelPoiExporter {

  public Resource exportExcel(List<RewardChartReportItem> data) {
    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("AWARD-CHARTS");
    
    prepareRoomCategoriesHeaders(workbook, sheet);
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
  
  private void prepareRoomCategoriesHeaders(Workbook workbook, Sheet sheet) {
    Row headerRow = sheet.createRow(0); // Either standard or premium
    Font font = workbook.createFont();
    font.setBold(true);
    font.setFontName("Arial");
    font.setColor(IndexedColors.WHITE.getIndex());

    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setFont(font);
    cellStyle.setAlignment(HorizontalAlignment.CENTER);
    cellStyle.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
    cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    
    sheet.addMergedRegion(CellRangeAddress.valueOf("B1:D1"));
    sheet.addMergedRegion(CellRangeAddress.valueOf("E1:F1"));
    
    Cell headerCell1 = headerRow.createCell(1);
    headerCell1.setCellValue("Standard");
    headerCell1.setCellStyle(cellStyle);
    
    Cell headerCell2 = headerRow.createCell(4);
    headerCell2.setCellValue("Premium");
    headerCell2.setCellStyle(cellStyle);
  }


  private void prepareHeaders(Workbook workbook, Sheet sheet, String... headers) {
    Row headerRow = sheet.createRow(1);
    Font font = workbook.createFont();
    font.setBold(true);
    font.setFontName("Arial");
    font.setColor(IndexedColors.WHITE.getIndex());

    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setFont(font);
    cellStyle.setAlignment(HorizontalAlignment.CENTER);
    cellStyle.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
    cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

    int columnNumber = 0;
    for (String header : headers) {
      Cell headerCell = headerRow.createCell(columnNumber++);
      headerCell.setCellValue(header);
      headerCell.setCellStyle(cellStyle);
    }
  }

  private void populateUserData(Workbook workbook, Sheet sheet, List<RewardChartReportItem> data) {
    int rowNo = 2;
    Font font = workbook.createFont();
    font.setFontName("Arial");

    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setFont(font);
    cellStyle.setAlignment(HorizontalAlignment.CENTER);

    for (RewardChartReportItem item : data) {
      int columnNumber = 0;
      Row row = sheet.createRow(rowNo);
      populateCell(sheet, row, columnNumber++, String.valueOf(item.getCategory()), cellStyle);
      populateCell(sheet, row, columnNumber++, String.valueOf(item.getRewardSaver()), cellStyle);
      populateCell(sheet, row, columnNumber++, String.valueOf(item.getStandard()), cellStyle);
      populateCell(sheet, row, columnNumber++, String.valueOf(item.getBasePeak()), cellStyle);
      populateCell(sheet, row, columnNumber++, String.valueOf(item.getPremium()), cellStyle);
      populateCell(sheet, row, columnNumber++, String.valueOf(item.getPremiumPeak()), cellStyle);
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
