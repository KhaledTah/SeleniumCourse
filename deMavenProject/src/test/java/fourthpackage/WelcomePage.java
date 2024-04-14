package fourthpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	
	@FindBy(id = "welcome")			
	private WebElement welcomeMessage;
	
	private WebDriver driver;
	
	public WelcomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public String getWelcomeMessage() {
		
		return welcomeMessage.getText();
	}

	public boolean isWelcomeMessageShown() {
		return welcomeMessage.isDisplayed();

	}
}
