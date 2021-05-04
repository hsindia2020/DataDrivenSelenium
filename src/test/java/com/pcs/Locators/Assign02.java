package com.pcs.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign02 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.cleartrip.com/flights");

		driver.findElement(By.xpath("//input[@id='DepartDate']")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		Thread.sleep(3000);

		WebElement statele = driver.findElement(By.name("adults"));
		Select dropdown = new Select(statele);
		dropdown.selectByIndex(3);

		WebElement childele = driver.findElement(By.name("childs"));
		Select childrop = new Select(childele);
		childrop.selectByValue("2");

		// Auto dropdown selected
		driver.findElement(By.cssSelector(".rArrow.blue")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='AirlineAutocomplete']")).sendKeys("air india");
		Thread.sleep(2000);

		// Click and Error Message print
		driver.findElement(By.xpath("//input[@id='SearchBtn']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='homeErrorMessage']")).getText());

	}

}
