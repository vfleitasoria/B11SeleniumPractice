package waitspractice.practice1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

		WebElement button1 = driver.findElement(By.id("display-other-button"));
		button1.click();


		WebElement button2 = driver.findElement(By.id("hidden"));
		button2.click();

		driver.quit();
	}
}
