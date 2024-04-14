package secondpackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {

	@FindBy(how = How.ID, using = "new_username")			
	private WebElement txtUsername;
	
	@FindBy(how = How.ID, using = "new_password")			
	private WebElement txtPassword;
	

	@FindBy(how = How.XPATH, using = "//*[@id=\"admin\"]/table[1]/tbody/tr[3]/td[2]/span")			
	private WebElement btnCreate;

	//@FindBy(how = How.XPATH, using = "//*[@id=\"admin\"]/table[2]/tbody/tr[2]/td[1]/label")
		@FindBy(how = How.XPATH, using = "//td[@onclick='resetUsers(true)']/label1")
	//@FindBy(how = How.XPATH, using = "//*[contains(text(),'reset users')]		")
	private WebElement btnResetUsers;
	
	@FindBy(how = How.CLASS_NAME, using = "feedback")			
	private WebElement txtError;
	
	public void createNewUserWith(String username, String password) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
		txtPassword.clear();
		txtPassword.sendKeys(password);	
		btnCreate.click();
		}
	
	public void resetUsers() {
		btnResetUsers.click();
	}
	
	public String getErrorMessage() {
		return txtError.getText();
	}
	

}
