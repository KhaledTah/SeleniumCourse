package fourthpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

	@FindBy(id  = "username")			
	private WebElement txtUsername;
	
	@FindBy(id = "password")			
	private WebElement txtPassword;
	
	@FindBy(name = "language")			
	private WebElement dropdownLanguage;
	
	
	@FindBy(tagName = "label")			
	private WebElement btnLogin;
	
	@FindBy(className = "error")			
	private WebElement txtError;

	private WebDriver driver;
	
	/*
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	*/
	
	
	public LoginPage() {
		PageFactory.initElements(DriverManager.getEventDriver(), this);
	}
	
	public void loginWith(String username, String password) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
		txtPassword.clear();
		txtPassword.sendKeys(password);	
		btnLogin.click();
		}
	
	public LoginPage loginWith1(String username, String password) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
		txtPassword.clear();
		txtPassword.sendKeys(password);	
		btnLogin.click();
		return this;

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
