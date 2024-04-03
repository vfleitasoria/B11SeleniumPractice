package waitspractice.practice1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ThreadSleepPractice {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
		
		WebElement button1 = driver.findElement(By.id("display-other-button"));
		button1.click();
		
		Thread.sleep(20000);
		
		WebElement button2 = driver.findElement(By.id("hidden"));
		button2.click();
		
		
		driver.quit();
		
	}
}
