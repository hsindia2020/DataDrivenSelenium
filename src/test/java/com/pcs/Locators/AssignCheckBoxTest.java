package com.pcs.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignCheckBoxTest {

	@Test
	public void f() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();

		Assert.assertTrue(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());

		System.out.println(driver.findElements(By.cssSelector("input[id*='checkBoxOption']")).size());

		System.out.println(driver.findElement(By.xpath("//input[@id='autocomplete']")).isEnabled());
		Thread.sleep(3000);
		driver.close();
	}
}
