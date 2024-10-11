package Calc;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.*;


public class CalculateTest{
	
	Calculate calculadora;
	
	@Before
	public void setUp() throws Exception {
		calculadora = new Calculate();
	}
	
	@Test
	public void TestCamino1(){ //camino test: [1-2-9] -> año bisiesto y mismo mes
		assertTrue(calculadora.cal(6, 2, 6, 28, 2024) == 26);
	}
	
	@Test 
	public void TestCamino2(){ //camino test: [1-3-4-6-7-9] -> año no bisiesto mes de diferencia 1
		assertTrue(calculadora.cal(3, 8, 4, 19, 2023) == 42);	
	}
	
	@Test 
	public void TestCamino3(){ //camino test: [1-3-5-6-7-9] -> año bisiesto mes de diferencia 1
		assertTrue(calculadora.cal(3, 8, 4, 19, 2024) == 42);
	}
	
	@Test
	public void TestCamino4(){ //camino test: [1-3-4-6-7-8-7-9] -> año no bisiesto meses de diferencia 2
		assertTrue(calculadora.cal(4, 3, 6, 6, 2022) == 64);
	}
	
	@Test
	public void TestCamino5(){ //camino test: [1-3-5-6-7-8-7-8-7-9] -> año bisiesto meses de diferencia 3
		assertTrue(calculadora.cal(2, 28, 5, 17, 2024) == 79);
	}
	
	//TEST QUE MATAN MUTAACIONES
	@Test 
	public void TestMt3(){ 
		assertTrue(calculadora.cal(1, 8, 2, 19, 2023) == 42);	
	}
	@Test 
	public void TestMt5(){ 
		assertTrue(calculadora.cal(1, 8, 3, 19, 4000) == 722155);	
	}
	@Test 
	public void TestMt7(){ 
		assertTrue(calculadora.cal(1, 8, 3, 19, 2023) == 70);	
	}
	
}