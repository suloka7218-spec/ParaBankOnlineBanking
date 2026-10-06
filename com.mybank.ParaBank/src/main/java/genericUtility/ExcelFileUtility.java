package genericUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	public String toReadDatafromExcelFile(String sheetname, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}

	public int toGetLastRowNum(String sheetname) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int rowCount = sh.getLastRowNum();
		return rowCount;

	}

}
