package day10;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestCase extends BaseTest{

	
	
	
	
	@Test(priority = 1, groups = { "Sanity" })

	void verifyloginwithcorrectData() {

		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(pr.getProperty("email"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pr.getProperty("password"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		boolean status = driver.getCurrentUrl().contains("account/account");
		Assert.assertEquals(status, true);
	}

	@Test(priority = 2, groups = { "Sanity" })

	void verifyLogoispresent() {

		boolean logoVisibility = driver.findElement(By.xpath("//a[text()='Qafox.com']")).isDisplayed();
		Assert.assertEquals(logoVisibility, false);

	}

	@Test(priority = 3, groups = { "Sanity" },dependsOnMethods= {"verifyLogoispresent"})

	void verifyforgotpwlinkclickable() {

		driver.findElement(By.xpath("//a[text()='Forgotten Password']")).click();
		boolean status = driver.getCurrentUrl().contains("account/forgotten");

		Assert.assertEquals(status, true);

	}

	@Test(priority = 4, groups = { "Sanity" })
	void verifyTitle() {
		String titleofwebpage = driver.getTitle();
		Assert.assertEquals(titleofwebpage, "Account Login");

	}


	
	
}
