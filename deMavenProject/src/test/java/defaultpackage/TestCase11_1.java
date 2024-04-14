
package defaultpackage;
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

import defaultpackage.AdminPage;
import defaultpackage.CustomListener;
import defaultpackage.DriverManager;
import defaultpackage.LoginPage;
import defaultpackage.MenuPage;
import defaultpackage.WelcomePage;

public class TestCase11_1 {
	
	public static MenuPage menu ;
	public static LoginPage loginpage;
	public static WelcomePage welcomepage ;
	public static AdminPage adminpage ;
	
	@BeforeSuite
	public static void config() {
		
	System.out.println("Preparing the test...");
	WebDriver normalDriver = DriverManager.getDriver1();
	WebDriverListener listener = new CustomListener();
	//WebDriver eventDriver = new EventFiringDecorator<WebDriver>(listener).decorate(normalDriver);
	WebDriver eventDriver = new EventFiringDecorator(listener).decorate(normalDriver);

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
	
	@Test
	public  void Test() {
		System.out.println("\n ");
		System.out.println("<TEST>");
		System.out.println("\n ");

	}
	
	
	@BeforeTest
	public  void beforeTest() {

		System.out.println("Starting the test...");

		menu.logout();


	}

	
	
	@Parameters({
		"username", "password", "isloggedIn"
	})
	@Test
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
			Assert.assertTrue(welcomepage.isWelcomeMessageShown());

		}
		else {
			Assert.assertFalse(welcomepage.isWelcomeMessageShown());


		}
		System.out.println("\n ");

		System.out.println("WelcomeMessage: " + welcomepage.getWelcomeMessage());
		System.out.println("\n");

		}
	

	
	@AfterTest
	public  void finishTest() {

System.out.println("Ending the test...");
//DriverManager.getDriver1().close();
//DriverManager.getDriver1().quit();


	}
}


