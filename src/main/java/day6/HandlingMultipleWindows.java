package day6;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingMultipleWindows {

	public static void main(String args[]) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String Parentwindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text()='Open Seperate Multiple Windows']")).click();
		driver.findElement(By.xpath("//button[@onclick='multiwindow()']")).click();
		Set<String> allWindows = driver.getWindowHandles();

		for (String child1 : allWindows) {

			if (!child1.equals(Parentwindow)) {

				driver.switchTo().window(child1);
				System.out.println("Current URL 1: " + driver.getCurrentUrl()); //https://demo.automationtesting.in/Index.html
				System.out.println("Current Title 1: " + driver.getTitle()); //Index
	
				break;

			}
		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele= driver.findElement(By.xpath("//img[@id='enterimg']"));
		wait.until(ExpectedConditions.elementToBeClickable(ele));


		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Testing");

		driver.switchTo().window(Parentwindow);
		driver.quit();
	}
}