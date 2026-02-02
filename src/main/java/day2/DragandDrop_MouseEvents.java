package day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragandDrop_MouseEvents {

	public static void main(String args[]) {
		
		
		WebDriver driver= new ChromeDriver() ;
			
			driver.get("https://testautomationpractice.blogspot.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Actions act= new Actions(driver);
			WebElement source = driver.findElement(By.xpath("//div[@id='draggable']//p"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(source));
			WebElement dest= driver.findElement(By.xpath("//div[@id='droppable']//p"));
			try {
			act.dragAndDrop(source, dest).perform();
			

			if(dest.getText().contains("Dropped")) {
				
				System.out.println("Test Case Passed");
			}

			else {
				
				System.out.println("Test Case Failed");
			}
		
			}
			catch(Exception e) {
				
				e.printStackTrace();
			}
			
		driver.quit();
		
	}
	
	
	
}
