package day7;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_Learning {

	public static void main(String args[]) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		//1️ Count rows
		
		List<WebElement> totalRows=driver.findElements(By.xpath("//div[@class='oxd-table-card']"));
		
		
		System.out.println("Row Size of table is: "+totalRows.size());
		
		
		for(int i=0;i<=totalRows.size()-1;i++) {
			
		
			System.out.print(totalRows.get(i).getText());
			
			System.out.println("");
			
			
			
		}

		
		
		//2️ Count columns
		
		List<WebElement>totalcolumns=driver.findElements(By.xpath("//div[@role='columnheader']"));
		
		System.out.println("Column Size of table is: "+totalcolumns.size());

		for(int i=0;i<=totalcolumns.size()-1;i++) {
			
			
			System.out.print(totalcolumns.get(i).getText()+" ");
			
			System.out.println("");
			
			
			
		}
		
		//3️ Get specific cell value (Row + Column)
		//4️ Find row by text (MOST IMPORTANT)
		
		//5️ Click button inside specific row (MOST ASKED)
		driver.findElement(By.xpath("//div[@class='orangehrm-container']//div[3]//div[1]//div[6]//div[1]//button[2]//i[1]")).click();
		
		
		
		driver.quit();
		
		
		
		

	}

}
