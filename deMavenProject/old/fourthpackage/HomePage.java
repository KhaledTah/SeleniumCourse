package fourthpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {


	@FindBy(id = "bear")			
	private WebElement image2;
	
	@FindBy(xpath = "//*[@id=\"bear\"]")
	private WebElement bearImage;


	public WebElement getBearImage() {
		return bearImage;
	}

	public void setBearImage(WebElement bearImage) {
		this.bearImage = bearImage;
	}

	public WebElement getImage() {
		return image2;
	}

	public void setImage2(WebElement image2) {
		this.image2 = image2;
	}

	@FindBy(xpath = "//*[@id=\"welcome\"]/p[4]/input")			
	private WebElement btnShowMe;

	

	private WebDriver driver;
	

	
	public void clickBtnShowMe() {
		btnShowMe.click();
	}
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	

}
