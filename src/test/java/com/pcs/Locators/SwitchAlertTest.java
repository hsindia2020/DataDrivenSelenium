package com.pcs.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchAlertTest {
	@Test
	public void AlertSwitch() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Alert MSG");
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		Thread.sleep(3000);
		System.out.println("Message is " + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Confirm BTN");
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		driver.switchTo().alert().dismiss();

		driver.close();
	}
}
