package day5;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class PromptAlert_Ex03 {

	public static void main(String args[]) throws IOException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();
		driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();
		TakesScreenshot ts = (TakesScreenshot) driver;
		try {

			Alert a = driver.switchTo().alert();

			a.sendKeys("Pooja");
			a.accept();
			String enteredText = driver.findElement(By.xpath("//p[@id='demo1']")).getText();

		

			if (enteredText.contains("Hello Pooja How are you today")) {
				File source = ts.getScreenshotAs(OutputType.FILE);
				File dest = new File("C:\\My Workspace\\DailySeleniumPractice\\Screenshots\\PromptalertPassed.png");
				FileHandler.copy(source, dest);
				System.out.println("Test Case Passed and Entered text is:"+enteredText);
			}

			else {

				
				File source = ts.getScreenshotAs(OutputType.FILE);
				File dest = new File("C:\\My Workspace\\DailySeleniumPractice\\Screenshots\\PromptalertFailed.png");
				FileHandler.copy(source, dest);
				System.out.println("Test Case Failed and Entered text is:"+enteredText);

			}

		}

		catch (Exception e) {

			e.printStackTrace();

		} finally {

			driver.quit();
		}
	}

}
