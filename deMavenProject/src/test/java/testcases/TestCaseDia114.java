package testcases;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestCaseDia114 extends BaseTest {

	private ExtentReports extent;
	private ExtentTest extentTest;

	@BeforeClass
	public void setUp() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Khaled");

		reporter.config(
				ExtentSparkReporterConfig.builder()
				.theme(Theme.DARK)
				.documentTitle("MyReport")
				.build()
				);
		extentTest = extent.createTest("Test Suite");  
	}

	@Test(testName = "Simple test 1")
	public void SimpleTest1() {
		extentTest.log(Status.INFO, "Verifying if 1 equals 1");
		Assert.assertTrue(1 == 1);
		extentTest.log(Status.PASS, "Assertion passed");
	}

	@Test(testName = "Simple test 2")
	public void SimpleTest2() {
		extentTest.log(Status.INFO, "Verifying if 1 equals 2");
		AssertJUnit.assertTrue(1 == 2);
		Reporter.log("Reporter.log: false ", false);
		extentTest.log(Status.FAIL, "Assertion failed");
	}

	@Test(testName = "test 3")
	public void loginWithCorrectUsernameAndPassword() {
		extentTest = extent.createTest("Login with Correct Username and Password");
		menu.logout();

		loginpage.loginWith("admin", "superduper");
		Assert.assertTrue(welcomepage.getWelcomeMessage().contains("Welcome"));
		extentTest.log(Status.PASS, "Login successful");
	}

	@Test(testName = "test 4")
	public void loginWithCorrectUsernameAndIncorrectPassword() {
		extentTest = extent.createTest("Login with Correct Username and Incorrect Password");
		menu.logout();

		loginpage.loginWith("admin", "false");
		Assert.assertFalse(welcomepage.getWelcomeMessage().contains("Welcome"));
		extentTest.log(Status.PASS, "Login failed as expected");
	}

	@Test(testName = "test 5")
	public void loginWithIncorrectUsername() {
		extentTest = extent.createTest("Login with Incorrect Username");
		menu.logout();

		loginpage.loginWith("false", "superduper");
		Assert.assertFalse(welcomepage.getWelcomeMessage().contains("Welcome1"));
		extentTest.log(Status.PASS, "Login failed as expected");
	}

	@Test(testName = "test 6")
	public void loginWithNoUsernameAndPassword() {
		extentTest = extent.createTest("Login with No Username and Password");
		menu.logout();

		loginpage.loginWith("", "");
		Assert.assertFalse(welcomepage.getWelcomeMessage().contains("Welcome"));
		extentTest.log(Status.PASS, "Login failed as expected");
	}

	@AfterClass
	public void tearDown() {
		extent.flush();
	}
}
