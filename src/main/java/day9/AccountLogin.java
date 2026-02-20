package day9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountLogin {

	WebDriver driver;

@BeforeClass

	void testLogin() {

		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	

	}
	
	@Test(priority = 2)
	void enteruserDetails() {
		
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("pooja@test.in");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Root@123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	@Test(priority = 3)
	void testMyAccounttitle() {

		String exp_Text = "My Account";

		String act_Text = driver.findElement(By.xpath("//h2[text()='My Account']")).getText();
		Assert.assertEquals(act_Text, exp_Text);
	}

	@AfterClass
	void tearDown() {

		driver.quit();

	}

}