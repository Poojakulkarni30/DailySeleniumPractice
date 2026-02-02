package day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClick_MouseEvents {

	public static void main(String args[]) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://vinothqaacademy.com/mouse-event/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement rightclick = driver.findElement(By.id("rightclick"));
		Actions act = new Actions(driver);
		act.contextClick(rightclick).perform();

		List<WebElement> links = driver.findElements(By.xpath("//div[@id='myDiv']//a"));

		System.out.println(links.size());

		boolean isMatched = false;

		for (WebElement link : links) {

			String ss= link.getText();
			
			if (ss.equals("Registration Form") || ss.equals("Alert Popup") || ss.equals("Mouse Event"))
			{

				System.out.println("Matched link: " + ss);
				 isMatched = true;

			}
		}

			if( isMatched) {
				System.out.println("Test Case Passed");
			}
			else {
				System.out.println("Test Case Failed");
			}
		
		
		driver.quit();

	}
	

}
