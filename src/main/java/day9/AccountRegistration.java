package day9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AccountRegistration {

/*  
 * TestNG Annotations
 *   1. Before Suite  -- it runs before ruunig the suite
 *   2. After Suite   -- after running the suite at the end
 * 
 *   1. Before Test  --  on xml file each test contains multiple classes so before running that
 *   2. After Test  --   after
 *   
 *   1. Before class  --- before running each class
 *   2. After Class  ----  after
 * 
 *   1. Before Method  --- before execution each method
 *   2. After Method   --- after
 *  
 */
	WebDriver driver;
	
	@BeforeTest
	
	void testLogin(){
		
		
		driver= new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
				
	}

	@Test(priority=2)
	void testAccountReg()
	{
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("china");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("japan");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test" + System.currentTimeMillis() + "@gmail.com");
		driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Root@123");
		driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys("Root@123");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();


		
	}
	@Test(priority=3)
	void testTitle() {
		
		String exp_Text="Your Account Has Been Created!";
		
		String actual_Text=driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
		
		Assert.assertEquals(actual_Text, exp_Text);
		
	}
	

	@AfterTest
	void TearDown() {
		
		
		driver.quit();
	}



}
