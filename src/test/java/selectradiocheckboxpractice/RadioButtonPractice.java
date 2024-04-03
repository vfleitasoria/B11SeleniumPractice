package selectradiocheckboxpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonPractice {
	public static void main(String[] args) {
		String url = "https://practice.expandtesting.com/radio-buttons";
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		
		WebElement tennisRadioButton = driver.findElement(By.id("football"));
		tennisRadioButton.click();
		
		
	}

}
