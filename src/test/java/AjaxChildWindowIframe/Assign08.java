package AjaxChildWindowIframe;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign08{
  @Test
	public void assign08() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("aus");
		Thread.sleep(3000);

		List<WebElement> options = driver.findElements(By.className(".ui-menu-item"));

		for (WebElement option : options)

		{
			if (option.getText().equalsIgnoreCase("Australia")) {
				option.click();
				break;
			}
		}
  }
}
