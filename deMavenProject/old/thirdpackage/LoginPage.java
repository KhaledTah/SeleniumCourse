package thirdpackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

	@FindBy(how = How.ID, using = "username")			
	private WebElement txtUsername;
	
	@FindBy(how = How.ID, using = "password")			
	private WebElement txtPassword;
	
	@FindBy(how = How.NAME, using = "language")			
	private WebElement dropdownLanguage;
	
	
	@FindBy(how = How.TAG_NAME, using = "label")			
	private WebElement btnLogin;
	
	@FindBy(how = How.CLASS_NAME, using = "error")			
	private WebElement txtError;
	
	public void loginWith(String username, String password) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
		txtPassword.clear();
		txtPassword.sendKeys(password);	
		btnLogin.click();
		}
	
	public void setLanguageTo(String language) {

		Select dropdownLanguageOptions = new Select(dropdownLanguage);

		dropdownLanguageOptions.selectByVisibleText(language);
	
	}
	
	public String getErrorMessage() {
		return txtError.getText();
	}
	
	public void LoginAsAdmin() {
		txtUsername.clear();
		txtUsername.sendKeys("admin");
		txtPassword.clear();
		txtPassword.sendKeys("superduper");	
		btnLogin.click();
	}
}
