package secondpackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WelcomePage {

	
	@FindBy(how = How.ID, using = "welcome")			
	private WebElement welcomeMessage;
	
	public String getWelcomeMessage() {
		
		return welcomeMessage.getText();
	}

	public boolean isWelcomeMessageShown() {
		return welcomeMessage.isDisplayed();

	}
}
