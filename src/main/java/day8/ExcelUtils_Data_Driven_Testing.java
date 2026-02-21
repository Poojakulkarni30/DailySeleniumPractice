package day8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils_Data_Driven_Testing

{

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;
	public static CellStyle style;

	public static int getrowcount(String filepath, String sheetname) throws IOException

	{

		fi = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
	}

	public static int getCellcount(String filepath, String sheetname, int rownum) throws IOException {

		fi = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;

	}

	public static String getCellData(String filepath, String sheetname, int rownum, int cellnum) throws IOException {

		fi = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		String data;

		try {

			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);

		}

		catch (Exception e) {

			data = "";

		}

		workbook.close();
		fi.close();
		return data;
	}

	public static void setCellData(String filepath,String sheetname, int rownum, int cellnum, String data) throws IOException {
		
		fi= new FileInputStream(filepath);
		workbook= new XSSFWorkbook(fi);
		sheet= workbook.getSheet(sheetname);
		row= sheet.getRow(rownum);
		cell= row.createCell(cellnum);
		cell.setCellValue(data);
		fo= new FileOutputStream(filepath);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
		
	}
	
	
	public static void fillGreencolor(String filepath, String sheetname, int rownum, int cellnum) throws IOException {
		
		fi= new FileInputStream(filepath);
		workbook= new XSSFWorkbook(fi);
		sheet= workbook.getSheet(sheetname);
		row= sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		style= workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		
		fo= new FileOutputStream(filepath);		
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
		
	}
	
	
	public static void fillRedcolor(String filepath, String sheetname, int rownum, int cellnum) throws IOException {
		
		
		fi= new FileInputStream(filepath);
		workbook= new XSSFWorkbook(fi);
		sheet= workbook.getSheet(sheetname);
		row= sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		style= workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		
		fo= new FileOutputStream(filepath);		
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
