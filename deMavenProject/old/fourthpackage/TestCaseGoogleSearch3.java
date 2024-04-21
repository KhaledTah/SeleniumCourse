
package fourthpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;


public class TestCaseGoogleSearch3 {

	public class GoogleSearchPage{

		private WebDriver driver;
		
		
		@FindBy(how = How.NAME, using = "q")
		private WebElement searchBox;
		
		@FindBy(how = How.NAME, using = "btnK")
		private WebElement buttonSearch;
		
	
		
			
		public void searchFor(String text) {
		searchBox.sendKeys(text);
		buttonSearch.click();
		}

		}
		
		
	
		


		
	
	
@Test
public void SearchSelenium() {
	WebDriver driver = new ChromeDriver();
	GoogleSearchPage page = new GoogleSearchPage();
	PageFactory.initElements(driver, page);
driver.get("https://www.google.com");
driver.findElement(By.id("L2AGLb")).click();
	page.searchFor("khaled");
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


