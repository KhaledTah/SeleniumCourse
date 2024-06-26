package testcases;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.Select;

import drivers.DriverManager;
import listeners.CustomListener;
import pageobject.AdminPage;
import pageobject.LoginPage;
import pageobject.MenuPage;
import pageobject.WelcomePage;


public class TestCaseDia65 {

	public static MenuPage menu ;
	public static LoginPage loginpage;
	public static WelcomePage welcomepage ;
	public static AdminPage adminpage ;
	public static WebDriverListener listener;
	public static WebDriver eventDriver;
	public static WebDriver normalDriver;

	@BeforeAll
	public static void config() {

		System.out.println("Starting the test");

		normalDriver = DriverManager.getDriver1();
		listener =  new CustomListener();
		eventDriver = new EventFiringDecorator<WebDriver>(listener).decorate(normalDriver);
		eventDriver.get("https://app-tst-training.azurewebsites.net/");

		menu = new MenuPage(eventDriver);
		loginpage = new LoginPage();
		welcomepage = new WelcomePage(eventDriver);
		adminpage = new AdminPage(eventDriver);




	}


	@BeforeEach
	public  void beforeTest() {
		WebDriver normalDriver = DriverManager.getDriver1();
		WebDriverListener listener =  new CustomListener();
		WebDriver eventDriver = new EventFiringDecorator<WebDriver>(listener).decorate(normalDriver);
		eventDriver.get("https://app-tst-training.azurewebsites.net/");

		menu.logout1();


	}



	@Test
	public void loginWithCorrectUsernameAndPassword() {
		//	loginpage = new LoginPage(eventDriver);
		loginpage.loginWith1("admin", "superduper");
		Assert.assertTrue(welcomepage.getWelcomeMessage().contains("Welcome"));
		System.out.println("Test 1: " + welcomepage.getWelcomeMessage());
	}

	@Test
	public void loginWithCorrectUsernameAndIncorrectPassword() {

		loginpage.loginWith1("admin", "false");
		Assert.assertFalse(welcomepage.getWelcomeMessage().contains("Welcome"));
		System.out.println("Test 2: " + welcomepage.getWelcomeMessage());
	}


	@Test
	public void loginWithIncorrectUsername() {

		loginpage.loginWith1("false", "superduper");
		Assert.assertFalse(welcomepage.getWelcomeMessage().contains("Welcome1"));
		System.out.println("Test 3: " + welcomepage.getWelcomeMessage());

	}


	@Test
	public void loginWithNoUsernameAndPassword() {
		//	loginpage = new LoginPage(eventDriver);

		loginpage.loginWith1("", "");
		Assert.assertFalse(welcomepage.getWelcomeMessage().contains("Welcome"));
		System.out.println("Test 4: " + welcomepage.getWelcomeMessage());

	}


	@AfterEach
	public  void finishTest() {

		System.out.println("Ending the test");


	}
}



