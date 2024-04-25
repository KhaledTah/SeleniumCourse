package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import drivers.DriverManager;

public class StatsPage 

{

	private WebDriver driver;


	public StatsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public StatsPage() {
		PageFactory.initElements(DriverManager.getEventDriver(), this);

	}

}