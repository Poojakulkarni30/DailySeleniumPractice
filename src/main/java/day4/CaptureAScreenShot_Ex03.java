package day4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureAScreenShot_Ex03 {

	public static void main(String args[]) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();

		driver.findElement(By.id("input-email")).sendKeys("pooja@test.in");
		driver.findElement(By.id("input-password")).sendKeys("Root@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		String Exp_text = driver.findElement(By.xpath("//div[@id='content']//h2")).getText();

		
		TakesScreenshot ts = (TakesScreenshot) driver;
		boolean isMatched = false;

		if (Exp_text.contains("My Accounts")) {

		    try {
		        File source = ts.getScreenshotAs(OutputType.FILE);
		        File dest = new File(
		            "C:\\My Workspace\\DailySeleniumPractice\\Screenshots\\login_success.png"
		        );
		        FileHandler.copy(source, dest);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }

		    isMatched = true;

		} else {

		    try {
		        File source = ts.getScreenshotAs(OutputType.FILE);
		        File dest = new File(
		            "C:\\My Workspace\\DailySeleniumPractice\\Screenshots\\login_failed.png"
		        );
		        FileHandler.copy(source, dest);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}

		if (isMatched) {
		    System.out.println("Test Case Passed");
		} else {
		    System.out.println("Test Case Failed");
		}

		driver.quit();
}
}