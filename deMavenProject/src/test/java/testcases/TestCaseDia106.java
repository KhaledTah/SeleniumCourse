package testcases;


import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import drivers.DriverManager;
import listeners.CustomListener;
import pageobject.AdminPage;
import pageobject.ConnectionPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.MenuPage;
import pageobject.NewPage;
import pageobject.StatsPage;
import pageobject.StatsTable;
import pageobject.WelcomePage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import utilities.MyConnectionsResultTable;

public class TestCaseDia106 {

	public static MenuPage menu ;
	public static LoginPage loginpage;
	public static WelcomePage welcomepage ;
	public static AdminPage adminpage ;
	public static StatsPage statspage ;
	public static StatsTable statstable ;
	public static MyConnectionsResultTable myconnectionsresulttable;

	public static WebDriverListener listener;
	public static WebDriver eventDriver;
	public static WebDriver normalDriver;
	public static NewPage newpage;
	public static HomePage homepage;

	public static ConnectionPage connectionpage;



	@BeforeAll
	public static void config() {

		System.out.println("Starting the test execution");
		normalDriver = DriverManager.getDriver1();
		listener =  new CustomListener();
		eventDriver = new EventFiringDecorator<WebDriver>(listener).decorate(normalDriver);
		eventDriver.get("https://app-tst-training.azurewebsites.net/");


		menu = new MenuPage();
		loginpage = new LoginPage();
		welcomepage = new WelcomePage();
		adminpage = new AdminPage();
		newpage = new NewPage();
		connectionpage = new ConnectionPage();
		statspage = new StatsPage();
		statstable = new StatsTable();
		myconnectionsresulttable = new MyConnectionsResultTable();




	}


	@BeforeEach
	public  void beforeTest() {
		System.out.println("Preparing the drivers for the test..");

		WebDriver normalDriver = DriverManager.getDriver1();
		WebDriverListener listener =  new CustomListener();
		WebDriver eventDriver = new EventFiringDecorator<WebDriver>(listener).decorate(normalDriver);
		eventDriver.get("https://app-tst-training.azurewebsites.net/");
		menu.logout();


	}



	@Test
	public void recognizeImage() {
		System.out.println("Starting the test 'recognizeImage'");

		loginpage.loginWith1("admin", "superduper");

		menu.OpenHomePage1();
		homepage.clickBtnShowMe(); 

		try {
			WebElement imageElement = homepage.getImage();
			Screenshot shot = new AShot().takeScreenshot(eventDriver, imageElement);

			File screenshotFile = new File(System.getProperty("user.dir") + "\\image_screenshot.jpg");
			System.out.println(System.getProperty("user.dir") + "\\image_screenshot.jpg");

			ImageIO.write(shot.getImage(), "JPG", screenshotFile);

			String imgFile2 = "C:\\Eclipse\\deMavenProject\\bear_high_five.jpg";
			System.out.println("imgFile2 path: " + "C:\\Eclipse\\deMavenProject\\bear_high_five.jpg");

			Image img2 = Toolkit.getDefaultToolkit().getImage(imgFile2);

			PixelGrabber pixGrab1 = new PixelGrabber(shot.getImage(), 0, 0, -1, -1, false);
			PixelGrabber pixGrab2 = new PixelGrabber(img2, 0, 0, -1, -1, false);

			int[] dataArry1 = null;
			int[] dataArry2 = null;

			if (pixGrab1.grabPixels()) {
				int width1 = pixGrab1.getWidth();
				int height1 = pixGrab1.getHeight();
				dataArry1 = new int[width1 * height1];
				dataArry1 = (int[]) pixGrab1.getPixels();
				System.out.println("1: Width = " + width1 + ", Height = " + height1);
			}

			if (pixGrab2.grabPixels()) {
				int width2 = pixGrab2.getWidth();
				int height2 = pixGrab2.getHeight();
				dataArry2 = new int[width2 * height2];
				dataArry2 = (int[]) pixGrab2.getPixels();
				System.out.println("2: Width = " + width2 + ", Height = " + height2);
			}

			boolean imagesMatch = Arrays.equals(dataArry1, dataArry2);
			System.out.println("Images match: " + imagesMatch);
			Assert.assertArrayEquals("The images are not the same", dataArry2, dataArry1) ;


		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testImageComparison() throws IOException, InterruptedException {
		System.out.println("Starting the test 'testImageComparison' ");

		loginpage.loginWith1("admin", "superduper");

		menu.OpenHomePage1();

		homepage.clickBtnShowMe();

		eventDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		eventDriver.manage().window().maximize();

		WebElement imageElement = homepage.getImage();
		Thread.sleep(3000);
		Screenshot shot = new AShot().takeScreenshot(eventDriver, imageElement);
		// Step 5: Save the screenshot as a JPG file;
		File file = new File("C:\\Eclipse\\deMavenProject\\bear_high_five.jpg");
		System.out.println("File path: " + "C:\\Eclipse\\deMavenProject\\bear_high_five.jpg");
		System.out.println(file);
		ImageIO.write(shot.getImage(), "JPG", file);

		BufferedImage expectedImg = ImageIO.read(file);
		BufferedImage actualImg = shot.getImage();
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff dif = imgDiff.makeDiff(expectedImg, actualImg);

		if (dif.hasDiff()) {
			System.out.println("The images are different");
		} else {
			System.out.println("The images are the same");
		}

		Assert.assertFalse("The images are not the same", dif.hasDiff());
	}



	@Test
	public  void testImageDisplayed() {
		System.out.println("Starting the test 'TestImageDisplayed'");

		loginpage.loginWith1("admin", "superduper");

		menu.OpenHomePage1();

		Assert.assertFalse("The image is displayed while it shouldn't be displayed", 	    homepage.getImage().isDisplayed());


		homepage.clickBtnShowMe();

		Assert.assertTrue("The image isn't displayed while it should be displayed", 	    homepage.getImage().isDisplayed());


	}

	@Test
	public  void testImageEnabled() {
		System.out.println("Starting the test 'TestImageDisplayed'");


		loginpage.loginWith1("admin", "superduper");

		menu.OpenHomePage1();



		homepage.clickBtnShowMe();

		Assert.assertTrue("The image isn't enabled while it should be enabled", 	    homepage.getImage().isEnabled());


	}

	@AfterEach
	public  void finishTest() {
		System.out.println("");
		System.out.println("");
		System.out.println("---------- Ending the test ----------");
		System.out.println("");
		System.out.println("");


	}
}



