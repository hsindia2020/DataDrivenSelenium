package excel.tests;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.excel.lib.util.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	@Test
	public static void LoginTest() {

		String stat = "Status";

		LocalDate dd = LocalDate.now();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebElement userName = driver.findElement(By.name("username"));
		WebElement pwd = driver.findElement(By.name("password"));


		Xls_Reader reader = new Xls_Reader("./src/main/java/com/excel/lib/util/SampleExcel.xlsx");
		String sheetName = "login";

		int rowCount = reader.getRowCount(sheetName);

		// Writing the Data Set the values
		reader.addColumn(sheetName, stat + dd);

		for(int rowNum=2; rowNum<=rowCount; rowNum++){

			String loginId = reader.getCellData(sheetName, "username", rowNum);
			String passsword = reader.getCellData(sheetName, "password", rowNum);

			// Writing the Data into the Excel sheet
			reader.setCellData(sheetName, stat + dd, rowNum, "Pass");

			System.out.println(loginId + " " + passsword);

			userName.clear();
			userName.sendKeys(loginId);

			pwd.clear();
			pwd.sendKeys(passsword);


		}
	}

}
