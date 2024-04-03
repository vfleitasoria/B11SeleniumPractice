package jsexecutorpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchPractice {
	public static void main(String[] args) throws InterruptedException {
		practice2();
		
	}
	
	public static void practice1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		WebElement textArea = driver.findElement(By.cssSelector("textarea#APjFqb"));
		textArea.sendKeys("Selenium");
		
		Thread.sleep(1000);
		
		WebElement searchButton = driver.findElement(By.cssSelector("div.FPdoLc.lJ9FBc input[name=btnK]"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchButton);
	}

	public static void practice2() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		WebElement textArea = driver.findElement(By.cssSelector("textarea#APjFqb"));
		textArea.sendKeys("Selenium");
		
		Thread.sleep(1000);
		
		WebElement searchResultsPopup = driver.findElement(By.cssSelector("#Alh6id"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].hidden = true;", searchResultsPopup);
		
		Thread.sleep(1000);
		
		WebElement searchButton = driver.findElement(By.cssSelector("div.FPdoLc.lJ9FBc input[name=btnK]"));
		searchButton.click();
		
	}
}
