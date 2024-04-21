package listeners;

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
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/*
public class ITestListenerClass implements ITestListener{





@Override
public void onTestFailure(ITestResult result) {
    System.out.println("The name of the testcase failed is :"+ result.getName());					

}





}


 */