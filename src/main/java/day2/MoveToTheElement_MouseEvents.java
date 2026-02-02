package day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoveToTheElement_MouseEvents {

	public static void main(String args[]) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Make object of action class
		WebElement comp = driver.findElement(By.xpath("//a[text()='Desktops']"));
		Actions act = new Actions(driver);
		act.moveToElement(comp).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Mac (1)']")));
		
		//driver.findElement(By.xpath("//a[text()='Mac (1)']")).click();
		System.out.println("Test Case Passed");
		 driver.quit();
	}

}
