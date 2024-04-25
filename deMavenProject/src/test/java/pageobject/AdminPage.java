package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import drivers.DriverManager;

public class AdminPage {

	@FindBy(id = "new_username")			
	private WebElement txtUsername;

	@FindBy(id = "new_password")			
	private WebElement txtPassword;

	@FindBy(className = "feedback")			
	private WebElement txtError;


	@FindBy(xpath = "//*[@id=\"admin\"]/table[1]/tbody/tr[3]/td[2]/span")			
	private WebElement btnCreate;

	@FindBy(xpath = "//td[@onclick='resetUsers(true)']/label1")
	private WebElement btnResetUsers;

	private WebDriver driver;


	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AdminPage() {

		PageFactory.initElements(DriverManager.getEventDriver(), this);
	}

	public void createNewUserWith(String username, String password) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
		txtPassword.clear();
		txtPassword.sendKeys(password);	
		btnCreate.click();
	}

	public AdminPage createNewUserWith1(String username, String password) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
		txtPassword.clear();
		txtPassword.sendKeys(password);	
		btnCreate.click();
		return this;
	}

	public void resetUsers() {
		btnResetUsers.click();
	}



	public String getErrorMessage() {
		return txtError.getText();
	}


}
