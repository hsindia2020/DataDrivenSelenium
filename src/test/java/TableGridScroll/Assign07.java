package TableGridScroll;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign07 {
  @Test
	public void assign07() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr"));

		List<WebElement> cols = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th"));

		WebElement row = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[3]"));
		System.out.println("Number of rows in table " + rows.size());
		System.out.println("Number of cols in table " + cols.size());
		System.out.println("Data from table " + "'" + row.getText() + "'");

  }
}
