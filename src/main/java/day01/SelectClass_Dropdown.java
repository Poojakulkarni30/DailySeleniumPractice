package day01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClass_Dropdown {
	
	
public static void main (String args[]) {
		
		
		
		WebDriver driver = new ChromeDriver();
		

	
	driver.get("https://demoqa.com/select-menu");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	

	// Create object of select class 
	
	WebElement selctbox= driver.findElement(By.xpath("//select[@id=\"oldSelectMenu\"]"));
	
	Select sel = new Select(selctbox);
	sel.selectByVisibleText("Black");
	driver.close();
	
	
	
	}

}


