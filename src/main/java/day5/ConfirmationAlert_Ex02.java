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

public class ConfirmationAlert_Ex02 {

	public static void main(String args[]) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
		TakesScreenshot ts = (TakesScreenshot) driver;

		try {
			driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();
			driver.switchTo().alert().accept();
			String OkText = driver.findElement(By.xpath("//p[text()='You pressed Ok']")).getText();
			System.out.println(OkText);

			if (OkText.contains("You pressed Ok")) {
				File source = ts.getScreenshotAs(OutputType.FILE);
				File dest = new File("C:\\My Workspace\\DailySeleniumPractice\\Screenshots\\confirmationalert.png");
				FileHandler.copy(source, dest);

				System.out.println("Test Case Passed");
			} else {
				File source = ts.getScreenshotAs(OutputType.FILE);
				File dest = new File(
						"C:\\My Workspace\\DailySeleniumPractice\\Screenshots\\confirmationalertfailed.png");
				FileHandler.copy(source, dest);

				System.out.println("Test Case Failed");

			}

		}

		catch (Exception e) {

			e.printStackTrace();
		}

		finally {

			driver.quit();
		}
	}

}
