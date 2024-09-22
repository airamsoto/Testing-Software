package Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Money.Divisa;
import Money.Money;

public class MoneyTestTemplate {
	Divisa SEK, DKK, EUR;
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
		assertEquals(SEK, SEK100.getDivisa());
		assertEquals(SEK, SEKn100.getDivisa());
		assertEquals(EUR, EUR0.getDivisa());
	}

	@Test
	public void testToString() {
		assertEquals("10000 SEK", SEK100.toString());
		assertEquals("1000 EUR", EUR10.toString());
		assertEquals("20000 SEK", SEK200.toString());
	}

	@Test
	public void testGlobalValue() {
		assertEquals(1500, SEK100.valorUniversal()); // 10000 * 0.15 = 1500
		assertEquals(1500, EUR10.valorUniversal());  // 1000 * 1.5 = 1500
	}

	@Test
	public void testEqualsMoney() {
		assertTrue(SEK100.equals(EUR10)); // Both have the same universal value
		assertFalse(SEK100.equals(SEK200)); // Different universal values
	}

	@Test
	public void testAdd() {
		Money result = SEK100.add(EUR10); // 10000 SEK + 1000 EUR converted to SEK
		assertEquals(20000, result.getCantidad()); // Result should be 20000 SEK
		assertEquals(SEK, result.getDivisa()); // Currency should remain SEK
	}

	@Test
	public void testSub() {
		Money result = SEK200.sub(EUR10); // 20000 SEK - 1000 EUR converted to SEK
		assertEquals(10000, result.getCantidad()); // Result should be 10000 SEK
		assertEquals(SEK, result.getDivisa()); // Currency should remain SEK
	}

	@Test
	public void testIsZero() {
		assertTrue(EUR0.isZero());
		assertFalse(SEK100.isZero());
	}

	@Test
	public void testNegate() {
		assertEquals(-10000, SEK100.negate().getCantidad());
		assertEquals(10000, SEKn100.negate().getCantidad());
	}

	@Test
	public void testCompareTo() {
		assertEquals(0, SEK100.compareTo(EUR10)); // Same universal value
		assertTrue(SEK100.compareTo(SEK200) < 0); // SEK100 is less than SEK200
		assertTrue(SEK200.compareTo(SEK100) > 0); // SEK200 is greater than SEK100
	}
}
