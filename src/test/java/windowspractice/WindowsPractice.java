package windowspractice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// driver.close() -> will only close the currently active tab
// driver.quit() -> will close the entire driver session (all the tabs and windows)

public class WindowsPractice {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		try {
			test(driver);
		} catch (Exception e) {			
			throw e;
		} finally {
			Thread.sleep(5000);
			driver.quit();
		}
		
		
	}
	
	public static void test(WebDriver driver) {
		
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		String parentWindowId = driver.getWindowHandle();
		
		// 1. Click on "Open New Tab button"
		
		driver.findElement(By.id("newTabBtn")).click();
		
		// 2. Switch to that new window (using the set obtained by driver.getWindowHandles())
		
		Set<String> windowIds = driver.getWindowHandles(); // [parentWindowId, childWindowId]
		
		for (String windowId : windowIds) {
			if (windowId == parentWindowId) { // skip parentWindowId
				continue;
			}
			driver.switchTo().window(windowId); // switch to childWindowId
		}
		
		// 3. Do your automation
		
		String url = driver.getCurrentUrl();
		System.out.println("URL of the other window: " + url);
		
		driver.close(); // will only close the child window that we opened later
		
		// 4. Come back to the parent page (using parentWindowId)
		
		driver.switchTo().window(parentWindowId);
		
		// 5. Type something in the text box of the parent page
		
		driver.findElement(By.id("name")).sendKeys("I'm done automating windows");
		
	}
}
