package testcases;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;
/*
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource; */
import org.testng.annotations.*;

import pageobject.AdminPage;
import listeners.CustomListener;
import drivers.DriverManager;
import pageobject.LoginPage;
import pageobject.MenuPage;
import pageobject.WelcomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class TestCase11_1 extends BaseTest{

	private ExtentReports extent;
	private ExtentTest extentTest;

	@BeforeClass
	public void setUp() {

		// The final version of the ExtentReport is implemented in TestCaseDia114

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

	}

	@Test(testName = "Simple test 1")
	public  void SimpleTest1() {
		extent.createTest("Simple Test 1");
		extentTest.log(Status.INFO, "Verifying if 1 equals 1");
		Assert.assertTrue(1 == 1);
		extentTest.log(Status.PASS, "Assertion passed");
	}

	@Test (testName = "Simple test 2")
	public  void SimpleTest2() {
		extentTest = extent.createTest("Simple Test 2");
		extentTest.log(Status.INFO, "Verifying if 1 equals 2");
		AssertJUnit.assertTrue(1==2);
		Reporter.log("Reporter.log: false ", false);
		extentTest.log(Status.FAIL, "Assertion failed");


	}


	@Parameters({
		"username", "password", "isloggedIn"
	})
	@Test(testName = "login With Correct Username & Password")
	public void loginWithCorrectUsernameAndPassword(String username, String password, String isloggedIn) {
		System.out.println("Testing...");

		Boolean loggedin = Boolean.parseBoolean(isloggedIn);

		if (username == null) {
			username = "";
		}

		if (password == null) {
			password = "";
		}

		loginpage.loginWith(username, password);



		if(loggedin) {
			AssertJUnit.assertTrue(welcomepage.isWelcomeMessageShown());
		}
		else {
			AssertJUnit.assertFalse(welcomepage.isWelcomeMessageShown());
		}

		System.out.println("\n ");
		System.out.println("WelcomeMessage: " + welcomepage.getWelcomeMessage().toString());
		System.out.println("\n");

	}


	@Parameters({
		"username2", "password2", "isloggedIn2"
	})
	@Test(dataProvider = "loginData", testName = "login With Username & Password")
	public void loginWithUsernameAndPassword(String username2, String password2, String isloggedIn2) {
		System.out.println("Testing...");

		Boolean loggedin = Boolean.parseBoolean(isloggedIn2);

		if (username2 == null) {
			username2 = "";
		}

		if (password2 == null) {
			password2 = "";
		}

		loginpage.loginWith(username2, password2);



		if(loggedin) {
			AssertJUnit.assertTrue(welcomepage.isWelcomeMessageShown());

		}
		else {
			AssertJUnit.assertFalse(welcomepage.isWelcomeMessageShown());


		}
		System.out.println("\n ");

		System.out.println("WelcomeMessage: " + welcomepage.getWelcomeMessage().toString());
		System.out.println("\n");


	}

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {
		return new Object[][] {
			{"admin", "superduper", "True"},
			{"admin", "false", "False"}
		};
	}

	@AfterTest
	public void teardown() {
		extent.flush();
		driver.quit();
	}

}
