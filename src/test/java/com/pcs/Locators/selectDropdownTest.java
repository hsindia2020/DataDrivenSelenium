package com.pcs.Locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selectDropdownTest {

	@Test
	void func() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		WebElement staticelement = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
		Select dropdown = new Select(staticelement);

		dropdown.selectByIndex(3);
		System.out.println(" Selected " + dropdown.getFirstSelectedOption().getText() + " Currency ");
		dropdown.selectByValue("AED");
		System.out.println(" Selected " + dropdown.getFirstSelectedOption().getText() + " Currency ");

		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for (int i = 1; i <= 5; i++) {
			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}
		System.out.println("Value " + driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());

		driver.findElement(By.xpath("//span[@id='ctl00_mainContent_ddl_originStation1_CTXTaction']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Delhi (DEL)')]")).click();

		/*
		 * driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 * System.out.println(" From Country " + driver.findElement(By.xpath(
		 * "(//input[@id='ctl00_mainContent_ddl_originStation1_CTXT'])[1]"))
		 * .getText());
		 */
		driver.findElement(By.xpath("(//a[contains(text(),'Mumbai (BOM)')])[2]")).click();
		Thread.sleep(3000);

		driver.close();
	}
}
