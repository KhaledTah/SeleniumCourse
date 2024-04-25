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


public class TestCase10_01 {

	public static MenuPage menu ;
	public static LoginPage loginpage;
	public static WelcomePage welcomepage ;
	public static AdminPage adminpage ;

	@BeforeAll
	public static void config() {

		System.out.println("Starting the test");
		WebDriver normalDriver = DriverManager.getDriver1();
		WebDriverListener listener =  new CustomListener();
		WebDriver eventDriver = new EventFiringDecorator<WebDriver>(listener).decorate(normalDriver);
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


	@BeforeEach
	public  void beforeTest() {

		menu.logout();
	}



	@Test
	public void loginWithCorrectUsernameAndPassword() {
		loginpage.loginWith("admin", "superduper");
		Assert.assertTrue(welcomepage.getWelcomeMessage().contains("Welcome"));
		System.out.println("1: " + welcomepage.getWelcomeMessage());
	}

	@Test
	public void loginWithCorrectUsernameAndIncorrectPassword() {
		loginpage.loginWith("admin", "false");
		Assert.assertFalse(welcomepage.getWelcomeMessage().contains("Welcome"));
		System.out.println("2: " + welcomepage.getWelcomeMessage());

	}


	@Test
	public void loginWithIncorrectUsername() {
		loginpage.loginWith("false", "superduper");
		Assert.assertFalse(welcomepage.getWelcomeMessage().contains("Welcome1"));
		System.out.println("3: " + welcomepage.getWelcomeMessage());

	}

	@Test
	public void loginWithNoUsernameAndPassword() {
		loginpage.loginWith("", "");
		Assert.assertFalse(welcomepage.getWelcomeMessage().contains("Welcome"));
		System.out.println("4: " + welcomepage.getWelcomeMessage());

	}

	@AfterEach
	public  void finishTest() {

		System.out.println("Ending the test");


	}
}



