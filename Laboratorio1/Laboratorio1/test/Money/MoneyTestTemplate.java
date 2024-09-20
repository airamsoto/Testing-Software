package Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Money.Divisa;
import Money.Money;

public class MoneyTestTemplate {
	Divisa SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		
		SEK = new Divisa("SEK", 0.15);
		DKK = new Divisa("DKK", 0.20);
		EUR = new Divisa("EUR", 1.5);
		
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetCantidad() {
		assertEquals(10000, SEK100.getCantidad());
		assertEquals(1000, EUR10.getCantidad());
		assertEquals(20000, SEK200.getCantidad());
		assertEquals(-10000, SEKn100.getCantidad());
		
	}

	@Test
	public void testGetDivisa() {
		assertEquals (SEK, SEK100.getDivisa());
		assertEquals (SEK, SEKn100.getDivisa());
		assertEquals (EUR, EUR0.getDivisa());
	}
	  //Devuelve un String "cantidad nombre de divisa", e.g. "10.5 SEK".
	  //Los numeros decimales se representan con enteros, e.g "10.5 SEK" se almacena como 1050
	@Test
	public void testToString() {
		assertEquals("10000 SEK", SEK100.toString());
	}

	@Test
	public void testGlobalValue() {
		//fail("No implementado");
	}

	@Test
	public void testEqualsMoney() {
		//fail("No implementado");
	}

	@Test
	public void testAdd() {
		//fail("No implementado");
	}

	@Test
	public void testSub() {
		//fail("No implementado");
	}

	@Test
	public void testIsZero() {
		//fail("No implementado");
		assertTrue(EUR0.isZero());
		assertFalse(SEK100.isZero());
	}

	@Test
	public void testNegate() {
		//fail("No implementado");
		assertEquals(-SEK100.getCantidad(), SEK100.negate().getCantidad());
	}

	@Test
	public void testCompareTo() {
		assertEquals(0, SEK100.negate().compareTo(SEKn100));		
	}
}
