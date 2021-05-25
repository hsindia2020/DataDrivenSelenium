package extentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basicReport {

	ExtentReports ext;

	@BeforeTest
	public void extentbase() {
		// ExtentReport
		String loc = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter exspre = new ExtentSparkReporter(loc);
		exspre.config().setReportName("AutomationResult");
		exspre.config().setDocumentTitle("Report The One");

		ext = new ExtentReports();
		ext.attachReporter(exspre);
		ext.setSystemInfo("Tester ", "Harmeet Singh");

	}

  @Test
	public void extentbasic() {

		ExtentTest test = ext.createTest("Extent Basic");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium Auto");
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println(driver.getTitle());

		ext.flush();

  }
}
