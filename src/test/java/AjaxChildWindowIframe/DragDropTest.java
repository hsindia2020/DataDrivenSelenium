package AjaxChildWindowIframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDropTest {
  @Test
  public void f() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");
//		driver.manage().window().maximize();
		System.out.println(driver.findElement(By.tagName("iframe")).getSize());
		driver.switchTo().frame(0);

		// driver.findElement(By.xpath("//div[@id='column-a']")).click();
		Actions aa = new Actions(driver);

		aa.dragAndDrop(driver.findElement(By.cssSelector("div[id='draggable']")),
				driver.findElement(By.xpath("//div[@id='droppable']"))).build().perform();
  }
}
