package excel.tests;

import org.testng.annotations.Test;

import com.excel.lib.util.Xls_Reader;

public class ExcelUtilTest {

	@Test
	public void ExcelTest() {

		Xls_Reader reader = new Xls_Reader("./SampleExcel.xlsx");
		String sheetName = "login";

		System.out.println(reader.getCellData(sheetName, "username", 3));
		String data = reader.getCellData(sheetName, 0, 2);
		System.out.println(data);

		int rowCount = reader.getRowCount(sheetName);
		System.out.println("total rows: "+ rowCount);

		//reader.addColumn(sheetName, "status");

		if(! reader.isSheetExist("Regsitration")){
			reader.addSheet("Regsitration");
		}
		reader.setCellData(sheetName, "status", 2, "PASS");

		System.out.println(reader.getColumnCount(sheetName));

		//reader.removeColumn("Regsitration", 0);

		System.out.println(reader.getCellData("Regsitration", "phonenumber", 2));
		System.out.println(reader.getCellData("Regsitration", "age", 2));

	}

}
