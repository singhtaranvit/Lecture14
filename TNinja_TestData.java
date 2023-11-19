package com.Lecture14;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class TNinja_TestData {

	public static FileInputStream fIS;


	@DataProvider(name = "TNinja1")
	public static Object[][] TNinjTestData() throws IOException {
		Object[][] data = TNinja_TestData.getTNinjaTestData("TNinja");
		return data;
		
	}
	public static Object[][] getTNinjaTestData(String sheet) throws IOException {

		fIS = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\com\\Lecture14\\RegisterUser.xlsx");

		XSSFWorkbook TNinjaWB = new XSSFWorkbook(fIS); // this will give us excel workbook

		XSSFSheet TNinjaSheet = TNinjaWB.getSheetAt(0);// this will give us particular sheet

		int rows = TNinjaSheet.getLastRowNum();

		int cells = TNinjaSheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows][cells];

		for (int i = 0; i < rows; i++) {

			XSSFRow row = TNinjaSheet.getRow(i + 1);

			for (int j = 0; j < cells; j++) {

				XSSFCell cell = row.getCell(j);

				switch (cell.getCellType()) {

				case STRING:
					data[i][j] = cell.getStringCellValue();

					break;
				case NUMERIC:
					data[i][j] = Long.toString((long)cell.getNumericCellValue());
					 

					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				case BLANK:
					data[i][j] = "";
					break;
				default:
					data[i][j] = "";
					break;
				}
			}
			TNinjaWB.close();
}return data;

}
	
}