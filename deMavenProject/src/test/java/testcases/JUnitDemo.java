package testcases;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class JUnitDemo {

	@Test
	public void method() {
		System.out.println("Test | Method()");
	}

	@Test
	public void method3() {
		System.out.println("Tes | Method3()");
	}


	@BeforeEach
	public void method2() {
		System.out.println("BeforeEach | method2()");}


	@AfterEach
	public void method4() {
		System.out.println("AfterEach | method4() ");
	}

	@AfterEach	
	public static void method5() {
		System.out.println("AfterEach | method5()");

	}

	@BeforeAll
	public static void method6() {
		System.out.println("BeforeAll | method6()");

	}
	// 6 2 1 (of 3) 5 2 3 (of 1) 5 4
}
