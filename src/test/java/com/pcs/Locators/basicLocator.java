package com.pcs.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basicLocator {
	/**
	 * Locator define and working.
	 *
	 * @param args
	 * @throws Exception, this is maintain the wait for 3 seconds
	 */
	@Test
	public void f() throws Exception {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://trello.com/login");

		driver.findElement(By.xpath("//input[@id='user']")).sendKeys("ab@email.com");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("abcd1234");
		driver.findElement(By.xpath("//div[@id='googleButton']/following-sibling::div[2]")).click();
		Thread.sleep(5000);
//		driver.manage().timeouts().implicitlyWait(120, TimeUnit.ECONDS);

		driver.close();
	}

}
