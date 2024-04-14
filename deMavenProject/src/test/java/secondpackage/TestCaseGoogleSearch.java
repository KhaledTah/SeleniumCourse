
package secondpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class TestCaseGoogleSearch {
	
	

	@Test
	public void SearchSelenium() {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");
		driver.findElement(By.id("L2AGLb")).click();
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("btnK")).click();
	}
	
	
	@Test
	public void SearchCTG() {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");
		driver.findElement(By.id("L2AGLb")).click();
		driver.findElement(By.name("q")).sendKeys("CTG");
		driver.findElement(By.name("btnK")).click();

	}
	
	
	@BeforeTest
	public  void beforeTest() {

		System.out.println("Starting the test...");



	}

	
	
	
	

	
	@AfterTest
	public  void finishTest() {

System.out.println("Ending the test...");
//DriverManager.getDriver1().close();
//DriverManager.getDriver1().quit();


	}
}


