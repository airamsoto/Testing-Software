package Money;

public class Money implements Comparable<Money> {
	
	private int cantidad;
	private Divisa divisa;

	/**
	 * @param cantidad	
	 * @param divisa	
	 */
	Money (int cantidad, Divisa divisa) {
		this.cantidad = cantidad;
		this.divisa = divisa;
	}
	
	/**
	 * Return Cantidad.
	 * @return Cantidad.
	 */
	public int getCantidad() {
		return cantidad;
	}
	
	/**
	 * Returns Divisa.
	 * @return Divisa asociada a esta cantidad
	 */
	public Divisa getDivisa() {
		return divisa;
	}
	
	/**
	 * Devuelve un String "cantidad nombre de divisa", e.g. "10.5 SEK".
	 * Los numeros decimales se representan con enteros, e.g "10.5 SEK" se almacena como 1050
	 * 
	 *  @return String con información de la moneda.
	 */
	public String toString() {
		return cantidad + " " + getDivisa().getName();
	}
	
	/**
	 * Valor universal de la cantidad de acuerdo al rate asociado a la divisa
	 * @return Valor universal de la cantidad
	 */
	public int valorUniversal() {
		return (int) (this.cantidad * this.divisa.getRate());
	}
	
	/**
	 * Chequea si el valor universal de otro objeto Money es equivalente al actual
	 * @param otra Objeto Money a comparar
	 * @return Boolean indicando equivalencia
	 */
	public Boolean equals(Money otra) {
		return this.valorUniversal() == otra.valorUniversal();
	}
	
	/**
	 * A�ade un objeto Money al actual.
	 * Convierte el importe recibido a la divisa actual si es necesario.
	 * @param otra Objeto Money a añadir.
	 * @return Un nuevo objeto Money con la divisa del actual, y la cantidad acumulada con el importe del objeto Money recibido.
	 **/
	public Money add(Money otra) {
		int cantidadConvertida = this.getDivisa().valorEnEstaDivisa(otra.getCantidad(), otra.getDivisa());
		Money result = new Money(this.getCantidad() + cantidadConvertida, this.getDivisa());
		return result;
	}

	/**
	 * Sustrae un objeto Money del actual.
	 * Convierte el importe recibido a la divisa actual si es necesario.
	 * @param otra Objeto Money a sustraer.
	 * @return Un nuevo objeto Money con la divisa del actual, y la cantidad resultante.
	 **/
	public Money sub(Money otra) {
		int cantidadConvertida = this.getDivisa().valorEnEstaDivisa(otra.getCantidad(), otra.getDivisa());
		Money result = new Money(this.getCantidad() - cantidadConvertida, this.getDivisa());
		return result;
	}

	/**
	 * 
	 * @return True si cantidad es cero, false en caso contrario.
	 */
	public Boolean isZero() {
		return getCantidad() == 0;
	}

	/**
	 * Convierte la cantidad del objeto actual a negativo
	 * @return Un nuevo objeto Money con la cantidad en negativo
	 */
	public Money negate() {
		return new Money(-getCantidad(), getDivisa());
	}
	
	/**
	 * Compara dos objetos Money
	 * @return 0  si sus valores son iguales
	 * Un entero negativo si el objeto actual tiene menos valor que el recibido
	 * Un entero positivo si el objeto actual tiene más valor que el recibido
	 */
	@Override
	public int compareTo(Money otra) {
		return Integer.compare(this.valorUniversal(), otra.valorUniversal()); //funcion que devuelve lo de antes
	}
}
