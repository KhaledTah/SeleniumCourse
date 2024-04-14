package secondpackage;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class JUnitDemo {
	
	@Test
	public void method() {
		System.out.println("Starting the test");
		}
	
	@Test
	public void method3() {
		System.out.println("Starting the test");
		}

	
	
	@BeforeEach
	public void method2() {
		System.out.println("Starting the test");}

	
	@AfterEach
	public void method4() {
		System.out.println("test");
	}
	
	@AfterEach	
	public static void method5() {
		System.out.println("test");

	}
	
	@BeforeAll
public static void method6() {
		System.out.println("test");

	}
// 6 2 1 (of 3) 5 2 3 (of 1) 5 4
}
