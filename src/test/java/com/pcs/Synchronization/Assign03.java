package com.pcs.Synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[contains(text(),'Click to load get data via Ajax!')]")).click();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='results']")));

		System.out.println("Text Prints -- " + driver.findElement(By.cssSelector("div[id='results']")).getText());

		driver.close();
	}

}
