package secondpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise04b {


	public static void main(String[] args) {
	

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium training\\drivers\\chromedriver-win64\\chromedriver.exe");

		System.out.println("Starting the test");

	
		WebDriver driver1 = new ChromeDriver();

		driver1.get("https://app-tst-training.azurewebsites.net/");
		WebElement btn = driver1.findElement(By.id("logout"));
		btn.click();
		WebElement dropdown = driver1.findElement(By.name("language"));
		Select cboOptions = new Select(dropdown);
		cboOptions.selectByVisibleText("French");

		WebElement txtUsername = driver1.findElement(By.id("username"));
		WebElement txtPassword = driver1.findElement(By.id("password"));
		txtUsername.sendKeys("admin");
		txtPassword.sendKeys("superduper");
		WebElement btnLogIn = driver1.findElements(By.tagName("label")).get(0);
		btnLogIn.click();

		System.out.println("The test has ended");

	}

}

