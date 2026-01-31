package day01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Example_03 {

	public static void main (String args[]) {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//choosing flight from bang to pune 
		
		WebElement from= driver.findElement(By.xpath("//input[@value='Delhi (DEL)']"));;
		
		from.clear();
		from.click();
		driver.findElement(By.xpath("//div[text()='BLR']")).click();
		driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement des=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Hyderabad']")));
		des.click();
		driver.findElement(By.xpath("//div[text()='Sat, 7 Feb 2026']")).click();
		
		String year = "2027";
		String month = "June";
        String date = "30";		
        while (true) {

            // 1. Read visible month + year text
            String monthYear = driver.findElement(
                By.xpath("//div[contains(text(),'202')]")
            ).getText();

            // 2. Check target year and month
            if (monthYear.contains(year) && monthYear.contains(month)) {
                break;
            }

            // 3. Click Next arrow
            driver.findElement(By.cssSelector("body div[id='react-root'] div[id='main-container'] div[data-testid='application-id'] div div div div div div div[data-testid='undefined-calendar-picker'] div:nth-child(1) svg g circle")
              
            ).click();
        }

        driver.findElement(By.xpath("//div[text()='" + date + "']")).click();
		
		
	}
	
	
}
