package practices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearchPractice {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com.tr/");
		
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox")); //*[@id='twotabsearchtextbox']
		searchBar.sendKeys("selenium java");
		searchBar.sendKeys(Keys.ENTER);
		
		List<WebElement> titles = driver.findElements(By.cssSelector("h2.a-size-mini")); //h2[contains(@class,'a-size-mini')]
		
		for (WebElement title : titles) {
			System.out.println(title.getText());
			System.out.println("*******");
		}
		
		Thread.sleep(3000);
		driver.quit();
		
	}
}
