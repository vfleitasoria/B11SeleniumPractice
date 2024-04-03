package framepractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramePractice2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		
		List<WebElement> iframes = driver.findElements(By.xpath("//div[starts-with(@id, 'post-body')]//iframe"));
		System.out.println(iframes.size()); // 3
		
		
		for (WebElement iframe : iframes) {
			driver.switchTo().frame(iframe);
			
			// do whatever automation needed
			String cssLocator = "h1.post-title.entry-title";
			String title = driver.findElement(By.cssSelector(cssLocator)).getText().trim();
			System.out.println(title);
			
			driver.switchTo().defaultContent();
		}
		
		
		Thread.sleep(3000);
		driver.quit();
	}
}


