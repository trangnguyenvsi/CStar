package com.vsii.cstar.testcase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.vsii.tsc.model.TestCase;

public class testOnly2 {
	
	public static TestCase testcase;

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream("D:\\abc.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("TestTeamCalendar1");
		System.out.println(sheet.getSheetName());
		
		ArrayList<String> id = new ArrayList<>();

		for (int cNo = 0; cNo<=5;cNo++){
		for (int r = 11; r <= sheet.getLastRowNum(); r++) {

			Cell c = null;
			Row row1 = sheet.getRow(r);
			c = row1.getCell(cNo);
			

			if (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK) {
				// Nothing in the cell in this row, skip it
			} else {
				// cellValueList.add(c.getStringCellValue());
				id.add(c.getStringCellValue());
				System.out.println(c.getStringCellValue());
			}
			

		}
		}
		
		FileOutputStream fileOut = new FileOutputStream("D:\\file 2.xlsx");
//		workbook2 = new XSSFWorkbook(file);
		
		
	}
	
	public void setId(){
		
	}
}
