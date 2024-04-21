package drivers;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import defaultpackage.CustomListener;
//import defaultpackage.DriverManager;

public class DriverManager {

	private static WebDriver driver1;
	public static WebDriver normalDriver1;
	public static WebDriverListener listener1;
	private static WebDriver eventDriver1;
	

	private static WebDriver driver2;

	public static WebDriver getDriver1 () {
		if(driver1 == null) {

			setChromeDriver();
		}
		return driver1;

	}
	
	public static WebDriver getDriver2 () {
		if(driver2 == null) {

			setChromeDriver();
		}
		return driver2 ;
	}

	public static void setChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium training\\drivers\\chromedriver-win64\\chromedriver.exe");
		driver1  = (WebDriver) new ChromeDriver();
	}
	
	public static void setEventDriver() {
		normalDriver1 = DriverManager.getDriver1();
		listener1 = new CustomListener();
	 eventDriver1 = new EventFiringDecorator(listener1).decorate(normalDriver1);
	 eventDriver1 = 	 DriverManager.getDriver1();
	}
	
	public static void setFireFoxDriver() {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium training\\drivers\\geckodriver.exe");
		driver2  = (WebDriver) new FirefoxDriver();
	}
	
	public static void quitDriver1(){
		if(!(driver1 == null)){
			driver1.quit();
		}
		driver1 = null;
		
	}
	
	public static void quitDriver2(){
		if(!(driver2 == null)){
			driver2.quit();
		}
		driver2 = null;
		
	}

	public static SearchContext getEventDriver() {
		if(eventDriver1 == null) {

			setEventDriver();
		}
		return eventDriver1;

	}

}

