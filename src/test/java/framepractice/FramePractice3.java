package framepractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramePractice3 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		
		driver.switchTo().frame("frm3");
		driver.switchTo().frame("frm1");
		
		String cssLocator = "h1.post-title.entry-title";
		WebElement title = driver.findElement(By.cssSelector(cssLocator));
		System.out.println(title.getText()); // HTML Dropdowns
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		driver.quit();
	}
}
