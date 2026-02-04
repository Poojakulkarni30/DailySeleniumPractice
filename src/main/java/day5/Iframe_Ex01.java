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

public class Iframe_Ex01 {

	public static void main(String args[]) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Frames.html");

		// we can switch to iframe by 4 types
		/*
		 * 1. ID 2. Name 3. Index 4. WebElemtn
		 * 
		 */
		;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		TakesScreenshot ts = (TakesScreenshot) driver;

		try {

			driver.switchTo().frame("SingleFrame");
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Switched to single frame");
			File source = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\My Workspace\\DailySeleniumPractice\\Screenshots\\iframePassed.png");
			FileHandler.copy(source, dest);
			System.out.println("Test Case Passed");

		}

		catch (Exception e) {

			File source = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\My Workspace\\DailySeleniumPractice\\Screenshots\\iframefailed.png");
			FileHandler.copy(source, dest);

			e.printStackTrace();

		}
		finally {

			driver.switchTo().defaultContent();
		driver.quit();
	}
	}
}
