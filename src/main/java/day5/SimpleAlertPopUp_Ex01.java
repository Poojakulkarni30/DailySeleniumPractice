package day5;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class SimpleAlertPopUp_Ex01 {

	public static void main(String args[]) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		TakesScreenshot ts = (TakesScreenshot) driver;

		try {
			driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
			String alerttext = driver.switchTo().alert().getText();
			System.out.println(alerttext);
			driver.switchTo().alert().accept();
			File Source = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\My Workspace\\DailySeleniumPractice\\Screenshots\\simplealert.png");
			FileHandler.copy(Source, dest);
			System.out.println("Test Case Passed");

		} catch (Exception e) {
			File Source = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\My Workspace\\DailySeleniumPractice\\Screenshots\\simplealertfailed.png");
			FileHandler.copy(Source, dest);
			System.out.println("Test Case Failed" + e.getMessage());

		} finally {

			driver.quit();
		}
	}
}
