package defaultpackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import org.testng.annotations.Test;

public class TestCase_TestNG {

	@AfterTest
	public void displayResult_AfterEach() {
		System.out.println("@AfterEach");
	}
	
	@Test
	public void displayResult_Test() {
		System.out.println("@Test");
	}
	
	@BeforeTest
	public void displayResult_BeforeEach() {
		System.out.println("@BeforeEach");
	}
}
