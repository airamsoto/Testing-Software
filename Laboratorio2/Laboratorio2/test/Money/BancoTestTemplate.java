package Money;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.*;
import org.junit.rules.*;

public class BancoTestTemplate {
	Divisa SEK, DKK;
    Banco Nordea, DanskeBanco;
	Money importe;
	
	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testGetNombre() {

	}

	@Test
	public void testGetDivisa() {
	}
	
	@Test
	public void testGetCuentas() {

	}
	//Abrir cuenta Inexistente
	@Test
	public void testAbrirNuevaCuenta()  {
		
	}
	//Abrir cuenta Existente
	@Test
	public void testAbrirCuentaExistenteException() {

	}
	
	
	//Recuperar Saldo cuenta Existente
	@Test
	public void testGetSaldoCuentaExistente() {
		
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();  
	
	//Recuperar Saldo cuenta Inexistente
	@Test
	public void testGetSaldoCuentaNoExistente()  {
		
	}
	
	//Deposito cuenta Existente
	@Test
	public void testDeposito() {
		
	}
	//Deposito cuenta Inexistente
	@Test
	public void testDepositoCuentaNoExisteException() throws CuentaNoExisteException, SaldoInsuficienteException {

	}

	//Reintegro cuenta Existente con saldo suficiente
	@Test
	public void testReintegro() {
		
	}
	
	//Reintegro cuenta Inexistente
	@Test
	public void testReintegroCuentaNoExisteException() {
		
	}
	
	//Reintegro cuenta Existente con saldo Insuficiente
	@Test
	public void testReintegroSaldoInsuficienteException()  {
	
	}
	
	//Transfer a otro Banco a una cuenta existente con Saldo Suficiente
	@Test
	public void testTransferOtroBanco() {
	
	}
	//Transfer a otro Banco a cuenta inexistente 
	@Test
	public void testTransferOtroBancoCuentaNoExisteException() {
		
	}
	
	//Transfer a otro Banco a una cuenta existente con Saldo Insuficiente
	@Test
	public void testTransferOtroBancoSaldoInsuficienteException() {
		
	}
	//Transfer a mismo Banco a una cuenta existente con Saldo Suficiente
	@Test
	public void testTransferMismoBanco() {
		
	}
	//Transfer mismo Banco a cuenta inexistente	
	@Test
	public void testTransferMismoBancoCuentaNoExisteException()  {
		
	}
	//Transfer a mismo banco a una cuenta existente con Saldo Insuficiente
	@Test
	public void testTransferMismoBancoSaldoInsuficienteException()  {
		
	}
	
}
/*
 
 package Money;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.*;
import org.junit.rules.*;

public class BancoTestTemplate {
	Divisa SEK, DKK;
    Banco Nordea, DanskeBanco;
	Money importe;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Divisa("SEK", 0.15);
		DKK = new Divisa("DKK", 0.20);
		
		Nordea = new Banco("Nordea", SEK);
		DanskeBanco = new Banco("DanskeBanco", DKK);
		
		// Inicializamos el importe para pruebas
		importe = new Money(1000, SEK);
	}

	@Test
	public void testGetNombre() {
		assertThat(Nordea.getNombre(), is("Nordea"));
		assertThat(DanskeBanco.getNombre(), is("DanskeBanco"));
	}

	@Test
	public void testGetDivisa() {
		assertThat(Nordea.getDivisa(), is(SEK));
		assertThat(DanskeBanco.getDivisa(), is(DKK));
	}
	
	@Test
	public void testGetCuentas() {
		assertNotNull(Nordea.getCuentas());
		assertThat(Nordea.getCuentas().size(), is(0)); // Verifica que inicialmente no tiene cuentas
	}
	
	// Abrir cuenta inexistente
	@Test
	public void testAbrirNuevaCuenta()  {
		try {
			Nordea.abrirCuenta("Alice", "ALICE123");
			assertTrue(Nordea.getCuentas().containsKey("ALICE123"));
		} catch (CuentaExisteException e) {
			fail("No debería lanzar una excepción: " + e.getMessage());
		}
	}

	// Abrir cuenta existente
	@Test(expected = CuentaExisteException.class)
	public void testAbrirCuentaExistenteException() throws CuentaExisteException {
		Nordea.abrirCuenta("Alice", "ALICE123");
		Nordea.abrirCuenta("Alice", "ALICE123"); // Debe lanzar CuentaExisteException
	}
	
	// Recuperar saldo de cuenta existente
	@Test
	public void testGetSaldoCuentaExistente() {
		try {
			Nordea.abrirCuenta("Alice", "ALICE123");
			assertThat(Nordea.getSaldo("ALICE123"), is(0)); // Saldo inicial es 0
		} catch (Exception e) {
			fail("No debería lanzar ninguna excepción: " + e.getMessage());
		}
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();  
	
	// Recuperar saldo de cuenta inexistente
	@Test
	public void testGetSaldoCuentaNoExistente() throws CuentaNoExisteException {
		thrown.expect(CuentaNoExisteException.class);
		thrown.expectMessage("Cuenta no existente");
		Nordea.getSaldo("NONEXISTENT"); // Debe lanzar CuentaNoExisteException
	}
	
	// Depósito en cuenta existente
	@Test
	public void testDeposito() {
		try {
			Nordea.abrirCuenta("Alice", "ALICE123");
			Nordea.deposito("ALICE123", new Money(500, SEK));
			assertThat(Nordea.getSaldo("ALICE123"), is(500)); // Verificamos el saldo después del depósito
		} catch (Exception e) {
			fail("No debería lanzar ninguna excepción: " + e.getMessage());
		}
	}
	
	// Depósito en cuenta inexistente
	@Test(expected = CuentaNoExisteException.class)
	public void testDepositoCuentaNoExisteException() throws CuentaNoExisteException {
		Nordea.deposito("NONEXISTENT", new Money(500, SEK)); // Debe lanzar CuentaNoExisteException
	}
	
	// Reintegro en cuenta existente con saldo suficiente
	@Test
	public void testReintegro() {
		try {
			Nordea.abrirCuenta("Alice", "ALICE123");
			Nordea.deposito("ALICE123", new Money(500, SEK));
			Nordea.reintegro("ALICE123", new Money(300, SEK));
			assertThat(Nordea.getSaldo("ALICE123"), is(200)); // Verificamos el saldo después del reintegro
		} catch (Exception e) {
			fail("No debería lanzar ninguna excepción: " + e.getMessage());
		}
	}
	
	// Reintegro en cuenta inexistente
	@Test(expected = CuentaNoExisteException.class)
	public void testReintegroCuentaNoExisteException() throws CuentaNoExisteException, SaldoInsuficienteException {
		Nordea.reintegro("NONEXISTENT", new Money(300, SEK)); // Debe lanzar CuentaNoExisteException
	}
	
	// Reintegro en cuenta existente con saldo insuficiente
	@Test(expected = SaldoInsuficienteException.class)
	public void testReintegroSaldoInsuficienteException() throws SaldoInsuficienteException, CuentaNoExisteException {
		Nordea.abrirCuenta("Alice", "ALICE123");
		Nordea.deposito("ALICE123", new Money(200, SEK));
		Nordea.reintegro("ALICE123", new Money(300, SEK)); // Debe lanzar SaldoInsuficienteException
	}
	
	// Transferencia a otro banco con saldo suficiente
	@Test
	public void testTransferOtroBanco() {
		try {
			Nordea.abrirCuenta("Alice", "ALICE123");
			DanskeBanco.abrirCuenta("Bob", "BOB456");
			Nordea.deposito("ALICE123", new Money(1000, SEK));
			Nordea.transfer("ALICE123", DanskeBanco, "BOB456", new Money(500, SEK));
			assertThat(Nordea.getSaldo("ALICE123"), is(500)); // Saldo restante de Alice
			assertThat(DanskeBanco.getSaldo("BOB456"), is(500)); // Bob recibe 500
		} catch (Exception e) {
			fail("No debería lanzar ninguna excepción: " + e.getMessage());
		}
	}
	
	// Transferencia a otro banco a cuenta inexistente
	@Test(expected = CuentaNoExisteException.class)
	public void testTransferOtroBancoCuentaNoExisteException() throws CuentaNoExisteException, SaldoInsuficienteException {
		Nordea.abrirCuenta("Alice", "ALICE123");
		Nordea.deposito("ALICE123", new Money(1000, SEK));
		Nordea.transfer("ALICE123", DanskeBanco, "NONEXISTENT", new Money(500, SEK)); // Debe lanzar CuentaNoExisteException
	}
	
	// Transferencia a otro banco con saldo insuficiente
	@Test(expected = SaldoInsuficienteException.class)
	public void testTransferOtroBancoSaldoInsuficienteException() throws SaldoInsuficienteException, CuentaNoExisteException {
		Nordea.abrirCuenta("Alice", "ALICE123");
		DanskeBanco.abrirCuenta("Bob", "BOB456");
		Nordea.deposito("ALICE123", new Money(300, SEK));
		Nordea.transfer("ALICE123", DanskeBanco, "BOB456", new Money(500, SEK)); // Debe lanzar SaldoInsuficienteException
	}
	
	// Transferencia en mismo banco con saldo suficiente
	@Test
	public void testTransferMismoBanco() {
		try {
			Nordea.abrirCuenta("Alice", "ALICE123");
			Nordea.abrirCuenta("Bob", "BOB456");
			Nordea.deposito("ALICE123", new Money(1000, SEK));
			Nordea.transfer("ALICE123", "BOB456", new Money(500, SEK));
			assertThat(Nordea.getSaldo("ALICE123"), is(500)); // Saldo restante de Alice
			assertThat(Nordea.getSaldo("BOB456"), is(500)); // Bob recibe 500
		} catch (Exception e) {
			fail("No debería lanzar ninguna excepción: " + e.getMessage());
		}
	}
	
	// Transferencia en mismo banco a cuenta inexistente
	@Test(expected = CuentaNoExisteException.class)
	public void testTransferMismoBancoCuentaNoExisteException() throws CuentaNoExisteException, SaldoInsuficienteException {
		Nordea.abrirCuenta("Alice", "ALICE123");
		Nordea.deposito("ALICE123", new Money(1000, SEK));
		Nordea.transfer("ALICE123", "NONEXISTENT", new Money(500, SEK)); // Debe lanzar CuentaNoExisteException
	}
	
	// Transferencia en mismo banco con saldo insuficiente
	@Test(expected = SaldoInsuficienteException.class)
	public void testTransferMismoBancoSaldoInsuficienteException() throws SaldoInsuficienteException, CuentaNoExisteException {
		Nordea.abrirCuenta("Alice", "ALICE123");
		Nordea.abrirCuenta("Bob", "BOB456");
		Nordea.deposito("ALICE123", new Money(300, SEK));
		Nordea.transfer("ALICE123", "BOB456", new Money(500, SEK)); // Debe lanzar SaldoInsuficienteException
	}
}

 
 
 
 
 */
*/