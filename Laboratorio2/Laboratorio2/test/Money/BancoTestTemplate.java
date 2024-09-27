package Money;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

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
		
		importe = new Money(1000, SEK);

	}

	@Test
	public void testGetNombre() {
		assertTrue(Nordea.getNombre().equals("Nordea"));
		assertTrue(DanskeBanco.getNombre().equals("DanskeBanco"));

	}

	@Test
	public void testGetDivisa() {
		assertTrue(Nordea.getDivisa().equals(SEK));
		assertTrue(Nordea.getDivisa().equals(DKK));
	}
	
	@Test
	public void testGetCuentas() throws CuentaExisteException {
		assertNotNull(Nordea.getCuentas());
		assertTrue(Nordea.getCuentas().size() == 0);

	}
	//Abrir cuenta Inexistente
	@Test
	public void testAbrirNuevaCuenta() throws CuentaExisteException  {
		
		Nordea.abrirCuenta("Airam", "AIR555");
		assertTrue(Nordea.getCuentas().containsKey("AIR555"));
		
		
		
	}
	//Abrir cuenta Existente
	@Test(expected = CuentaExisteException.class)
	public void testAbrirCuentaExistenteException() throws CuentaExisteException {
		Nordea.abrirCuenta("Airam", "AIR555");
		Nordea.abrirCuenta("Airam", "AIR555");
	}
	
	
	//Recuperar Saldo cuenta Existente
	@Test
	public void testGetSaldoCuentaExistente() throws CuentaExisteException, CuentaNoExisteException {
	
		Nordea.abrirCuenta("Airam", "AIR555");
		assertTrue(Nordea.getSaldo("AIR555") == 0);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();  
	
	//Recuperar Saldo cuenta Inexistente
	@Test(expected = CuentaNoExisteException.class)
	public void testGetSaldoCuentaNoExistente() throws CuentaNoExisteException  {
		Nordea.getSaldo("124");
	}
	
	//Deposito cuenta Existente
	@Test
	public void testDeposito() {
		fail("No implementado");
	}
	//Deposito cuenta Inexistente
	@Test
	public void testDepositoCuentaNoExisteException() throws CuentaNoExisteException, SaldoInsuficienteException {
		fail("No implementado");
	}

	//Reintegro cuenta Existente con saldo suficiente
	@Test
	public void testReintegro() {
		fail("No implementado");
	}
	
	//Reintegro cuenta Inexistente
	@Test
	public void testReintegroCuentaNoExisteException() {
		fail("No implementado");
	}
	
	//Reintegro cuenta Existente con saldo Insuficiente
	@Test
	public void testReintegroSaldoInsuficienteException()  {
		fail("No implementado");
	}
	
	//Transfer a otro Banco a una cuenta existente con Saldo Suficiente
	@Test
	public void testTransferOtroBanco() {
		fail("No implementado");
	}
	//Transfer a otro Banco a cuenta inexistente 
	@Test
	public void testTransferOtroBancoCuentaNoExisteException() {
		fail("No implementado");
	}
	
	//Transfer a otro Banco a una cuenta existente con Saldo Insuficiente
	@Test
	public void testTransferOtroBancoSaldoInsuficienteException() {
		fail("No implementado");
	}
	//Transfer a mismo Banco a una cuenta existente con Saldo Suficiente
	@Test
	public void testTransferMismoBanco() {
		fail("No implementado");
	}
	//Transfer mismo Banco a cuenta inexistente	
	@Test
	public void testTransferMismoBancoCuentaNoExisteException()  {
		fail("No implementado");
	}
	//Transfer a mismo banco a una cuenta existente con Saldo Insuficiente
	@Test
	public void testTransferMismoBancoSaldoInsuficienteException()  {
		fail("No implementado");
	}
	
}
