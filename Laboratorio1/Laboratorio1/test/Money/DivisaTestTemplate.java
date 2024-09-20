package Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Money.Divisa;

public class DivisaTestTemplate {
	Divisa SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Divisa("SEK", 0.15);
		DKK = new Divisa("DKK", 0.20);
		EUR = new Divisa("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertEquals ("SEK", SEK.getName());
		assertEquals ("DKK", DKK.getName());
		assertEquals ("EUR", EUR.getName());
		//fail("No implementado");
	}
	
	@Test
	public void testGetRate() {
		
		assertEquals (0.15, SEK.getRate(), 0.0001);
		assertEquals (0.20, DKK.getRate(), 0.0001);
		assertEquals (1.5, EUR.getRate(), 0.0001);
		//fail("No implementado");
	}
	
	@Test
	public void testSetRate() {
		//fail("No implementado");
		SEK.setRate(0.19);
		assertEquals(0.19, SEK.getRate(), 0.0001);
		
		EUR.setRate(0.11);
		assertEquals(0.11, EUR.getRate(), 0.0001);
		
		DKK.setRate(0.19);
		assertEquals(0.19, DKK.getRate(), 0.0001);
	}
	
	@Test
	public void testGlobalValue() {
		fail("No implementado");
	}
	
	@Test
	public void testValueEnEstaDivisa() {
		fail("No implementado");
	}

}
