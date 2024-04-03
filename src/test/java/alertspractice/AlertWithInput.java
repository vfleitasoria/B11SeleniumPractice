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

public class AlertWithInput {
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
	public void test() throws InterruptedException {
		driver.findElement(By.partialLinkText("Alert with Textbox")).click();
		WebElement button = driver.findElement(By.cssSelector("button.btn.btn-info"));
		button.click();
		
		String name = "Muhammet";
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(name);
		alert.accept();
				
		String text = driver.findElement(By.cssSelector("p#demo1")).getText().trim();
		System.out.println(text);
		
		if (!text.contains("Hello " + name + " How are you today")) {
			throw new RuntimeException("Invalid message");
		}
	}
}
