
package testcases;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import drivers.DriverManager;



public class TestCaseGoogleSearch1 extends BaseTest {

	public class GoogleSearchPage{
		private WebDriver driver;
		private WebDriverWait wait ;

		public GoogleSearchPage(WebDriver driver) {
			this.driver = driver;
			this.driver.get("https://www.google.com");
			this.driver.manage().window().maximize();

			this.driver.findElement(By.id("L2AGLb")).click();
		}

		public WebElement getTextboxSearch() {

			return this.driver.findElement(By.name("q"));
		}

		public WebElement getButtonSearch() {


			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
			WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
			return button;
		}
	}

	@Test  (testName = "Search Selenium")
	public void SearchSelenium() {
		WebDriver driver = new ChromeDriver();
		GoogleSearchPage page = new GoogleSearchPage(driver);
		page.getTextboxSearch().sendKeys("Selenium");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK"))).click();
		driver.quit();
	}

	@Test  (testName = "Search Selenium Test 2")
	public void SearchSelenium0() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com");

		driver.findElement(By.id("L2AGLb")).click();
		driver.findElement(By.name("q")).sendKeys("Selenium");
		//	driver.findElement(By.name("btnK")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK"))).click();
		driver.quit();
	}


	@Test  (testName = "Search CTG")
	public void SearchCTG() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com");

		driver.findElement(By.id("L2AGLb")).click();
		driver.findElement(By.name("q")).sendKeys("CTG");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK"))).click();
		driver.quit();

	}


}


