package day8;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginUsingExcelutils {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String filepath = System.getProperty("user.dir") + "\\testData\\Loginfile.xlsx";

		int rows = ExcelUtils_Data_Driven_Testing.getrowcount(filepath, "Sheet1");

		for (int r = 1; r <= rows; r++) {

			driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

			String email = ExcelUtils_Data_Driven_Testing.getCellData(filepath, "Sheet1", r, 0);

			String password = ExcelUtils_Data_Driven_Testing.getCellData(filepath, "Sheet1", r, 1);
			driver.findElement(By.xpath("//input[@id='input-email']")).clear();
			driver.findElement(By.xpath("//input[@id='input-password']")).clear();

			driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@value='Login']")).click();

			boolean status = driver.getCurrentUrl().contains("account/account");

			if (status) {

				ExcelUtils_Data_Driven_Testing.setCellData(filepath, "Sheet1", r, 3, "Passed");
				ExcelUtils_Data_Driven_Testing.fillGreencolor(filepath, "Sheet1", r, 3);
				driver.findElement(By.xpath("//a[@title='My Account']")).click();
				driver.findElement(By.xpath("//a[text()='Logout']")).click();
				driver.findElement(By.xpath("//a[@class='list-group-item'][1]")).click();

			}

			else {

				ExcelUtils_Data_Driven_Testing.setCellData(filepath, "Sheet1", r, 3, "Failed");
				ExcelUtils_Data_Driven_Testing.fillRedcolor(filepath, "Sheet1", r, 3);
				driver.findElement(By.xpath("//a[@class='list-group-item'][1]")).click();

			}
		}
		driver.quit();
	}

}
