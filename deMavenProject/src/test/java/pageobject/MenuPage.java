package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import drivers.DriverManager;

public class MenuPage {

	@FindBy(xpath = "//*[@id=\"main-nav\"]/ul/li[1]/a")			
	private WebElement btnHome;

	@FindBy(xpath = "//*[@id=\"main-nav\"]/ul/li[2]/a")			
	private WebElement btnConnections;

	@FindBy(id = "crudConnection")			
	private WebElement btnNew;

	@FindBy(xpath = "//*[@id=\"main-nav\"]/ul/li[4]/a")			
	private WebElement btnStats;

	@FindBy(xpath = "//*[@id=\"main-nav\"]/ul/li[5]/a")			
	private WebElement btnAlert;

	@FindBy(linkText = "Admin")			
	private WebElement btnAdmin;

	@FindBy(id = "logout")			
	private WebElement btnLogout;


	private WebDriver driver;

	public MenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public MenuPage() {
		PageFactory.initElements(DriverManager.getEventDriver(), this);
	}

	public MenuPage OpenHomePage1() {


		btnHome.click();
		return this;
	}


	public MenuPage logout1() {


		btnLogout.click();
		return this;
	}

	public MenuPage OpenConnectionPage1() {


		btnConnections.click();
		return this;
	}


	public MenuPage OpenNewPage1() {


		btnNew.click();
		return this;
	}

	public MenuPage OpenStatsPage1() {


		btnStats.click();
		return this;
	}

	public MenuPage OpenAlertPage1() {


		btnAlert.click();
		return this;
	}


	public MenuPage OpenAdminPage1() {


		btnAdmin.click();
		return this;
	}


	public void logout() {


		btnLogout.click();
	}

	public void OpenAdminPage() {


		btnAdmin.click();
	}

	public void OpenConnectionsPage() {


		btnConnections.click();
	}

	public void OpenNewPage() {


		btnNew.click();
	}

	public void OpenStatsPage() {


		btnStats.click();
	}

	public void OpennAlertPage() {


		btnAlert.click();
	}





}
