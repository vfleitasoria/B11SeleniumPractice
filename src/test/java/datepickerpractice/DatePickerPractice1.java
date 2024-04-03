package datepickerpractice;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerPractice1 {
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		try {
			test2(driver);
		} catch (Exception e) {			
			throw e;
		} finally {
			Thread.sleep(5000);
			driver.quit();
		}
		
		
	}
	
	// Confirmed that it works
	public static void test1(WebDriver driver) {
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		
		String date = "03/15/2023";
		
		driver.findElement(By.id("datepicker2")).sendKeys(date);
	}
	
	// More challenging
	public static void test2(WebDriver driver) {
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		
		WebElement datePicker1 = driver.findElement(By.id("datepicker1"));
		datePicker1.click();
		
		String date = "03/15/2023";
				
		int monthDiff = getMonthDiffFromToday(date);
		
		for (int i = 0; i < monthDiff; i++) {
			driver.findElement(By.cssSelector("a.ui-datepicker-prev.ui-corner-all")).click();
		}
		
		int intDay = Integer.valueOf(date.split("/")[1]);
		String dayLocator = String.format("//a[@class='ui-state-default' and text()='%s']", intDay);
		driver.findElement(By.xpath(dayLocator)).click();
		
	}
	
	public static int getMonthDiffFromToday(String date) {
		String[] dateParts = date.split("/"); // {"03", "15", "2023"}
		
		int day = Integer.valueOf(dateParts[1]);
		int month = Integer.valueOf(dateParts[0]);
		int year = Integer.valueOf(dateParts[2]);
		
		LocalDate targetDate = LocalDate.of(year, month, day);
		LocalDate todaysDate = LocalDate.now();
		
		long dayDiff = todaysDate.toEpochDay() - targetDate.toEpochDay();
		double diffMonths = dayDiff / 30.0;
		
		int diffMonthsInt = (int) Math.round(diffMonths);
		
		return diffMonthsInt;
	}
}
