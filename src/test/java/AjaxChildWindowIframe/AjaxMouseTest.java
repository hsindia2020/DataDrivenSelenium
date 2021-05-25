package AjaxChildWindowIframe;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjaxMouseTest {
  @Test
	public void func() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();
		Actions aa = new Actions(driver);
		WebElement hover = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		WebElement caps = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

		aa.moveToElement(caps).click().keyDown(Keys.SHIFT).sendKeys("lego").build().perform();
		Thread.sleep(3000);
		// Move to specific element
		aa.moveToElement(hover).build().perform(); // perform is like to execute
		Thread.sleep(2000);
		aa.moveToElement(hover).contextClick().build().perform();

  }
}
