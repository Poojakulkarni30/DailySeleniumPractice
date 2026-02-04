package day5;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Iframe_Ex02 {

	public static void main(String args[]) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("Iframe with in an Iframe")).click();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		try {
		
		WebElement outerframe = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame((outerframe));

		WebElement innerframe = driver.findElement(By.xpath("//iframe[@src='SingleFrames.html']"));
		driver.switchTo().frame((innerframe));

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Testing nested frames");
		File source= ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("C:\\My Workspace\\DailySeleniumPractice\\Screenshots\\nestediframespassed.png");
		FileHandler.copy(source, dest);
		System.out.println("Test Case passed");

	}
		
		catch(Exception E) {
			
			File source= ts.getScreenshotAs(OutputType.FILE);
			File dest= new File("C:\\My Workspace\\DailySeleniumPractice\\Screenshots\\nestediframesfailed.png");
			FileHandler.copy(source, dest);
			System.out.println("Test Case failed");
			E.printStackTrace();
		}
		
		finally {
			
			driver.switchTo().defaultContent();
			driver.quit();
		}

}
}
