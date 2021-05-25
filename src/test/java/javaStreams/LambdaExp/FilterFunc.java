package javaStreams.LambdaExp;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FilterFunc {
	@Parameters({ "URL", "path" })
	@Test(groups = { "Function" })
	public void funcs(String url, String pp) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get(url);

		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Rice");

		List<WebElement> veggies = driver.findElements(By.xpath(pp));
		// 1 results

		List<WebElement> filteredList = veggies.stream().filter(veggie -> veggie.getText().contains("Rice"))
				.collect(Collectors.toList());
		// 1 result
//In Debug mode we can change the result and find the assertion validation working.
		AssertJUnit.assertEquals(veggies.size(), filteredList.size());

  }
}
