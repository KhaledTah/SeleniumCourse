package secondpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Excercise01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium training\\drivers\\chromedriver-win64\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:/Selenium training/drivers/chromedriver-win64/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\Selenium training\drivers/chromedriver-win64\chromedriver.exe");
		
		

		System.setProperty("webdriver.gecko.driver", "C:\\Selenium training\\drivers\\geckodriver.exe");

		System.out.println("Starting the test");
		
		// control space
		WebDriver driver1 = new ChromeDriver();
	    WebDriver driver2 = new FirefoxDriver();
	    driver2.close();
		
		driver1.get("https://www.ctg.com");
		System.out.println("The url is" + driver1.getCurrentUrl());
		System.out.println("The test has ended!");
	}

}
