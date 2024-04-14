package thirdpackage;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
//import java.util.NoSuchElementException;
//import java.util.logging.FileHandler;
//import org.openqa.selenium.io.FileHandler;
//import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.WebDriverListener;

public class CustomListener implements WebDriverListener{


	/*
	 * public void afterFindElement(WebDriver driver, By locator, WebElement result)
	{

	System.out.println("(afterFindElement) Element found:" + locator.toString());
	}
	*/
	
	public void beforeFindElement(WebDriver driver,
			 By locator)
	{

		System.out.println("(beforeFindElement) Element found:" + locator.toString());
	}
	
	
	
public void beforeClick(WebElement element) {
	System.out.println("(beforeClick) Element found:" + element.toString());

}
/*
public void afterClick(WebElement element) {
	System.out.println("(afterClick) Element found:" + element.toString());

	
}
*/


public  void onError(Object target,
		 Method method,
		 Object[] args, InvocationTargetException e) {
	if(e.getTargetException() instanceof NoSuchElementException)
	{
		System.out.println("Error: noSuchElementException: " + e.toString());
    File f= ((TakesScreenshot)DriverManager.getDriver1()).getScreenshotAs(OutputType.FILE);
    try {
		FileHandler.copy(f, new File("c:\\temp\\screenshot.png"));
		System.out.println("Error: noSuchElementException --> See screenshot");

	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}
	
	
}


}


