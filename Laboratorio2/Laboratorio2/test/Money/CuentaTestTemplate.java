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
		
	}
	

	@Test
	public void testGetSaldo() {
		fail("No implementado");
	}
	
		
	@Test
	public void testAnadirPagoPeriodico() throws PagoExistenteException{
		fail("No implementado");
	}
	
	@Test
	public void testAnadirPagoPeriodicoException() throws PagoExistenteException{
		fail("No implementado");
	}
	
	@Test
	public void testBorrarPagoPeriodico()  throws PagoNoExistenteException, PagoExistenteException {
		fail("No implementado");
	}
	
	@Test
	public void testBorrarPagoPeriodicoException()  throws PagoNoExistenteException {
		fail("No implementado");
	}
	
	@Test
	public void testPagoPeriodicoExiste() throws PagoNoExistenteException,PagoExistenteException{
		fail("No implementado");
	}
	
	@Test
	public void testdeposito() {
		fail("No implementado");
	}

	@Test
	public void testReintegro() {
		fail("No implementado");
	}
}

/*

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
		testAccount = new Cuenta("TestUser", SEK);
		importe = new Money(1000, SEK);
	}

	@Test
	public void testGetSaldo() {
		// Saldo inicial debe ser 0
		assertThat(testAccount.getSaldo(), is(0));
		
		// Añadimos un depósito
		testAccount.deposito(new Money(500, SEK));
		assertThat(testAccount.getSaldo(), is(500));

		// Añadimos un reintegro
		testAccount.reintegro(new Money(200, SEK));
		assertThat(testAccount.getSaldo(), is(300)); // Saldo restante debe ser 300
	}

	@Test
	public void testAnadirPagoPeriodico() throws PagoExistenteException {
		// Crear un pago periódico
		PagoPeriodico pago = new PagoPeriodico("PagoAlquiler", 1, new Money(100, SEK), testAccount);

		// Añadir el pago periódico
		testAccount.anadirPagoPeriodico(pago);

		// Verificar que el pago periódico fue añadido correctamente
		assertTrue(testAccount.pagoPeriodicoExiste("PagoAlquiler"));
	}

	@Test(expected = PagoExistenteException.class)
	public void testAnadirPagoPeriodicoException() throws PagoExistenteException {
		PagoPeriodico pago = new PagoPeriodico("PagoAlquiler", 1, new Money(100, SEK), testAccount);
		testAccount.anadirPagoPeriodico(pago);
		
		// Añadir el mismo pago debe lanzar la excepción PagoExistenteException
		testAccount.anadirPagoPeriodico(pago);
	}

	@Test
	public void testBorrarPagoPeriodico() throws PagoNoExistenteException, PagoExistenteException {
		// Añadimos un pago periódico primero
		PagoPeriodico pago = new PagoPeriodico("PagoAlquiler", 1, new Money(100, SEK), testAccount);
		testAccount.anadirPagoPeriodico(pago);

		// Borrar el pago periódico
		testAccount.borrarPagoPeriodico("PagoAlquiler");

		// Verificar que el pago periódico fue eliminado correctamente
		assertFalse(testAccount.pagoPeriodicoExiste("PagoAlquiler"));
	}

	@Test(expected = PagoNoExistenteException.class)
	public void testBorrarPagoPeriodicoException() throws PagoNoExistenteException {
		// Intentar borrar un pago periódico que no existe debe lanzar PagoNoExistenteException
		testAccount.borrarPagoPeriodico("PagoInexistente");
	}

	@Test
	public void testPagoPeriodicoExiste() throws PagoNoExistenteException, PagoExistenteException {
		// Verificar que un pago periódico no existe inicialmente
		assertFalse(testAccount.pagoPeriodicoExiste("PagoAlquiler"));

		// Añadir un pago periódico
		PagoPeriodico pago = new PagoPeriodico("PagoAlquiler", 1, new Money(100, SEK), testAccount);
		testAccount.anadirPagoPeriodico(pago);

		// Verificar que el pago periódico ahora existe
		assertTrue(testAccount.pagoPeriodicoExiste("PagoAlquiler"));
	}

	@Test
	public void testDeposito() {
		// Saldo inicial es 0
		assertThat(testAccount.getSaldo(), is(0));

		// Realizamos un depósito
		testAccount.deposito(new Money(500, SEK));

		// Verificar que el saldo es 500
		assertThat(testAccount.getSaldo(), is(500));
	}

	@Test
	public void testReintegro() {
		// Añadir un depósito para tener saldo
		testAccount.deposito(new Money(500, SEK));

		// Realizar un reintegro
		testAccount.reintegro(new Money(200, SEK));

		// Verificar que el saldo es 300 después del reintegro
		assertThat(testAccount.getSaldo(), is(300));
	}
}


*/