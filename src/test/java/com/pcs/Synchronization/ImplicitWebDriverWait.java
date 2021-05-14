package com.pcs.Synchronization;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWebDriverWait {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		driver.manage().window().maximize();

		// Implicit wait will work globally with class. it will work on class level
		// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		String[] addItem = { "Potato", "Cauliflower", "Onion", "Tomato" };

		List<String> addItemList = Arrays.asList(addItem);

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		List<WebElement> buttons = driver.findElements(By.xpath("//div[@class='product-action']/button"));

		String[] productArray;

		String product;

		int j = 0;

		for (int i = 1; i < products.size(); i++) {

			productArray = products.get(i).getText().split("-");

			product = productArray[0].trim();

			if (addItemList.contains(product)) {

				j++;

				buttons.get(i).click();

				Thread.sleep(3000);

				if (j == (addItem.length)) {

					break;

				}

			}

		}

//click on Cart bag

		driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/a[4]/img")).click();

//click on Proceed to checkout

		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		// explicit wait only effect on below code only.
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='promoCode']")));

		// rahulshettyacademy promo code apply and it take some time

		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();

		// explicit wait only effect on below code only. WebDriverWait is part of
		// Explicit Wait..
		// WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));

		System.out.println(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText());
	}

}
