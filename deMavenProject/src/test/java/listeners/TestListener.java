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
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.model.Test;

import testcases.BaseTest;


public class TestListener extends BaseTest implements ITestListener{


	@Override
	public void onTestStart(ITestResult result) {
		//  System.out.println(result.getTestContext().getName() +" test case started");					
		//   ITestNGMethod method = result.getMethod();
		//System.out.println(method.getMethodName()+ " started");
		String testName = result.getName();
		if (testName == null) {
			testName = result.getMethod().getMethodName();
		}
		System.out.println("");
		System.out.println("Test '" + testName + "' started.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//  System.out.println("The name of the testcase passed is :"+ result.getTestName());		
		System.out.println("The name of the testcase PASSED is :"+ result.getTestContext().getName() + " - " + result.getMethod().getMethodName()) ;	
		System.out.println("");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the testcase FAILED is :"+ result.getTestContext().getName() + " - " + result.getMethod().getMethodName());
		// captureScreenshot(result.getName());
		captureScreenshot(result.getMethod().getMethodName()+".jpg");
		//   captureScreenshot(result.getName() +".jpg");
		System.out.println("");


	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage: " +result.getTestContext().getName() + " - " + result.getMethod().getMethodName());
		System.out.println("");


	}



	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase SKIPPED is :"+ result.getTestContext().getName() + " - " + result.getMethod().getMethodName());	
		System.out.println("");


	}


	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart method started (" + context.getName() + ")." );

	}


	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish method started (" + context.getName() + ").");
		System.out.println("");
	}


}


