package day6;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingNewTab {

	public static void main(String args[]) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// find out parent window it first

		String Parentwindowid = driver.getWindowHandle();

		driver.findElement(By.xpath("//button[text()='    click   ']")).click();
		Set<String> childwindows = driver.getWindowHandles();

		try
		
		{
		
		for (String winids : childwindows) 
		
		{
				if (!winids.equalsIgnoreCase(Parentwindowid)) 
				
				{

					driver.switchTo().window(winids);
					driver.findElement(By.linkText("Register now!")).click();
					System.out.println("Test Case Passed");

				}

			} 
			
		}
		catch (Exception e)
			{

				e.printStackTrace();
				System.out.println("Test Case Failed");

			}
			
			finally {
				
				driver.quit();
				
			}
		}
	}

