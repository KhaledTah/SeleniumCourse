package testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercise02b {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium training\\drivers\\chromedriver-win64\\chromedriver.exe");

		System.out.println("Starting the test");

		WebDriver driver1 = new ChromeDriver();

		driver1.get("https://www.google.com");

		String titel1 = driver1.getTitle();
		String url1 = driver1.getCurrentUrl();
		System.out.println("The title is: " + titel1);

		driver1.get("https://www.bing.com");

		String titel2 = driver1.getTitle();
		System.out.println("The title is: " + titel2);

		driver1.navigate().back();

		String titel3 = driver1.getTitle();

		if(titel2.equals(titel3)) {
			System.out.println("The page title is the same");
		}else {
			System.out.println("The page title is not the same");
		}

		driver1.navigate().refresh();
		driver1.quit();
		System.out.println("The test has ended");

	}

}
