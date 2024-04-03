package actionspractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickPractice {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		WebElement button = driver.findElement(By.cssSelector("span.context-menu-one"));
		
		Actions actions = new Actions(driver);
		actions.contextClick(button).build().perform();
		
		driver.findElement(By.xpath("//span[text()='Copy']")).click();
		
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		System.out.println(message);
		alert.accept();
		
		Thread.sleep(3000);
		driver.quit();
	}
}
