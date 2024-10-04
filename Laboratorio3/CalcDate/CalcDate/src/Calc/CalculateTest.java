package Calc;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.*;
import org.junit.rules.*;
import Calc.Calculate;
public class CalculateTest {
	int month1;
	int month2;
	int days1;
	int days2;
	int year;
	
	
	@Test
	public void ct129 () throws Exception {
		//mes 1 == mes 2 , creamos un objeto y ejecutamos el metodo
		/*
		 * mes1 = mes2 = 4
		 * 
		 * dia 1 = 20
		 * dia 2 = 29
		 * 
		 * year = 2025
		 *
		 * 
		 * 
		 */
		this.month1 = 4; this.month2 = 4; this.days1 = 20; this.days2 = 29;
		this.year = 2025;
		assertTrue(cal(month1, days1, month2, days2, year) == 9);
	}
	
	
	@Test
	public void ct134679 () throws Exception {
		/*
		 * mes1 = 4 y mes2 = 5
		 * 
		 * dia 1 = 20
		 * dia 2 = 29
		 * 
		 * year = 2025
		 *
		 * 
		 * 
		 */
		this.month1 = 4; this.month2 = 5; this.days1 = 20; this.days2 = 29;
		this.year = 2025;
		assertTrue(cal(month1, days1, month2, days2, year)== 0);
	}
	
	
	
	
	@Test
	public void ct13467879 () throws Exception {
		//una vuelta al bucle, dos de diferencia
		/*
		 * month1 = marzo month2 = mayo
		 * year 2025
		 *
		 * 
		 * 
		 */
		this.month1 = 3; this.month2 = 5; this.days1 = 20; this.days2 = 29;
		this.year = 2025;
		cal(month1, days1, month2, days2, year);
		
	}
	@Test
	public void ct1356787879 () throws Exception {
		//dos vueltas al bucle y leap year 2026 tres meses de diferencia
		// creamos un objeto y ejecutamos el metodo
		/*
		 * month1 = marzo month2 = junio
		 * year 2026
		 * 
		 */
		this.month1 = 3; this.month2 = 6; this.days1 = 20; this.days2 = 29;
		this.year = 2026;
		cal(month1, days1, month2, days2, year);
		
	}
	@Test
	public void ct135679 () throws Exception {
		//sin vueltas y leap year 2026
		//creamos un objeto y ejecutamos el metodo
	
		/*
		 * month 1 = marzo month 2 = abril
		 * year = 2026
		 *
		 *
		 * 
		 * 
		 */
		this.month1 = 3; this.month2 = 4; this.days1 = 20; this.days2 = 29;
		this.year = 2026;
		cal(month1, days1, month2, days2, year);
		
	}

}
