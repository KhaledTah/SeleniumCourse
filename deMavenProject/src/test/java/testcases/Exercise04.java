/**
 * dit is een java doc voor een package
 */
package testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/** @author ktahriou test test 0 {@summary}*/
public class Exercise04 {
	/** @author ktahriou test test 1*/


	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium training\\drivers\\chromedriver-win64\\chromedriver.exe");

		/** @author ktahriou test test 2*/
		System.out.println("Starting the test");

		WebDriver driver1 = new ChromeDriver();

		driver1.get("https://app-tst-training.azurewebsites.net/");
		WebElement btn = driver1.findElement(By.xpath("//*[@id=\"logout\"]"));
		btn.click();
		WebElement dropdown = driver1.findElement(By.name("language"));
		Select cboOptions = new Select(dropdown);
		cboOptions.selectByVisibleText("French");

		WebElement txtUsername = driver1.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement txtPassword = driver1.findElement(By.xpath("//*[@id=\"password\"]"));
		txtUsername.sendKeys("admin");
		txtPassword.sendKeys("superduper");
		WebElement btnLogIn = driver1.findElements(By.className("content")).get(0);

		btnLogIn.click();

		System.out.println("The test has ended");

	}	

}
