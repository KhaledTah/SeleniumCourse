package defaultpackage;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class TestCase07_01 {

	public static void main(String[] args) {

		System.out.println("Starting the test");


		WebDriver normalDriver = DriverManager.getDriver1();
		WebDriverListener listener = new CustomListener();
	//	WebDriver eventDriver = new EventFiringDecorator<WebDriver>(listener).decorate(normalDriver);
		WebDriver eventDriver = new EventFiringDecorator(listener).decorate(normalDriver);

		eventDriver.get("https://app-tst-training.azurewebsites.net/");


		MenuPage menu = new MenuPage();
		LoginPage loginpage = new LoginPage();
		WelcomePage welcomepage = new WelcomePage();
		AdminPage adminpage = new AdminPage();


		//	WebElement btn = driver1.findElement(By.xpath("//*[@id=\"logout\"]"));

		PageFactory.initElements(eventDriver, menu);
		PageFactory.initElements(eventDriver, loginpage);
		PageFactory.initElements(eventDriver, welcomepage);
		PageFactory.initElements(eventDriver, adminpage);





		menu.logout();

		loginpage.loginWith("admin", "superduper");		

		String orginalWindow = eventDriver.getWindowHandle();

		menu.OpenAdminPage();

		Set<String> allWindows = eventDriver.getWindowHandles();
		String newWindow = null;
		for(String window: allWindows) {
			if(!orginalWindow.equals(window)){

				newWindow = window;
				break;
			}

		}

		eventDriver.switchTo().window(newWindow);

		adminpage.resetUsers();

		Alert popup = eventDriver.switchTo().alert();



		String popupText = popup.getText();
		if(popupText.equals("Users reset.")) {
			System.out.println("The popup text is correct");		
		} else 
		{
			System.out.println("The popup text is not correct");
		}

		popup.accept();

		adminpage.createNewUserWith("Khaled", "Test");
		//DriverManager.getDriver1().close();
		eventDriver.close();

		eventDriver.switchTo().window(orginalWindow);
		eventDriver.switchTo().window(orginalWindow);


		menu.logout();
		loginpage.loginWith("Khaled", "Test");


		System.out.println("Ending the test");



	}

}