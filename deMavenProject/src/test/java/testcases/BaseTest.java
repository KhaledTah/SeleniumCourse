package testcases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pageobject.AdminPage;
import listeners.CustomListener;
import drivers.DriverManager;
import pageobject.LoginPage;
import pageobject.MenuPage;
import pageobject.WelcomePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	public static WebDriver driver;
	public static WebDriver normalDriver;
	public static WebDriverListener listener;
	public static WebDriver eventDriver ;

	public static MenuPage menu ;
	public static LoginPage loginpage;
	public static WelcomePage welcomepage ;
	public static AdminPage adminpage ;

	@BeforeTest
	public  void setup() {

		System.out.println("@BeforeTest");
		normalDriver = DriverManager.getDriver1();
		listener = new CustomListener();
		eventDriver = new EventFiringDecorator(listener).decorate(normalDriver);
		eventDriver = 	 DriverManager.getDriver1();

		eventDriver.manage().window().maximize();
		eventDriver.get("https://app-tst-training.azurewebsites.net/");

		menu = new MenuPage();
		loginpage = new LoginPage();
		welcomepage = new WelcomePage();
		adminpage = new AdminPage();

		PageFactory.initElements(eventDriver, menu);
		PageFactory.initElements(eventDriver, loginpage);
		PageFactory.initElements(eventDriver, welcomepage);
		PageFactory.initElements(eventDriver, adminpage);

		menu.logout();

	}

	@AfterTest
	public  void finishTest() {

		System.out.println("@AfterTest");
		//DriverManager.getDriver1().quit();

	}

	@AfterSuite
	public  void finishTestSuite() {
		System.out.println("@AfterSuite");

		DriverManager.getDriver1().quit();

	}

	public void captureScreenshot(String fileName) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) DriverManager.getDriver1();
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/" + fileName);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
	}
}
