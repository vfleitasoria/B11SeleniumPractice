package alertspractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertWithOkAndCancel {
	WebDriver driver;
	final String url = "https://demo.automationtesting.in/Alerts.html";
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@AfterMethod
	public void cleanup() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test
	public void test() {
		driver.findElement(By.partialLinkText("Alert with OK & Cancel")).click();
		WebElement button = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		button.click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept(); // press OK
		
		String text = driver.findElement(By.cssSelector("p#demo")).getText().trim();
		System.out.println(text);
		
		if (!text.contains("You pressed Ok")) {
			throw new RuntimeException("Invalid message");
		}
	}
	
	@Test
	public void test2() {
		driver.findElement(By.partialLinkText("Alert with OK & Cancel")).click();
		WebElement button = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		button.click();
		
		Alert alert = driver.switchTo().alert();
		alert.dismiss(); // press CANCEL
		
		String text = driver.findElement(By.cssSelector("p#demo")).getText().trim();
		System.out.println(text);
		
		if (!text.contains("You Pressed Cancel")) {
			throw new RuntimeException("Invalid message");
		}
	}
	
	
}
