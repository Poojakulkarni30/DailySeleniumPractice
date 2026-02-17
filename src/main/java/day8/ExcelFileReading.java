package day8;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReading {

	public static void main(String[] args) throws IOException {


		// to read data from excel file --> FileInputStream
		
		//fileinputstream-->XSSFWorkbook-->XSSFSheet-->XSSFRow-->XSSFCell
		
		
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\testData\\dummyfile.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheet("Sheet1");
		int totalRows= sheet.getLastRowNum();
		System.out.println("Total rows in excel sheet are:" +totalRows); // row starts from 0
		
		
		int totalCells= sheet.getRow(1).getLastCellNum();
		System.out.println("Total columns in excel sheet are:" +totalCells);
		
		
		// to read data from excel file from cells and rows
		
		
		for(int r=0; r<=totalRows;r++) {
			
			
			for(int c=0; c<totalCells;c++) {
				
			String allData=	sheet.getRow(r).getCell(c).toString();
			System.out.print(allData + "\t");
				
				
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();
		
	}
	

}
