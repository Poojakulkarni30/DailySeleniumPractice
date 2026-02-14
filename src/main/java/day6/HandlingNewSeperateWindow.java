package day6;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingNewSeperateWindow {

	public static void main(String args[]) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text()='Open New Seperate Windows']")).click();

		driver.findElement(By.xpath("//button[@onclick='newwindow()']")).click();
		Set<String> childWindows = driver.getWindowHandles();

		try {

			for (String allwinids : childWindows) {

				if (!allwinids.equalsIgnoreCase(parentWindow)) {

					driver.switchTo().window(allwinids);
					driver.findElement((By.linkText("Register now!"))).click();
					System.out.println("Test Case Passed");

					break;
				}

			}
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println("element not found hence test case failed");
		}

		finally {
			driver.switchTo().window(parentWindow);
			driver.findElement(By.linkText("Home")).click();

			String pageTitle = driver.getTitle();
			System.out.println(pageTitle);
			driver.quit();

		}
	}
}