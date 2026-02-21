package day10;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Mylistener implements ITestListener {

	public ExtentSparkReporter sparkreporter; // UI of the report
	public ExtentReports extent; // populate common info into the report
	public ExtentTest test; // create test enteries and add status to the test methods

	public void onStart(ITestContext context) {

		sparkreporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/Reports/Myreport_" + System.currentTimeMillis() + ".html");

		sparkreporter.config().setDocumentTitle("Automation Report");
		sparkreporter.config().setReportName("Functional Test Report");
		sparkreporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);

		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "Preprod");
		extent.setSystemInfo("QA Name", "Pooja Kulkarni");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Operating System", "Windows");

	}

	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Case Passed: " + result.getName());

	}

	public void onTestFailure(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Failed: " + result.getName());
		test.log(Status.FAIL, "Test Case Failed: " + result.getThrowable());

	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test is skipped: " + result.getName());

	}

	public void onFinish(ITestContext context) {

		extent.flush();

	}

}