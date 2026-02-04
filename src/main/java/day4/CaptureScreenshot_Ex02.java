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

public class CaptureScreenshot_Ex02 {

	public static void main(String args[]) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Test");
		driver.findElement(By.id("input-lastname")).sendKeys("Check");
		
		String email = "test" + System.currentTimeMillis() + "@yopmail.com";

		
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-telephone")).sendKeys("7876765645");
		driver.findElement(By.id("input-password")).sendKeys("Root@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Root@123");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String exp_text = driver.findElement(By.xpath("//div[@id='content']//h1")).getText();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);


		boolean status = false;
		if (exp_text.equalsIgnoreCase("Your Account Has Been Created!")) {

			File dest = new File("C:\\My Workspace\\DailySeleniumPractice\\Screenshots\\registration.png");
			try {
				FileHandler.copy(source, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			status = true;
		}
	
			

		if (status) {
			System.out.println("Test Case Passed");

		} else {

			System.out.println("Test Case Failed");
		}

		driver.quit();
	}

}
