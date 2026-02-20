package day8;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PropertiesFileRead {

	WebDriver driver;
	Properties pr;
	FileInputStream file;

	@Test(priority = 1)

	void setup() throws IOException {

		driver = new ChromeDriver();
		pr = new Properties();
		file = new FileInputStream(System.getProperty("user.dir") + "\\testData\\config.properties");
		pr.load(file);
		driver.get(pr.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}

	@Test(priority = 2)
	void enteruserDetails() {

		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(pr.getProperty("email"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pr.getProperty("password"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}
	
	@Test(priority = 3)
	void tearDown() {

		driver.quit();

	}

}
