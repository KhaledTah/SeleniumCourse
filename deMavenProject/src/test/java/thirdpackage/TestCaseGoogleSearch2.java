
package thirdpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class TestCaseGoogleSearch2 {
	
	public class GoogleSearchPage{
		private WebDriver driver;
		
		public GoogleSearchPage(WebDriver driver) {
			this.driver = driver;
		

		}
		
		public void searchFor(String text) {
			this.driver.get("https://www.google.com");
			this.driver.findElement(By.id("L2AGLb")).click();
	 this.driver.findElement(By.name("q")).sendKeys(text);
		this.driver.findElement(By.name("btnK")).click();
		}
		


		}
	
	
@Test
public void SearchSelenium() {
	WebDriver driver = new ChromeDriver();
	GoogleSearchPage page = new GoogleSearchPage(driver);
	page.searchFor("khaled");
//driver.quit();
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


