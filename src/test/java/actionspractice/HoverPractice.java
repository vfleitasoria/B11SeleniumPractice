package actionspractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HoverPractice {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-perform-mouse-hover-in-selenium.html");
		
		WebElement button = driver.findElement(By.cssSelector("button.dropbtn"));
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(button).build().perform();
		
		driver.findElement(By.linkText("Selenium")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
	}
}
