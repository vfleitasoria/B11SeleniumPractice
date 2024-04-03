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

public class SimpleAlert {
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
		WebElement button = driver.findElement(By.cssSelector("button.btn.btn-danger"));
		button.click();
		
		Thread.sleep(1000);
		
		Alert alert = driver.switchTo().alert();
		
		// Get the text
		String text = alert.getText();
		System.out.println(text);
		
		// Click OK
		alert.accept();
		
	}
	
}
