package com.pcs.Miscellaneous;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {
  @Test
	public void BrokenLk() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		/**
		 * Broken URL step 1 - IS to get all URL tied up to the links using Selenium
		 * Java methods will call URL's and gets you the status code is state code is >
		 * 400 than that URL is not working>> a[href*="soapui"]
		 */

		String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		String brokenurl = driver.findElement(By.cssSelector("a[href*='broken']")).getAttribute("href");

		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		HttpURLConnection broconn = (HttpURLConnection) new URL(brokenurl).openConnection();

		conn.setRequestMethod("HEAD");
		broconn.setRequestMethod("HEAD");
		conn.connect();
		broconn.connect();
		int code = conn.getResponseCode();
		int bcode = broconn.getResponseCode();
		System.out.println(code);
		System.out.println(bcode);

  }
}
