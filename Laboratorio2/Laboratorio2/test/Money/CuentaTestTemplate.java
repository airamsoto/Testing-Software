package Money;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.junit.Assert.*;

public class CuentaTestTemplate {
	
	Divisa SEK, DKK;
	Banco Nordea;
	Banco DanskeBanco;
	Banco SweBanco;
	Cuenta testAccount;
	Money importe;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Divisa("SEK", 0.15);
		SweBanco = new Banco("SweBanco", SEK);
		testAccount = new Cuenta("testAccount", SEK);
		importe = new Money(1000, SEK);
	}
	

	@Test
	public void testGetSaldo() throws SaldoInsuficienteException {
		assertEquals(testAccount.getSaldo().getCantidad(), 0);
	}
	
		
	@Test
	public void testAnadirPagoPeriodico() throws PagoExistenteException{
		testAccount.pagoPeriodico("Primer pago", importe, testAccount);
		assertTrue(testAccount.pagoPeriodicoExiste("Primer pago"));
				
	}
	
	@Test(expected = PagoExistenteException.class)
	public void testAnadirPagoPeriodicoException() throws PagoExistenteException{
		testAccount.pagoPeriodico("Primer pago", importe, testAccount);
		testAccount.pagoPeriodico("Primer pago", importe, testAccount);
	}
	
	@Test
	public void testBorrarPagoPeriodico()  throws PagoNoExistenteException, PagoExistenteException {
		testAccount.pagoPeriodico("Primer pago", importe, testAccount);
		testAccount.cancelarPagoPeriodico("Primer pago");
		assertFalse(testAccount.pagoPeriodicoExiste("Primer pago"));
	}
	
	@Test(expected = PagoNoExistenteException.class)
	public void testBorrarPagoPeriodicoException()  throws PagoNoExistenteException {
		testAccount.cancelarPagoPeriodico("Primer pago");
	}
	
	@Test
	public void testPagoPeriodicoExiste() throws PagoNoExistenteException,PagoExistenteException{
		assertFalse(testAccount.pagoPeriodicoExiste("Primer pago"));
	}
	
	@Test
	public void testdeposito() {

		testAccount.deposito(new Money(500, SEK));
		assertEquals(testAccount.getSaldo().getCantidad(), 500);

	}

	@Test
	public void testReintegro() throws SaldoInsuficienteException {
		testAccount.deposito(new Money(500, SEK));
		testAccount.reintegro(new Money(200, SEK));
		assertEquals(testAccount.getSaldo().getCantidad(), 300);
	}
}

