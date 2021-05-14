package TableGridScroll;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollTable {
  @Test
	public void TableScroll() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,700)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		List<WebElement> values = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[4]"));

		int sum = 0;
		for (int i = 0; i < values.size(); i++) {

			sum = sum + Integer.parseInt(values.get(i).getText());
		}

		System.out.println("Sum of the values " + sum);

		int txt = Integer
				.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());

		System.out.println(txt + sum);
		assertEquals(txt, sum);

		driver.close();
  }
}
