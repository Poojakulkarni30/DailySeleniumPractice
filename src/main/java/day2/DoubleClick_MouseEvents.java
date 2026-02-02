package day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick_MouseEvents {

	public static void main(String args[]) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://qa-practice.netlify.app/double-click");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement dbclick = driver.findElement(By.xpath("//button[@type='submit']"));
		Actions act = new Actions(driver);

		String ExpectedText = "Congrats, ydou double clicked!";
		try {
			act.doubleClick(dbclick).build().perform();
			WebElement msg = driver.findElement(By.xpath("//div[text()='Congrats, you double clicked!']"));

			if (msg.getText().equalsIgnoreCase(ExpectedText)) {

				System.out.println("Test Case Passed");

			} else {
				System.out.println("Test case failed");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		driver.quit();
	}
}
