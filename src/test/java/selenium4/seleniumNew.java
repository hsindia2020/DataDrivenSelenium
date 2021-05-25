package selenium4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class seleniumNew {
  @Test
	public void func() {
		/*
		 * Selenium Relative Locators || Friendly Locators above(): Element located
		 * above with respect to the specified element. Below(): Element located above
		 * with respect to the specified element. toLiftOf(): Element located to the
		 * left of specified element. toRightOf(): Element located to the right of the
		 * specified element.
		 *
		 * Syntax: driver.findElement(withTagName("MM").above(WebElement())
		 *
		 * import static
		 * org.openqa.selenium.support.locators.RelativeLocator.withTagName;
		 *
		 */
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.MILLISECONDS);
		/**
		 * Below code has been committed as its not working for selenium 4;
		 */

		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
//		System.out.println(driver.findElement(withTagName("label").above(nameEditBox)).getText());
		WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
//		driver.findElement(withTagName("input").below(dateofBirth)).sendKeys("02/02/1992");

		WebElement iceCreamLabel = driver
				.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));

//		driver.findElement(withTagName("input").toLeftOf(iceCreamLabel)).click();

		// Get me the label of first Radio button
		WebElement rb = driver.findElement(By.id("inlineRadio1"));
//		System.out.println(driver.findElement(withTagName("label").toRightOf(rb)).getText());

	}

}
