package waitspractice.practice1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

		WebElement button1 = driver.findElement(By.id("display-other-button"));
		button1.click();

		WebDriverWait wait20Secs = new WebDriverWait(driver, Duration.ofSeconds(20));
		// WebDriverWait wait10Secs = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait20Secs.until(ExpectedConditions.visibilityOfElementLocated(By.id("hidden")));

		WebElement button2 = driver.findElement(By.id("hidden"));
		button2.click();

		driver.quit();
	}
}
