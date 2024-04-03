package locatorpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice1 {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}
	

	@Test
	public void loginTest() {
		// Actions
		
		WebElement usernameInput = driver.findElement(By.id("user-name"));
		usernameInput.sendKeys("standard_user");

		WebElement passwordInput = driver.findElement(By.name("password"));
		passwordInput.sendKeys("secret_sauce");

		WebElement loginButton = driver.findElement(By.className("submit-button"));
		loginButton.click();
		
		// Assertions
		
		String url = driver.getCurrentUrl();
		if (url.endsWith("/inventory.html")) {
			System.out.println("Test case has passed");
		} else {
			throw new RuntimeException("Test has failed");
		}
		
	}
	
	
	@AfterMethod
	public void destroy() throws InterruptedException {
		Thread.sleep(500);
		driver.quit();
	}
}
