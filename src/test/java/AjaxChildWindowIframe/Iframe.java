package AjaxChildWindowIframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframe {
  @Test
	public void frame() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/iframe");

		Thread.sleep(3000);
		// To identified the iframe we have to first select the frame into the Window,
		// because frame is behaving a different window in window.

		driver.switchTo().frame("mce_0_ifr").findElement(By.id("tinymce")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("tinymce")).sendKeys("First clear the existing, than I entered the Text");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[@class='tox-tbtn'][3]")).click();

	}

}
