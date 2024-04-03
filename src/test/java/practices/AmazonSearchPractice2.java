package practices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearchPractice2 {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.amazon.com.tr/");

		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox")); //*[@id='twotabsearchtextbox']
		searchBar.sendKeys("selenium java");
		searchBar.sendKeys(Keys.ENTER);

		List<WebElement> prices = driver.findElements(By.cssSelector("span.a-price-whole")); //span[contains(@class, 'a-price-whole')]

		double total = 0;
		
		for (WebElement price: prices) {
			String strPrice = price.getText().replace(".", "").replace(",", "");
			total += Double.valueOf(strPrice);
		}
		
		List<WebElement> fractions = driver.findElements(By.cssSelector("span.a-price-fraction")); //span[contains(@class, 'a-price-fraction')]
		
		for (WebElement fraction: fractions) {
			String fractionStr = fraction.getText();
			fractionStr = "0." + fractionStr;
			total += Double.valueOf(fractionStr);
		}

		System.out.println(total);

		Thread.sleep(3000);
		driver.quit();
		
	}
}
