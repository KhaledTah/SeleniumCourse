package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.DriverManager;
import utils.Table;


public class StatsTable implements Table{

	@FindBy(xpath = "//*[@id=\"statsConnections\"]")	
	private WebElement tabel;

	private WebDriver driver;

	public StatsTable(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public StatsTable() {
		PageFactory.initElements(DriverManager.getEventDriver(), this);
	}


	public void printTableData() {
		List <WebElement> rows = tabel.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			List <WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				System.out.print(cell.getText() + " | ");
			}
			System.out.println();
		}
	}

	@Override
	public int getRowCount() {
		List <WebElement> rows = this.tabel.findElements(By.tagName("tr"));
		return rows.size();
	}


	@Override
	public String getText(int row, int col) {
		try {

			List <WebElement> rows = tabel.findElements(By.tagName("tr"));
			WebElement specificRow = rows.get(row-1);
			List <WebElement> cells = specificRow.findElements(By.tagName("td"));
			WebElement specificCell = cells.get(col-1);


			return specificCell.getText();
		} catch(IndexOutOfBoundsException e){
			System.out.print("");
			return "";

		}
	}
}
