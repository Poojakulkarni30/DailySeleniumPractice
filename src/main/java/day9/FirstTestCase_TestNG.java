package day9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FirstTestCase_TestNG {

	/*
	 * TestNG We have to use @Test annotations for execution of test below things we
	 * can achieve using testng 1. it does grouping 2. Priority 3. Parameterization
	 * 4. reports 5.parellel testing and so on .....
	 * 
	 */

	WebDriver driver;

	@Test(priority = 1)
	void OpenApp() {

		driver = new ChromeDriver();

		driver.get("https://practice.automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}

	@Test(priority = 2)
	void AccountRegistration() {

		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testproject@yopmail.com");
		driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys("Root@123#");
		driver.findElement(By.xpath("//input[@value='Register']")).click();

	}

	@Test(priority = 3)
	void testDashboardPage() {
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));


		String finalText = mywait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Dashboard']"))).getText();

		if (finalText.contains("Dashboard")) {

			System.out.println("TestCase Passed- Registration Successful");
		} else {

			System.out.println("TestCase Failed- Registration Unsuccessful");
		}

	}

	@Test(priority = 4)
	void TearDown() {

		driver.quit();

	}

}
