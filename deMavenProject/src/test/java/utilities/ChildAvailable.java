package utilities;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ChildAvailable implements ExpectedCondition<Boolean> {


	private WebElement divMyConnections;

	private By childLocator;



	public ChildAvailable(WebElement divMyConnections, By childLocator) {
		this.divMyConnections = divMyConnections;
		this.childLocator = childLocator;
	}

	@Override
	public Boolean apply(WebDriver driver) {
		Boolean isChildAvailable = divMyConnections.findElement(childLocator).isDisplayed();
		return isChildAvailable;
	}
}
