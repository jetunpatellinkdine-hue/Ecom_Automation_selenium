package com.saucedemo.SeleniumTestNGFramework.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	private Workbook workbook;
	private Sheet sheet;

	public ExcelUtils(String filePath, String sheetName) throws Exception {
		FileInputStream file = new FileInputStream(filePath);
		workbook = WorkbookFactory.create(file);
		sheet = workbook.getSheet(sheetName);
	}

	public int[] getRowAndCol() {
		int row = sheet.getLastRowNum() + 1;
		int col = sheet.getRow(0).getLastCellNum();

		return new int[] { row, col };
	}

	public String getCell(int row, int col) {
		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(sheet.getRow(row).getCell(col));
	}

}
