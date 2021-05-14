package com.pcs.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign06 {
  @Test
	public void func() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		String opt = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[3]")).getText();
		driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).click();
		System.out.println(opt);

		WebElement staticelement = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(staticelement);

		dropdown.selectByVisibleText(opt);

		driver.findElement(By.xpath("//input[@class='inputs']")).sendKeys(opt);
		driver.findElement(By.xpath("//input[@value='Alert']")).click();
		Thread.sleep(3000);
//		driver.switchTo().alert().getText();
		String alttext = driver.switchTo().alert().getText().split(" ")[1].trim().split(" ")[0];
		System.out.println(alttext);
  }
}
