package fourthpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StatsPage 

{

// test github push
	
	private WebDriver driver;


	public StatsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



}