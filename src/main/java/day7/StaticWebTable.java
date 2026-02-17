package day7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// find number of rows in table

		int totalRows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();

		System.out.println("Total no of rows in table is:" + totalRows);

		// find number of columns in table

		int totalcolumns = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();

		System.out.println("Total no of rows in table is:" + totalcolumns);

		// read data from specific row and column

		String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();

		System.out.println("BookName is:" + bookName);

		// read data from all rows and all cells

		for (int i = 2; i < totalRows; i++) {

			for (int j = 1; j < totalcolumns; j++) {

				String AllbookName = driver
						.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td[" + j + "]")).getText();

				System.out.print(AllbookName + "\t");

			}
			System.out.println();
		}

		// find books written by mukesh

		for (int i = 2; i < totalRows; i++) {

			String AuthorName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td[2]"))
					.getText();

			if (AuthorName.equalsIgnoreCase("Mukesh")) {

				String bookswrittenbymukesh = driver
						.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]//td[1]")).getText();

				System.out.println("Books written by mukesh: " + bookswrittenbymukesh);
			}

		}

		driver.quit();

	}

}
