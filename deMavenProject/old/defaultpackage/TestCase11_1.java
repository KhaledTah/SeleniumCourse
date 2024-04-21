
package defaultpackage;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;
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

import defaultpackage.AdminPage;
import defaultpackage.CustomListener;
import defaultpackage.DriverManager;
import defaultpackage.LoginPage;
import defaultpackage.MenuPage;
import defaultpackage.WelcomePage;



public class TestCase11_1 extends fourthpackage.BaseTest{
	

	

	@Test(testName = "Simple test 1")
	public  void SimpleTest1() {
		AssertJUnit.assertTrue(1==1);
		Reporter.log("Reporter.log: true ", true);

	}
	
	@Test (testName = "Simple test 2")
	public  void SimpleTest2() {
		AssertJUnit.assertTrue(1==2);
		Reporter.log("Reporter.log: false ", false);

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
	}



