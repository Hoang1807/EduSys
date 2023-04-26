/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.com.HELPER;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author huuho
 */
public class XExcel {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public static void setSheet() {
        XExcel.sheet = XExcel.workbook.createSheet();
    }
    static XSSFRow row;

    public static void setWorkbook(XSSFWorkbook workbook) {
        XExcel.workbook = workbook;
    }

    public static XSSFSheet getSheet() {
        return sheet;
    }

    public static XSSFWorkbook getWorkbook() {
        return workbook;
    }
    

    public static XSSFRow getRow() {
        return row;
    }

    public static void setRow(int row) {
        XExcel.row = sheet.createRow(row);
    }

    public static void clearWorkBook() {
        XExcel.workbook = new XSSFWorkbook();
    }

    public static Cell cells(int indexCell) {
        return row.createCell(indexCell);
    }

    public static void addMergedRegion(int startRow, int endRow, int startCell, int endCell) {
        sheet.addMergedRegion(new CellRangeAddress(startRow, endRow, startCell, endCell));
    }

    public static CellStyle styleCellTitel() {
        CellStyle cs = XExcel.workbook.createCellStyle();
        cs.setBorderBottom(BorderStyle.MEDIUM);
        cs.setBorderTop(BorderStyle.MEDIUM);
        cs.setBorderLeft(BorderStyle.MEDIUM);
        cs.setBorderRight(BorderStyle.MEDIUM);
        cs.setFillForegroundColor(IndexedColors.RED.getIndex());
        cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        Font font = XExcel.workbook.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        cs.setFont(font);
        return cs;
    }

    public static CellStyle styleCellColumn() {
        CellStyle cs = XExcel.workbook.createCellStyle();
        cs.setBorderBottom(BorderStyle.MEDIUM);
        cs.setBorderTop(BorderStyle.MEDIUM);
        cs.setBorderLeft(BorderStyle.MEDIUM);
        cs.setBorderRight(BorderStyle.MEDIUM);
        cs.setFillForegroundColor(IndexedColors.BLACK.getIndex());
        cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        Font font = XExcel.workbook.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        cs.setFont(font);
        return cs;
    }

    public static CellStyle styleCellConten() {
        CellStyle cs = XExcel.workbook.createCellStyle();
        cs.setBorderBottom(BorderStyle.MEDIUM);
        cs.setBorderTop(BorderStyle.MEDIUM);
        cs.setBorderLeft(BorderStyle.MEDIUM);
        cs.setBorderRight(BorderStyle.MEDIUM);
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        return cs;
    }

    public static void export(java.io.File file) throws FileNotFoundException, IOException {
        java.io.FileOutputStream fis = new java.io.FileOutputStream(file);
        XExcel.workbook.write(fis);
        fis.close();
    }
}
