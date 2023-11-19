package com.Lecture14;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class TNinja_RegistrationData_Print {
	public static FileInputStream fIS;

	    public static void main(String[] args) {
	        FileInputStream file = null;
	        try {
	            fIS = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\Lecture14\\RegisterUser.xlsx");
	            Workbook workbook = WorkbookFactory.create(fIS);
	            Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet

	            int rowCount = sheet.getPhysicalNumberOfRows();
	            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

	            Object[][] excelData = new Object[rowCount][colCount];

	            for (int i = 0; i < rowCount; i++) {
	                Row row = sheet.getRow(i);
	                for (int j = 0; j < colCount; j++) {
	                    Cell cell = row.getCell(j);
	                    switch (cell.getCellType()) {
	                        case STRING:
	                            excelData[i][j] = cell.getStringCellValue();
	                            break;
	                        case NUMERIC:
	                            if (DateUtil.isCellDateFormatted(cell)) {
	                                excelData[i][j] = cell.getDateCellValue();
	                            } else {
	                                excelData[i][j] = cell.getNumericCellValue();
	                            }
	                            break;
	                        case BOOLEAN:
	                            excelData[i][j] = cell.getBooleanCellValue();
	                            break;
	                        case BLANK:
	                            excelData[i][j] = "";
	                            break;
	                        default:
	                            excelData[i][j] = "";
	                            break;
	                    }
	                }
	            }

	            // Printing the two-dimensional array (for demonstration)
	            for (Object[] row : excelData) {
	                for (Object cellData : row) {
	                    System.out.print(cellData + "\t");
	                }
	                System.out.println();
	            }

	            workbook.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (file != null) {
	                try {
	                    file.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	}


