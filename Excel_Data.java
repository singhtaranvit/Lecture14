package com.Lecture14;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.apache.poi.ss.usermodel.CellType;

public class Excel_Data {
	public static FileInputStream ip;
	public static XSSFWorkbook WB;
	public static XSSFSheet Sheet;

	@DataProvider(name = "rediff")
	public static Object[][] getRediffExcelData() throws Exception {
		Object[][] RediffData = Excel_Data.readExcelDataForRediff("Rediff");
		return RediffData;
	}
	@DataProvider(name = "TNinja")
	public static Object[][] readExcelDataForTNinja() throws Exception {
		Object[][] TNinjaData = Excel_Data.readExcelDataForRediff("TutorialsNinja");
		return TNinjaData;

	}
	public static Object[][] readExcelDataForRediff(String sheetName) throws Exception {
		// Step 1: Create the object of FileInputStream class and pass the path of excel
		// sheet in the constructor
		  ip = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\com\\Lecture14\\LoginData.xlsx");
		// Step 2: Create the object of XSSFWorkbook class and pass the ip reference its
		// constructor
		 WB = new XSSFWorkbook(ip);
		// Step 3 Use the workbook reference to get the sheet and return the value of
		// XSSFSheet class
		 Sheet = WB.getSheet(sheetName);
		// Step 4 Get the number of Rows and Columns
		int rows = Sheet.getLastRowNum();
		int cols = Sheet.getRow(0).getLastCellNum();
		// Step 5 Create a 2 Dimensional Array
		Object[][] DataObj = new Object[rows][cols];
		// Step 6 Nested for loop to iterate between rows and cols
		for (int i = 0; i < rows; i++) {
			XSSFRow	DataRow = Sheet.getRow(i + 1);
			for (int j = 0; j < cols; j++) {
				XSSFCell DataCell = DataRow.getCell(j);
				// Step 7: You have to determine what is the data type in each cell or column
				  CellType cellType = DataCell.getCellType(); 
				switch(cellType) {
				case STRING:
					DataObj[i][j] = DataCell.getStringCellValue();
					break;
				case NUMERIC:
					DataObj[i][j] = Integer.toString((int)DataCell.getNumericCellValue());
					break;
				case BOOLEAN:
					DataObj[i][j] = DataCell.getBooleanCellValue();
					break;
				default:
					DataObj[i][j] = "";
					break;
				}	
				}
		}return DataObj;

	}

	public static Object[][] readExcelDataForTNinja(String sheetName) throws Exception {
		// Step 1: Create the object of FileInputStream class and pass the path of excel
		// sheet in the constructor
		ip = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\com\\Lecture14\\LoginData.xlsx");
		// Step 2: Create the object of XSSFWorkbook class and pass the ip reference its
		// constructor
		 WB = new XSSFWorkbook(ip);
		// Step 3 Use the workbook reference to get the sheet and return the value of
		// XSSFSheet class
		 Sheet = WB.getSheet(sheetName);
		// Step 4 Get the number of Rows and Columns
		int rows = Sheet.getLastRowNum();
		int cols = Sheet.getRow(0).getLastCellNum();
		// Step 5 Create a 2 Dimensional Array
		Object[][] DataObj = new Object[rows][cols];
		// Step 6 Nested for loop to iterate between rows and cols
		for (int i = 0; i < rows; i++) {
			XSSFRow	DataRow = Sheet.getRow(i + 1);
			for (int j = 0; j < cols; j++) {
				XSSFCell DataCell = DataRow.getCell(j);
				// Step 7: You have to determine what is the data type in each cell or column
				  CellType cellType = DataCell.getCellType(); 
				
				  switch(cellType) {
				case STRING:
					DataObj[i][j] = DataCell.getStringCellValue();
					break;
				case NUMERIC:
					DataObj[i][j] = Integer.toString((int)DataCell.getNumericCellValue());
					break;
				case BOOLEAN:
					DataObj[i][j] = DataCell.getBooleanCellValue();
					break;
				default:
					DataObj[i][j] = "";
					break;
				}	
				}
		}return DataObj;

}
	}