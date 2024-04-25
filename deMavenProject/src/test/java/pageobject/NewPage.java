package pageobject;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverManager;
import utils.Connection;


public class NewPage 

{
	@FindBy(id = "crudConnection")
	private WebElement menuConnection;

	@FindBy(id = "firstName")			
	private WebElement txtFirstName;

	@FindBy(id = "lastName")			
	private WebElement txtLastName;

	@FindBy(id = "sex")			
	private WebElement lstSex;

	@FindBy(id = "email")			
	private WebElement txtEmail;

	@FindBy(id = "telephone")			
	private WebElement txtTelephone;


	@FindBy(id = "company")			
	private WebElement txtCompany;

	@FindBy(id = "SSU")			
	private WebElement lstSSU;

	@FindBy(id = "seniority")			
	private WebElement lstSeniority;

	@FindBy(id = "interests")			
	private WebElement txtAddInfo;

	@FindBy(xpath = "//*[@id=\"add\"]/span/label")
	private WebElement btnAdd;



	private WebDriver driver;
	
	public NewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public NewPage() {
		PageFactory.initElements(DriverManager.getEventDriver(), this);
	}

	
	public void createNewConnectionWith(String firstName, String lastName, String sex, String email, String telephone, String company, String SSU, String seniority) {

		menuConnection.click();

		txtFirstName.clear();
		txtFirstName.sendKeys(firstName);

		txtLastName.clear();
		txtLastName.sendKeys(lastName);	

		Select cboOptions = new Select(lstSex);
		cboOptions.selectByVisibleText(sex);

		txtEmail.clear();
		txtEmail.sendKeys(email);

		txtTelephone.clear();
		txtTelephone.click();
		txtTelephone.sendKeys(telephone.toString());

		txtCompany.clear();
		txtCompany.sendKeys(company);

		Select cboOptions2 = new Select(lstSSU);
		cboOptions2.selectByVisibleText(SSU);

		Select cboOptions3 = new Select(lstSeniority);
		cboOptions3.selectByVisibleText(seniority);

		btnAdd.click();

	}


	public NewPage createNewConnectionWith1(String firstName, String lastName, String sex, String email, String telephone, String company, String SSU, String seniority) {
		menuConnection.click();

		txtFirstName.clear();
		txtFirstName.sendKeys(firstName);

		txtLastName.clear();
		txtLastName.sendKeys(lastName);	

		Select cboOptions = new Select(lstSex);
		cboOptions.selectByVisibleText(sex);

		txtEmail.clear();
		txtEmail.sendKeys(email);

		txtTelephone.clear();
		txtTelephone.click();
		txtTelephone.sendKeys(telephone.toString());

		txtCompany.clear();
		txtCompany.sendKeys(company);

		Select cboOptions2 = new Select(lstSSU);
		cboOptions2.selectByVisibleText(SSU);

		Select cboOptions3 = new Select(lstSeniority);
		cboOptions3.selectByVisibleText(seniority);

		btnAdd.click();

		return this;
	}

	public NewPage createNewConnectionWithConnection(Connection c) {
		menuConnection.click();

		txtFirstName.clear();
		txtFirstName.sendKeys(c.getFirstName());

		txtLastName.clear();
		txtLastName.sendKeys(c.getLastName());	

		Select cboOptions = new Select(lstSex);
		cboOptions.selectByVisibleText(c.getGender());

		txtEmail.clear();
		txtEmail.sendKeys(c.getEmail());

		txtTelephone.clear();
		txtTelephone.click();
		txtTelephone.sendKeys(c.getTelephone().toString());

		txtCompany.clear();
		txtCompany.sendKeys(c.getCompany());

		Select cboOptions2 = new Select(lstSSU);
		cboOptions2.selectByVisibleText(c.getSsu());

		Select cboOptions3 = new Select(lstSeniority);
		cboOptions3.selectByVisibleText(c.getSeniority());

		btnAdd.click();

		return this;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}


	public void setTxtFirstName(WebElement txtFirstName) {
		this.txtFirstName = txtFirstName;
	}


	public WebElement getTxtLastName() {
		return txtLastName;
	}


	public void setTxtLastName(WebElement txtLastName) {
		this.txtLastName = txtLastName;
	}


	public WebElement getLstSex() {
		return lstSex;
	}


	public void setLstSex(WebElement lstSex) {
		this.lstSex = lstSex;
	}


	public WebElement getTxtEmail() {
		return txtEmail;
	}


	public void setTxtEmail(WebElement txtEmail) {
		this.txtEmail = txtEmail;
	}


	public WebElement getTxtTelephone() {
		return txtTelephone;
	}


	public void setTxtTelephone(WebElement txtTelephone) {
		this.txtTelephone = txtTelephone;
	}


	public WebElement getTxtCompany() {
		return txtCompany;
	}


	public void setTxtCompany(WebElement txtCompany) {
		this.txtCompany = txtCompany;
	}


	public WebElement getLstSSU() {
		return lstSSU;
	}


	public void setLstSSU(WebElement lstSSU) {
		this.lstSSU = lstSSU;
	}


	public WebElement getLstSeniority() {
		return lstSeniority;
	}


	public void setLstSeniority(WebElement lstSeniority) {
		this.lstSeniority = lstSeniority;
	}


	public WebElement getTxtAddInfo() {
		return txtAddInfo;
	}


	public void setTxtAddInfo(WebElement txtAddInfo) {
		this.txtAddInfo = txtAddInfo;
	}






}