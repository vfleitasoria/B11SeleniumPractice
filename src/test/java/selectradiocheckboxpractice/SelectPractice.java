package selectradiocheckboxpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectPractice {
	public static void main(String[] args) throws InterruptedException {
		String url = "https://www.globalsqa.com/demo-site/select-dropdown-menu/";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		WebElement dropdown = driver.findElement(By.tagName("select"));
		
		Select select = new Select(dropdown);
		select.selectByIndex(3); // Algeria
		select.selectByVisibleText("Argentina");
		select.selectByValue("AUS"); // Australia
		
		Thread.sleep(3000);
		driver.quit();
		
	}
}
