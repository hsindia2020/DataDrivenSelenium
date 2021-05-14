package AjaxChildWindowIframe;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assign04 {
  @Test
	public void ChildWindow() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/windows");

		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> it = windows.iterator();

		String parentId = it.next();

		String childId = it.next();

		driver.switchTo().window(childId);

		System.out.println(
				"Child Window Text " + driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());

		driver.switchTo().window(parentId);
		System.out.println(
				"Parent Window Text "
						+ driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());

  }
}
