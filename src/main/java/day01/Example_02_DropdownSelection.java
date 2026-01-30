package day01;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Example_02_DropdownSelection {
	
	
	public static void main (String args []) {
		
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
	WebElement Userrole=	driver.findElement(By.xpath("//div[text()='-- Select --']"));
	      Userrole.click();
	      WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	      List <WebElement> allelements=  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='oxd-select-option']")));
		
		//List <WebElement> allelements = driver.findElements(By.xpath("//div[@class='oxd-select-option']"));
		String role = "ESS";
		Boolean clicked = false;
		for (WebElement ele:allelements) {
			
			
			try {
				
			
			if(ele.getText().equals(role)){
				
			
				
				ele.click();
				
				clicked=true;
				System.out.println("Test case passed");
				break;
				
			}
			}
			catch(Exception e) {
				
			
				System.out.println(	e.getMessage());
			}
		}
		
			if (!clicked) {
			    System.out.println("Test case failed - role not found");
			
		}
			driver.quit();
	
	}
			
	
	
	}