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


public class TestCaseDia98 {

	public static MenuPage menu ;
	public static LoginPage loginpage;
	public static WelcomePage welcomepage ;
	public static AdminPage adminpage ;
	public static StatsPage statspage ;
	public static StatsTable statstable ;
	public static MyConnectionsResultTable myconnectionsresulttable;

	public static WebDriverListener listener;
	public static WebDriver eventDriver;
	public static WebDriver normalDriver;
	public static NewPage newpage;
	public static ConnectionPage connectionpage;


	@BeforeAll
	public static void config() {

		System.out.println("Starting the test");
		normalDriver = DriverManager.getDriver1();
		listener =  new CustomListener();
		eventDriver = new EventFiringDecorator<WebDriver>(listener).decorate(normalDriver);
		eventDriver.get("https://app-tst-training.azurewebsites.net/");


		menu = new MenuPage(eventDriver);
		loginpage = new LoginPage(eventDriver);

		welcomepage = new WelcomePage(eventDriver);
		adminpage = new AdminPage(eventDriver);
		newpage = new NewPage(eventDriver);
		connectionpage = new ConnectionPage(eventDriver);

		statspage = new StatsPage(eventDriver);
		statstable = new StatsTable(eventDriver);
		myconnectionsresulttable = new MyConnectionsResultTable(eventDriver);




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
	public void verifyTableData() {
		loginpage.loginWith1("admin", "superduper");
		Assert.assertTrue(welcomepage.getWelcomeMessage().contains("Welcome"));
		System.out.println("1: " + welcomepage.getWelcomeMessage());
		Connection c = new Connection("khaled", "Tahriou", "M", "tahrdfdf@hotmail.com", "1111/11.67.89", "02", "AS", "Senior");
		newpage.createNewConnectionWith1(c.getFirstName(), c.getLastName(), c.getGender(), c.getEmail(), c.getTelephone(), c.getCompany(), c.getSsu(), c.getSeniority());
		

		menu.OpenConnectionPage1();

		connectionpage.searchConnectionsByFirstName(c.getFirstName());
		

		System.out.println("Value cell with row 2 & col 1 : " + myconnectionsresulttable.getText(2, 1).toString());
		
		if(myconnectionsresulttable.getText(2, 1).contains(c.getFirstName())) {
			System.out.println("The connections page contains " + c.getFirstName() + " as a record");		
		} else 
		{
			System.out.println("The connections page doesn't contain" + c.getFirstName() + " as a record");
		}
		
	}



	@AfterEach
	public  void finishTest() {

		System.out.println("Ending the test");


	}
}



