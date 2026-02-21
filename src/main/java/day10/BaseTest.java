package day10;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	WebDriver driver;
	Properties pr;
	FileInputStream fi;

	@BeforeMethod

	public void setup() throws IOException {

		driver = new ChromeDriver();
		fi = new FileInputStream(System.getProperty("user.dir") + "\\testData\\config.properties");
		pr = new Properties();
		pr.load(fi);
		driver.get(pr.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}

	@AfterMethod

	void tearDown() {

		driver.quit();
	}

}
