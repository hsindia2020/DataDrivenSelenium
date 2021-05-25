package com.pcs.seleniumGrid;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicGridSel {
  @Test
	public void funcs() throws IOException, Exception {

		// DesiredCapabilities
		/**
		 * This is for execute the test at remote location. WebDriver driver = new
		 * ChromeDriver(); **********This is for local running.
		 */
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("firefox");
		dc.setPlatform(Platform.WINDOWS);
//Location of Server as well
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.102:5555/wd/hub"), dc);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();

		Assert.assertTrue(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());

		System.out.println(driver.findElements(By.cssSelector("input[id*='checkBoxOption']")).size());

		System.out.println(driver.findElement(By.xpath("//input[@id='autocomplete']")).isEnabled());
		Thread.sleep(3000);

  }
}
