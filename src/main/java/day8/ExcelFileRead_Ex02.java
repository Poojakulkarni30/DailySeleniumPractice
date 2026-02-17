package day8;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileRead_Ex02 {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream((System.getProperty("user.dir") + "\\testData\\InterviewTestData.xlsx"));

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet("AllDataTypes");

		int totalRows = sheet.getLastRowNum();

		System.out.println("Total rows in sheet" + totalRows);
		System.out.println("Total rows in sheet new method" + sheet.getPhysicalNumberOfRows());

		int totalCells = sheet.getRow(1).getLastCellNum();

		System.out.println("Total columns in sheet" + totalCells);

		System.out.println("Total columns in sheet new method " + sheet.getRow(1).getPhysicalNumberOfCells());
		
		DataFormatter formatter = new DataFormatter();

		for (int r = 0; r <= totalRows; r++) {
			
			Row row= sheet.getRow(r);
			if(row== null) 
				continue;

			for (int c = 0; c < totalCells; c++) {
				

			Cell cell = sheet.getRow(r).getCell(c);
			
				String value = formatter.formatCellValue(cell);
				System.out.print(value + "\t");
				
			}
			
			System.out.println();

		}

		
		
		workbook.close();
		file.close();

	}

}
