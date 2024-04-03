package actionspractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HoldDownKeyPractice {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.wikipedia.org/");
		
		WebElement link = driver.findElement(By.cssSelector("a[href='//www.wiktionary.org/']"));
		
		Actions actions = new Actions(driver);
		
		// for windows users
		// actions.moveToElement(link).keyDown(Keys.CONTROL).click(link).keyUp(Keys.COMMAND).build().perform();
		
		// for mac users
		actions.moveToElement(link).keyDown(Keys.COMMAND).click(link).keyUp(Keys.COMMAND).build().perform();
		
		Thread.sleep(3000);
		driver.quit();
	}
}
