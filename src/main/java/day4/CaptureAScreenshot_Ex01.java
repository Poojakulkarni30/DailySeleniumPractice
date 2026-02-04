package day4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureAScreenshot_Ex01 {

	
	public static void main(String args[]) {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		TakesScreenshot screen= (TakesScreenshot)driver; //TakesScreenshot is an interface
		File source=screen.getScreenshotAs(OutputType.FILE);
		File dest= new File("C:\\My Workspace\\DailySeleniumPractice\\Screenshots\\page.png");
		try {
			FileHandler.copy(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		driver.quit();;
		
		
	}
}