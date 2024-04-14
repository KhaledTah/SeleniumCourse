
package fourthpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class TestCaseGoogleSearch1 {
	
	public class GoogleSearchPage{
		private WebDriver driver;
		
		public GoogleSearchPage(WebDriver driver) {
			this.driver = driver;
			this.driver.get("https://www.google.com");
			this.driver.findElement(By.id("L2AGLb")).click();

		}
		
		public WebElement getTextboxSearch() {
		//	driver.findElement(By.id("L2AGLb")).click();

			return this.driver.findElement(By.name("q"));
		}
		
		public WebElement getButtonSearch() {
			//driver.findElement(By.id("L2AGLb")).click();

			return this.driver.findElement(By.name("btnK"));

		}
	}
	
@Test
public void SearchSelenium() {
	WebDriver driver = new ChromeDriver();
	GoogleSearchPage page = new GoogleSearchPage(driver);
	page.getTextboxSearch().sendKeys("Selenium");
	page.getButtonSearch().click();
	driver.quit();
}
	
	@Test
	public void SearchSelenium0() {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");
		driver.findElement(By.id("L2AGLb")).click();
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("btnK")).click();
		driver.quit();

	}
	
	
	@Test
	public void SearchCTG() {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");
		driver.findElement(By.id("L2AGLb")).click();
		driver.findElement(By.name("q")).sendKeys("CTG");
		driver.findElement(By.name("btnK")).click();
		driver.quit();


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


