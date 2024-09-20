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
	}
	
	@Test
	public void testGetRate() {
		
		assertEquals (0.15, SEK.getRate(), 0.0001);
		assertEquals (0.20, DKK.getRate(), 0.0001);
		assertEquals (1.5, EUR.getRate(), 0.0001);
	}
	
	@Test
	public void testSetRate() {
		SEK.setRate(0.19);
		assertEquals(0.19, SEK.getRate(), 0.0001);
		
		EUR.setRate(0.11);
		assertEquals(0.11, EUR.getRate(), 0.0001);
		
		DKK.setRate(0.10);
		assertEquals(0.10, DKK.getRate(), 0.0001);
	}
	
	@Test
	public void testGlobalValue() {
//		fail("No implementado");
		assertEquals(1, this.SEK.valorUniversal(10));
		assertEquals(150, this.EUR.valorUniversal(100));
		assertEquals(20, this.DKK.valorUniversal(100));
	}
	
	@Test
	public void testValueEnEstaDivisa() {
		//fail("No implementado");
		assertEquals (13, this.SEK.valorEnEstaDivisa(10, DKK));
		assertEquals (1, this.EUR.valorEnEstaDivisa(5, SEK), 1);
		assertEquals (60, this.DKK.valorEnEstaDivisa(8, EUR));
	}

}
