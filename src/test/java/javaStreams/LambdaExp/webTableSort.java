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

public class webTableSort {
	@Parameters({ "URL", "path" })
	@Test(groups = { "Business" })
	public void func(String url, String pp) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get(url);

		// click on column

//		driver.manage().window().maximize();
		driver.findElement(By.xpath("//tr/th[1]")).click();

		// capture all webelements into list

		List<WebElement> elementsList = driver.findElements(By.xpath(pp));

		// capture text of all webelements into new(original) list

		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());

		// sort on the original list of step 3 -> sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		// compare original list vs sorted list
		AssertJUnit.assertTrue(originalList.equals(sortedList));

		List<String> price;
		// scan the name column with getText ->Beans->print the price of the Rice
		do
		{
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Tomato")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());

			price.forEach(a -> System.out.println("Tomato price :" + a));
			if (price.size() < 1)
			{
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (price.size() < 1);
//		System.out.println(price.size());
  }
	private static String getPriceVeggie(WebElement s) {
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}

}
