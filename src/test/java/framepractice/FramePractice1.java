package framepractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramePractice1 {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		
		// Switch to the frame
		
		// 1. By name or id
		// 2. By index
		// 3. By WebElement that represents iframe
		
		// First way
		// driver.switchTo().frame("frm1");
		
		// Second way
		// driver.switchTo().frame(2);
		
		// Third
		WebElement iframe = driver.findElement(By.id("frm1"));
		driver.switchTo().frame(iframe);
		
		
		// String xpathLocator = "//h1[@class='post-title entry-title']";
		String cssLocator = "h1.post-title.entry-title";
		
		List<WebElement> titles = driver.findElements(By.cssSelector(cssLocator));
		
		int numOfTitles = titles.size();
		
		System.out.println("Number of titles: " + numOfTitles);
		
		for (WebElement x: titles) {
			System.out.println(x.getText());
		}
		
		
		Thread.sleep(3000);
		driver.quit();
	}
}
