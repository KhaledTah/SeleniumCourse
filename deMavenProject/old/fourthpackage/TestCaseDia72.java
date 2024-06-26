package fourthpackage;


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


public class TestCaseDia72 {
	
	public static MenuPage menu ;
	public static LoginPage loginpage;
	public static WelcomePage welcomepage ;
	public static AdminPage adminpage ;
	public static WebDriverListener listener;
	public static WebDriver eventDriver;
	public static WebDriver normalDriver;
	public static NewPage connectionpage;
	
	@BeforeAll
	public static void config() {
		
	System.out.println("Starting the test");
	normalDriver = DriverManager.getDriver1();
	 listener =  new CustomListener();
	 eventDriver = new EventFiringDecorator<WebDriver>(listener).decorate(normalDriver);
	eventDriver.get("https://app-tst-training.azurewebsites.net/");


	// menu = new MenuPage();
	 menu = new MenuPage(eventDriver);

	// loginpage = new LoginPage();
		//loginpage = new LoginPage(eventDriver);
		loginpage = new LoginPage();
		
	 welcomepage = new WelcomePage(eventDriver);
	 adminpage = new AdminPage(eventDriver);
	connectionpage = new NewPage(eventDriver);
	//PageFactory.initElements(eventDriver, menu);
	//PageFactory.initElements(eventDriver, loginpage);
	//PageFactory.initElements(eventDriver, welcomepage);
	//PageFactory.initElements(eventDriver, adminpage);
	
	//menu.logout();


	}
	
	
	@BeforeEach
	public  void beforeTest() {
		WebDriver normalDriver = DriverManager.getDriver1();
		WebDriverListener listener =  new CustomListener();
		WebDriver eventDriver = new EventFiringDecorator<WebDriver>(listener).decorate(normalDriver);
		eventDriver.get("https://app-tst-training.azurewebsites.net/");

		menu.logout1();


	}

	/*
	
	@Test
	public void loginWithCorrectUsernameAndPassword() {
	//	loginpage = new LoginPage(eventDriver);
		loginpage.loginWith1("admin", "superduper");
		Assert.assertTrue(welcomepage.getWelcomeMessage().contains("Welcome"));
		System.out.println("1: " + welcomepage.getWelcomeMessage());
		}
	
	@Test
	public void loginWithCorrectUsernameAndIncorrectPassword() {
	//	loginpage = new LoginPage(eventDriver);

		loginpage.loginWith1("admin", "false");
		Assert.assertFalse(welcomepage.getWelcomeMessage().contains("Welcome"));
		System.out.println("2: " + welcomepage.getWelcomeMessage());

		}
	
	
	@Test
	public void loginWithIncorrectUsername() {
	//	loginpage = new LoginPage(eventDriver);

		loginpage.loginWith1("false", "superduper");
		Assert.assertFalse(welcomepage.getWelcomeMessage().contains("Welcome1"));
		System.out.println("3: " + welcomepage.getWelcomeMessage());

		}
	
	
	@Test
	public void loginWithNoUsernameAndPassword() {
	//	loginpage = new LoginPage(eventDriver);

        loginpage.loginWith1("", "");
		Assert.assertFalse(welcomepage.getWelcomeMessage().contains("Welcome"));
		System.out.println("4: " + welcomepage.getWelcomeMessage());

		}
	*/
	
	@Test
	public void addNewConnection() {
	//	loginpage = new LoginPage(eventDriver);
		loginpage.loginWith1("admin", "superduper");
		Assert.assertTrue(welcomepage.getWelcomeMessage().contains("Welcome"));
		System.out.println("1: " + welcomepage.getWelcomeMessage());
	//	adminpage.createNewUserWith1("Khaled", "Test");
		//connectionpage.createNewConnectionWith1("khaled", "Tahriou", "M", "tahrdfdf@hotmail.com", "1111/11.67.89", "02", "AS", "Senior");
		Connection c = new Connection("khaled", "Tahriou", "M", "tahrdfdf@hotmail.com", "1111/11.67.89", "02", "AS", "Senior");
		connectionpage.createNewConnectionWith2(c);

		}
	
	@Test
	public void addNewConnection2() {
	//	loginpage = new LoginPage(eventDriver);
		loginpage.loginWith1("admin", "superduper");
		Assert.assertTrue(welcomepage.getWelcomeMessage().contains("Welcome"));
		System.out.println("1: " + welcomepage.getWelcomeMessage());
	//	adminpage.createNewUserWith1("Khaled", "Test");
		//connectionpage.createNewConnectionWith1("khaled", "Tahriou", "M", "tahrdfdf@hotmail.com", "1111/11.67.89", "02", "AS", "Senior");
		Connection c = new Connection("khaled", "Tahriou", "M", "tahrdfdf@hotmail.com", "1111/11.67.89", "02", "AS", "Senior");
		connectionpage.createNewConnectionWith1(c.getFirstName(), c.getLastName(), "", "", "", "", "", "");

		}

	@AfterEach
	public  void finishTest() {

	System.out.println("Ending the test");


	}
}



