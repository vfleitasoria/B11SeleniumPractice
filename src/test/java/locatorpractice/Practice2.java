package locatorpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice2 {
	public static void main(String[] args) {
		String url = "https://demo.guru99.com/test/newtours/";
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximize the window size
		
		driver.get(url);
		
		driver.findElement(By.name("userName")).sendKeys("User123");
		driver.findElement(By.name("password")).sendKeys("12345");
		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
		// driver.findElement(By.cssSelector("input[name=submit]")).click();
		
		String text = driver.findElement(By.xpath("//tbody//h3")).getText();
		System.out.println(text);
	}
}
