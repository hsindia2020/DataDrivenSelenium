package com.pcs.Locators;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EcomItemAdd {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String[] itemNeeded = { "Cucumber", "Brinjal", "Apple" };

		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i <= product.size(); i++) {

			String[] name = product.get(i).getText().split("-");

			// Clear the text with spaces and trimming
			String formatname = name[0].trim();

			// convert Array into ArrayList for every search
			// check the name for every present arraylist

			List itemNeedList = Arrays.asList(itemNeeded);

			int j = 0;
			if (itemNeedList.contains(formatname)) {

				j++;
				driver.findElements(By.xpath("//div[@class=\"product-action\"]")).get(i).click();
				/*
				 * // This for button change the text and take 5 seconds to come back
				 * Thread.sleep(5000);
				 */
				if (j == itemNeeded.length) {
					break;
				}
			}
		}

	}

}
