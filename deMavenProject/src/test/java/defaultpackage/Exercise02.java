package defaultpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise02 {




public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium training\\drivers\\chromedriver-win64\\chromedriver.exe");
	//System.setProperty("webdriver.chrome.driver", "C:/Selenium training/drivers/chromedriver-win64/chromedriver.exe");
	//System.setProperty("webdriver.gecko.driver", "C:\\Selenium training\\drivers\\geckodriver.exe");
//	    WebDriver driver2 = new FirefoxDriver();

	System.out.println("Starting the test");
	
	// control space
	WebDriver driver1 = new ChromeDriver();

	driver1.get("https://www.google.com");
	String titel1 = driver1.getTitle();
	System.out.println("The title is: " + titel1);
	driver1.get("https://www.bing.com");
//	driver1.navigate()
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
