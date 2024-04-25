package testcases;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverManager;
import listeners.CustomListener;
import pageobject.AdminPage;
import pageobject.LoginPage;
import pageobject.MenuPage;
import pageobject.NewPage;
import pageobject.StatsPage;
import pageobject.StatsTable;
import pageobject.WelcomePage;
import utils.Connection;


public class TestCaseDia82 {

	public static MenuPage menu ;
	public static LoginPage loginpage;
	public static WelcomePage welcomepage ;
	public static AdminPage adminpage ;
	public static StatsPage statspage ;
	public static StatsTable statstable ;

	public static WebDriverListener listener;
	public static WebDriver eventDriver;
	public static WebDriver normalDriver;
	public static NewPage newpage;

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
		statspage = new StatsPage();
		statstable = new StatsTable();
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

		statstable.printTableData();

		System.out.println("Value cell with row 1 & col 1 : " + statstable.getText(1, 1).toString());
		System.out.println("Value cell with row 1 & col 2 : " + statstable.getText(1, 2).toString());
		System.out.println("Value cell with row 1 & col 3 : " + statstable.getText(1, 3).toString());
		System.out.println("Value cell with row 1 & col 1 : " + statstable.getText(2, 1).toString());
		System.out.println("Value cell with row 2 & col 1 : " + statstable.getText(2, 2).toString());
		System.out.println("Value cell with row 3 & col 1 : " + statstable.getText(2, 3).toString());

		if(statstable.getText(1, 1).equals("Total connections") && statstable.getText(1, 3).toString().equals("1")) {
			System.out.println("The data in the table is correct");		
		} else 
		{
			System.out.println("The data in the table is not correct");
		}

		newpage.createNewConnectionWith1("Samira", c.getLastName(), "F", c.getEmail(), c.getTelephone(), c.getCompany(), c.getSsu(), c.getSeniority());
		menu.OpenStatsPage1();
		statstable.printTableData();

		if(statstable.getText(1, 1).equals("Total connections") && statstable.getText(1, 3).toString().equals("2")) {
			System.out.println("The data in the table is correct");		
		} else 
		{
			System.out.println("The data in the table is not correct");
		}

	}

	@AfterEach
	public  void finishTest() {

		System.out.println("Ending the test");
	}
}



