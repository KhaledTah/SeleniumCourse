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


public class TestCaseDia87 {

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


		menu = new MenuPage();
		loginpage = new LoginPage();
		welcomepage = new WelcomePage();
		adminpage = new AdminPage();
		newpage = new NewPage();
		connectionpage = new ConnectionPage();
		statspage = new StatsPage();
		statstable = new StatsTable();
		myconnectionsresulttable = new MyConnectionsResultTable();




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
		menu.OpenStatsPage1();
		System.out.println("Row count: " + statstable.getRowCount());
		System.out.println("Value cell with row 1 & col 1 : " + statstable.getText(1, 1).toString());
		System.out.println("Value cell with row 1 & col 2 : " + statstable.getText(1, 2).toString());
		System.out.println("Value cell with row 1 & col 3 : " + statstable.getText(1, 3).toString());
		System.out.println("Value cell with row 2 & col 1 : " + statstable.getText(2, 1).toString());
		System.out.println("Value cell with row 2 & col 1 : " + statstable.getText(2, 2).toString());
		System.out.println("Value cell with row 2 & col 1 : " + statstable.getText(2, 3).toString());

		if(statstable.getText(1, 1).equals("Total connections") && statstable.getText(1, 3).toString().equals("1")) {
			System.out.println("The data in the table is correct");		
		} else 
		{
			System.out.println("The data in the table is not correct");
		}


		menu.OpenConnectionPage1();
		connectionpage.resetAddressBook();
		menu.OpenStatsPage1();
	
		if(statstable.getText(1, 1).equals("Total connections") && statstable.getText(1, 3).toString().equals("N/A")) {
			System.out.println("There are no connections");		
		} else 
		{
			System.out.println("There are still connections");
		}
		connectionpage.populateForTesting();
		menu.OpenConnectionPage1();
		connectionpage.searchConnectionsByFirstName("Peter");
		menu.OpenStatsPage1();
		if(statstable.getText(2, 3).equals("13") && statstable.getText(3, 3).toString().equals("3")) {
			System.out.println("The data in the table is correct");		
		} else 
		{
			System.out.println("The data in the table is not correct");
		}
		connectionpage.searchConnectionsByFirstName("Peter");


		System.out.println("Value cell with row 2 & col 1 : " + myconnectionsresulttable.getText(2, 1).toString());
		
		if(myconnectionsresulttable.getText(2, 1).contains("Peter Parker")) {
			System.out.println("The connections page contains Peter Parker as a record");		
		} else 
		{
			System.out.println("The connections page doesn't contain Peter Parker as a record");
		}
	}



	@AfterEach
	public  void finishTest() {

		System.out.println("Ending the test");


	}
}



