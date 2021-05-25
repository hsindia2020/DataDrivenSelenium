package com.pcs.Locators;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkCountsTest {
  @Test
	public void LinkCountsFooter() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		int tagsize = driver.findElements(By.tagName("a")).size();
		System.out.println("Tags found in webpage " + tagsize);
		assertEquals(tagsize, 27);

		WebElement FooterElements = driver.findElement(By.id("gf-BIG"));// Limiting webdriver scope.
//Count all the links available with the tagName 'a'.
		int tagFooterSize = FooterElements.findElements(By.tagName("a")).size();
		assertEquals(tagFooterSize, 20);

		System.out.println(FooterElements.findElements(By.tagName("a")).size());

		WebElement FirstColFooter = FooterElements
				.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]"));

		System.out.println(FirstColFooter.findElements(By.tagName("a")).size());

		int FCFooter = FirstColFooter.findElements(By.tagName("a")).size();

//Clink on all the specific links into the footer first column only.

		for (int i = 1; i < FCFooter; i++) {

			String Clkonlink = Keys.chord(Keys.CONTROL, Keys.ENTER);

			FirstColFooter.findElements(By.tagName("a")).get(i).sendKeys(Clkonlink);
			Thread.sleep(3000);
		}
			Set<String> winset = driver.getWindowHandles();
			Iterator<String> it = winset.iterator();

			while (it.hasNext()) {
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}

  }
}
