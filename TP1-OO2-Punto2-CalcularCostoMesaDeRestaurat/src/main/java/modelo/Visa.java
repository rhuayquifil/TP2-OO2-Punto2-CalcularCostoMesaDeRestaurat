package modelo;

public class Visa extends Tarjeta {

	public Visa() {
		super();
	}

	public float calcularCosto(Item item) {
		return item.pagarConVisa();
	}
}
