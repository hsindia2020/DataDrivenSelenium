package com.pcs.Synchronization;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitReal {

	public WebDriver driver;

  @Test
	public void func() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@id='start']/button")).click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		WebElement ele = wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed())
			{
				return driver.findElement(By.cssSelector("[id='finish'] h4"));
			} else {
				return null;
			}
			}
		});
		// Element found but its disabled, need to do something other. its display
		// false.

		System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed());
  }

}
