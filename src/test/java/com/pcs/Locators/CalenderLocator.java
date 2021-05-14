package com.pcs.Locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderLocator {
  @Test
	public void func() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@name='travel_date']")).click();
		int dateselect = driver.findElements(By.className("day")).size();

		System.out.println(dateselect);
		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText()
				.contains("May")) {
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}

		for (int i = 0; i <= dateselect; i++) {

			String date = driver.findElements(By.className("day")).get(i).getText();

			if (date.equalsIgnoreCase("23")) {
				driver.findElements(By.className("day")).get(i).click();
				break;

			}
			}
//		}
//		}

  }
}
