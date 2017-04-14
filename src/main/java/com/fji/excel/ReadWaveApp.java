package com.fji.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fji.core.Constants;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ReadWaveApp {

	public Map<Integer, String> readAllApplication() {

		Workbook workbook = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			
			InputStream excelFile = new FileInputStream(Constants.APP_MASTERDATAVALIDATION);
			workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(1);
			Iterator<Row> iterator = datatypeSheet.iterator();
			String value = "";
			Integer key = null;

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				if (currentRow.getRowNum() != 0) {
					Iterator<Cell> cellIterator = currentRow.iterator();
					while (cellIterator.hasNext()) {

						Cell currentCell = cellIterator.next();
						if (currentCell.getColumnIndex() == 3 /*or we can 5 column too need to check */) {

							if (currentCell.getDateCellValue() == null)
								value += "-" + "new";
							else if (currentCell.getDateCellValue().toString()
									.length() > 0)
								value += "-" + "review";
						} else if (currentCell.getColumnIndex() == 0) {

							key = (int) currentCell.getNumericCellValue();
						} else if (currentCell.getColumnIndex() == 2) {

							value = currentCell.getNumericCellValue() + "";
						}

						if (currentCell.getColumnIndex() == 3 /*|| currentCell.getColumnIndex() == 0 */) {
							// if (value.trim().length() > 0) {
							if (value.contains("-")) {
								map.put(key, value);
							}
						}
					}
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null)
					workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return map;
	}
}
